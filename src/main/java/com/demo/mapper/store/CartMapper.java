package com.demo.mapper.store;

import com.demo.bean.store.CartBean;
import com.demo.mapstruct.GenericMapper;
import com.demo.model.store.Cart;
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