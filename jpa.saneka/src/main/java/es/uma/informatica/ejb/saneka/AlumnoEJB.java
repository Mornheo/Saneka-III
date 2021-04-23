package es.uma.informatica.ejb.saneka;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.jpa.saneka.*;

@Stateless
public class AlumnoEJB implements GestionAlumno{

	@PersistenceContext(name="Alumno")
	private EntityManager em;
	
	@Override
	public void insertarAlumno(String dni) {
		// TODO Auto-generated method stub
		Alumno al=em.find(Alumno.class,dni);
		if(al!=null) {
			
		}
		Alumno a=new Alumno();
		a.setDNI(dni);
		em.persist(a);
	}

	@Override
	public void modificarAlumno(Alumno alumno) {
		// De alumno se puede cambiar el nombre, los apellidos,email-personal,
		// telefono,direccion notificacion, localidad notificacion, provincia
		// notificacion, cp.
		Alumno al=em.find(Alumno.class,"tal");
		if(al==null) {
			
		}
		al.setApellido1(alumno.getApellido1());
		al.setApellido2(alumno.getApellido2());
		al.setCP_notificacion(alumno.getCP_notificacion());
		
	}

	@Override
	public void mostrarAlumno() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarAlumno() {
		// TODO Auto-generated method stub
		
	}
public class AlumnoEJB {

}
