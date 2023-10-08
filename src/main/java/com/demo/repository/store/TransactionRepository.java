package com.demo.repository.store;

import com.demo.model.store.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Function: TransactionRepository.java
 * @Description: Transaction Repository
 * @author: kuo
 * @date: 2023/10/02
 * @MaintenancePersonnel: kuo
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

}
