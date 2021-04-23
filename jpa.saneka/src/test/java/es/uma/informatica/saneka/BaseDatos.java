package es.uma.informatica.saneka;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.uma.informatica.jpa.saneka.Alumno;
import es.uma.informatica.jpa.saneka.Asignatura;
import es.uma.informatica.jpa.saneka.Centro;
import es.uma.informatica.jpa.saneka.Encuesta;
import es.uma.informatica.jpa.saneka.Expediente;
import es.uma.informatica.jpa.saneka.Grupo;
import es.uma.informatica.jpa.saneka.Grupos_por_asignatura;
import es.uma.informatica.jpa.saneka.Matricula;
import es.uma.informatica.jpa.saneka.Optativa;
import es.uma.informatica.jpa.saneka.Titulacion;

public class BaseDatos {
	public static void inicializaBaseDatos(String nombreUnidadPersistencia) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreUnidadPersistencia);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		//Rellenar con la base de datos para los test
		
		//Centro
		Centro centro = new Centro(123, "informatica", "avenida de andalucia n11");
		em.persist(centro);
		
		//Titulacion
		List<Centro> centros = new ArrayList<Centro>();
		centros.add(centro);
		Titulacion titu = new Titulacion(1234, centros);
		em.persist(titu);
		
		//Alumno
		Alumno alumnoA = new Alumno();
		alumnoA.setDNI("090");
		alumnoA.setNombre("Diego");
		alumnoA.setApellido1("Centeno");
		em.persist(alumnoA);
		
		//Expediente
		Expediente exp = new Expediente(12345, titu, alumnoA);
		em.persist(exp);
		
		//Asignatura
		Asignatura asig = new Asignatura(232, true, 101, 6, titu);
		em.persist(asig);
		
		//Optativa
		Optativa opt = new Optativa(233, true, 102, 6, titu);
		em.persist(opt);
		
		//Encuesta
		Encuesta encu = new Encuesta("23/04/2021", exp);
		em.persist(encu);
		
		//Matricula
		Matricula matr = new Matricula("3", "12/09/2020", exp);
		em.persist(matr);
		
		//Grupo
		Grupo grupo = new Grupo(3, "B", "tarde", false);
		em.persist(grupo);
		
		//Grupos Por Asignatura
		Grupos_por_asignatura gpa = new Grupos_por_asignatura(3, asig, grupo);
		em.persist(gpa);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
