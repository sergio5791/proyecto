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

	public Using() {
	}

	public int getIdUsing() {
		return this.idUsing;
	}

	public void setIdUsing(int idUsing) {
		this.idUsing = idUsing;
	}

}