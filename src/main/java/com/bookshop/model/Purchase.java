package com.bookshop.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Purchase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    public Integer purchaseId;

    public String isbn;

    public Integer quantity;

    @Column(name = "purchase_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date purchaseDate;
}
