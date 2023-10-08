package com.demo.repository.store;

import com.demo.model.store.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Function: MemberRepository.java
 * @Description: Member Repository
 * @author: kuo
 * @date: 2023/10/02
 * @MaintenancePersonnel: kuo
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

}
