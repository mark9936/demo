package com.demo.mapper.store;

import com.demo.bean.store.ProductBean;
import com.demo.mapstruct.GenericMapper;
import com.demo.model.store.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @Function: ProductMapper.java
 * @Description: Product Mapper
 * @author: kuo
 * @date: 2023/10/08
 * @MaintenancePersonnel: kuo
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper extends GenericMapper<Product, ProductBean> {

}