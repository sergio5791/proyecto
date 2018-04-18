package dl;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class LeerFicheroXML implements LeerFichero {

	@Override
	public ListaUsuarios leer() {

		File fichero = new File("/home/sergio/Escritorio/ListaUsuarios.xml");
		ListaUsuarios lista = new ListaUsuarios();

		JAXBContext contexto;
		if (fichero.exists()) {
			try {
				contexto = JAXBContext.newInstance(ListaUsuarios.class);
				Unmarshaller unmarshaller = contexto.createUnmarshaller();
				lista = (ListaUsuarios) unmarshaller.unmarshal(fichero);
			} catch (JAXBException e) {

				e.printStackTrace();
			}
		}
		return lista;
	}

}
