package dl;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class LeerFicheroXML implements LeerFichero{

	@Override
	public ListaUsuarios leer() {
		// TODO Auto-generated method stub
		File fichero=new File("/home/sergio/ListaUsuarios.xml");
		ListaUsuarios lista= new ListaUsuarios();
		
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(ListaUsuarios.class);
			Unmarshaller unmarshaller = contexto.createUnmarshaller();
			lista=(ListaUsuarios) unmarshaller.unmarshal(fichero);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return lista;
	}

}
