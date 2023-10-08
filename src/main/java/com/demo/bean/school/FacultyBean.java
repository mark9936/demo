package com.demo.bean.school;

import java.io.Serializable;


import java.math.BigInteger;
import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Function: FacultyBean.java
 * @Description: Faculty Bean
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
@Data
public class FacultyBean implements Serializable {

    private static final long serialVersionUID = -3373152156474779400L;

    /**
     * FacultyID
     */
    private Integer facultyID;

    /**
     * FacultyTitle
     */
    private String facultyTitle;

    /**
     * FacultySalary
     */
    private Integer facultySalary;

    /**
     * FacultyName
     */
    private String facultyName;

    /**
     * PersonID
     */
    private Integer personID;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
