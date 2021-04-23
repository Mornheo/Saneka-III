package es.uma.informatica.ejb.saneka;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.exceptions.AlumnoNoEncontrado;
import es.uma.informatica.ejb.exceptions.AlumnoYaExistente;
import es.uma.informatica.jpa.saneka.*;

@Stateless
public class AlumnoEJB implements GestionAlumno{

	@PersistenceContext(name="jpa.saneka")
	private EntityManager em;
	
	@Override
	public void insertarAlumno(Alumno alumno) throws AlumnoYaExistente{
		// TODO Auto-generated method stub
		Alumno al=em.find(Alumno.class,alumno.getDNI());
		if(al!=null) {
			throw new AlumnoYaExistente();
		}
		em.persist(alumno);
	}

	@Override
	public void modificarAlumno(Alumno alumno) throws AlumnoNoEncontrado{
		// De alumno se puede cambiar el nombre, los apellidos,email-personal,
		// telefono,direccion notificacion, localidad notificacion, provincia
		// notificacion, cp.
		Alumno al=em.find(Alumno.class,alumno.getDNI());
		if(al==null) {
			throw new AlumnoNoEncontrado();
		}
		al.setApellido1(alumno.getApellido1());
		al.setApellido2(alumno.getApellido2());
		al.setCP_notificacion(alumno.getCP_notificacion());
		al.setDireccion_notificacion(alumno.getDireccion_notificacion());
		al.setEmail_personal(alumno.getEmail_personal());
		al.setTelefono(alumno.getTelefono());
		al.setLocalidad_notificacion(alumno.getLocalidad_notificacion());
		al.setProvincia_notificaccion(alumno.getProvincia_notificaccion());
		al.setCP_notificacion(alumno.getCP_notificacion());
		em.persist(al);
		
	}

	@Override
	public void mostrarAlumno(String dni) throws AlumnoNoEncontrado{
		Alumno al=em.find(Alumno.class,dni);
		if(al==null) {
			throw new AlumnoNoEncontrado();
		}
		System.out.print(al.toString());
		
	}

	@Override
	public void eliminarAlumno(String dni) throws AlumnoNoEncontrado{
		// TODO Auto-generated method stub
		Alumno al=em.find(Alumno.class,dni);
		if(al==null) {
			throw new AlumnoNoEncontrado();
		}
		em.remove(al);
	}
}
