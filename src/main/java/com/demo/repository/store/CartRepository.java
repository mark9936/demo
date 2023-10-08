package com.demo.repository.store;

import com.demo.model.store.Cart;
import com.demo.model.store.pk.CartPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Function: CartRepository.java
 * @Description: Cart Repository
 * @author: kuo
 * @date: 2023/10/02
 * @MaintenancePersonnel: kuo
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, CartPK> {

}
