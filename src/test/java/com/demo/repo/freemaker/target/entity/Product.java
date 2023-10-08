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
* @Function: Product.java
* @Description: Product Entity
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/
@Data
@Entity
@Table(name = "PRODUCT")
@NamedQuery(name = "Product.findAll", query = "SELECT c FROM Product c")
public class Product implements Serializable {

private static final long serialVersionUID = 7414919119839326032L;

    /** pNo */
      @Column(name = "pNo")
  private String pNo;

    /** pName */
      @Column(name = "pName")
  private String pName;

    /** unitPrice */
      @Column(name = "unitPrice")
  private BigDecimal unitPrice;

    /** catalog */
      @Column(name = "catalog")
  private String catalog;


@Override
public String toString() {
return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
}

}
