package com.demo.model.school;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Function: Student.java
 * @Description: Student Entity
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
@Data
@Entity
@Table(name = "STUDENT")
@NamedQuery(name = "Student.findAll", query = "SELECT c FROM Student c")
public class Student implements Serializable {

    private static final long serialVersionUID = -8201800323765310767L;

    /**
     * StudentID
     */
    @Id
    @Column(name = "StudentID")
    private Integer studentID;

    /**
     * StudentGPA
     */
    @Column(name = "StudentGPA")
    private Double studentGPA;

    /**
     * StudentName
     */
    @Column(name = "StudentName")
    private String studentName;

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
