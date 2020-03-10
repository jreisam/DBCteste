package com.jreis.teste.mock;

import com.jreis.teste.domain.GrupoSeq;

public class GrupoSeqMock {

    public static GrupoSeq getAleatorio(Long id) {
        GrupoSeq grupoSeq = GrupoSeq.builder()
                .indrCont("test")
                .numSeq("12345")
                .build();
        grupoSeq.setId(id);

        return grupoSeq;
    }

}
