package es.uma.informatica.ejb.saneka;

import javax.ejb.Local;

import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.jpa.saneka.Titulacion;


@Local
public interface GestionTitulacion {
	
	public String mostrarTitulacion(Titulacion titulacion) throws SanekaException;
	
	public void eliminarTitulacion(Titulacion titulacion) throws SanekaException;
	
	public void insertarTitulacion(Titulacion titulacion) throws SanekaException;
	
	public void modificarTitulacion(Titulacion titulacion) throws SanekaException;
	
	public Titulacion devolverTitulacion(Integer code) throws SanekaException;
	
}
