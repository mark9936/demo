package com.bookshop.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    public String customerID;

    @Column(name = "customer_name")
    public String customerName;

    public String phone;
    public String address;
}
