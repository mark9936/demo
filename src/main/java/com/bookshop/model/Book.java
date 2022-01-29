package com.bookshop.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String isbn;

    public String book_name;

    public Integer price;

    public String author;

    @Temporal(TemporalType.DATE)
    public Date publication_date;

    public String publisher_id;

}
