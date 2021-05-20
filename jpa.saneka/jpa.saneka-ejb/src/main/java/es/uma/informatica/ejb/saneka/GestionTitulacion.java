package es.uma.informatica.ejb.saneka;

import javax.ejb.Local;

import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.jpa.saneka.Titulacion;


@Local
public interface GestionTitulacion {
	
	public String mostrarTitulacion(Integer code) throws SanekaException;
	
	public void eliminarTitulacion(Integer code) throws SanekaException;
	
	public void insertarTitulacion(Integer code, Titulacion titulacion) throws SanekaException;
	
	public void modificarTitulacion(Integer code, Titulacion titulacion) throws SanekaException;
	
	public Titulacion devolverTitulacion(Integer code) throws SanekaException;
	
}
