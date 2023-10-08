package com.demo.mapper.school;

import com.demo.bean.school.InternsBean;
import com.demo.mapstruct.GenericMapper;
import com.demo.model.school.Interns;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
* @Function: InternsMapper.java
* @Description: Interns Mapper
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InternsMapper extends GenericMapper<Interns, InternsBean> {

}