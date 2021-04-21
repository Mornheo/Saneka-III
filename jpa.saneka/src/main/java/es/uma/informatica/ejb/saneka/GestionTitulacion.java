package es.uma.informatica.ejb.saneka;

import javax.ejb.Local;

import es.uma.informatica.jpa.saneka.Titulacion;


@Local
public interface GestionTitulacion {
	
	public String mostrarTitulacion(Titulacion titulacion);
	
	public void eliminarTitulacion(Titulacion titulacion);
	
	public void insertarTitulacion(Titulacion titulacion);
	
	public void modificarTitulacion(Titulacion titulacion);
	
}
