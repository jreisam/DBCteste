package com.jreis.teste.controller;

import com.jreis.teste.domain.GrupoSeq;
import com.jreis.teste.service.GrupoSeqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/sequence"})
public class GrupoSeqController {

    @Autowired
    private GrupoSeqService grupoSeqService;

    @GetMapping
    public ResponseEntity<List<GrupoSeq>> findAll() {
        List<GrupoSeq> response = grupoSeqService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody GrupoSeq grupoSeq) {
        grupoSeqService.save(grupoSeq);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> save(@PathVariable("Id") Long id, @Valid @RequestBody GrupoSeq grupoSeq) {
        grupoSeqService.update(id, grupoSeq);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }
}