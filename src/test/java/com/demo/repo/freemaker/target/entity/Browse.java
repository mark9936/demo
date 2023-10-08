package com.demo.repo.freemaker.target.entity;

import java.io.Serializable;


import java.time.LocalDateTime;

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
* @Function: Browse.java
* @Description: Browse Entity
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/
@Data
@Entity
@Table(name = "BROWSE")
@NamedQuery(name = "Browse.findAll", query = "SELECT c FROM Browse c")
public class Browse implements Serializable {

private static final long serialVersionUID = 1237443412398945475L;

    /** mId */
      @Column(name = "mId")
  private String mId;

    /** pNo */
      @Column(name = "pNo")
  private String pNo;

    /** browseTime */
      @Column(name = "browseTime")
  private LocalDateTime browseTime;


@Override
public String toString() {
return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
}

}
