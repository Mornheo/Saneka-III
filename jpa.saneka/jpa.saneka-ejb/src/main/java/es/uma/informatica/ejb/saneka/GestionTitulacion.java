package es.uma.informatica.ejb.saneka;

import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.ejb.exceptions.TitulacionExistenteException;
import es.uma.informatica.ejb.exceptions.TitulacionNoEncontradoException;
import es.uma.informatica.jpa.saneka.Titulacion;


@Local
public interface GestionTitulacion {
	
	public String mostrarTitulacion(Integer code) throws TitulacionNoEncontradoException;
	
	public void eliminarTitulacion(Integer code) throws TitulacionNoEncontradoException;
	
	public void insertarTitulacion(Integer code, Titulacion titulacion) throws TitulacionExistenteException;
	
	public void modificarTitulacion(Integer code, Titulacion titulacion) throws TitulacionNoEncontradoException;
	
	public Titulacion devolverTitulacion(Integer code) throws TitulacionNoEncontradoException;
	public List<Titulacion> devolverTitulaciones() ;
	
	
}
