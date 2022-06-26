package net.javaguides.springboot.model;

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
	public Palco getPalco() {
		return palco;
	}
	public void setPalco(Palco palco) {
		this.palco = palco;
	}
}