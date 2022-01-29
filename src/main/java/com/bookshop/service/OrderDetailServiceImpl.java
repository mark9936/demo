package com.bookshop.service;

import com.bookshop.model.OrderDetails;
import com.bookshop.dao.OrderDetailsDao;
import com.bookshop.model.OrderMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailsDao orderDetailsDao;

    @Override
    public List<OrderDetails> getOrderDetailsByCustomer() {
        return orderDetailsDao.getOrderDetails();
    }

    @Override
    public OrderMaster getOrderDetailsByCustomer2(int orderMasterId) {
        return orderDetailsDao.getOrderDetails2(orderMasterId);
    }
}
