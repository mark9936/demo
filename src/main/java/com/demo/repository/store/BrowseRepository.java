package com.demo.repository.store;

import com.demo.model.store.Browse;
import com.demo.model.store.pk.BrowsePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Function: BrowseRepository.java
 * @Description: Browse Repository
 * @author: kuo
 * @date: 2023/10/02
 * @MaintenancePersonnel: kuo
 */
@Repository
public interface BrowseRepository extends JpaRepository<Browse, BrowsePK> {

}
