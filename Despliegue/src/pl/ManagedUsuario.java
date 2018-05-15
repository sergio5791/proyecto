package pl;

import java.io.IOException;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import bl.LogicaNegocio;
import dl.Usuario;

@Named
@RequestScoped
public class ManagedUsuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private LogicaNegocio logica;
	Usuario cliente = new Usuario();
	private String direccion;
	private boolean correorepetido=false;
	private boolean correoMalEscrito=false;
	private boolean noMoto=false;
	
	//private boolean checkInsert = false;

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String add() {
		
		String paginaActividad=null;
		 Pattern pattern = Pattern
	                .compile("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$");
	        Matcher mather = pattern.matcher(cliente.getCorreo());
	 
	        if (mather.find() == true) {
	            System.out.println("El email ingresado es válido.");
	            this.correorepetido=logica.anadirUsuario(cliente);
	        } else {
	            System.out.println("El email ingresado es inválido.");
	            this.correoMalEscrito=true;
	        }		
			if(this.correoMalEscrito==false && this.correorepetido==false){
				paginaActividad="PaginaActividad";
			}
			return paginaActividad;
	}
	
	public String checkExistUser(){
		
		String destino=null;
		
		if(logica.checkUser(cliente))
			destino="PaginaActividad";
		
		return destino;
	}
	
	public void delete(){
		logica.eliminarUsuario(cliente);
	}

	public int getIdUsuarios() {
		return cliente.getIdUsuarios();
	}

	public void setIdUsuarios(int idUsuarios) {
		cliente.setIdUsuarios(idUsuarios);
	}

	public String getApellido() {
		return cliente.getApellido();
	}

	public void setApellido(String apellido) {
		cliente.setApellido(apellido);
	}

	public String getContrasena() {
		return cliente.getContrasena();
	}

	public void setContrasena(String contrasena) {
		cliente.setContrasena(contrasena);
	}

	public String getCorreo() {
		return cliente.getCorreo();
	}

	public void setCorreo(String correo) {
		cliente.setCorreo(correo);
	}

	public String getNombre() {
		return cliente.getNombre();
	}

	public void setNombre(String nombre) {
		cliente.setNombre(nombre);
	}
	public void calculaDistancias() throws IOException{
		
		String direccionDestino;
		
		direccionDestino=logica.calculoDistancia(direccion,cliente.getCorreo());

		if(direccionDestino!=null){
		StringBuilder str= new StringBuilder();
		str.append("http://maps.google.com/maps?saddr=");
		str.append(direccion+",Bilbao");
		str.append("&daddr=");
		str.append(direccionDestino+",Bilbao");//LA direccion que va con numero es Elorrio
		
	    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	    externalContext.redirect(str.toString());
		}else{
			System.out.println("No hay motos disponibles");
			this.noMoto=true;
		}
	}

	
	public boolean isCorreorepetido() {
		return correorepetido;
	}

	public void setCorreorepetido(boolean correorepetido) {
		this.correorepetido = correorepetido;
	}

	public boolean isCorreoMalEscrito() {
		return correoMalEscrito;
	}

	public void setCorreoMalEscrito(boolean correoMalEscrito) {
		this.correoMalEscrito = correoMalEscrito;
	}

	public boolean isNoMoto() {
		return noMoto;
	}

	public void setNoMoto(boolean noMoto) {
		this.noMoto = noMoto;
	}
	
	

}