package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Usuarios database table.
 * 
 */
@Entity
@Table(name="Usuarios")
@NamedQueries({
@NamedQuery(name="BuscaCorreo", query="SELECT u.correo FROM Usuario u"),
@NamedQuery(name="getLista", query="SELECT u FROM Usuario u"),
})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsuarios;

	private String apellido;

	private String correo;

	private String nombre;

	private String password;

	//uni-directional many-to-one association to Using
	@ManyToOne
	@JoinColumn(name="Using_idUsing")
	private Using using;

	public Usuario() {
	}

	public int getIdUsuarios() {
		return this.idUsuarios;
	}

	public void setIdUsuarios(int idUsuarios) {
		this.idUsuarios = idUsuarios;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Using getUsing() {
		return this.using;
	}

	public void setUsing(Using using) {
		this.using = using;
	}

}