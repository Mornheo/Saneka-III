package es.uma.informatica.ejb.saneka;

import javax.ejb.Local;

import es.uma.informatica.ejb.exceptions.TitulacionExistenteException;
import es.uma.informatica.ejb.exceptions.TitulacionNoExistenteException;
import es.uma.informatica.jpa.saneka.Titulacion;


@Local
public interface GestionTitulacion {
	
	public String mostrarTitulacion(Titulacion titulacion) throws TitulacionNoExistenteException;
	
	public void eliminarTitulacion(Titulacion titulacion) throws TitulacionNoExistenteException;
	
	public void insertarTitulacion(Titulacion titulacion) throws TitulacionExistenteException;
	
	public void modificarTitulacion(Titulacion titulacion) throws TitulacionNoExistenteException;
	
}
