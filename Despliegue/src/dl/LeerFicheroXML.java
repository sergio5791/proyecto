package dl;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class LeerFicheroXML implements LeerFichero {

	@Override
	public ListaErrores leer() {

		File fichero = new File("/home/sergio/Escritorio/ListaErrores.xml");
		ListaErrores lista = new ListaErrores();
		
		JAXBContext contexto;
		if (fichero.exists()) {
			try {
				contexto = JAXBContext.newInstance(ListaErrores.class);
				Unmarshaller unmarshaller = contexto.createUnmarshaller();
				lista = (ListaErrores) unmarshaller.unmarshal(fichero);
			} catch (JAXBException e) {

				e.printStackTrace();
			}
		}
		return lista;
	}

}
