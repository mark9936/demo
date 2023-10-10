package com.demo.mapstruct.mapper.store;

import com.demo.bean.store.BrowseBean;
import com.demo.mapstruct.GenericMapper;
import com.demo.model.store.Browse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @Function: BrowseMapper.java
 * @Description: Browse Mapper
 * @author: kuo
 * @date: 2023/10/08
 * @MaintenancePersonnel: kuo
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BrowseMapper extends GenericMapper<Browse, BrowseBean> {

}