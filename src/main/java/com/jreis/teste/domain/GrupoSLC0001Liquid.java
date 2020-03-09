package com.jreis.teste.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jreis.teste.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private SLC0001 slc0001;

//    @OneToMany(mappedBy = "grupoSLC0001Liquid", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private Set<GrupoSLC0001Prodt> grupoSLC0001Prodts;

    @JsonIgnore
    @OneToMany(mappedBy = "grupoSLC0001Liquid", cascade = CascadeType.ALL)
    private Set<GrupoSLC0001Prodt> grupoSLC0001Prodt;

}