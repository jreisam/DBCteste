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
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GrupoSLC0001Prodt extends BaseEntity {

    private String codProdt;

//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn
//    private GrupoSLC0001Liquid grupoSLC0001Liquid;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<GrupoSLC0001LiquidProdt> grupoSLC0001LiquidProdts;

//    @JsonIgnore
//    @OneToMany(mappedBy = "grupoSlc0001Prodt", cascade = CascadeType.ALL)
//    private Set<GrupoSLC0001LiquidProdt> grupoSLC0001LiquidProdt;
}
