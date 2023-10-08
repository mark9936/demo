package com.demo.repo.freemaker.target.repository;

import com.demo.repo.freemaker.target.entity.Cart;

import org.springframework.data.jpa.repository.JpaRepository;

/**
* @Function: CartRepository.java
* @Description: Cart Repository
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/
public interface CartRepository extends JpaRepository<Cart, String> {

}
