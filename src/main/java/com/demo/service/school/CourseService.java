package com.demo.service.school;

import com.demo.model.school.Course;
import java.util.List;

/** Course 的商業邏輯介面。 */
public interface CourseService {

    List<Course> findAll();

    Course findById(Integer id);

    Course create(Course course);

    Course update(Integer id, Course course);

    void delete(Integer id);
}
