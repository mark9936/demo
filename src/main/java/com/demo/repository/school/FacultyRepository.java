package com.demo.repository.school;

import com.demo.model.school.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

/** Faculty 的 Spring Data JPA Repository。 */
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
}
