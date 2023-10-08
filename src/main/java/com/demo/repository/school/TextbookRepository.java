package com.demo.repository.school;

import com.demo.model.school.Textbook;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Function: TextbookRepository.java
 * @Description: Textbook Repository
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
public interface TextbookRepository extends JpaRepository<Textbook, String> {

}
