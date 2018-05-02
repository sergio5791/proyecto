package pl;



import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import dl.GoogleMaps;

@Named
@SessionScoped //Es de Session ya que no hay un botton que envie el formulario 
			   //y me reeenvia a la pagina web por lo que un RequestScope no llega
			

public class ManagedGoogleMaps implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GoogleMaps mapa=new GoogleMaps();

	public String getLatitud() {
		return mapa.getLatitud();
	}

	public void setLatitud(String latitud) {
		mapa.setLatitud(latitud);
	}

	public String getLongitud() {
		return mapa.getLongitud();
	}

	public void setLongitud(String longitud) {
		mapa.setLongitud(longitud);
	}
	
	public void redirect() throws IOException {
	    
		StringBuilder str= new StringBuilder();
		str.append("http://maps.google.com/maps?saddr=");
		str.append(mapa.getLatitud()+",");
		str.append(mapa.getLongitud());
		str.append("&daddr=");
		str.append("43.1301667,-2.5392527777776");//LA direccion que va con numero es Elorrio
		
	    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	    externalContext.redirect(str.toString());
	}

}
