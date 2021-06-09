package es.uma.informatica.ejb.saneka;
import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.ejb.exceptions.AsignaturaExistenteException;
import es.uma.informatica.ejb.exceptions.AsignaturaNoEncontradoException;
import es.uma.informatica.jpa.saneka.Asignatura;
import es.uma.informatica.jpa.saneka.Usuario;

@Local
public interface GestionAsignatura {
	
	public String mostrarAsignatura(Integer ref) throws AsignaturaNoEncontradoException;
	
	public void eliminarAsignatura(Integer ref) throws AsignaturaNoEncontradoException;
	
	public void insertarAsignatura(Integer ref, Asignatura asignatura) throws AsignaturaExistenteException;
	
	public void modificarAsignatura(Integer ref, Asignatura asignatura) throws AsignaturaNoEncontradoException;
	
	public Asignatura devolverAsignatura(Integer ref) throws AsignaturaNoEncontradoException;
	public List<Asignatura> devolverAsignaturas();
	
}
