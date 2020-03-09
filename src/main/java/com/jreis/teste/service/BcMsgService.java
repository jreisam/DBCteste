package com.jreis.teste.service;

import com.jreis.teste.domain.BcMsg;
import com.jreis.teste.repository.BcMsgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BcMsgService {

    @Autowired
    private BcMsgRepository bcmsgRepository;

    public List<BcMsg> findAll() {
        return bcmsgRepository.findAll();
    }

    public BcMsg findById(final Long id) {
        return bcmsgRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(this.getClass().getName() + " not found!"));
    }

    public void save(final BcMsg bcmsg) {
        bcmsgRepository.save(bcmsg);
    }

    public void update(Long id, BcMsg bcmsg) {
        BcMsg bcMsgOld = findById(id);
        bcmsg.setId(bcMsgOld.getId());

        bcmsgRepository.save(bcmsg);
    }
}