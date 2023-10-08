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
 * @Function: Person.java
 * @Description: Person Entity
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
@Data
@Entity
@Table(name = "PERSON")
@NamedQuery(name = "Person.findAll", query = "SELECT c FROM Person c")
public class Person implements Serializable {

    private static final long serialVersionUID = -6863668612110908020L;

    /**
     * PersonID
     */
    @Id
    @Column(name = "PersonID")
    private Integer personID;

    /**
     * PersonPhoneNumber
     */
    @Column(name = "PersonPhoneNumber")
    private String personPhoneNumber;

    /**
     * PersonName
     */
    @Column(name = "PersonName")
    private String personName;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
