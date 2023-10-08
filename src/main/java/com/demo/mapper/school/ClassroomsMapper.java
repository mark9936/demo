package com.demo.mapper.school;

import com.demo.bean.school.ClassroomsBean;
import com.demo.mapstruct.GenericMapper;
import com.demo.model.school.Classrooms;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
* @Function: ClassroomsMapper.java
* @Description: Classrooms Mapper
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClassroomsMapper extends GenericMapper<Classrooms, ClassroomsBean> {

}