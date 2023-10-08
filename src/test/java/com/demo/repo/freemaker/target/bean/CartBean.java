package com.demo.repo.freemaker.target.bean;

import java.io.Serializable;


import java.time.LocalDateTime;
import java.math.BigInteger;
import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
* @Function: CartBean.java
* @Description: Cart Bean
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/
@Data
public class CartBean implements Serializable {

private static final long serialVersionUID = -4812942183305069188L;

    /** mId */
  private String mId;

    /** cartTime */
  private LocalDateTime cartTime;

    /** tNo */
  private String tNo;


@Override
public String toString() {
return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
}

}
