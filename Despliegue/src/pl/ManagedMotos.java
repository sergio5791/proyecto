package pl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import bl.LogicaNegocio;
import dl.Moto;

@Named
@RequestScoped
public class ManagedMotos {

	private Moto moto=new Moto();
	@EJB
	private LogicaNegocio logica;

	public int getIdMotos() {
		return moto.getIdMotos();
	}

	public void setIdMotos(int idMotos) {
		moto.setIdMotos(idMotos);
	}

	public String getLatitud() {
		return moto.getLatitud();
	}

	public void setLatitud(String latitud) {
		moto.setLatitud(latitud);
	}

	public String getLongitud() {
		return moto.getLongitud();
	}

	public void setLongitud(String longitud) {
		moto.setLongitud(longitud);
	}
	
	public void addMoto(){
		logica.addMoto(moto);

	}
	
	
	
	
}
