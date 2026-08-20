package com.demo.service.school.impl;

import com.demo.exception.ResourceNotFoundException;
import com.demo.model.school.Course;
import com.demo.repository.school.CourseRepository;
import com.demo.service.school.CourseService;
import java.util.List;
import org.springframework.stereotype.Service;

/** CourseService 的實作。 */
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }

    @Override
    public Course findById(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("找不到 Course，id=" + id));
    }

    @Override
    public Course create(Course course) {
        return repository.save(course);
    }

    @Override
    public Course update(Integer id, Course course) {
        findById(id);
        course.setCourseId(id);
        return repository.save(course);
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
