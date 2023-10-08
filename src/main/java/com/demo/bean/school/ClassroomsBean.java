package com.demo.bean.school;

import java.io.Serializable;


import java.math.BigInteger;
import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Function: ClassroomsBean.java
 * @Description: Classrooms Bean
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
@Data
public class ClassroomsBean implements Serializable {

    private static final long serialVersionUID = -6803828971822182465L;

    /**
     * RoomNumber
     */
    private Integer roomNumber;

    /**
     * HasProjector
     */
    private String hasProjector;

    /**
     * BuildingID
     */
    private Integer buildingID;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
