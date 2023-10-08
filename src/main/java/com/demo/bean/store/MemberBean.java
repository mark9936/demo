package com.demo.bean.store;

import java.io.Serializable;


import java.time.LocalDateTime;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Function: MemberBean.java
 * @Description: Member Bean
 * @author: kuo
 * @date: 2023/10/02
 * @MaintenancePersonnel: kuo
 */
@Data
public class MemberBean implements Serializable {

    private static final long serialVersionUID = 8748338825999143976L;

    /**
     * mId
     */
    private String mId;

    /**
     * pId
     */
    private String pId;

    /**
     * name
     */
    private String name;

    /**
     * birthday
     */
    private LocalDateTime birthday;

    /**
     * phone
     */
    private String phone;

    /**
     * address
     */
    private String address;

    /**
     * email
     */
    private String email;

    /**
     * introducer
     */
    private String introducer;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
