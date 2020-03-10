package com.jreis.teste.mock;

import com.jreis.teste.domain.BcMsg;

public class BcmsgMock {

    public static BcMsg getAleatorio(Long id) {
        BcMsg bcMsg = BcMsg.builder()
                .domSist("teste")
                .identdDestinatario("1235")
                .identdEmissor("1234")
                .nUOp("12344")
                .grupoSeqs(GrupoSeqMock.getAleatorio(id))
                .build();
        bcMsg.setId(id);

        return bcMsg;
    }

}
