package com.jreis.teste.repository;

import com.jreis.teste.domain.BcMsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BcMsgRepository extends JpaRepository<BcMsg, Long> {

    List<BcMsg> findByGrupoSeqsNumSeq(String numSeq);

}

