package com.demo.service.school;

import com.demo.model.school.College;
import java.util.List;

/** College 的商業邏輯介面。 */
public interface CollegeService {

    List<College> findAll();

    College findById(String id);

    College create(College college);

    College update(String id, College college);

    void delete(String id);
}
