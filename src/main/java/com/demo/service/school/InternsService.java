package com.demo.service.school;

import com.demo.model.school.Interns;
import java.util.List;

/** Interns 的商業邏輯介面。 */
public interface InternsService {

    List<Interns> findAll();

    Interns findById(Integer id);

    Interns create(Interns interns);

    Interns update(Integer id, Interns interns);

    void delete(Integer id);
}
