package com.demo.repository.school;

import com.demo.model.school.Classrooms;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Function: ClassroomsRepository.java
 * @Description: Classrooms Repository
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
public interface ClassroomsRepository extends JpaRepository<Classrooms, String> {

}
