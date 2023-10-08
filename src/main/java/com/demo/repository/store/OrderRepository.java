package com.demo.repository.store;


import com.demo.model.store.Order;
import com.demo.model.store.pk.OrderPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Function: OrderRepository.java
 * @Description: Order Repository
 * @author: kuo
 * @date: 2023/10/02
 * @MaintenancePersonnel: kuo
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, OrderPK> {

}
