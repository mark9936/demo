package com.demo.repo.freemaker.target.mapper;

import com.demo.repo.freemaker.target.bean.TransactionBean;
import com.demo.mapstruct.GenericMapper;
import com.demo.repo.freemaker.target.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
* @Function: TransactionMapper.java
* @Description: Transaction Mapper
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransactionMapper extends GenericMapper<Transaction, TransactionBean> {

}