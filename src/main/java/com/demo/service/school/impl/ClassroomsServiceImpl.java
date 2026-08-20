package com.demo.service.school.impl;

import com.demo.exception.ResourceNotFoundException;
import com.demo.model.school.Classrooms;
import com.demo.repository.school.ClassroomsRepository;
import com.demo.service.school.ClassroomsService;
import java.util.List;
import org.springframework.stereotype.Service;

/** ClassroomsService 的實作。 */
@Service
public class ClassroomsServiceImpl implements ClassroomsService {

    private final ClassroomsRepository repository;

    public ClassroomsServiceImpl(ClassroomsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Classrooms> findAll() {
        return repository.findAll();
    }

    @Override
    public Classrooms findById(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("找不到 Classroom，id=" + id));
    }

    @Override
    public Classrooms create(Classrooms classrooms) {
        return repository.save(classrooms);
    }

    @Override
    public Classrooms update(Integer id, Classrooms classrooms) {
        findById(id);
        classrooms.setRoomNumber(id);
        return repository.save(classrooms);
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
