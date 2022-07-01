package fabio.halcyon.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "artistas")
public class Artista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "artista")
	private String artista;

	@Column(name = "filaPos")
	private String filaPos;

	@Column(name = "tempo")
	private String tempo;

	@ManyToOne
	private Palco palco;

	public Artista() {
		
	}
	
	public Artista(String artista) {
		super();
		this.artista = artista;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getFilaPos() {
		return filaPos;
	}

	public void setFilaPos(String filaPos) {
		this.filaPos = filaPos;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo (String tempo) {
		this.tempo = tempo;
	}

	public Palco getPalco() {
		return palco;
	}

	public void setPalco(Palco palco) {
		this.palco = palco;
	}
}