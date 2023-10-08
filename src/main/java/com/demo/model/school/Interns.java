package com.demo.model.school;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.math.BigInteger;
import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;

/**
 * @Function: Interns.java
 * @Description: Interns Entity
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
@Data
@Entity
@Table(name = "INTERNS")
@NamedQuery(name = "Interns.findAll", query = "SELECT c FROM Interns c")
public class Interns implements Serializable {

    private static final long serialVersionUID = -1802743118677229218L;

    /**
     * InternID
     */
    @Id
    @Column(name = "InternID")
    private Integer internID;

    /**
     * PersonID
     */
    @Column(name = "PersonID")
    private Integer personID;

    /**
     * InternHourlyWage
     */
    @Column(name = "InternHourlyWage")
    private Integer internHourlyWage;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
