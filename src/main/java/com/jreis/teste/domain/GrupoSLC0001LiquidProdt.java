package com.jreis.teste.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jreis.teste.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GrupoSLC0001LiquidProdt extends BaseEntity {

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

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private GrupoSLC0001Prodt grupoSlc0001Prodt;
}