package fabio.halcyon.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

<<<<<<< HEAD:src/main/java/fabio/halcyon/springboot/model/Usuario.java
=======
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

>>>>>>> 5ba764fa506d12880094601eb47f6c7df885698b:src/main/java/net/javaguides/springboot/model/Usuario.java
@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "usuario")
	private String usuario;

	@Column(name = "senha")
	private String senha;

	public static final PasswordEncoder encoder = new BCryptPasswordEncoder();

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
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = encoder.encode(senha);
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}
}