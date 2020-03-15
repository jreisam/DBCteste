package dbc.jreis.ticket.service;

import dbc.jreis.ticket.model.Cidade;
import dbc.jreis.ticket.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> findAll() {
        return cidadeRepository.findAll();
    }

    public Cidade findById(final Long id) {
        return cidadeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(this.getClass().getName() + " not found!"));
    }

/*    public List<Cidade> findAllByEstado(final Estado estado) {
        return cidadeRepository.findAllByEstado(estado);
    }*/

    public void save(final Cidade cidade) {
        cidadeRepository.save(cidade);
    }

    public void update(Long id, Cidade cidade) {
        Cidade cidadeOld = findById(id);
        cidade.setId(cidadeOld.getId());

        cidadeRepository.save(cidade);
    }
}