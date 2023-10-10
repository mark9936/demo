package com.demo.mapstruct.mapper.school;

import com.demo.bean.school.SectionBean;
import com.demo.mapstruct.GenericMapper;
import com.demo.model.school.Section;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @Function: SectionMapper.java
 * @Description: Section Mapper
 * @author: kuo
 * @date: 2023/10/08
 * @MaintenancePersonnel: kuo
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SectionMapper extends GenericMapper<Section, SectionBean> {

}