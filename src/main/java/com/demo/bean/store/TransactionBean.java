package com.demo.bean.store;

import java.io.Serializable;


import java.time.LocalDateTime;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Function: TransactionBean.java
 * @Description: Transaction Bean
 * @author: kuo
 * @date: 2023/10/02
 * @MaintenancePersonnel: kuo
 */
@Data
public class TransactionBean implements Serializable {

    private static final long serialVersionUID = -8495256837486576570L;

    /**
     * tNo
     */
    private String tNo;

    /**
     * transMid
     */
    private String transMid;

    /**
     * transTime
     */
    private LocalDateTime transTime;

    /**
     * method
     */
    private String method;

    /**
     * bankId
     */
    private String bankId;

    /**
     * bankName
     */
    private String bankName;

    /**
     * cardType
     */
    private String cardType;

    /**
     * cardId
     */
    private String cardId;

    /**
     * dueDate
     */
    private LocalDateTime dueDate;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
