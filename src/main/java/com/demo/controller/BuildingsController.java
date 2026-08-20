package com.demo.controller;

import com.demo.model.school.Buildings;
import com.demo.service.school.BuildingsService;
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

/** 提供校舍的基本 CRUD REST API。 */
@RestController
@RequestMapping("/api/buildings")
public class BuildingsController {

    private final BuildingsService service;

    public BuildingsController(BuildingsService service) {
        this.service = service;
    }

    @GetMapping
    public List<Buildings> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Buildings findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Buildings> create(@RequestBody Buildings buildings) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(buildings));
    }

    @PutMapping("/{id}")
    public Buildings update(@PathVariable("id") Integer id,
                            @RequestBody Buildings buildings) {
        return service.update(id, buildings);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
