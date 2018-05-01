package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Using database table.
 * 
 */
@Entity
@NamedQuery(name="Using.findAll", query="SELECT u FROM Using u")
public class Using implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsing;

	//uni-directional many-to-one association to Moto
	@ManyToOne
	@JoinColumn(name="Motos_idMotos")
	private Moto moto;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="Usuarios_idUsuarios")
	private Usuario usuario;

	public Using() {
	}

	public int getIdUsing() {
		return this.idUsing;
	}

	public void setIdUsing(int idUsing) {
		this.idUsing = idUsing;
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