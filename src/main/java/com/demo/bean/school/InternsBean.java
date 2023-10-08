package com.demo.bean.school;

import java.io.Serializable;


import java.math.BigInteger;
import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Function: InternsBean.java
 * @Description: Interns Bean
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
@Data
public class InternsBean implements Serializable {

    private static final long serialVersionUID = -1802743118677229218L;

    /**
     * InternID
     */
    private Integer internID;

    /**
     * PersonID
     */
    private Integer personID;

    /**
     * InternHourlyWage
     */
    private Integer internHourlyWage;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
