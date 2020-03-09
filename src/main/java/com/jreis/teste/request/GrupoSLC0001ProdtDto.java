package com.jreis.teste.request;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;

import java.util.List;

@Getter
@JacksonXmlRootElement(localName = "Grupo_SLC0001_Prodt")
public class GrupoSLC0001ProdtDto {

    private String codProdt;

    private List<GrupoSLC0001LiquidProdtDto> grupoSLC0001LiquidProdt;

    @JacksonXmlProperty(localName = "CodProdt")
    public void setCodProdt(String codProdt) {
        this.codProdt = codProdt;
    }

    @JacksonXmlProperty(localName = "Grupo_SLC0001_LiquidProdt")
    public void setGrupoSLC0001ProdtDto(List<GrupoSLC0001LiquidProdtDto> grupoSLC0001LiquidProdtDto) {
        this.grupoSLC0001LiquidProdt = grupoSLC0001LiquidProdtDto;
    }
}