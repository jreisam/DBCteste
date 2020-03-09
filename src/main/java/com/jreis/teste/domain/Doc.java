package com.jreis.teste.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jreis.teste.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Doc extends BaseEntity {

    private String xmlns;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = BcMsg.class)
    private BcMsg bcmsg;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = SisMsg.class)
    private SisMsg sismsg;

}