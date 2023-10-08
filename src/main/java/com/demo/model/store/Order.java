package com.demo.model.store;

import com.demo.model.store.pk.OrderPK;
import java.io.Serializable;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Function: Order.java
 * @Description: Order Entity
 * @author: kuo
 * @date: 2023/10/01
 * @MaintenancePersonnel: kuo
 */
@Data
@Entity
@Table(name = "ORDER")
@IdClass(OrderPK.class)
@NamedQuery(name = "Order.findAll", query = "SELECT c FROM Order c")
public class Order implements Serializable {

    private static final long serialVersionUID = -8213326515295627300L;

    /**
     * pNo
     */
    @Id
    @Column(name = "pNo")
    private String pNo;

    /**
     * mId
     */
    @Id
    @Column(name = "mId")
    private String mId;

    /**
     * cartTime
     */
    @Id
    @Column(name = "cartTime")
    private LocalDateTime cartTime;

    /**
     * amount
     */
    @Column(name = "amount")
    private Integer amount;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
