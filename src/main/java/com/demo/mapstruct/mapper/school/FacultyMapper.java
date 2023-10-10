package com.demo.mapstruct.mapper.school;

import com.demo.bean.school.FacultyBean;
import com.demo.mapstruct.GenericMapper;
import com.demo.model.school.Faculty;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @Function: FacultyMapper.java
 * @Description: Faculty Mapper
 * @author: kuo
 * @date: 2023/10/08
 * @MaintenancePersonnel: kuo
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FacultyMapper extends GenericMapper<Faculty, FacultyBean> {

}