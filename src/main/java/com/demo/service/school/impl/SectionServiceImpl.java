package com.demo.service.school.impl;

import com.demo.exception.ResourceNotFoundException;
import com.demo.model.school.Section;
import com.demo.repository.school.SectionRepository;
import com.demo.service.school.SectionService;
import java.util.List;
import org.springframework.stereotype.Service;

/** SectionService 的實作。 */
@Service
public class SectionServiceImpl implements SectionService {

    private final SectionRepository repository;

    public SectionServiceImpl(SectionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Section> findAll() {
        return repository.findAll();
    }

    @Override
    public Section findById(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("找不到 Section，id=" + id));
    }

    @Override
    public Section create(Section section) {
        return repository.save(section);
    }

    @Override
    public Section update(Integer id, Section section) {
        findById(id);
        section.setSectionId(id);
        return repository.save(section);
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
