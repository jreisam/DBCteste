package dbc.jreis.ticket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dbc.jreis.ticket.model.base.BaseEntity;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class Cidade extends BaseEntity {

    private String nome;

    @JoinColumn
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Estado estado;

/*    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Estado estado;*/

}
