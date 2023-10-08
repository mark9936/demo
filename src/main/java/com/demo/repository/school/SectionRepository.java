package com.demo.repository.school;

import com.demo.model.school.Section;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Function: SectionRepository.java
 * @Description: Section Repository
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
public interface SectionRepository extends JpaRepository<Section, String> {

}
