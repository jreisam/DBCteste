package com.jreis.teste.request;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;

@Getter
@JacksonXmlRootElement(localName = "Grupo_SLC0001_Liquid")
public class GrupoSLC0001Dto {

    private String dtLiquid;
    private String numSeqCicloLiquid;

    @JacksonXmlProperty(localName = "DtLiquid")
    public void setDtLiquid(String dtLiquid) {
        this.dtLiquid = dtLiquid;
    }

    @JacksonXmlProperty(localName = "NumSeqCicloLiquid")
    public void setNumSeqCicloLiquid(String numSeqCicloLiquid) {
        this.numSeqCicloLiquid = numSeqCicloLiquid;
    }

}