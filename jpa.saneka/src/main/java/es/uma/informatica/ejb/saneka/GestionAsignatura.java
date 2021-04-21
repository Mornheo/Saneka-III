package es.uma.informatica.ejb.saneka;
import javax.ejb.Local;

import es.uma.informatica.jpa.saneka.Asignatura;

@Local
public interface GestionAsignatura {
	
	public String mostrarAsignatura(Asignatura asignatura);
	
	public void eliminarAsignatura(Asignatura asignatura);
	
	public void insertarAsignatura(Asignatura asignatura);
	
	public void modificarAsignatura(Asignatura asignatura);
	
}
