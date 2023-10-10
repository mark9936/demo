package com.demo.mapstruct.mapper.school;

import com.demo.bean.school.StudentBean;
import com.demo.mapstruct.GenericMapper;
import com.demo.model.school.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @Function: StudentMapper.java
 * @Description: Student Mapper
 * @author: kuo
 * @date: 2023/10/08
 * @MaintenancePersonnel: kuo
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentMapper extends GenericMapper<Student, StudentBean> {

}