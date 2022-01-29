package com.bookshop.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order_master")
@Data
public class OrderMaster implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "customer_id")
    private String customerId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date")
    private Date orderDate;

    @OneToMany(mappedBy = "orderMaster", cascade = CascadeType.ALL)
    private Set<OrderDetail2> orderDetail = new HashSet<OrderDetail2>();
}
