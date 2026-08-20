package com.demo.controller;

import com.demo.model.school.Interns;
import com.demo.service.school.InternsService;
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

/** 提供實習生的基本 CRUD REST API。 */
@RestController
@RequestMapping("/api/interns")
public class InternsController {

    private final InternsService service;

    public InternsController(InternsService service) {
        this.service = service;
    }

    @GetMapping
    public List<Interns> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Interns findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Interns> create(@RequestBody Interns interns) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(interns));
    }

    @PutMapping("/{id}")
    public Interns update(@PathVariable("id") Integer id, @RequestBody Interns interns) {
        return service.update(id, interns);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
