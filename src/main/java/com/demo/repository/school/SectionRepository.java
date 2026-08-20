package com.demo.repository.school;

import com.demo.model.school.Section;
import org.springframework.data.jpa.repository.JpaRepository;

/** Section 的 Spring Data JPA Repository。 */
public interface SectionRepository extends JpaRepository<Section, Integer> {
}
