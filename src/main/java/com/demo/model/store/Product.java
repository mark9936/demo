package com.demo.model.store;

import java.io.Serializable;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Function: Product.java
 * @Description: Product Entity
 * @author: kuo
 * @date: 2023/10/01
 * @MaintenancePersonnel: kuo
 */
@Data
@Entity
@Table(name = "PRODUCT")
@NamedQuery(name = "Product.findAll", query = "SELECT c FROM Product c")
public class Product implements Serializable {

    private static final long serialVersionUID = 2057112514747272737L;

    /**
     * pro_id
     */
    @Id
    @Column(name = "pro_id")
    private Integer pro_id;

    /**
     * pNo
     */
    @Column(name = "pNo")
    private String pNo;

    /**
     * name
     */
    @Column(name = "name")
    private String name;

    /**
     * pName
     */
    @Column(name = "pName")
    private String pName;

    /**
     * desc
     */
    @Column(name = "desc")
    private String desc;

    /**
     * unitPrice
     */
    @Column(name = "unitPrice")
    private BigDecimal unitPrice;

    /**
     * price
     */
    @Column(name = "price")
    private BigDecimal price;

    /**
     * catalog
     */
    @Column(name = "catalog")
    private String catalog;

    /**
     * item_model
     */
    @Column(name = "item_model")
    private String item_model;

    /**
     * status
     */
    @Column(name = "status")
    private Integer status;

    /**
     * created_date
     */
    @Column(name = "created_date")
    private LocalDateTime created_date;

    /**
     * last_updated_date
     */
    @Column(name = "last_updated_date")
    private LocalDateTime last_updated_date;

    /**
     * last_updated_by
     */
    @Column(name = "last_updated_by")
    private Integer last_updated_by;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
