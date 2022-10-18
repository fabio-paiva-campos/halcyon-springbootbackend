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
import fabio.halcyon.springboot.model.Evento;
import fabio.halcyon.springboot.repository.EventoRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class EventoController {

	@Autowired
	private EventoRepository EventoRepository;
	
	@GetMapping("/eventos")
	public List<Evento> getAllEventos(){
		return EventoRepository.findAll();
	}		
	
	@PostMapping("/eventos")
	public Evento createEvento(@RequestBody Evento Evento) {
		return EventoRepository.save(Evento);
	}
	
	@GetMapping("/eventos/{id}")
	public ResponseEntity<Evento> getEventoById(@PathVariable Long id) {
		Evento Evento = EventoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Evento nao existe:" + id));
		return ResponseEntity.ok(Evento);
	}
	
	@PutMapping("/eventos/{id}")
	public ResponseEntity<Evento> updateCidade(@PathVariable Long id, @RequestBody Evento EventoDetails){
		Evento Evento = EventoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Evento nao existe:" + id));
		
		Evento.setEvento(EventoDetails.getEvento());
		Evento.setFilaPos(EventoDetails.getFilaPos());
		Evento.setTempo(EventoDetails.getTempo());
		Evento.setPalco(EventoDetails.getPalco());
		
		Evento updatedEvento = EventoRepository.save(Evento);
		return ResponseEntity.ok(updatedEvento);
	}
	
	@DeleteMapping("/eventos/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEvento(@PathVariable Long id){
		Evento Evento = EventoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Evento nao existe:" + id));
		
		EventoRepository.delete(Evento);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}	
}