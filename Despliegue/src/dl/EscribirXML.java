package dl;

import java.io.File;

public class EscribirXML implements Escribir{

	@Override
	public void EscribirFichero(Usuario user) {
		// TODO Auto-generated method stub
		
		File fichero= new File("/home/sergio/ListaUsuarios.xml");
		ListaUsuarios lista = new ListaUsuarios();
		LeerFicheroXML leer= new LeerFicheroXML();
		
		if(fichero.exists()){		
			lista.setLista(leer.leer().getLista());
		}
		lista.getLista().add(user);
		
	}

}
