package com.demo.repo.freemaker.target.repository;

import com.demo.repo.freemaker.target.entity.Record;

import org.springframework.data.jpa.repository.JpaRepository;

/**
* @Function: RecordRepository.java
* @Description: Record Repository
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/
public interface RecordRepository extends JpaRepository<Record, String> {

}
