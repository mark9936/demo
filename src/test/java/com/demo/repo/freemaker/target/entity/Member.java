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
* @Function: Member.java
* @Description: Member Entity
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/
@Data
@Entity
@Table(name = "MEMBER")
@NamedQuery(name = "Member.findAll", query = "SELECT c FROM Member c")
public class Member implements Serializable {

private static final long serialVersionUID = 2381375898179703144L;

    /** mId */
      @Column(name = "mId")
  private String mId;

    /** pId */
      @Column(name = "pId")
  private String pId;

    /** name */
      @Column(name = "name")
  private String name;

    /** birthday */
      @Column(name = "birthday")
  private LocalDateTime birthday;

    /** phone */
      @Column(name = "phone")
  private String phone;

    /** address */
      @Column(name = "address")
  private String address;

    /** email */
      @Column(name = "email")
  private String email;

    /** introducer */
      @Column(name = "introducer")
  private String introducer;


@Override
public String toString() {
return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
}

}
