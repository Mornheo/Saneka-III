package es.uma.informatica.saneka;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.uma.informatica.jpa.saneka.Alumno;
import es.uma.informatica.jpa.saneka.Centro;
import es.uma.informatica.jpa.saneka.Expediente;
import es.uma.informatica.jpa.saneka.Matricula;
import es.uma.informatica.jpa.saneka.Titulacion;

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
		
		//Centro
		Centro centro = new Centro(123, "informatica", "avenida de andalucia n11");
		em.persist(centro);
		
		//Titulacion
		List<Centro> centros = new ArrayList<Centro>();
		centros.add(centro);
		Titulacion titu = new Titulacion(1234, centros);
		em.persist(titu);
		
		//Expediente
		Expediente exp = new Expediente(12345, titu, a);
		em.persist(exp);
		
		//Matricula
		Matricula matr = new Matricula("3", "12/09/2020", exp);
		em.persist(matr);
		
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
