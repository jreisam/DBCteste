package com.jreis.teste.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jreis.teste.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class SLC0001 extends BaseEntity {

    private String iSPBIF;
    private String dtMovto;
    private String dtHrSLC;
    private String codMsg;
    private String tpInf;
    private String numCtrlSLC;

    //    @OneToMany(mappedBy = "slc0001", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //    private Set<GrupoSLC0001Liquid> grupoSLC0001Liquids;

    @JsonIgnore
    @OneToMany(mappedBy = "slc0001", cascade = CascadeType.ALL)
    private Set<GrupoSLC0001Liquid> grupoSLC0001Liquid;
}