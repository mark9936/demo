package com.demo.controller;

import com.demo.model.school.Classrooms;
import com.demo.service.school.ClassroomsService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 提供教室的基本 CRUD REST API。 */
@RestController
@RequestMapping("/api/classrooms")
public class ClassroomsController {

    private final ClassroomsService service;

    public ClassroomsController(ClassroomsService service) {
        this.service = service;
    }

    @GetMapping
    public List<Classrooms> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Classrooms findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Classrooms> create(@RequestBody Classrooms classrooms) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(classrooms));
    }

    @PutMapping("/{id}")
    public Classrooms update(@PathVariable("id") Integer id,
                             @RequestBody Classrooms classrooms) {
        return service.update(id, classrooms);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
