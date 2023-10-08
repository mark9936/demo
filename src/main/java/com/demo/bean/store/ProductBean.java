package com.demo.bean.store;

import java.io.Serializable;


import java.time.LocalDateTime;
import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Function: ProductBean.java
 * @Description: Product Bean
 * @author: kuo
 * @date: 2023/10/02
 * @MaintenancePersonnel: kuo
 */
@Data
public class ProductBean implements Serializable {

    private static final long serialVersionUID = 3983658326600597771L;

    /**
     * pro_id
     */
    private Integer pro_id;

    /**
     * pNo
     */
    private String pNo;

    /**
     * name
     */
    private String name;

    /**
     * pName
     */
    private String pName;

    /**
     * desc
     */
    private String desc;

    /**
     * unitPrice
     */
    private BigDecimal unitPrice;

    /**
     * price
     */
    private BigDecimal price;

    /**
     * catalog
     */
    private String catalog;

    /**
     * item_model
     */
    private String item_model;

    /**
     * status
     */
    private Integer status;

    /**
     * created_date
     */
    private LocalDateTime created_date;

    /**
     * last_updated_date
     */
    private LocalDateTime last_updated_date;

    /**
     * last_updated_by
     */
    private Integer last_updated_by;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
