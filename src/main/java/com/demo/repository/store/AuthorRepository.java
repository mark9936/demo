package com.demo.repository.store;

import com.demo.model.store.Author;
import com.demo.model.store.pk.AuthorPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Function: AuthorRepository.java
 * @Description: Author Repository
 * @author: kuo
 * @date: 2023/10/02
 * @MaintenancePersonnel: kuo
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, AuthorPK> {

}
