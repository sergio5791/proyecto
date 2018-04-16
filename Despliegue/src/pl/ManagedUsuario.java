package pl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import dl.Usuario;

@Named
@RequestScoped
public class ManagedUsuario {

	private Usuario user;

	public String getNombre() {
		return user.getNombre();
	}

	public void setNombre(String nombre) {
		user.setNombre(nombre);
	}

	public String getApellido() {
		return user.getApellido();
	}
//Esto es una prueba
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
	
	
	
}
