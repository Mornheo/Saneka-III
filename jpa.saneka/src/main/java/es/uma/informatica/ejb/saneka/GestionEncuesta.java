package es.uma.informatica.ejb.saneka;

import javax.ejb.Local;

import es.uma.informatica.ejb.exceptions.EncuestaExistenteException;
import es.uma.informatica.ejb.exceptions.EncuestaNoEncontradoException;
import es.uma.informatica.jpa.saneka.Encuesta;

@Local
public interface GestionEncuesta {

	public void insertarEncuesta(Encuesta enc) throws EncuestaExistenteException;
	public void eliminarEncuesta(Encuesta enc) throws EncuestaNoEncontradoException;
	public void modificarEncuesta(Encuesta enc) throws EncuestaNoEncontradoException;
	public void mostrarEncuesta(Encuesta enc) throws EncuestaNoEncontradoException;
}
