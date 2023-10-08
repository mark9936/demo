package com.demo.bean.school;

import java.io.Serializable;


import java.math.BigInteger;
import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Function: CollegeBean.java
 * @Description: College Bean
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
@Data
public class CollegeBean implements Serializable {

    private static final long serialVersionUID = -4538298405182755007L;

    /**
     * CollegeName
     */
    private String collegeName;

    /**
     * CollegeTotalStudents
     */
    private Integer collegeTotalStudents;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
