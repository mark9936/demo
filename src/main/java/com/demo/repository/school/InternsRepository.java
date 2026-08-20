package com.demo.repository.school;

import com.demo.model.school.Interns;
import org.springframework.data.jpa.repository.JpaRepository;

/** Interns 的 Spring Data JPA Repository。 */
public interface InternsRepository extends JpaRepository<Interns, Integer> {
}
