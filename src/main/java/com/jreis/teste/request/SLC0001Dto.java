package com.jreis.teste.request;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;

import java.util.List;

@Getter
@JacksonXmlRootElement(localName = "SLC0001")
public class SLC0001Dto {

    private String codMsg;
    private String numCtrlSLC;
    private String iSPBIF;
    private String tpInf;
    private String dtMovto;
    private String dtHrSLC;
    private List<GrupoSLC0001LiquidDto> grupoSLC0001Liquid;


    @JacksonXmlProperty(localName = "CodMsg")
    public void setCodMsg(String codMsg) {
        this.codMsg = codMsg;
    }

    @JacksonXmlProperty(localName = "NumCtrlSLC")
    public void setNumCtrlSLC(String numCtrlSLC) {
        this.numCtrlSLC = numCtrlSLC;
    }

    @JacksonXmlProperty(localName = "ISPBIF")
    public void setISPBIF(String iSPBIF) {
        this.iSPBIF = iSPBIF;
    }

    @JacksonXmlProperty(localName = "TpInf")
    public void setTpInf(String tpInf) {
        this.tpInf = tpInf;
    }

    @JacksonXmlProperty(localName = "DtHrSLC")
    public void setDtHrSLC(String dtHrSLC) {
        this.dtHrSLC = dtHrSLC;
    }

    @JacksonXmlProperty(localName = "DtMovto")
    public void setDtMovto(String dtMovto) {
        this.dtMovto = dtMovto;
    }


    @JacksonXmlProperty(localName = "Grupo_SLC0001_Liquid")
    public void setGrupoSLC0001Liquid(List<GrupoSLC0001LiquidDto> grupoSLC0001Liquid) {
        this.grupoSLC0001Liquid = grupoSLC0001Liquid;
    }
}