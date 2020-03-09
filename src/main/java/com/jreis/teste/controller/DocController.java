package com.jreis.teste.controller;

import com.jreis.teste.domain.Doc;
import com.jreis.teste.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/document"})
public class DocController {

    @Autowired
    private DocService docService;

    @GetMapping
    public ResponseEntity<List<Doc>> findAll() {
        List<Doc> response = docService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Doc doc) {
        docService.save(doc);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> save(@PathVariable("Id") Long id, @Valid @RequestBody Doc doc) {
        docService.update(id, doc);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }
}