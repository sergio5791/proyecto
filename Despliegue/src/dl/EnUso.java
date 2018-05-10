package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EnUso database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="EnUso.findAll", query="SELECT e FROM EnUso e")
})
public class EnUso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEnUso;

	//uni-directional many-to-one association to Moto
	@ManyToOne
	@JoinColumn(name="Motos_idMotos")
	private Moto moto;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="Usuarios_idUsuarios")
	private Usuario usuario;

	public EnUso() {
	}

	public int getIdEnUso() {
		return this.idEnUso;
	}

	public void setIdEnUso(int idEnUso) {
		this.idEnUso = idEnUso;
	}

	public Moto getMoto() {
		return this.moto;
	}

	public void setMoto(Moto moto) {
		this.moto = moto;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}