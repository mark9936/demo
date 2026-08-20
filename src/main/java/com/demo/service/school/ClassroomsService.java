package com.demo.service.school;

import com.demo.model.school.Classrooms;
import java.util.List;

/** Classrooms 的商業邏輯介面。 */
public interface ClassroomsService {

    List<Classrooms> findAll();

    Classrooms findById(Integer id);

    Classrooms create(Classrooms classrooms);

    Classrooms update(Integer id, Classrooms classrooms);

    void delete(Integer id);
}
