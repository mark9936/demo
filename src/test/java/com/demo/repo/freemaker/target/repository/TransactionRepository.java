package com.demo.repo.freemaker.target.repository;

import com.demo.repo.freemaker.target.entity.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;

/**
* @Function: TransactionRepository.java
* @Description: Transaction Repository
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/
public interface TransactionRepository extends JpaRepository<Transaction, String> {

}
