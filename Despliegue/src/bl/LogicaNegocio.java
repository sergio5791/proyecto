package bl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.google.gson.Gson;

import dl.Cuerpo;
import dl.EnUso;
import dl.ErrorMoto;
import dl.EscribirXML;
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

	public int googleApi(String direccionOrigen,String direccionDestino) {

		//La direccion tiene un formato calle+Nombre
		URL url;
		int distancia=0;
		
		try {
			url = new URL(
					"https://maps.googleapis.com/maps/api/distancematrix/json?origins="+direccionOrigen+",+Bilbao&destinations="+direccionDestino+",+Bilbao&mode=walking&language=es-ES&key=AIzaSyCihVMBwuZD-84fDMK-_Y8nFuXVBg7DHNQ");
			InputStreamReader reader = new InputStreamReader(url.openStream());

			Cuerpo sr = (Cuerpo) new Gson().fromJson(reader, Cuerpo.class);

			System.out.println("destination: " + sr.destination_addresses.get(0));
			System.out.println("origins: " + sr.origin_addresses.get(0));
			distancia=sr.rows.get(0).elements.get(0).getDistance().getValue();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return distancia;

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
		
		List<Moto> lista=null;
		try{
		lista=em.createNamedQuery("Moto.findAll").getResultList();
		}catch(Exception ex){
			System.out.println("No hay motos en la base de datos");
		}
		
		
		return lista;
	}

	@SuppressWarnings("deprecation")
	public String calculoDistancia(String direccion,String correo){
		
		List<Moto> lista=null;
		int i=0,posicionMotoCercana=0;
		EnUso disponible= new EnUso();
		Moto moto=null;
		Date fecha=new Date();
		Usuario user=null;
		ErrorMoto errorMoto = null;
		String motoMasCercana=null;
		POJOCalculaMinDistancia calculo= new POJOCalculaMinDistancia();
		int listaDistancias[]=new int[getMotosFalse().size()];
		
		lista=getMotosFalse();
		if(lista.size()!=0){
		for(i=0;i< lista.size();i++){
			listaDistancias[i]=googleApi(direccion.replace(" ","_"),lista.get(i).getDireccion().replace(" ","_"));
			//System.out.println(listaDistancias[i]);		
		}
		posicionMotoCercana=calculo.minDistancia(listaDistancias);
		
		moto=em.find(Moto.class, lista.get(posicionMotoCercana).getIdMotos());
		user=(Usuario) em.createNamedQuery("Usuario.Correo").setParameter("mail", correo).getSingleResult();
		disponible.setUsuario(user);
		disponible.setMoto(moto);
		em.persist(disponible);
		moto.setDisponibilidad(true);
		em.persist(moto);
		
		motoMasCercana=lista.get(posicionMotoCercana).getDireccion(); //Se asigna la direccion de la moto mas cercana 
		}else{
			errorMoto=new ErrorMoto();
			errorMoto.setDireccion(direccion);
			errorMoto.setFecha(fecha.toString());
			EscribirXML escribir= new EscribirXML();
			escribir.EscribirFichero(errorMoto);
	
		}
		return motoMasCercana;

	}


	@SuppressWarnings("unchecked")
	public List<EnUso> getListaMotosUso(){
		
		return em.createNamedQuery("EnUso.findAll").getResultList();
		
			
	}
	
	public void deleteMotoEnUso(int id){
		
		EnUso auxiliar;
		int idMoto;
		Moto moto;
		
		auxiliar=em.find(EnUso.class, id);
		idMoto=auxiliar.getMoto().getIdMotos();
		moto=em.find(Moto.class, idMoto);
		moto.setDisponibilidad(false);
		em.persist(moto);
		em.remove(auxiliar);
	}
	
	@SuppressWarnings("unchecked")
	public List<Moto> getMotosFalse(){
		
		return em.createNamedQuery("Moto.false").getResultList();
		
	}
	
}
