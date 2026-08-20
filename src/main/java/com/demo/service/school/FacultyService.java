package com.demo.service.school;

import com.demo.model.school.Faculty;
import java.util.List;

/** Faculty 的商業邏輯介面。 */
public interface FacultyService {

    List<Faculty> findAll();

    Faculty findById(Integer id);

    Faculty create(Faculty faculty);

    Faculty update(Integer id, Faculty faculty);

    void delete(Integer id);
}
