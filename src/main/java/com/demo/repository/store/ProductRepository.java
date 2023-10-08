package com.demo.repository.store;

import com.demo.model.store.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Function: ProductRepository.java
 * @Description: Product Repository
 * @author: kuo
 * @date: 2023/10/02
 * @MaintenancePersonnel: kuo
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
