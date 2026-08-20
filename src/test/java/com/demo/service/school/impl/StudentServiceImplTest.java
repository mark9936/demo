package com.demo.service.school.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.demo.dao.school.SchoolDao;
import com.demo.exception.ResourceNotFoundException;
import com.demo.model.school.Student;
import com.demo.repository.school.StudentRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * StudentServiceImpl 的單元測試。
 *
 * <p>{@link ExtendWith} 搭配 {@link MockitoExtension}，讓 JUnit 5 在每個測試前
 * 建立 Mockito 測試物件。單元測試不啟動 Spring，也不連接資料庫，因此執行速度較快。</p>
 */
@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    /** @Mock 建立假的 Repository，測試過程不會真的存取資料庫。 */
    @Mock
    private StudentRepository repository;

    /** @Mock 建立假的 DAO，讓測試只關注 Service 自己的行為。 */
    @Mock
    private SchoolDao schoolDao;

    /** @InjectMocks 會將上方兩個 mock 透過建構子傳入被測試的 Service。 */
    @InjectMocks
    private StudentServiceImpl service;

    @Test
    void findAllShouldReturnRepositoryData() {
        List<Student> expected = Collections.singletonList(createStudent(1, 4.0, "Jerry Ryan"));
        // when(...).thenReturn(...) 用來設定假的相依物件應該回傳什麼。
        when(repository.findAll()).thenReturn(expected);

        List<Student> actual = service.findAll();

        assertSame(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void findByIdShouldReturnStudentWhenFound() {
        Student expected = createStudent(1, 4.0, "Jerry Ryan");
        when(repository.findById(1)).thenReturn(Optional.of(expected));

        Student actual = service.findById(1);

        assertSame(expected, actual);
        // verify(...) 確認被測試程式確實呼叫了預期的方法。
        verify(repository).findById(1);
    }

    @Test
    void findByIdShouldThrowExceptionWhenStudentDoesNotExist() {
        when(repository.findById(404)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> service.findById(404));

        assertEquals("找不到 Student，id=404", exception.getMessage());
    }

    @Test
    void createShouldSaveAndReturnStudent() {
        Student student = createStudent(3, 3.6, "New Student");
        when(repository.save(student)).thenReturn(student);

        Student actual = service.create(student);

        assertSame(student, actual);
        verify(repository).save(student);
    }

    @Test
    void updateShouldUseIdFromUrl() {
        Student existing = createStudent(1, 4.0, "Jerry Ryan");
        Student request = createStudent(999, 3.8, "Updated Student");
        when(repository.findById(1)).thenReturn(Optional.of(existing));
        when(repository.save(request)).thenReturn(request);

        Student actual = service.update(1, request);

        assertEquals(Integer.valueOf(1), actual.getStudentId());
        assertSame(request, actual);
        verify(repository).findById(1);
        verify(repository).save(request);
    }

    @Test
    void deleteShouldCheckExistenceBeforeDeleting() {
        Student existing = createStudent(1, 4.0, "Jerry Ryan");
        when(repository.findById(1)).thenReturn(Optional.of(existing));

        service.delete(1);

        verify(repository).findById(1);
        verify(repository).deleteById(1);
    }

    @Test
    void deleteShouldNotCallDeleteWhenStudentDoesNotExist() {
        when(repository.findById(404)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.delete(404));

        verify(repository, never()).deleteById(404);
    }

    @Test
    void findByGpaBetweenShouldDelegateToDao() {
        List<Student> expected = Collections.singletonList(createStudent(1, 4.0, "Jerry Ryan"));
        when(schoolDao.findByGpaBetween(3.5, 4.0)).thenReturn(expected);

        List<Student> actual = service.findByGpaBetween(3.5, 4.0);

        assertSame(expected, actual);
        verify(schoolDao).findByGpaBetween(3.5, 4.0);
    }

    @Test
    void searchShouldDelegateOptionalConditionsToDao() {
        List<Student> expected = Collections.singletonList(createStudent(1, 4.0, "Jerry Ryan"));
        when(schoolDao.search("ryan", 3.5, null)).thenReturn(expected);

        List<Student> actual = service.search("ryan", 3.5, null);

        assertSame(expected, actual);
        verify(schoolDao).search("ryan", 3.5, null);
    }

    private Student createStudent(Integer id, Double gpa, String name) {
        return new Student(id, gpa, name, 1);
    }
}
