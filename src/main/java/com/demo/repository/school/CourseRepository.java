package com.demo.repository.school;

import com.demo.model.school.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/** Course 的 Spring Data JPA Repository。 */
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
