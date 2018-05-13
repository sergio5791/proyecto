package dl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaErrores implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ErrorMoto> lista;

	@XmlElement
	public List<ErrorMoto> getLista() {
		if(lista==null){
		lista=new ArrayList<ErrorMoto>();
		}
		return lista;
	}

	public void setLista(List<ErrorMoto> lista) {
		this.lista = lista;
	}

	
	
}
