package com.demo.repository.school;

import com.demo.model.school.College;
import org.springframework.data.jpa.repository.JpaRepository;

/** College 的 Spring Data JPA Repository；主鍵型別是 String。 */
public interface CollegeRepository extends JpaRepository<College, String> {
}
