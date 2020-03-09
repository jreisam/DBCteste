package com.jreis.teste.controller;

import com.jreis.teste.domain.GrupoSLC0001LiquidProdt;
import com.jreis.teste.service.GrupoSLC0001LiquidProdtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/slc0001liquidprodt"})
public class Slc0001LiquidProdtController {

    @Autowired
    private GrupoSLC0001LiquidProdtService grupoSLC0001LiquidProdtService;

    @GetMapping
    public ResponseEntity<List<GrupoSLC0001LiquidProdt>> findAll() {
        List<GrupoSLC0001LiquidProdt> response = grupoSLC0001LiquidProdtService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody GrupoSLC0001LiquidProdt grupoSLC0001LiquidProdt) {
        grupoSLC0001LiquidProdtService.save(grupoSLC0001LiquidProdt);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> save(@PathVariable("Id") Long id, @Valid @RequestBody GrupoSLC0001LiquidProdt grupoSLC0001LiquidProdt) {
        grupoSLC0001LiquidProdtService.update(id, grupoSLC0001LiquidProdt);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }
}