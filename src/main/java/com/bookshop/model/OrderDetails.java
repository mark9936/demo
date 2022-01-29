package com.bookshop.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class OrderDetails implements Serializable {
    @Id
    public String customerId;
    public String customerName;
    public Integer orderId;
    public String isbn;
    public Integer quantity;
    @Temporal(TemporalType.TIMESTAMP)
    public Date orderDate;
}
