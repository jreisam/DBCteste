package com.jreis.teste.controller;

import com.jreis.teste.domain.GrupoSLC0001Liquid;
import com.jreis.teste.service.GrupoSLC0001LiquidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/slc0001liquid"})
public class Slc0001LiquidController {

    @Autowired
    private GrupoSLC0001LiquidService grupoSLC0001LiquidService;

    @GetMapping
    public ResponseEntity<List<GrupoSLC0001Liquid>> findAll() {
        List<GrupoSLC0001Liquid> response = grupoSLC0001LiquidService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody GrupoSLC0001Liquid grupoSLC0001Liquid) {
        grupoSLC0001LiquidService.save(grupoSLC0001Liquid);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> save(@PathVariable("Id") Long id, @Valid @RequestBody GrupoSLC0001Liquid grupoSLC0001Liquid) {
        grupoSLC0001LiquidService.update(id, grupoSLC0001Liquid);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }
}