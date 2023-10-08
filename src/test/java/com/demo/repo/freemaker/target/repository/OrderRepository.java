package com.demo.repo.freemaker.target.repository;

import com.demo.repo.freemaker.target.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;

/**
* @Function: OrderRepository.java
* @Description: Order Repository
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/
public interface OrderRepository extends JpaRepository<Order, String> {

}
