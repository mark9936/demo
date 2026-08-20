package com.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import com.demo.model.school.Student;
import com.demo.service.school.StudentService;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * StudentController 的單元測試。
 *
 * <p>這裡直接呼叫 Controller 方法，並以 mock 取代真正的 Service。
 * HTTP 路由、JSON 轉換及 Spring Context 則由 DemoApplicationTests 的整合測試負責。</p>
 */
@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    private StudentService service;

    @InjectMocks
    private StudentController controller;

    @Test
    void findAllShouldReturnServiceData() {
        List<Student> expected = Collections.singletonList(createStudent(1, 4.0, "Jerry Ryan"));
        when(service.findAll()).thenReturn(expected);

        List<Student> actual = controller.findAll();

        assertSame(expected, actual);
        verify(service).findAll();
    }

    @Test
    void findByIdShouldReturnServiceData() {
        Student expected = createStudent(1, 4.0, "Jerry Ryan");
        when(service.findById(1)).thenReturn(expected);

        Student actual = controller.findById(1);

        assertSame(expected, actual);
        verify(service).findById(1);
    }

    @Test
    void createShouldReturnCreatedStatus() {
        Student request = createStudent(3, 3.6, "New Student");
        when(service.create(request)).thenReturn(request);

        ResponseEntity<Student> response = controller.create(request);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertSame(request, response.getBody());
        verify(service).create(request);
    }

    @Test
    void updateShouldReturnServiceResult() {
        Student request = createStudent(null, 3.8, "Updated Student");
        Student saved = createStudent(1, 3.8, "Updated Student");
        when(service.update(1, request)).thenReturn(saved);

        Student actual = controller.update(1, request);

        assertSame(saved, actual);
        verify(service).update(1, request);
    }

    @Test
    void deleteShouldReturnNoContentStatus() {
        ResponseEntity<Void> response = controller.delete(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(service).delete(1);
    }

    @Test
    void findByGpaShouldReturnMatchingStudents() {
        List<Student> expected = Collections.singletonList(createStudent(1, 4.0, "Jerry Ryan"));
        when(service.findByGpaBetween(3.5, 4.0)).thenReturn(expected);

        ResponseEntity<List<Student>> response = controller.findByGpa(3.5, 4.0);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertSame(expected, response.getBody());
        verify(service).findByGpaBetween(3.5, 4.0);
    }

    @Test
    void findByGpaShouldReturnBadRequestForInvalidRange() {
        ResponseEntity<List<Student>> response = controller.findByGpa(4.0, 3.0);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        verifyNoInteractions(service);
    }

    @Test
    void searchShouldPassOptionalConditionsToService() {
        List<Student> expected = Collections.singletonList(createStudent(1, 4.0, "Jerry Ryan"));
        when(service.search("ryan", 3.5, null)).thenReturn(expected);

        ResponseEntity<List<Student>> response = controller.search("ryan", 3.5, null);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertSame(expected, response.getBody());
        verify(service).search("ryan", 3.5, null);
    }

    @Test
    void searchShouldReturnBadRequestForInvalidRange() {
        ResponseEntity<List<Student>> response = controller.search(null, 4.0, 3.0);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        verifyNoInteractions(service);
    }

    private Student createStudent(Integer id, Double gpa, String name) {
        return new Student(id, gpa, name, 1);
    }
}
