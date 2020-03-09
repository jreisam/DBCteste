package com.jreis.teste.request;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;


@Getter
@JacksonXmlRootElement(localName = "SISMSG")
public class SisMsgDto {

    private SLC0001Dto slc0001;


    @JacksonXmlProperty(localName = "SLC0001")
    public void setSlc0001(SLC0001Dto slc0001) {
        this.slc0001 = slc0001;
    }

}