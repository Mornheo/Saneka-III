package es.uma.informatica.ejb.saneka;

import javax.ejb.Stateless;

import es.uma.informatica.ejb.exceptions.EncuestaExistenteException;
import es.uma.informatica.ejb.exceptions.EncuestaNoEncontradoException;
import es.uma.informatica.jpa.saneka.Encuesta;

@Stateless
public class EncuestaEJB implements GestionEncuesta{

	@Override
	public void insertarEncuesta(Encuesta enc) throws EncuestaExistenteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarEncuesta(Encuesta enc) throws EncuestaNoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarEncuesta(Encuesta enc) throws EncuestaNoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarEncuesta(Encuesta enc) throws EncuestaNoEncontradoException {
		// TODO Auto-generated method stub
		
	}

}
