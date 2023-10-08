package com.demo.bean.school;

import java.io.Serializable;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Function: StudentBean.java
 * @Description: Student Bean
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
@Data
public class StudentBean implements Serializable {

    private static final long serialVersionUID = -8201800323765310767L;

    /**
     * StudentID
     */
    private Integer studentID;

    /**
     * StudentGPA
     */
    private Double studentGPA;

    /**
     * StudentName
     */
    private String studentName;

    /**
     * PersonID
     */
    private Integer personID;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
