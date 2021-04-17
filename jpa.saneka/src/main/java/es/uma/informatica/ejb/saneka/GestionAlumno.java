package es.uma.informatica.ejb.saneka;
import javax.ejb.Local;

@Local
public interface GestionAlumno {
	
	public void insertarAlumno();
	
	public void modificarAlumno();
	
	public void mostrarAlumno();
	
	public void eliminarAlumno();

}
