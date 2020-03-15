package dbc.jreis.ticket.repository;

import dbc.jreis.ticket.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

//    List<Cidade> findAllByEstado(Estado estado);
}

