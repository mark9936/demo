package com.demo.repository.school;

import com.demo.model.school.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/** Student 的 Spring Data JPA Repository。 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
