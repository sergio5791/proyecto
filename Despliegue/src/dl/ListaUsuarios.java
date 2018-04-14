package dl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaUsuarios {

	private List<Usuario> lista;

	@XmlElement
	public List<Usuario> getLista() {
		
		if(lista==null)
		lista=new ArrayList<Usuario>();
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}
	
	
	
	
	
}
