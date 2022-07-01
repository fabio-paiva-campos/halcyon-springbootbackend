package fabio.halcyon.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fabio.halcyon.springboot.model.Palco;

@Repository
public interface PalcoRepository extends JpaRepository<Palco, Long>{

}
