package com.demo.repository.school;

import com.demo.model.school.Buildings;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Function: BuildingsRepository.java
 * @Description: Buildings Repository
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
public interface BuildingsRepository extends JpaRepository<Buildings, String> {

}
