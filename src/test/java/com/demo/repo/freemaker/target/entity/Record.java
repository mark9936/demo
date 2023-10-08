package com.demo.repo.freemaker.target.entity;

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
* @Function: Record.java
* @Description: Record Entity
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/
@Data
@Entity
@Table(name = "RECORD")
@NamedQuery(name = "Record.findAll", query = "SELECT c FROM Record c")
public class Record implements Serializable {

private static final long serialVersionUID = 5422472629401871016L;

    /** tNo */
      @Column(name = "tNo")
  private String tNo;

    /** pNo */
      @Column(name = "pNo")
  private String pNo;

    /** salePrice */
      @Column(name = "salePrice")
  private BigDecimal salePrice;

    /** amount */
      @Column(name = "amount")
  private Integer amount;


@Override
public String toString() {
return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
}

}
