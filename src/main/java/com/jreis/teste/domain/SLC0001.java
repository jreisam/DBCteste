package com.jreis.teste.domain;

import com.jreis.teste.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

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

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private GrupoSLC0001Liquid grupoSLC0001Liquid;
}
