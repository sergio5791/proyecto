package bl;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import dl.EscribirXML;
import dl.Usuario;

@Path("/servicio")
public class ServicioRest {

	
	@Path("anadir")
	@POST
	public void anadirUsuario (Usuario user){
		
		EscribirXML escribir= new EscribirXML();
		escribir.EscribirFichero(user);
		
	}
	
	
}
