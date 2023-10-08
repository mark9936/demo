package com.demo.model.store;

import java.io.Serializable;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Function: Transaction.java
 * @Description: Transaction Entity
 * @author: kuo
 * @date: 2023/10/01
 * @MaintenancePersonnel: kuo
 */
@Data
@Entity
@Table(name = "TRANSACTION")
@NamedQuery(name = "Transaction.findAll", query = "SELECT c FROM Transaction c")
public class Transaction implements Serializable {

    private static final long serialVersionUID = -8767900884549854558L;

    /**
     * tNo
     */
    @Id
    @Column(name = "tNo")
    private String tNo;

    /**
     * transMid
     */
    @Column(name = "transMid")
    private String transMid;

    /**
     * transTime
     */
    @Column(name = "transTime")
    private LocalDateTime transTime;

    /**
     * method
     */
    @Column(name = "method")
    private String method;

    /**
     * bankId
     */
    @Column(name = "bankId")
    private String bankId;

    /**
     * bankName
     */
    @Column(name = "bankName")
    private String bankName;

    /**
     * cardType
     */
    @Column(name = "cardType")
    private String cardType;

    /**
     * cardId
     */
    @Column(name = "cardId")
    private String cardId;

    /**
     * dueDate
     */
    @Column(name = "dueDate")
    private LocalDateTime dueDate;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
