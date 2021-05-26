package es.uma.informatica.ejb.saneka;

import javax.ejb.Local;

import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.jpa.saneka.Encuesta;

@Local
public interface GestionEncuesta {

	/*
	 * Inserta en la base de datos una nueva encuesta asociada a 
	 * un expediente. Si ya existe lanzará una excepción.
	 * @Param fecha PK de la encuesta.
	 * @Param enc La encuesta a insertar.
	 */
	public void insertarEncuesta(String fecha, Encuesta enc) throws SanekaException;
	
	/*
	 * Elimina de la base de datos la encuesta asociada a la clave 
	 * primaria introducida si existe. En otro caso lanzará una
	 * excepción.
	 * @Param fecha La PK de la encuesta a eliminar.
	 */
	public void eliminarEncuesta(String fecha) throws SanekaException;
	
	/*
	 * Muestra un toString() de la encuesta.
	 * @Param fecha PK de la encuesta a mostrar.
	 */
	public String mostrarEncuesta(String fecha) throws SanekaException;
	
	/*
	 * Devuelve una encuesta asociada a la PK fecha.
	 * @Param fecha PK de la encuesta a devolver.
	 */
	public Encuesta devolverEncuesta(String fecha)throws SanekaException;
}
