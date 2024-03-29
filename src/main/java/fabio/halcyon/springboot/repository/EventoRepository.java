package fabio.halcyon.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fabio.halcyon.springboot.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{

}
