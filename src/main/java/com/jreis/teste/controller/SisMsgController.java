package com.jreis.teste.controller;

import com.jreis.teste.domain.SisMsg;
import com.jreis.teste.service.SisMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/sismsg"})
public class SisMsgController {

    @Autowired
    private SisMsgService sisMsgService;

    @GetMapping
    public ResponseEntity<List<SisMsg>> findAll() {
        List<SisMsg> response = sisMsgService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody SisMsg sisMsg) {
        sisMsgService.save(sisMsg);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> save(@PathVariable("Id") Long id, @Valid @RequestBody SisMsg sisMsg) {
        sisMsgService.update(id, sisMsg);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }
}