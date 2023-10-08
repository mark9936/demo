package com.demo.bean.store;

import java.io.Serializable;


import java.time.LocalDateTime;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Function: OrderBean.java
 * @Description: Order Bean
 * @author: kuo
 * @date: 2023/10/02
 * @MaintenancePersonnel: kuo
 */
@Data
public class OrderBean implements Serializable {

    private static final long serialVersionUID = -8721283038783267655L;

    /**
     * pNo
     */
    private String pNo;

    /**
     * mId
     */
    private String mId;

    /**
     * cartTime
     */
    private LocalDateTime cartTime;

    /**
     * amount
     */
    private Integer amount;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
