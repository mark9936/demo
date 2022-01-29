package com.bookshop.repository;

import com.bookshop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
//    @Query(value = "SELECT c.customer_id as customerId, c.customer_name as customerName, om.order_id as orderId, od.isbn, od.quantity, om.order_date as orderDate " +
//            "FROM order_detail od, order_master om , customer c " +
//            "where od.order_id = om.order_id " +
//            "and om.customer_id = c.customer_id ")
//    public OrderDetails getOrderDetailsByCustomer(String customerId);
}
