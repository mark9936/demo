package com.demo.controller;

import com.demo.model.school.Section;
import com.demo.service.school.SectionService;
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

/** 提供開課班級的基本 CRUD REST API。 */
@RestController
@RequestMapping("/api/sections")
public class SectionController {

    private final SectionService service;

    public SectionController(SectionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Section> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Section findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Section> create(@RequestBody Section section) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(section));
    }

    @PutMapping("/{id}")
    public Section update(@PathVariable("id") Integer id, @RequestBody Section section) {
        return service.update(id, section);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
