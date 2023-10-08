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
 * @Function: Classrooms.java
 * @Description: Classrooms Entity
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
@Data
@Entity
@Table(name = "CLASSROOMS")
@NamedQuery(name = "Classrooms.findAll", query = "SELECT c FROM Classrooms c")
public class Classrooms implements Serializable {

    private static final long serialVersionUID = -6803828971822182465L;

    /**
     * RoomNumber
     */
    @Id
    @Column(name = "RoomNumber")
    private Integer roomNumber;

    /**
     * HasProjector
     */
    @Column(name = "HasProjector")
    private String hasProjector;

    /**
     * BuildingID
     */
    @Column(name = "BuildingID")
    private Integer buildingID;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
