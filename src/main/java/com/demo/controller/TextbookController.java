package com.demo.controller;

import com.demo.model.school.Textbook;
import com.demo.service.school.TextbookService;
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

/** 提供教科書的基本 CRUD REST API。 */
@RestController
@RequestMapping("/api/textbooks")
public class TextbookController {

    private final TextbookService service;

    public TextbookController(TextbookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Textbook> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Textbook findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Textbook> create(@RequestBody Textbook textbook) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(textbook));
    }

    @PutMapping("/{id}")
    public Textbook update(@PathVariable("id") Integer id, @RequestBody Textbook textbook) {
        return service.update(id, textbook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
