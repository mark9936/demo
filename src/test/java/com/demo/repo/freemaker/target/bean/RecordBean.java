package com.demo.repo.freemaker.target.bean;

import java.io.Serializable;



import java.math.BigInteger;
import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
* @Function: RecordBean.java
* @Description: Record Bean
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/
@Data
public class RecordBean implements Serializable {

private static final long serialVersionUID = 5422472629401871016L;

    /** tNo */
  private String tNo;

    /** pNo */
  private String pNo;

    /** salePrice */
  private BigDecimal salePrice;

    /** amount */
  private Integer amount;


@Override
public String toString() {
return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
}

}
