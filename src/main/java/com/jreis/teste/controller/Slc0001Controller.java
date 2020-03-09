package com.jreis.teste.controller;

import com.jreis.teste.domain.SLC0001;
import com.jreis.teste.service.SLC0001Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/slc0001"})
public class Slc0001Controller {

    @Autowired
    private SLC0001Service slc0001Service;

    @GetMapping
    public ResponseEntity<List<SLC0001>> findAll() {
        List<SLC0001> response = slc0001Service.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody SLC0001 slc0001) {
        slc0001Service.save(slc0001);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> save(@PathVariable("Id") Long id, @Valid @RequestBody SLC0001 slc0001) {
        slc0001Service.update(id, slc0001);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }
}