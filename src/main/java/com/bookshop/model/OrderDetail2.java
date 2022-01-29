package com.bookshop.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_detail2")
//@Data
@Getter
@Setter
public class OrderDetail2 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String isbn;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "om_id")
    private OrderMaster orderMaster;
}
