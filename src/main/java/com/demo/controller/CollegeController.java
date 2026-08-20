package com.demo.controller;

import com.demo.model.school.College;
import com.demo.service.school.CollegeService;
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

/** 提供學院的基本 CRUD REST API。 */
@RestController
@RequestMapping("/api/colleges")
public class CollegeController {

    private final CollegeService service;

    public CollegeController(CollegeService service) {
        this.service = service;
    }

    @GetMapping
    public List<College> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public College findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<College> create(@RequestBody College college) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(college));
    }

    @PutMapping("/{id}")
    public College update(@PathVariable("id") String id, @RequestBody College college) {
        return service.update(id, college);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
