package com.demo.repository.school;

import com.demo.model.school.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/** Person 的 Spring Data JPA Repository。 */
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
