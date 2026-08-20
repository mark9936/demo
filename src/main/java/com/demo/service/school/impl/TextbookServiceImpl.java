package com.demo.service.school.impl;

import com.demo.exception.ResourceNotFoundException;
import com.demo.model.school.Textbook;
import com.demo.repository.school.TextbookRepository;
import com.demo.service.school.TextbookService;
import java.util.List;
import org.springframework.stereotype.Service;

/** TextbookService 的實作。 */
@Service
public class TextbookServiceImpl implements TextbookService {

    private final TextbookRepository repository;

    public TextbookServiceImpl(TextbookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Textbook> findAll() {
        return repository.findAll();
    }

    @Override
    public Textbook findById(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("找不到 Textbook，isbn=" + id));
    }

    @Override
    public Textbook create(Textbook textbook) {
        return repository.save(textbook);
    }

    @Override
    public Textbook update(Integer id, Textbook textbook) {
        findById(id);
        textbook.setTextbookIsbn(id);
        return repository.save(textbook);
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
