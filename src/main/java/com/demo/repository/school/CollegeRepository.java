package com.demo.repository.school;

import com.demo.model.school.College;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Function: CollegeRepository.java
 * @Description: College Repository
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
public interface CollegeRepository extends JpaRepository<College, String> {

}
