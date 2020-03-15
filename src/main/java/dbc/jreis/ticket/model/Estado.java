package dbc.jreis.ticket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Table(name = "ESTADO")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String codNome;
    private String imgNome;

    @OneToMany
    @JoinColumn(name="ESTADO_ID", referencedColumnName="id")
    private Set<Cidade> cidades;

    public String toJson() {
        return "{nome: " + nome + ", codNome:" + codNome + ", imgName: " + imgNome + "}";
    }
}
