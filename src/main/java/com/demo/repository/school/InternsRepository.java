package com.demo.repository.school;

import com.demo.model.school.Interns;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Function: InternsRepository.java
 * @Description: Interns Repository
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
public interface InternsRepository extends JpaRepository<Interns, String> {

}
