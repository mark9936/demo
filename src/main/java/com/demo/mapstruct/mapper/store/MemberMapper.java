package com.demo.mapstruct.mapper.store;

import com.demo.bean.store.MemberBean;
import com.demo.mapstruct.GenericMapper;
import com.demo.model.store.Member;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @Function: MemberMapper.java
 * @Description: Member Mapper
 * @author: kuo
 * @date: 2023/10/08
 * @MaintenancePersonnel: kuo
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MemberMapper extends GenericMapper<Member, MemberBean> {

}