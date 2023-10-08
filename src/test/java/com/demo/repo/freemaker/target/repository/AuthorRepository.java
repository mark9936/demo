package com.demo.repo.freemaker.target.repository;

import com.demo.repo.freemaker.target.entity.Author;

import org.springframework.data.jpa.repository.JpaRepository;

/**
* @Function: AuthorRepository.java
* @Description: Author Repository
* @author: kuo
* @date: 2023/10/08
* @MaintenancePersonnel: kuo
*/
public interface AuthorRepository extends JpaRepository<Author, String> {

}
