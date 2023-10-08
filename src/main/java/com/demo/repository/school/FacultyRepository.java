package com.demo.repository.school;

import com.demo.model.school.Faculty;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Function: FacultyRepository.java
 * @Description: Faculty Repository
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
public interface FacultyRepository extends JpaRepository<Faculty, String> {

}
