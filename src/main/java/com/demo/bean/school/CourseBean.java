package com.demo.bean.school;

import java.io.Serializable;


import java.math.BigInteger;
import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Function: CourseBean.java
 * @Description: Course Bean
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
@Data
public class CourseBean implements Serializable {

    private static final long serialVersionUID = 3327253233876749258L;

    /**
     * CourseID
     */
    private Integer courseID;

    /**
     * CourseName
     */
    private String courseName;

    /**
     * TextbookISBN
     */
    private Integer textbookISBN;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
