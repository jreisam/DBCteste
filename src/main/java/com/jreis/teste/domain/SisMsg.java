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
public class SisMsg extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY, targetEntity = SLC0001.class)
    private SLC0001 slc0001;

//    @ManyToOne
//    @JoinColumn
//    private Document document;
//
//    @OneToMany(cascade = CascadeType.MERGE,
//            fetch = FetchType.EAGER,
//            mappedBy = "sismsg")
//    private Set<Slc0001> slc0001s = new HashSet<>();

}