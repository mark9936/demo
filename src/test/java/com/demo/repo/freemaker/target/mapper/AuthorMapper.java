package com.demo.repo.freemaker.target.mapper;

import com.demo.repo.freemaker.target.bean.AuthorBean;
import com.demo.mapstruct.GenericMapper;
import com.demo.repo.freemaker.target.entity.Author;
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