package com.jreis.teste.service;

import com.jreis.teste.domain.GrupoSLC0001LiquidProdt;
import com.jreis.teste.repository.GrupoSLC0001LiquidProdtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoSLC0001LiquidProdtService {

    @Autowired
    private GrupoSLC0001LiquidProdtRepository grupoSLC0001LiquidProdtRepository;

    public List<GrupoSLC0001LiquidProdt> findAll() {
        return grupoSLC0001LiquidProdtRepository.findAll();
    }

    public GrupoSLC0001LiquidProdt findById(final Long id) {
        return grupoSLC0001LiquidProdtRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(this.getClass().getName() + " not found!"));
    }

    public void save(final GrupoSLC0001LiquidProdt grupoSLC0001LiquidProdt) {
        grupoSLC0001LiquidProdtRepository.save(grupoSLC0001LiquidProdt);
    }

    public void update(Long id, GrupoSLC0001LiquidProdt grupoSLC0001LiquidProdt) {
        GrupoSLC0001LiquidProdt grupoSLC0001LiquidProdtOld = findById(id);
        grupoSLC0001LiquidProdt.setId(grupoSLC0001LiquidProdtOld.getId());

        grupoSLC0001LiquidProdtRepository.save(grupoSLC0001LiquidProdt);
    }
}