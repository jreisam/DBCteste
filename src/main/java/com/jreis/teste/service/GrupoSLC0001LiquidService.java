package com.jreis.teste.service;

import com.jreis.teste.domain.GrupoSLC0001Liquid;
import com.jreis.teste.repository.GrupoSLC0001LiquidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoSLC0001LiquidService {

    @Autowired
    private GrupoSLC0001LiquidRepository grupoSLC0001LiquidRepository;

    public List<GrupoSLC0001Liquid> findAll() {
        return grupoSLC0001LiquidRepository.findAll();
    }

    public GrupoSLC0001Liquid findById(final Long id) {
        return grupoSLC0001LiquidRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(this.getClass().getName() + " not found!"));
    }

    public void save(final GrupoSLC0001Liquid grupoSLC0001Liquid) {
        grupoSLC0001LiquidRepository.save(grupoSLC0001Liquid);
    }

    public void update(Long id, GrupoSLC0001Liquid grupoSLC0001Liquid) {
        GrupoSLC0001Liquid grupoSLC0001LiquidOld = findById(id);
        grupoSLC0001Liquid.setId(grupoSLC0001LiquidOld.getId());

        grupoSLC0001LiquidRepository.save(grupoSLC0001Liquid);
    }
}