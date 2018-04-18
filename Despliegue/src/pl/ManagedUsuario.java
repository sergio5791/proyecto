package pl;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

import dl.LeerFicheroXML;
import dl.ListaUsuarios;
import dl.Usuario;

@Named
@RequestScoped
public class ManagedUsuario implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuario cliente = new Usuario();
	private boolean checkInsert = false;
	private boolean checkCopy = false;

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

		if (buscaUsuario()) {
			ClientBuilder.newClient().target("http://localhost:8080/TAP/rest/servicio/").path("anadir").request()
					.post(Entity.json(cliente));
			this.checkInsert = true;
		} else {
			this.checkCopy = true;
		}
	}

	public boolean buscaUsuario() {

		// El boolean esta puesto asi para renderizar la respuesta

		LeerFicheroXML leer = new LeerFicheroXML();
		ListaUsuarios lista = new ListaUsuarios();
		boolean check = true;

		lista.setLista(leer.leer().getLista());

		for (Usuario user : lista.getLista()) {
			if (user.getCorreo().contentEquals(this.cliente.getCorreo())) {
				check = false;
			}
		}
		return (check);

	}

	public boolean checkInsertCorreo() {
		// Mira si se ha insertado el correo en el fichero
		// Si esto se cumple se devuelve True
		return (this.checkInsert);
	}

	public boolean checkCopyCorreo() {
		// Mira si hay un correo igual en el fichero
		// Si esto se cumple se devuelve True
		return (this.checkCopy);
	}

	

	public String checkRegistro() {
		// Busca si el usuario y la contraseña estan en el fichero

		LeerFicheroXML leer = new LeerFicheroXML();
		ListaUsuarios lista = new ListaUsuarios();
		String check ="PaginaInicio";

		lista.setLista(leer.leer().getLista());

		for (Usuario user : lista.getLista()) {
			if (user.getCorreo().contentEquals(cliente.getCorreo()) && user.getPassword().contentEquals(cliente.getPassword())) {
				check="PaginaActividad";
			}
		}

		return(check);
	}

}