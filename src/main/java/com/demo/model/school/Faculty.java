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
 * @Function: Faculty.java
 * @Description: Faculty Entity
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
@Data
@Entity
@Table(name = "FACULTY")
@NamedQuery(name = "Faculty.findAll", query = "SELECT c FROM Faculty c")
public class Faculty implements Serializable {

    private static final long serialVersionUID = -3373152156474779400L;

    /**
     * FacultyID
     */
    @Id
    @Column(name = "FacultyID")
    private Integer facultyID;

    /**
     * FacultyTitle
     */
    @Column(name = "FacultyTitle")
    private String facultyTitle;

    /**
     * FacultySalary
     */
    @Column(name = "FacultySalary")
    private Integer facultySalary;

    /**
     * FacultyName
     */
    @Column(name = "FacultyName")
    private String facultyName;

    /**
     * PersonID
     */
    @Column(name = "PersonID")
    private Integer personID;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
