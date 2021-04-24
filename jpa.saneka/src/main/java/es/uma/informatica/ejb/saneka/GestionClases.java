package es.uma.informatica.ejb.saneka;
import java.util.List;
import javax.ejb.Local;

import es.uma.informatica.ejb.exceptions.AsignaturaNoEncontradoException;
import es.uma.informatica.ejb.exceptions.ClaseExistenteException;
import es.uma.informatica.ejb.exceptions.ClaseNoEncontradoException;
import es.uma.informatica.jpa.saneka.Clase;
@Local
public interface GestionClases {
	public void insertarClase(Integer asignatura,Clase clase) throws AsignaturaNoEncontradoException, ClaseExistenteException ;
	public List<Clase> obtenerClasesDeAsignatura(Integer asignatura) throws AsignaturaNoEncontradoException;
	public void actualizarClase(Integer asignatura,Clase clase) throws AsignaturaNoEncontradoException, ClaseNoEncontradoException;
	public void eliminarClase(Integer asignatura,Clase clase) throws AsignaturaNoEncontradoException, ClaseNoEncontradoException;
	public void eliminarTodosClases(Integer asignatura) throws AsignaturaNoEncontradoException;
	
}
