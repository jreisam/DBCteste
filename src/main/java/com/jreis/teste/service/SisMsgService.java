package com.jreis.teste.service;

import com.jreis.teste.domain.SisMsg;
import com.jreis.teste.repository.SisMsgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SisMsgService {

    @Autowired
    private SisMsgRepository sisMsgRepository;

    public List<SisMsg> findAll() {
        return sisMsgRepository.findAll();
    }

    public SisMsg findById(final Long id) {
        return sisMsgRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(this.getClass().getName() + " not found!"));
    }

    public void save(final SisMsg sisMsg) {
        sisMsgRepository.save(sisMsg);
    }

    public void update(Long id, SisMsg sisMsg) {
        SisMsg sisMsgOld = findById(id);
        sisMsg.setId(sisMsgOld.getId());

        sisMsgRepository.save(sisMsg);
    }
}