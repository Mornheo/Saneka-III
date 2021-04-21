package es.uma.informatica.ejb.saneka;
import javax.ejb.Local;

import es.uma.informatica.jpa.saneka.Alumno;

@Local
public interface GestionAlumno {
	
	public void mostrarAlumno();
	
	public void eliminarAlumno();

	void insertarAlumno(String dni);

	void modificarAlumno(Alumno alumno);

}
