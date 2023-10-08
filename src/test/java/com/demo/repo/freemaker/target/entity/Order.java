package com.demo.repo.freemaker.target.entity;

import java.io.Serializable;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.math.BigInteger;
import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;

/**
* @Function: Order.java
* @Description: Order Entity
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/
@Data
@Entity
@Table(name = "ORDER")
@NamedQuery(name = "Order.findAll", query = "SELECT c FROM Order c")
public class Order implements Serializable {

private static final long serialVersionUID = -6491374808520101724L;

    /** pNo */
      @Column(name = "pNo")
  private String pNo;

    /** mId */
      @Column(name = "mId")
  private String mId;

    /** cartTime */
      @Column(name = "cartTime")
  private LocalDateTime cartTime;

    /** amount */
      @Column(name = "amount")
  private Integer amount;


@Override
public String toString() {
return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
}

}
