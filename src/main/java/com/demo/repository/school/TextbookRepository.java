package com.demo.repository.school;

import com.demo.model.school.Textbook;
import org.springframework.data.jpa.repository.JpaRepository;

/** Textbook 的 Spring Data JPA Repository。 */
public interface TextbookRepository extends JpaRepository<Textbook, Integer> {
}
