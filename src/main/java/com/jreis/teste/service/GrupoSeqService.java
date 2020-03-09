package com.jreis.teste.service;

import com.jreis.teste.domain.GrupoSeq;
import com.jreis.teste.repository.GrupoSeqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoSeqService {

    @Autowired
    private GrupoSeqRepository grupoSeqRepository;

    public List<GrupoSeq> findAll() {
        return grupoSeqRepository.findAll();
    }

    public GrupoSeq findById(final Long id) {
        return grupoSeqRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(this.getClass().getName() + " not found!"));
    }

    public void save(final GrupoSeq grupoSeq) {
        grupoSeqRepository.save(grupoSeq);
    }

    public void update(Long id, GrupoSeq grupoSeq) {
        GrupoSeq grupoSeqOld = findById(id);
        grupoSeq.setId(grupoSeqOld.getId());

        grupoSeqRepository.save(grupoSeq);
    }
}