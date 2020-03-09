package com.jreis.teste.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class GrupoSLC0001Liquid extends BaseEntity {

    private String dtLiquid;
    private String numSeqCicloLiquid;

//    @OneToMany(mappedBy = "grupoSLC0001Liquid", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private Set<GrupoSLC0001Prodt> grupoSLC0001Prodts;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<GrupoSLC0001Prodt> grupoSLC0001Prodt;

}
