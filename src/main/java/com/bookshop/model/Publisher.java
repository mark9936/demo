package com.bookshop.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Publisher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    public String publisherId;

    @Column(name = "publisher_name")
    public String publisherName;

    public String contact;
    public String phone;

    @Column(name = "create_time")
    public Date createTime;
}
