package dbc.jreis.ticket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dbc.jreis.ticket.model.base.BaseEntity;
import lombok.*;

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
@Builder
public class Estado extends BaseEntity {

    private String nome;
    private String codNome;
    private String imgName;


    @OneToMany(cascade = {CascadeType.MERGE})
    private List<Cidade> cidades;

    public String toJson() {
        return "{nome: " + nome + ", codNome:" + codNome + ", imgName: " + imgName + "}";
    }
}
