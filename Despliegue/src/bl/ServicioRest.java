package bl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import dl.EscribirXML;
import dl.Usuario;

@Path("/servicio")
public class ServicioRest {

	@Path("anadir")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void anadirUsuario (Usuario user){
		
		EscribirXML escribir= new EscribirXML();
		escribir.EscribirFichero(user);
		
	}	
	
}
