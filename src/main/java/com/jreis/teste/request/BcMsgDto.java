package com.jreis.teste.request;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;

@Getter
@JacksonXmlRootElement(localName = "BCMSG")
public class BcMsgDto {

    private String domSist;
    private String identdDestinatario;
    private String nUOp;
    private String identdEmissor;
    private GrupoSeqDto grupoSeqs;

    @JacksonXmlProperty(localName = "DomSist")
    public void setDomSist(String domSist) {
        this.domSist = domSist;
    }

    @JacksonXmlProperty(localName = "IdentdEmissor")
    public void setIdentdDestinatario(String identdDestinatario) {
        this.identdDestinatario = identdDestinatario;
    }

    @JacksonXmlProperty(localName = "NUOp")
    public void setnUOp(String nUOp) {
        this.nUOp = nUOp;
    }

    @JacksonXmlProperty(localName = "IdentdDestinatario")
    public void setIdentdEmissor(String identdEmissor) {
        this.identdEmissor = identdEmissor;
    }

    @JacksonXmlProperty(localName = "Grupo_Seq")
    public void setGrupoSeqs(GrupoSeqDto grupoSeqs) {
        this.grupoSeqs = grupoSeqs;
    }

}
