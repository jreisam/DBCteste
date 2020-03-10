package com.jreis.teste.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jreis.teste.domain.base.BaseEntity;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class BcMsg extends BaseEntity {

    private String domSist;
    private String identdDestinatario;
    private String nUOp;
    private String identdEmissor;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
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
