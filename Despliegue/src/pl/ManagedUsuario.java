package pl;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import bl.LogicaNegocio;
import dl.Using;
import dl.Usuario;

@Named
@RequestScoped
public class ManagedUsuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private LogicaNegocio logica;
	Usuario cliente = new Usuario();
	
	//private boolean checkInsert = false;



	public void add() {
			logica.anadirUsuario(cliente);
			//this.checkInsert = true;
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

	

}