package es.uma.informatica.ejb.saneka;
import java.util.List;
import javax.ejb.Local;

import es.uma.informatica.ejb.exceptions.AsignaturaNoEncontradoException;
import es.uma.informatica.ejb.exceptions.ClaseExistenteException;
import es.uma.informatica.ejb.exceptions.ClaseNoEncontradoException;
import es.uma.informatica.ejb.exceptions.GrupoNoEncontradoException;
import es.uma.informatica.jpa.saneka.Clase;
import es.uma.informatica.jpa.saneka.Usuario;
import es.uma.informatica.jpa.saneka.Clase.ClaseId;
@Local
public interface GestionClase {
	public void insertarClase(Integer grupo,Clase clase) throws GrupoNoEncontradoException, ClaseExistenteException ;
	public List<Clase> obtenerClasesDeGrupo(Integer grupo) throws GrupoNoEncontradoException;
	public void actualizarClase(Integer grupo,ClaseId idClase,Clase clase) throws GrupoNoEncontradoException, ClaseNoEncontradoException;
	public void eliminarClase(Integer grupo,ClaseId idClase) throws GrupoNoEncontradoException, ClaseNoEncontradoException;
	public void eliminarTodosClases(Integer grupo) throws GrupoNoEncontradoException;
	public List<Clase> devolverClases();
	
}
