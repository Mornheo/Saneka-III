package es.uma.informatica.saneka;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.uma.informatica.jpa.saneka.Alumno;

public class BaseDatos {
	public static void inicializaBaseDatos(String nombreUnidadPersistencia) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreUnidadPersistencia);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Alumno a=new Alumno();
		a.setDNI("090");
		a.setNombre("Diego");
		a.setApellido1("Centeno");
		a.setApellido2("Linares");
		
		em.persist(a);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
