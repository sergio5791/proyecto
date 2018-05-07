package pl;

import java.util.List;

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
	public String getDireccion() {
		return moto.getDireccion();
	}

	public void setDireccion(String direccion) {
		moto.setDireccion(direccion);
	}

	public boolean getDisponibilidad() {
		return moto.getDisponibilidad();
	}

	public void setDisponibilidad(boolean disponibilidad) {
		moto.setDisponibilidad(disponibilidad);
	}

	public void addMoto(){
		logica.addMoto(moto);

	}
	
	public void deleteMoto(int idMoto){
		
		logica.deleteMoto(idMoto);
	}
	
	public List<Moto> getListaMotos(){
		
		return logica.getListaMotos();
	}
	
	
	
}
