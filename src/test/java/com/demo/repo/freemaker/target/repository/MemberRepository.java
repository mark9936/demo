package com.demo.repo.freemaker.target.repository;

import com.demo.repo.freemaker.target.entity.Member;

import org.springframework.data.jpa.repository.JpaRepository;

/**
* @Function: MemberRepository.java
* @Description: Member Repository
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/
public interface MemberRepository extends JpaRepository<Member, String> {

}
