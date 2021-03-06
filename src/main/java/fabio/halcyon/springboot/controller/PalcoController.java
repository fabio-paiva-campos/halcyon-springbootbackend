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
import fabio.halcyon.springboot.model.Palco;
import fabio.halcyon.springboot.repository.PalcoRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class PalcoController {

	@Autowired
	private PalcoRepository palcoRepository;
	
	@GetMapping("/palcos")
	public List<Palco> getAllEstado(){
		return palcoRepository.findAll();
	}		
	
	@PostMapping("/palcos")
	public Palco createPalco(@RequestBody Palco palco) {
		return palcoRepository.save(palco);
	}
	
	@GetMapping("/palcos/{id}")
	public ResponseEntity<Palco> getEstadoById(@PathVariable Long id) {
		Palco estado = palcoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Estado nao existe:" + id));
		return ResponseEntity.ok(estado);
	}
	
	@PutMapping("/palcos/{id}")
	public ResponseEntity<Palco> updateEstado(@PathVariable Long id, @RequestBody Palco palcoDetails){
		Palco palco = palcoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Palco nao existe:" + id));
		
		palco.setPalco(palcoDetails.getPalco());
		
		Palco updatedEstado = palcoRepository.save(palco);
		return ResponseEntity.ok(updatedEstado);
	}
	
	@DeleteMapping("/palcos/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePalco(@PathVariable Long id){
		Palco palco = palcoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Palco nao existe:" + id));
		
		palcoRepository.delete(palco);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}	
}