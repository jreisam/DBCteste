package com.jreis.teste.service;

import com.jreis.teste.domain.Doc;
import com.jreis.teste.repository.DocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocService {

    @Autowired
    private DocRepository docRepository;

    public List<Doc> findAll() {
        return docRepository.findAll();
    }

    public Doc findById(final Long id) {
        return docRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(this.getClass().getName() + " not found!"));
    }

    public void save(final Doc doc) {
        docRepository.save(doc);
    }

    public void update(Long id, Doc doc) {
        Doc docOld = findById(id);
        doc.setId(docOld.getId());

        docRepository.save(doc);
    }
}