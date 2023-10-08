package com.demo.repository.school;

import com.demo.model.school.Student;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Function: StudentRepository.java
 * @Description: Student Repository
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
