package com.jreis.teste.request;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;

@Getter
@JacksonXmlRootElement(localName = "Grupo_SLC0001_LiquidProdt")
public class GrupoSLC0001LiquidProdtDto {

    private String identdLinhaBilat;
    private String cNPJNLiqdantDebtd;
    private String iSPBIFDebtd;
    private String nomCliDebtd;
    private String tpTranscSLC;
    private String vlrLanc;
    private String cNPJNLiqdantCredtd;
    private String tpDeb_Cred;
    private String iSPBIFCredtd;
    private String nomCliCredtd;

    @JacksonXmlProperty(localName = "IdentdLinhaBilat")
    public void setIdentdLinhaBilat(String identdLinhaBilat) {
        this.identdLinhaBilat = identdLinhaBilat;
    }

    @JacksonXmlProperty(localName = "TpDeb_Cred")
    public void setTpDeb_Cred(String tpDeb_Cred) {
        this.tpDeb_Cred = tpDeb_Cred;
    }

    @JacksonXmlProperty(localName = "ISPBIFCredtd")
    public void setiSPBIFCredtd(String iSPBIFCredtd) {
        this.iSPBIFCredtd = iSPBIFCredtd;
    }

    @JacksonXmlProperty(localName = "ISPBIFDebtd")
    public void setiSPBIFDebtd(String iSPBIFDebtd) {
        this.iSPBIFDebtd = iSPBIFDebtd;
    }

    @JacksonXmlProperty(localName = "VlrLanc")
    public void setVlrLanc(String vlrLanc) {
        this.vlrLanc = vlrLanc;
    }

    @JacksonXmlProperty(localName = "CNPJNLiqdantDebtd")
    public void setcNPJNLiqdantDebtd(String cNPJNLiqdantDebtd) {
        this.cNPJNLiqdantDebtd = cNPJNLiqdantDebtd;
    }

    @JacksonXmlProperty(localName = "NomCliDebtd")
    public void setNomCliDebtd(String nomCliDebtd) {
        this.nomCliDebtd = nomCliDebtd;
    }

    @JacksonXmlProperty(localName = "CNPJNLiqdantCredtd")
    public void setcNPJNLiqdantCredtd(String cNPJNLiqdantCredtd) {
        this.cNPJNLiqdantCredtd = cNPJNLiqdantCredtd;
    }

    @JacksonXmlProperty(localName = "NomCliCredtd")
    public void setNomCliCredtd(String nomCliCredtd) {
        this.nomCliCredtd = nomCliCredtd;
    }

    @JacksonXmlProperty(localName = "TpTranscSLC")
    public void setTpTranscSLC(String tpTranscSLC) {
        this.tpTranscSLC = tpTranscSLC;
    }

}