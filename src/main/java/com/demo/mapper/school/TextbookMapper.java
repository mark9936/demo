package com.demo.mapper.school;

import com.demo.bean.school.TextbookBean;
import com.demo.mapstruct.GenericMapper;
import com.demo.model.school.Textbook;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @Function: TextbookMapper.java
 * @Description: Textbook Mapper
 * @author: kuo
 * @date: 2023/10/08
 * @MaintenancePersonnel: kuo
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TextbookMapper extends GenericMapper<Textbook, TextbookBean> {

}