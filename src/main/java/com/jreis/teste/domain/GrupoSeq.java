package com.jreis.teste.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jreis.teste.domain.base.BaseEntity;
import lombok.*;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class GrupoSeq extends BaseEntity {

    private String numSeq;
    private String indrCont;

    public String toJson() {
        return "{NumSeq: " + numSeq + ", IndrCont: " + indrCont + "}";
    }
}
