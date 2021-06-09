package es.uma.informatica.ejb.saneka;

import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.ejb.exceptions.ExpedienteExistenteException;
import es.uma.informatica.ejb.exceptions.ExpedienteNoEncontradoException;
import es.uma.informatica.jpa.saneka.Expediente;
import es.uma.informatica.jpa.saneka.Optativa;

@Local
public interface GestionExpediente {
	
	/*
	 * Inserta un expediente en la base de datos. Lanzará una excepción
	 * si ya se encuentra en ella.
	 * @Param exp Expediente que se quiere insertar 
	 * lanzará una excepción ExpedienteExistenteException si 
	 * ya se encuentra dentro.
	 */
	public void insertarExpediente(Integer num, Expediente exp) throws ExpedienteExistenteException;
	
	/*
	 * Eliminara el expediente de la base de datos.
	 * @Param num PK del expediente a eliminar.
	 */
	public void eliminarExpediente(Integer num) throws ExpedienteNoEncontradoException;
	
	/*
	 * Se modificará su estado Activo y la nota_media.
	 * @Param num es el PK.
	 * @Param exp es el expediente de origen, contiene los nuevos
	 * datos.
	 */
	public void modificarExpediente(Integer num, Expediente exp) throws ExpedienteNoEncontradoException;
	
	/*
	 * Muestra un toString() el expediente.
	 * @Param num PK del expediente a mostrar.
	 */
	public String mostrarExpediente(Integer num) throws ExpedienteNoEncontradoException;
	
	/*
	 * Devuelve el expediente relacionado con el parametro.
	 * @Param num PK del expediente a devolver.
	 */
	public Expediente devolverExpediente(Integer num) throws ExpedienteNoEncontradoException;
	public List<Expediente> devolverExpedientes() ;
}