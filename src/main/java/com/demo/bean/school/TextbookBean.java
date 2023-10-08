package com.demo.bean.school;

import java.io.Serializable;


import java.math.BigInteger;
import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Function: TextbookBean.java
 * @Description: Textbook Bean
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
@Data
public class TextbookBean implements Serializable {

    private static final long serialVersionUID = -5914013587438811180L;

    /**
     * TextbookISBN
     */
    private Integer textbookISBN;

    /**
     * TextbookTitle
     */
    private String textbookTitle;

    /**
     * TextbookAuthor
     */
    private String textbookAuthor;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
