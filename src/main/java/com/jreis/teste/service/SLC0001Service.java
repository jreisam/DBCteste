package com.jreis.teste.service;

import com.jreis.teste.domain.SLC0001;
import com.jreis.teste.repository.SLC0001Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SLC0001Service {

    @Autowired
    private SLC0001Repository slc0001Repository;

    public List<SLC0001> findAll() {
        return slc0001Repository.findAll();
    }

    public SLC0001 findById(final Long id) {
        return slc0001Repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(this.getClass().getName() + " not found!"));
    }

    public void save(final SLC0001 slc0001) {
        slc0001Repository.save(slc0001);
    }

    public void update(Long id, SLC0001 slc0001) {
        SLC0001 slc0001Old = findById(id);
        slc0001.setId(slc0001Old.getId());

        slc0001Repository.save(slc0001);
    }
}