package dbc.jreis.ticket.service;

import dbc.jreis.ticket.model.Estado;
import dbc.jreis.ticket.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    public Estado findById(final Long id) {
        return estadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(this.getClass().getName() + " not found!"));
    }

    public void save(final Estado estado) {
        estadoRepository.save(estado);
    }

    public void update(Long id, Estado estado) {
        Estado estadoOld = findById(id);
        estado.setId(estadoOld.getId());

        estadoRepository.save(estado);
    }
}