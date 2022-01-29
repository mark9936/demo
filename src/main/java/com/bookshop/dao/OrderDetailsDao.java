package com.bookshop.dao;

import com.bookshop.model.OrderDetails;
import com.bookshop.model.OrderMaster;

import java.util.List;

public interface OrderDetailsDao {
    public List<OrderDetails> getOrderDetails();

    public OrderMaster getOrderDetails2(int orderMasterId);
}
