package com.demo.service.school.impl;

import com.demo.exception.ResourceNotFoundException;
import com.demo.model.school.Interns;
import com.demo.repository.school.InternsRepository;
import com.demo.service.school.InternsService;
import java.util.List;
import org.springframework.stereotype.Service;

/** InternsService 的實作。 */
@Service
public class InternsServiceImpl implements InternsService {

    private final InternsRepository repository;

    public InternsServiceImpl(InternsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Interns> findAll() {
        return repository.findAll();
    }

    @Override
    public Interns findById(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("找不到 Intern，id=" + id));
    }

    @Override
    public Interns create(Interns interns) {
        return repository.save(interns);
    }

    @Override
    public Interns update(Integer id, Interns interns) {
        findById(id);
        interns.setInternId(id);
        return repository.save(interns);
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
