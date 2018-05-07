package bl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

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

	public void googleApi(String direccion) {

		//La direccion tiene un formato calle+Nombre
		URL url;
		try {
			url = new URL(
					"https://maps.googleapis.com/maps/api/distancematrix/json?origins=direccion,+Bilbao&destinations=Calle+Autonomia,+Bilbao&mode=walking&language=es-ES&key=AIzaSyCihVMBwuZD-84fDMK-_Y8nFuXVBg7DHNQ");
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

		em.persist(moto);
	}

	public void deleteMoto(int idMoto){
		
		Moto moto;
		try{
		moto=em.find(Moto.class, idMoto);
		em.remove(moto);
		}catch(Exception ex){
			System.out.println("No hay una moto con se ID");
			
		}
	}

	@SuppressWarnings("unchecked")
	public List<Moto> getListaMotos(){
		
		List<Moto> lista;
		
		lista=em.createNamedQuery("Moto.findAll").getResultList();
		
		
		
		return lista;
	}

	public void calculoDistancia(String direccion){
		
		
		
	}


}
