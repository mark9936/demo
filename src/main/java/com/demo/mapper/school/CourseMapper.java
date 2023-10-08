package com.demo.mapper.school;

import com.demo.bean.school.CourseBean;
import com.demo.mapstruct.GenericMapper;
import com.demo.model.school.Course;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
* @Function: CourseMapper.java
* @Description: Course Mapper
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourseMapper extends GenericMapper<Course, CourseBean> {

}