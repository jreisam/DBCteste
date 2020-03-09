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
public class BcMsg extends BaseEntity {

    private String domSist;
    private String identdDestinatario;
    private String nUOp;
    private String identdEmissor;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private GrupoSeq grupoSeqs;

  /*  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @Getter
    @Setter
    private Document document;

    @OneToMany(cascade = CascadeType.MERGE,
            fetch = FetchType.EAGER,
            mappedBy = "bcmsg")
    private Set<Sequence> sequence = new HashSet<>();*/;
}