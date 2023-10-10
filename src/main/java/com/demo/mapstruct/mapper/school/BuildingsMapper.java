package com.demo.mapstruct.mapper.school;

import com.demo.bean.school.BuildingsBean;
import com.demo.mapstruct.GenericMapper;
import com.demo.model.school.Buildings;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @Function: BuildingsMapper.java
 * @Description: Buildings Mapper
 * @author: kuo
 * @date: 2023/10/08
 * @MaintenancePersonnel: kuo
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BuildingsMapper extends GenericMapper<Buildings, BuildingsBean> {

}