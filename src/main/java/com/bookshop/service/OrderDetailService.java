package com.bookshop.service;

import com.bookshop.model.OrderDetails;
import com.bookshop.model.OrderMaster;

import java.util.List;

public interface OrderDetailService {
    public List<OrderDetails> getOrderDetailsByCustomer();

    public OrderMaster getOrderDetailsByCustomer2(int orderMasterId);
}
