package com.demo.service.school;

import com.demo.model.school.Textbook;
import java.util.List;

/** Textbook 的商業邏輯介面。 */
public interface TextbookService {

    List<Textbook> findAll();

    Textbook findById(Integer id);

    Textbook create(Textbook textbook);

    Textbook update(Integer id, Textbook textbook);

    void delete(Integer id);
}
