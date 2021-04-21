package es.uma.informatica.ejb.saneka;

import javax.ejb.Local;

import es.uma.informatica.ejb.exceptions.ExpedienteExistenteException;
import es.uma.informatica.ejb.exceptions.ExpedienteNoEncontradoException;
import es.uma.informatica.jpa.saneka.Expediente;

@Local
public interface GestionExpediente {
	
	/*
	 * Inserta un expediente en la base de datos. Lanzará una excepción
	 * si ya se encuentra en ella.
	 * @Param exp Expediente que se quiere insertar 
	 * lanzará una excepción ExpedienteExistenteException si 
	 * ya se encuentra dentro.
	 */
	public void insertarExpediente(Expediente exp) throws ExpedienteExistenteException;
	public void eliminarExpediente(Expediente exp) throws ExpedienteNoEncontradoException;
	public void modificarExpediente(Expediente exp) throws ExpedienteNoEncontradoException;
	public void mostrarExpediente(Expediente exp) throws ExpedienteNoEncontradoException;
}