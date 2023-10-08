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
 * @Function: College.java
 * @Description: College Entity
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
@Data
@Entity
@Table(name = "COLLEGE")
@NamedQuery(name = "College.findAll", query = "SELECT c FROM College c")
public class College implements Serializable {

    private static final long serialVersionUID = -4538298405182755007L;

    /**
     * CollegeName
     */
    @Id
    @Column(name = "CollegeName")
    private String collegeName;

    /**
     * CollegeTotalStudents
     */
    @Column(name = "CollegeTotalStudents")
    private Integer collegeTotalStudents;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
