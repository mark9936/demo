package com.demo.repo.freemaker.target.repository;

import com.demo.repo.freemaker.target.entity.${tableBean.entityName};

import org.springframework.data.jpa.repository.JpaRepository;

/**
* @Function: ${tableBean.entityName}Repository.java
* @Description: ${tableBean.tableName} Repository
* @author: ${tableBean.userName}
* @date: ${.now ? string["yyyy/MM/dd"]}
* @MaintenancePersonnel: ${tableBean.userName}
*/
public interface ${tableBean.entityName}Repository extends JpaRepository<${tableBean.entityName}, String> {

}
