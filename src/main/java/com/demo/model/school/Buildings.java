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
 * @Function: Buildings.java
 * @Description: Buildings Entity
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
@Data
@Entity
@Table(name = "BUILDINGS")
@NamedQuery(name = "Buildings.findAll", query = "SELECT c FROM Buildings c")
public class Buildings implements Serializable {

    private static final long serialVersionUID = -6581134394718313970L;

    /**
     * BuildingID
     */
    @Id
    @Column(name = "BuildingID")
    private Integer buildingID;

    /**
     * BuildingName
     */
    @Column(name = "BuildingName")
    private String buildingName;

    /**
     * CollegeName
     */
    @Column(name = "CollegeName")
    private String collegeName;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
