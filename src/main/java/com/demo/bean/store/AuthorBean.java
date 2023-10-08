package com.demo.bean.store;

import java.io.Serializable;


import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Function: AuthorBean.java
 * @Description: Author Bean
 * @author: kuo
 * @date: 2023/10/02
 * @MaintenancePersonnel: kuo
 */
@Data
public class AuthorBean implements Serializable {

    private static final long serialVersionUID = 4747832975804633972L;

    /**
     * pNo
     */
    private String pNo;

    /**
     * name
     */
    private String name;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
