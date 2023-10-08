package com.demo.mapper.school;

import com.demo.bean.school.PersonBean;
import com.demo.mapstruct.GenericMapper;
import com.demo.model.school.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
* @Function: PersonMapper.java
* @Description: Person Mapper
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonMapper extends GenericMapper<Person, PersonBean> {

}