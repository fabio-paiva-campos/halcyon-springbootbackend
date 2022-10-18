package fabio.halcyon.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "eventos")
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "evento")
	private String evento;

	@Column(name = "filaPos")
	private long filaPos;

	@Column(name = "tempo")
	private long tempo;

	@ManyToOne
	private Palco palco;

	public Evento() {
		
	}
	
	public Evento(String evento) {
		super();
		this.evento = evento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public Long getFilaPos() {
		return filaPos;
	}

	public void setFilaPos(Long filaPos) {
		this.filaPos = filaPos;
	}

	public Long getTempo() {
		return tempo;
	}

	public void setTempo (Long tempo) {
		this.tempo = tempo;
	}

	public Palco getPalco() {
		return palco;
	}

	public void setPalco(Palco palco) {
		this.palco = palco;
	}
}