package com.demo.repo.freemaker.target.repository;

import com.demo.repo.freemaker.target.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

/**
* @Function: ProductRepository.java
* @Description: Product Repository
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/
public interface ProductRepository extends JpaRepository<Product, String> {

}
