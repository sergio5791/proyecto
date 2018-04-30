package pl;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import bl.LogicaNegocio;
import dl.Usuario;

@Named
@RequestScoped
public class ManagedUsuario implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuario cliente = new Usuario();
	@EJB
	private LogicaNegocio logica;
	//private boolean checkInsert = false;

	public String getNombre() {
		return cliente.getNombre();
	}

	public void setNombre(String nombre) {
		cliente.setNombre(nombre);
	}

	public String getApellido() {
		return cliente.getApellido();
	}

	public void setApellido(String apellido) {
		cliente.setApellido(apellido);
	}

	public String getCorreo() {
		return cliente.getCorreo();
	}

	public void setCorreo(String correo) {
		cliente.setCorreo(correo);
	}

	public String getPassword() {
		return cliente.getPassword();
	}

	public void setPassword(String password) {
		cliente.setPassword(password);
	}

	public void add() {

			logica.anadirUsuario(cliente);
			//this.checkInsert = true;
	}


}