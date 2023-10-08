package com.demo.repo.freemaker.target.mapper;

import com.demo.repo.freemaker.target.bean.CartBean;
import com.demo.mapstruct.GenericMapper;
import com.demo.repo.freemaker.target.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
* @Function: CartMapper.java
* @Description: Cart Mapper
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CartMapper extends GenericMapper<Cart, CartBean> {

}