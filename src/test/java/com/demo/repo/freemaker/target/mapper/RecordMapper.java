package com.demo.repo.freemaker.target.mapper;

import com.demo.repo.freemaker.target.bean.RecordBean;
import com.demo.mapstruct.GenericMapper;
import com.demo.repo.freemaker.target.entity.Record;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
* @Function: RecordMapper.java
* @Description: Record Mapper
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RecordMapper extends GenericMapper<Record, RecordBean> {

}