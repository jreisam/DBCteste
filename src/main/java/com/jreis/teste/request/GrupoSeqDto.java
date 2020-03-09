package com.jreis.teste.request;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;

@Getter
@JacksonXmlRootElement(localName = "Grupo_Seq")
public class GrupoSeqDto {

    private String numSeq;
    private String indrCont;

    @JacksonXmlProperty(localName = "NumSeq")
    public void setNumSeq(String numSeq) {
        this.numSeq = numSeq;
    }

    @JacksonXmlProperty(localName = "IndrCont")
    public void setIndrCont(String indrCont) {
        this.indrCont = indrCont;
    }
}
