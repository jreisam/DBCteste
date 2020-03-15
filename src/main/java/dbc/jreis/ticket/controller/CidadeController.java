package dbc.jreis.ticket.controller;

import dbc.jreis.ticket.model.Cidade;
import dbc.jreis.ticket.service.CidadeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/cidade"})
@Slf4j
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public ResponseEntity<List<Cidade>> findAll() {
        log.info("findAll Cidades");
        List<Cidade> response = cidadeService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

/*    @GetMapping
    public ResponseEntity<List<Cidade>> findAllByEstado(@RequestBody Estado estado) {
        log.info("findAll Cidades by Estado");
        List<Cidade> response = cidadeService.findAllByEstado(estado);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }*/

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Cidade cidade) {
        cidadeService.save(cidade);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> save(@PathVariable("Id") Long id, @Valid @RequestBody Cidade cidade) {
        cidadeService.update(id, cidade);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

/*    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("Id") Long id){
        bcmsgService.delete(id)
    }*/

}