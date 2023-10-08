package com.demo.repo.freemaker.target.bean;

import java.io.Serializable;


import java.time.LocalDateTime;
import java.math.BigInteger;
import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
* @Function: BrowseBean.java
* @Description: Browse Bean
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/
@Data
public class BrowseBean implements Serializable {

private static final long serialVersionUID = 1237443412398945475L;

    /** mId */
  private String mId;

    /** pNo */
  private String pNo;

    /** browseTime */
  private LocalDateTime browseTime;


@Override
public String toString() {
return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
}

}
