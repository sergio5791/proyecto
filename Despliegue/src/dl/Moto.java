package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Motos database table.
 * 
 */
@Entity
@Table(name="Motos")
@NamedQuery(name="Moto.findAll", query="SELECT m FROM Moto m")
public class Moto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMotos;

	private String latitud;

	private String longitud;

	public Moto() {
	}

	public int getIdMotos() {
		return this.idMotos;
	}

	public void setIdMotos(int idMotos) {
		this.idMotos = idMotos;
	}

	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

}