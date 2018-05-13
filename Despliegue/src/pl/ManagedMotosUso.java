package pl;



import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import bl.LogicaNegocio;
import dl.EnUso;
import dl.GoogleMaps;
import dl.Moto;

@Named
@RequestScoped //Es de Session ya que no hay un botton que envie el formulario 
			   //y me reeenvia a la pagina web por lo que un RequestScope no llega

public class ManagedMotosUso implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@EJB
	private LogicaNegocio logica;



	public List<Moto> getListaMotos(){
		
		return logica.getListaMotos();
		
	}
	
	public List<EnUso> getListaMotosUso(){
		
		return logica.getListaMotosUso();
		
	}
	
	public void deleteMotoUso(int id){
		logica.deleteMotoEnUso(id);
	}
	
}
