package bl;



import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dl.Usuario;

@Stateless
@LocalBean
public class LogicaNegocio {

	@PersistenceContext
	private EntityManager em;
	

	public void anadirUsuario (Usuario user){

	List<Usuario> lista;
		
	if(checkUser(user)==null){
		em.persist(user);
	}else{
		lista=getListaDB();
		for (int i = 0; i < lista.size(); i++) {
			em.persist(lista.get(i));
		}
		
	}
		
		
	}	
	
	public Usuario checkUser(Usuario user){
		
		Usuario usuario=(Usuario) em.createNamedQuery("BuscaCorreo")
				.setParameter("correo",user.getCorreo()).getSingleResult();
				
		return usuario;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> getListaDB(){
		
		List<Usuario> lista= (List<Usuario>)em.createNamedQuery("getLista").getResultList();
		
		return lista;
		
		
	}
	
	
	
	
	
	
	
	
	
}
