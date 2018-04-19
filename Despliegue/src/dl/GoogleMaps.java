package dl;

import java.io.Serializable;

public class GoogleMaps implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String latitud;
	private String longitud;
	
	
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	
	

}
