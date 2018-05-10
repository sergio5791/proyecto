package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Motos database table.
 * 
 */
@Entity
@Table(name="Motos")
@NamedQueries({
@NamedQuery(name="Moto.findAll", query="SELECT m FROM Moto m"),
@NamedQuery(name="Moto.false", query="SELECT m FROM Moto m WHERE m.disponibilidad = FALSE")
})
public class Moto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMotos;

	private String direccion;

	private boolean disponibilidad;

	public Moto() {
	}

	public int getIdMotos() {
		return this.idMotos;
	}

	public void setIdMotos(int idMotos) {
		this.idMotos = idMotos;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean getDisponibilidad() {
		return this.disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

}