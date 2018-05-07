package pl;



import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import bl.LogicaNegocio;
import dl.GoogleMaps;
import dl.Moto;

@Named
@SessionScoped //Es de Session ya que no hay un botton que envie el formulario 
			   //y me reeenvia a la pagina web por lo que un RequestScope no llega

public class ManagedGoogleMaps implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private GoogleMaps mapa=new GoogleMaps();
	@EJB
	private LogicaNegocio logica;

	public String getDireccion() {
		return mapa.getDireccion();
	}
	public void setDireccion(String direccion) {
		mapa.setDireccion(direccion);
	}
	public void redirect() throws IOException {
	    
		StringBuilder str= new StringBuilder();
		str.append("http://maps.google.com/maps?saddr=");
		//Aqui añadir direccion final
		str.append("&daddr=");
		str.append("43.1301667,-2.5392527777776");//LA direccion que va con numero es Elorrio
		
	    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	    externalContext.redirect(str.toString());
	}

	public void calculaDistancias(){
		
		logica.calculoDistancia(mapa.getDireccion());
	}
	
}
