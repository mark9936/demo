package com.demo.service.school.impl;

import com.demo.exception.ResourceNotFoundException;
import com.demo.model.school.College;
import com.demo.repository.school.CollegeRepository;
import com.demo.service.school.CollegeService;
import java.util.List;
import org.springframework.stereotype.Service;

/** CollegeService 的實作。 */
@Service
public class CollegeServiceImpl implements CollegeService {

    private final CollegeRepository repository;

    public CollegeServiceImpl(CollegeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<College> findAll() {
        return repository.findAll();
    }

    @Override
    public College findById(String id) {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("找不到 College，name=" + id));
    }

    @Override
    public College create(College college) {
        return repository.save(college);
    }

    @Override
    public College update(String id, College college) {
        findById(id);
        college.setCollegeName(id);
        return repository.save(college);
    }

    @Override
    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }
}
