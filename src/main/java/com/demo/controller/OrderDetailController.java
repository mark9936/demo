//package com.onlinestore.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/orderDetail")
//public class OrderDetailController {
//    @Autowired
//    OrderDetailService orderDetailService;
//
//    @GetMapping("/getOrderDetails/{customerId}")
//    public List<OrderDetails> getOrderDetailsByCustomer(@PathVariable String customerId) {
//        System.out.printf("*************OrderDetails");
//        return orderDetailService.getOrderDetailsByCustomer();
//    }
//
//    @GetMapping("/getOrderDetails2/{orderMasterId}")
//    public OrderMaster getOrderDetailsByCustomer2(@PathVariable String orderMasterId) {
//        System.out.printf("*************OrderMaster by one to many");
//        return orderDetailService.getOrderDetailsByCustomer2(Integer.parseInt(orderMasterId));
//    }
//}
