package ${projectName}.repo.freemaker.target.mapper;

import ${projectName}.repo.freemaker.target.bean.${tableBean.entityName}Bean;
import ${projectName}.mapstruct.GenericMapper;
import ${projectName}.repo.freemaker.target.entity.${tableBean.entityName};
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