package com.demo.repo.freemaker.target.bean;

import java.io.Serializable;



import java.math.BigInteger;
import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
* @Function: ProductBean.java
* @Description: Product Bean
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/
@Data
public class ProductBean implements Serializable {

private static final long serialVersionUID = 7414919119839326032L;

    /** pNo */
  private String pNo;

    /** pName */
  private String pName;

    /** unitPrice */
  private BigDecimal unitPrice;

    /** catalog */
  private String catalog;


@Override
public String toString() {
return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
}

}
