package ${projectName}.repo.freemaker.target.bean;

import java.io.Serializable;

<#if tableBean.localDate>import java.time.LocalDate;</#if>
<#if tableBean.localDateTime>import java.time.LocalDateTime;</#if>
import java.math.BigInteger;
import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Function: ${tableBean.entityName}Bean.java
 * @Description: ${tableBean.tableName} Bean
 * @author: ${tableBean.userName}
 * @date: ${.now ? string["yyyy/MM/dd"]}
 * @MaintenancePersonnel: ${tableBean.userName}
 */
@Data
public class ${tableBean.entityName}Bean<#if tableBean.baseEntity> extends BaseEntity</#if> implements Serializable {

    private static final long serialVersionUID = ${tableBean.serialVersion};
    <#list tableBean.columnBeans as columnBean>

    <#if columnBean.columnName?has_content>
    /**
     * ${columnBean.columnName}
     */
    </#if>
    private ${columnBean.dataType} ${columnBean.field};
    </#list>

    <#--    public ${tableBean.entityName}Bean() {-->
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
