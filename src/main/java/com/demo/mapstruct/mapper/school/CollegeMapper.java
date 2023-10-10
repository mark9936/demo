package com.demo.mapstruct.mapper.school;

import com.demo.bean.school.CollegeBean;
import com.demo.mapstruct.GenericMapper;
import com.demo.model.school.College;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @Function: CollegeMapper.java
 * @Description: College Mapper
 * @author: kuo
 * @date: 2023/10/08
 * @MaintenancePersonnel: kuo
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CollegeMapper extends GenericMapper<College, CollegeBean> {

}