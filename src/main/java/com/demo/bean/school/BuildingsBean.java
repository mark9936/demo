package com.demo.bean.school;

import java.io.Serializable;


import java.math.BigInteger;
import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Function: BuildingsBean.java
 * @Description: Buildings Bean
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
@Data
public class BuildingsBean implements Serializable {

    private static final long serialVersionUID = -6581134394718313970L;

    /**
     * BuildingID
     */
    private Integer buildingID;

    /**
     * BuildingName
     */
    private String buildingName;

    /**
     * CollegeName
     */
    private String collegeName;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
