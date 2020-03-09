package com.jreis.teste.request;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;

import java.util.List;

@Getter
@JacksonXmlRootElement(localName = "Grupo_SLC0001_Liquid")
public class GrupoSLC0001LiquidDto {

    private String dtLiquid;
    private String numSeqCicloLiquid;
    private List<GrupoSLC0001ProdtDto> grupoSLC0001Prodt;


    @JacksonXmlProperty(localName = "DtLiquid")
    public void setDtLiquid(String dtLiquid) {
        this.dtLiquid = dtLiquid;
    }

    @JacksonXmlProperty(localName = "NumSeqCicloLiquid")
    public void setNumSeqCicloLiquid(String numSeqCicloLiquid) {
        this.numSeqCicloLiquid = numSeqCicloLiquid;
    }

    @JacksonXmlProperty(localName = "Grupo_SLC0001_Prodt")
    public void setGrupoSLC0001Prodt(List<GrupoSLC0001ProdtDto> grupoSLC0001Prodt) {
        this.grupoSLC0001Prodt = grupoSLC0001Prodt;
    }
}