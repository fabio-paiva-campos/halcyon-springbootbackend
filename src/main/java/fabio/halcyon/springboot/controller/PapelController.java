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
import fabio.halcyon.springboot.model.Papel;
import fabio.halcyon.springboot.repository.PapelRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class PapelController {

	@Autowired
	private PapelRepository papelRepository;
	
	// get all papeis
	@GetMapping("/papeis")
	public List<Papel> getAllPapeis(){
		return papelRepository.findAll();
	}		
	
	// create papel rest api
	@PostMapping("/papeis")
	public Papel createPapel(@RequestBody Papel papel) {
		return papelRepository.save(papel);
	}
	
	// get papel by id rest api
	@GetMapping("/papeis/{id}")
	public ResponseEntity<Papel> getPapelById(@PathVariable Long id) {
		Papel papel = papelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Papel nao existe:" + id));
		return ResponseEntity.ok(papel);
	}
	
	// update papel rest api
	@PutMapping("/papeis/{id}")
	public ResponseEntity<Papel> updatePapel(@PathVariable Long id, @RequestBody Papel papelDetails){
		Papel papel = papelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Papel nao existe:" + id));
		
		papel.setPapel(papelDetails.getPapel());
		
		Papel updatedPapel = papelRepository.save(papel);
		return ResponseEntity.ok(updatedPapel);
	}
	
	// delete papel rest api
	@DeleteMapping("/papeis/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePapel(@PathVariable Long id){
		Papel papel = papelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Papel nao existe:" + id));
		
		papelRepository.delete(papel);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}	
}