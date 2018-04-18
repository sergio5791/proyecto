package dl;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class EscribirXML implements Escribir{

	@Override
	public void EscribirFichero(Usuario user) {
		
		
		File fichero= new File("/home/sergio/Escritorio/ListaUsuarios.xml");
		ListaUsuarios lista = new ListaUsuarios();
		LeerFicheroXML leer= new LeerFicheroXML();
		
		if(fichero.exists()){		
			lista.setLista(leer.leer().getLista());
		}
		lista.getLista().add(user);
		
		JAXBContext contexto;
		System.out.println("Escribe el XMl");
		try {
			contexto = JAXBContext.newInstance(ListaUsuarios.class);
			Marshaller marshaller=contexto.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(lista,fichero);
		} catch (JAXBException e) {
			
			e.printStackTrace();
		}

		
	}

}
