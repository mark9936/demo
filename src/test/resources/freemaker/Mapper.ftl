package com.demo.repo.freemaker.target.mapper;

import com.demo.repo.freemaker.target.bean.${tableBean.entityName}Bean;
import com.demo.mapstruct.GenericMapper;
import com.demo.repo.freemaker.target.entity.${tableBean.entityName};
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
* @Function: ${tableBean.entityName}Mapper.java
* @Description: ${tableBean.tableName} Mapper
* @author: ${tableBean.userName}
* @date: ${.now ? string["yyyy/MM/dd"]}
* @MaintenancePersonnel: ${tableBean.userName}
*/

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ${tableBean.entityName}Mapper extends GenericMapper<${tableBean.entityName}, ${tableBean.entityName}Bean> {

}