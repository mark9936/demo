package com.demo.model.school;

import java.io.Serializable;


import java.time.LocalDate;


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
 * @Function: Section.java
 * @Description: Section Entity
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
@Data
@Entity
@Table(name = "SECTION")
@NamedQuery(name = "Section.findAll", query = "SELECT c FROM Section c")
public class Section implements Serializable {

    private static final long serialVersionUID = 7217945477799703404L;

    /**
     * SectionID
     */
    @Id
    @Column(name = "SectionID")
    private Integer sectionID;

    /**
     * SectionDate
     */
    @Column(name = "SectionDate")
    private LocalDate sectionDate;

    /**
     * RoomNumber
     */
    @Column(name = "RoomNumber")
    private Integer roomNumber;

    /**
     * CourseID
     */
    @Column(name = "CourseID")
    private Integer courseID;

    /**
     * BuildingID
     */
    @Column(name = "BuildingID")
    private Integer buildingID;

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
