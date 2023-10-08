package com.demo.repo.freemaker.target.mapper;

import com.demo.repo.freemaker.target.bean.OrderBean;
import com.demo.mapstruct.GenericMapper;
import com.demo.repo.freemaker.target.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
* @Function: OrderMapper.java
* @Description: Order Mapper
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper extends GenericMapper<Order, OrderBean> {

}