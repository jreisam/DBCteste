package com.jreis.teste.service;

import com.jreis.teste.domain.GrupoSLC0001Prodt;
import com.jreis.teste.repository.GrupoSLC0001ProdtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoSLC0001ProdtService {

    @Autowired
    private GrupoSLC0001ProdtRepository grupoSLC0001ProdtRepository;

    public List<GrupoSLC0001Prodt> findAll() {
        return grupoSLC0001ProdtRepository.findAll();
    }

    public GrupoSLC0001Prodt findById(final Long id) {
        return grupoSLC0001ProdtRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(this.getClass().getName() + " not found!"));
    }

    public void save(final GrupoSLC0001Prodt grupoSLC0001Prodt) {
        grupoSLC0001ProdtRepository.save(grupoSLC0001Prodt);
    }

    public void update(Long id, GrupoSLC0001Prodt grupoSLC0001Prodt) {
        GrupoSLC0001Prodt grupoSLC0001ProdtOld = findById(id);
        grupoSLC0001Prodt.setId(grupoSLC0001ProdtOld.getId());

        grupoSLC0001ProdtRepository.save(grupoSLC0001Prodt);
    }
}