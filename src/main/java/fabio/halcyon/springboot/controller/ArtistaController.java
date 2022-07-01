package fabio.halcyon.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fabio.halcyon.springboot.exception.ResourceNotFoundException;
import fabio.halcyon.springboot.model.Artista;
import fabio.halcyon.springboot.repository.ArtistaRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class ArtistaController {

	@Autowired
	private ArtistaRepository artistaRepository;
	
	// get all artistas
	@GetMapping("/artistas")
	public List<Artista> getAllArtistas(){
		return artistaRepository.findAll();
	}		
	
	// create artista rest api
	@PostMapping("/artistas")
	public Artista createArtista(@RequestBody Artista artista) {
		return artistaRepository.save(artista);
	}
	
	// get artista by id rest api
	@GetMapping("/artistas/{id}")
	public ResponseEntity<Artista> getArtistaById(@PathVariable Long id) {
		Artista artista = artistaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Artista nao existe:" + id));
		return ResponseEntity.ok(artista);
	}
	
	// update artista rest api
	@PutMapping("/artistas/{id}")
	public ResponseEntity<Artista> updateCidade(@PathVariable Long id, @RequestBody Artista artistaDetails){
		Artista artista = artistaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Artista nao existe:" + id));
		
		artista.setArtista(artistaDetails.getArtista());
		artista.setFilaPos(artistaDetails.getFilaPos());
		artista.setTempo(artistaDetails.getTempo());
		artista.setPalco(artistaDetails.getPalco());
		
		Artista updatedArtista = artistaRepository.save(artista);
		return ResponseEntity.ok(updatedArtista);
	}
	
	// delete artista rest api
	@DeleteMapping("/artistas/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteArtista(@PathVariable Long id){
		Artista artista = artistaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Artista nao existe:" + id));
		
		artistaRepository.delete(artista);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}	
}