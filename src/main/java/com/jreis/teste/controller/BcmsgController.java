package com.jreis.teste.controller;

import com.jreis.teste.domain.BcMsg;
import com.jreis.teste.service.BcMsgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/bcmsg"})
@Slf4j
public class BcmsgController {

    @Autowired
    private BcMsgService bcmsgService;

    @GetMapping
    public ResponseEntity<List<BcMsg>> findAll() {
        log.info("findAll BcMsg");
        List<BcMsg> response = bcmsgService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody BcMsg bcmsg) {
        bcmsgService.save(bcmsg);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> save(@PathVariable("Id") Long id, @Valid @RequestBody BcMsg bcmsg) {
        bcmsgService.update(id, bcmsg);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

}