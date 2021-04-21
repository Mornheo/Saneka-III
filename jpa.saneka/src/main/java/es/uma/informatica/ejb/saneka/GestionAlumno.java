package es.uma.informatica.ejb.saneka;
import javax.ejb.Local;

import es.uma.informatica.ejb.exceptions.AlumnoNoEncontrado;
import es.uma.informatica.ejb.exceptions.AlumnoYaExistente;
import es.uma.informatica.jpa.saneka.Alumno;

@Local
public interface GestionAlumno {

	void insertarAlumno(Alumno alumno) throws AlumnoYaExistente;

	void modificarAlumno(Alumno alumno) throws AlumnoNoEncontrado;

	void mostrarAlumno(String dni) throws AlumnoNoEncontrado;

	void eliminarAlumno(String dni) throws AlumnoNoEncontrado;

}
