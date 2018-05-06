package bl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.json.JSONException;

import com.google.gson.Gson;

import dl.Cuerpo;
import dl.Moto;
import dl.Usuario;

@Stateless
@LocalBean
public class LogicaNegocio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;

	public void anadirUsuario(Usuario user) {

		Usuario usuario;

		try {
			usuario = (Usuario) em.createNamedQuery("Usuario.Correo").setParameter("mail", user.getCorreo())
					.getSingleResult();
			if (usuario.getCorreo().equals(user.getCorreo()))
				System.out.println("Ya hay un correo identico");

		} catch (NoResultException ex) {
			em.persist(user);
			System.out.println("Se introduce el usuario");
		}

	}

	public void eliminarUsuario(Usuario user) {

		// Si se quiere para ponerlo en una pagina de administrador

	}

	public boolean checkUser(Usuario user) {

		Usuario usuario;
		Boolean check = false;
		try {
			usuario = (Usuario) em.createNamedQuery("Usuario.Correo").setParameter("mail", user.getCorreo())
					.getSingleResult();
			if (usuario.getContrasena().equals(user.getContrasena()))
				check = true;
		} catch (NoResultException ex) {
			System.out.println("No hay un usuario con ese correo");
		}
		return check;
	}

	public void pruebaGoogleApi() throws JSONException {

        URL url;
		try {
			url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=Vancouver+BC|Seattle&destinations=San+Francisco|Victoria+BC&mode=bicycling&language=fr-FR&key=AIzaSyCihVMBwuZD-84fDMK-_Y8nFuXVBg7DHNQ");
	        InputStreamReader reader = new InputStreamReader(url.openStream());
	        
			Cuerpo sr = (Cuerpo) new Gson().fromJson(reader, Cuerpo.class);

	        System.out.println("destination: " + sr.destination_addresses.get(0));
	        System.out.println("origins: " + sr.origin_addresses.get(0));
	       sr.rows.get(0).elements.get(0).getDistance().mostrar();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	public void addMoto(Moto moto) {
		try {
			pruebaGoogleApi();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		em.persist(moto);
	}

}
