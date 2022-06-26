package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "palcos")
public class Palco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "palco")
	private String palco;
	
	public Palco() {
		
	}
	
	public Palco(String palco) {
		super();
		this.palco = palco;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPalco() {
		return palco;
	}
	public void setPalco(String palco) {
		this.palco = palco;
	}
}
