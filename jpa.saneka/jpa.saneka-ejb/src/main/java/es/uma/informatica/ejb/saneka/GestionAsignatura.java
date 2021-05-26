package es.uma.informatica.ejb.saneka;
import javax.ejb.Local;

import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.jpa.saneka.Asignatura;

@Local
public interface GestionAsignatura {
	
	public String mostrarAsignatura(Integer ref) throws SanekaException;
	
	public void eliminarAsignatura(Integer ref) throws SanekaException;
	
	public void insertarAsignatura(Integer ref, Asignatura asignatura) throws SanekaException;
	
	public void modificarAsignatura(Integer ref, Asignatura asignatura) throws SanekaException;
	
	public Asignatura devolverAsignatura(Integer ref) throws SanekaException;
	
}
