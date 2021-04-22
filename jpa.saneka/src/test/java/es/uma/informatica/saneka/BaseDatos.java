package es.uma.informatica.saneka;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.uma.informatica.jpa.saneka.Alumno;

public class BaseDatos {
	public static void inicializaBaseDatos(String nombreUnidadPersistencia) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreUnidadPersistencia);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Alumno diego =new Alumno();
		diego.setDNI("090");
		
		Alumno bezoya =new Alumno();
		bezoya.setDNI("010");
		
		for (Alumno alumno: new Alumno [] {diego, bezoya}) {
			em.persist(alumno);
		}
		
	}
}
