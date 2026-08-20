package com.demo.repository.school;

import com.demo.model.school.Classrooms;
import org.springframework.data.jpa.repository.JpaRepository;

/** Classrooms 的 Spring Data JPA Repository。 */
public interface ClassroomsRepository extends JpaRepository<Classrooms, Integer> {
}
