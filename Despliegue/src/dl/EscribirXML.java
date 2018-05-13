package dl;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class EscribirXML implements Escribir{

	@Override
	public void EscribirFichero(ErrorMoto error) {
		
		
		File fichero= new File("/home/sergio/Escritorio/ListaErrores.xml");
		ListaErrores lista = new ListaErrores();
		LeerFicheroXML leer= new LeerFicheroXML();
		
		if(fichero.exists()){		
			lista.setLista(leer.leer().getLista());
		}
		lista.getLista().add(error);
		
		JAXBContext contexto;

		try {
			contexto = JAXBContext.newInstance(ListaErrores.class);
			Marshaller marshaller=contexto.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(lista,fichero);
		} catch (JAXBException e) {
			
			e.printStackTrace();
		}

		
	}

}
