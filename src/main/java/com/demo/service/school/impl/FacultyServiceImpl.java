package com.demo.service.school.impl;

import com.demo.exception.ResourceNotFoundException;
import com.demo.model.school.Faculty;
import com.demo.repository.school.FacultyRepository;
import com.demo.service.school.FacultyService;
import java.util.List;
import org.springframework.stereotype.Service;

/** FacultyService 的實作。 */
@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository repository;

    public FacultyServiceImpl(FacultyRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Faculty> findAll() {
        return repository.findAll();
    }

    @Override
    public Faculty findById(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("找不到 Faculty，id=" + id));
    }

    @Override
    public Faculty create(Faculty faculty) {
        return repository.save(faculty);
    }

    @Override
    public Faculty update(Integer id, Faculty faculty) {
        findById(id);
        faculty.setFacultyId(id);
        return repository.save(faculty);
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
