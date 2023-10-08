package com.demo.repository.store;

import com.demo.model.store.Record;
import com.demo.model.store.pk.RecordPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Function: RecordRepository.java
 * @Description: Record Repository
 * @author: kuo
 * @date: 2023/10/02
 * @MaintenancePersonnel: kuo
 */
@Repository
public interface RecordRepository extends JpaRepository<Record, RecordPK> {

}
