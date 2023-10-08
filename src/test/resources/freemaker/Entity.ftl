package com.demo.repo.freemaker.target.entity;

import java.io.Serializable;

<#if tableBean.localDate>import java.time.LocalDate;</#if>
<#if tableBean.localDateTime>import java.time.LocalDateTime;</#if>

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
* @Function: ${tableBean.entityName}.java
* @Description: ${tableBean.tableName} Entity
* @author: ${tableBean.userName}
* @date: ${.now ? string["yyyy/MM/dd"]}
* @MaintenancePersonnel: ${tableBean.userName}
*/
@Data
@Entity
@Table(name = "${tableBean.table}")
@NamedQuery(name = "${tableBean.entityName}.findAll", query = "SELECT c FROM ${tableBean.entityName} c")
public class ${tableBean.entityName}<#if tableBean.baseEntity> extends BaseEntity</#if> implements Serializable {

private static final long serialVersionUID = ${tableBean.serialVersion};
<#list tableBean.columnBeans as columnBean>

    <#if columnBean.columnName?has_content>/** ${columnBean.columnName} */</#if>
    <#if columnBean.field == 'id'>
      @Id
      @Column(name = "${columnBean.column}", unique = true, nullable = false)
      // @GeneratedValue(generator = "uuid")
      // @GenericGenerator(name = "uuid", strategy = "uuid2")
    <#else>
      @Column(name = "${columnBean.column}")
    </#if>
  private ${columnBean.dataType} ${columnBean.field};
</#list>

<#--    public ${tableBean.entityName}() {-->
<#--    } -->
<#--<#list tableBean.columnBeans as columnBean>-->

<#--    <#if columnBean.columnName?has_content>/** ${columnBean.columnName} */</#if>-->
<#--    public ${columnBean.dataType} get${columnBean.methodFiled}() {-->
<#--        return ${columnBean.field};-->
<#--    }-->

<#--    <#if columnBean.columnName?has_content>/** ${columnBean.columnName} */</#if>-->
<#--    public void set${columnBean.methodFiled}(${columnBean.dataType} ${columnBean.field}) {-->
<#--        this.${columnBean.field} = ${columnBean.field};-->
<#--    }-->
<#--</#list>-->

@Override
public String toString() {
return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
}

}
