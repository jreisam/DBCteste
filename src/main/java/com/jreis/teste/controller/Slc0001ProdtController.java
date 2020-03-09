package com.jreis.teste.controller;

import com.jreis.teste.domain.GrupoSLC0001Prodt;
import com.jreis.teste.service.GrupoSLC0001ProdtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/slc0001prodt"})
public class Slc0001ProdtController {

    @Autowired
    private GrupoSLC0001ProdtService grupoSLC0001ProdtService;

    @GetMapping
    public ResponseEntity<List<GrupoSLC0001Prodt>> findAll() {
        List<GrupoSLC0001Prodt> response = grupoSLC0001ProdtService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody GrupoSLC0001Prodt grupoSLC0001Prodt) {
        grupoSLC0001ProdtService.save(grupoSLC0001Prodt);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> save(@PathVariable("Id") Long id, @Valid @RequestBody GrupoSLC0001Prodt grupoSLC0001Prodt) {
        grupoSLC0001ProdtService.update(id, grupoSLC0001Prodt);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }
}