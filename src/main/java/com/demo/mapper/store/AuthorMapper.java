package com.demo.mapper.store;

import com.demo.bean.store.AuthorBean;
import com.demo.mapstruct.GenericMapper;
import com.demo.model.store.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @Function: AuthorMapper.java
 * @Description: Author Mapper
 * @author: kuo
 * @date: 2023/10/08
 * @MaintenancePersonnel: kuo
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuthorMapper extends GenericMapper<Author, AuthorBean> {

}