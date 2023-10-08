package com.demo.bean.school;

import java.io.Serializable;


import java.math.BigInteger;
import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Function: PersonBean.java
 * @Description: Person Bean
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
@Data
public class PersonBean implements Serializable {

    private static final long serialVersionUID = -6863668612110908020L;

    /**
     * PersonID
     */
    private Integer personID;

    /**
     * PersonPhoneNumber
     */
    private String personPhoneNumber;

    /**
     * PersonName
     */
    private String personName;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
