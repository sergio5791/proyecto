package pl;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

import dl.Usuario;

@Named
@RequestScoped
public class ManagedUsuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario user = new Usuario();

	public String getNombre() {
		return user.getNombre();
	}

	public void setNombre(String nombre) {
		user.setNombre(nombre);
	}

	public String getApellido() {

		return user.getApellido();
	}

	public void setApellido(String apellido) {
		user.setApellido(apellido);
	}

	public String getCorreo() {
		return user.getCorreo();
	}

	public void setCorreo(String correo) {
		user.setCorreo(correo);
	}

	public String getPassword() {
		return user.getPassword();
	}

	public void setPassword(String password) {
		user.setPassword(password);
	}

	public void addUser() {

		ClientBuilder
		.newClient()
		.target("http://localhost:8080/TAP/rest/servicio/")
		.path("anadir")
		.request()
		.post(Entity.json(user));

	}

}
