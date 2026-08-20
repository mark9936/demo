package com.demo.service.school;

import com.demo.model.school.Person;
import java.util.List;

/** Person 的商業邏輯介面。 */
public interface PersonService {

    List<Person> findAll();

    Person findById(Integer id);

    Person create(Person person);

    Person update(Integer id, Person person);

    void delete(Integer id);
}
