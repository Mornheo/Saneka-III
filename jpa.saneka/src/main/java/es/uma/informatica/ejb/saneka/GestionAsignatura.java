package es.uma.informatica.ejb.saneka;
import javax.ejb.Local;

import es.uma.informatica.ejb.exceptions.AsignaturaExistenteException;
import es.uma.informatica.ejb.exceptions.AsignaturaNoExistenteException;
import es.uma.informatica.jpa.saneka.Asignatura;

@Local
public interface GestionAsignatura {
	
	public String mostrarAsignatura(Asignatura asignatura) throws AsignaturaNoExistenteException;
	
	public void eliminarAsignatura(Asignatura asignatura) throws AsignaturaNoExistenteException;
	
	public void insertarAsignatura(Asignatura asignatura) throws AsignaturaExistenteException;
	
	public void modificarAsignatura(Asignatura asignatura) throws AsignaturaNoExistenteException;

	public Asignatura obtenerAsignatura(int ref) throws AsignaturaNoExistenteException;
	
}
