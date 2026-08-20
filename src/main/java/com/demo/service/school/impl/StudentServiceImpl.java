package com.demo.service.school.impl;

import com.demo.dao.school.SchoolDao;
import com.demo.exception.ResourceNotFoundException;
import com.demo.model.school.Student;
import com.demo.repository.school.StudentRepository;
import com.demo.service.school.StudentService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * StudentService 的實作。
 *
 * <p>Service 會先處理「資料是否存在」這類應用程式規則，再呼叫 Repository。
 * 這樣 Controller 不需要直接操作資料庫。</p>
 */
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private final SchoolDao schoolDao;

    public StudentServiceImpl(StudentRepository repository, SchoolDao schoolDao) {
        this.repository = repository;
        this.schoolDao = schoolDao;
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("找不到 Student，id=" + id));
    }

    @Override
    public Student create(Student student) {
        return repository.save(student);
    }

    @Override
    public Student update(Integer id, Student student) {
        findById(id);
        student.setStudentId(id);
        return repository.save(student);
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public List<Student> findByGpaBetween(double minGpa, double maxGpa) {
        return schoolDao.findByGpaBetween(minGpa, maxGpa);
    }

    @Override
    public List<Student> search(String studentName, Double minGpa, Double maxGpa) {
        return schoolDao.search(studentName, minGpa, maxGpa);
    }
}
