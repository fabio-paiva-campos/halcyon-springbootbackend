package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "usuario")
	private String usuario;

	//@Column(name = "senha")
	//private BCryptPasswordEncoder senha;

	@Column(name = "senha")
	private String senha;

	@ManyToOne
	private Papel papel;

	public Usuario() {
		
	}
	
	public Usuario(String usuario) {
		super();
		this.usuario = usuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return usuario;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	//public BCryptPasswordEncoder getSenha() {
		//return senha;
	//}
	
	//public void setSenha(BCryptPasswordEncoder bCryptPasswordEncoder) {
		//this.senha = bCryptPasswordEncoder;
	//}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}
}