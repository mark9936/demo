package com.demo.controller;

import com.demo.model.school.Faculty;
import com.demo.service.school.FacultyService;
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

/** 提供教職員的基本 CRUD REST API。 */
@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

    private final FacultyService service;

    public FacultyController(FacultyService service) {
        this.service = service;
    }

    @GetMapping
    public List<Faculty> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Faculty findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Faculty> create(@RequestBody Faculty faculty) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(faculty));
    }

    @PutMapping("/{id}")
    public Faculty update(@PathVariable("id") Integer id, @RequestBody Faculty faculty) {
        return service.update(id, faculty);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
