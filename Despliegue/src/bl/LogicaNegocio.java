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
			if (usuario.getContrasena().equals(user.getCorreo())) {
				System.out.println("Ya hay un correo identico");
			} else {
				System.out.println("Ya existe un correo igual");
			}
		}catch(NoResultException ex){
			em.persist(user);
		}

	}

	@SuppressWarnings("unchecked")
	public List<Usuario> getListaDB() {

		System.out.println("LLega al metodo que devuelve la Lista");
		List<Usuario> lista = (List<Usuario>) em.createNamedQuery("getLista").getResultList();

		return lista;

	}

}
