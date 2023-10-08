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
* @Function: Author.java
* @Description: Author Entity
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/
@Data
@Entity
@Table(name = "AUTHOR")
@NamedQuery(name = "Author.findAll", query = "SELECT c FROM Author c")
public class Author implements Serializable {

private static final long serialVersionUID = 2656781703446593833L;

    /** pNo */
      @Column(name = "pNo")
  private String pNo;

    /** name */
      @Column(name = "name")
  private String name;


@Override
public String toString() {
return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
}

}
