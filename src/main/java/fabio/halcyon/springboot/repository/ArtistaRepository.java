package fabio.halcyon.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fabio.halcyon.springboot.model.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long>{

}
