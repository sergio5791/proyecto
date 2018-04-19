package pl;



import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import dl.GoogleMaps;

@Named
@SessionScoped

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

	public String toString() {
		
		System.out.println("La latitud->"+mapa.getLatitud());
		System.out.println("La longitud->"+mapa.getLongitud());
		
		StringBuilder str= new StringBuilder();
		str.append("http://maps.google.com/maps?saddr=");
		str.append(mapa.getLatitud()+",");
		str.append(mapa.getLongitud());
		str.append("&daddr=");
		str.append("43.1301667,-2.5392527777776");//LA direccion que va con numero es Miribilla
		return str.toString();
	}
	
	

}
