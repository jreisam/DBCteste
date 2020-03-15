package dbc.jreis.ticket.controller;

import dbc.jreis.ticket.model.Estado;
import dbc.jreis.ticket.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping({"/estado"})
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<Estado>> findAll() {
        List<Estado> response = estadoService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Estado estado) {
        estadoService.save(estado);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> save(@PathVariable("Id") Long id, @Valid @RequestBody Estado estado) {
        estadoService.update(id, estado);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }
}