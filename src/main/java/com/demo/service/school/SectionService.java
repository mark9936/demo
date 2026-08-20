package com.demo.service.school;

import com.demo.model.school.Section;
import java.util.List;

/** Section 的商業邏輯介面。 */
public interface SectionService {

    List<Section> findAll();

    Section findById(Integer id);

    Section create(Section section);

    Section update(Integer id, Section section);

    void delete(Integer id);
}
