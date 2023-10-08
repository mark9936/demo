package com.demo.bean.school;

import java.io.Serializable;


import java.time.LocalDate;

import java.math.BigInteger;
import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Function: SectionBean.java
 * @Description: Section Bean
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
@Data
public class SectionBean implements Serializable {

    private static final long serialVersionUID = 7217945477799703404L;

    /**
     * SectionID
     */
    private Integer sectionID;

    /**
     * SectionDate
     */
    private LocalDate sectionDate;

    /**
     * RoomNumber
     */
    private Integer roomNumber;

    /**
     * CourseID
     */
    private Integer courseID;

    /**
     * BuildingID
     */
    private Integer buildingID;

    /**
     * PersonID
     */
    private Integer personID;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
