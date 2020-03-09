package com.jreis.teste.request;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "DOC")
public class SlcRequest {

    BcMsgDto bcMsg;
    SisMsgDto sisMsg;

    @JacksonXmlProperty(localName = "BCMSG")
    public void setBcMsg(BcMsgDto bcMsg) {
        this.bcMsg = bcMsg;
    }

    @JacksonXmlProperty(localName = "SISMSG")
    public void setSisMsg(SisMsgDto sisMsg) {
        this.sisMsg = sisMsg;
    }

}
