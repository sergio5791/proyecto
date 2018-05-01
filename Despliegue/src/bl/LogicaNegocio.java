package bl;

import java.io.Serializable;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import dl.Using;
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
		
		try{
			usuario = (Usuario) em.createNamedQuery("Usuario.Correo").setParameter("mail", user.getCorreo())
					.getSingleResult();
			if(usuario.getCorreo().equals(user.getCorreo()))
				System.out.println("Ya hay un correo identico");
	
		}catch(NoResultException ex){
			em.persist(user);
			System.out.println("Se introduce el usuario");
		}

	}

	public void eliminarUsuario(Usuario user){
		
		//Si se quiere para ponerlo en una pagina de administrador
		
	}

	public boolean checkUser(Usuario user){
		
		Usuario usuario;
		Boolean check=false;
		
		try{
			usuario = (Usuario) em.createNamedQuery("Usuario.Correo").setParameter("mail", user.getCorreo())
					.getSingleResult();
			if(usuario.getContrasena().equals(user.getContrasena()))
				check=true;
	
		}catch(NoResultException ex){
			System.out.println("No hay un usuario con ese correo");
		}
		return check;
	}
	
}
