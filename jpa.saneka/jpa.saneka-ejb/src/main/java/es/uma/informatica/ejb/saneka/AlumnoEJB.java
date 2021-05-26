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
		Alumno al=em.find(Alumno.class,alumno.getDni());
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
		Alumno al=em.find(Alumno.class,alumno.getDni());
		if(al==null) {
			throw new AlumnoNoEncontrado();
		}
		al.setApellido1(alumno.getApellido1());
		al.setApellido2(alumno.getApellido2());
		al.setCpNotificacion(alumno.getCpNotificacion());
		al.setDireccionNotificacion(alumno.getDireccionNotificacion());
		al.setEmailPersonal(alumno.getEmailPersonal());
		al.setTelefono(alumno.getTelefono());
		al.setLocalidadNotificacion(alumno.getLocalidadNotificacion());
		al.setProvinciaNotificaccion(alumno.getProvinciaNotificaccion());
		al.setCpNotificacion(alumno.getCpNotificacion());
		em.persist(al);
		
	}

	@Override
	public String mostrarAlumno(String dni) throws AlumnoNoEncontrado{
		Alumno al=em.find(Alumno.class,dni);
		if(al==null) {
			throw new AlumnoNoEncontrado();
		}
		return al.toString();
		
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
	
	@Override
	public Alumno devolverAlumno(String dni) throws AlumnoNoEncontrado{
		Alumno al=em.find(Alumno.class,dni);
		if(al==null) {
			throw new AlumnoNoEncontrado();
		}
		return al;
	}
	
}


