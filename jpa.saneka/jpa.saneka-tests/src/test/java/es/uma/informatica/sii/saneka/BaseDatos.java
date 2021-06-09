

package es.uma.informatica.sii.saneka;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.uma.informatica.jpa.saneka.Alumno;
import es.uma.informatica.jpa.saneka.Asignatura;
import es.uma.informatica.jpa.saneka.AsignaturasMatricula;
import es.uma.informatica.jpa.saneka.Centro;
import es.uma.informatica.jpa.saneka.Clase;
import es.uma.informatica.jpa.saneka.Encuesta;
import es.uma.informatica.jpa.saneka.Expediente;
import es.uma.informatica.jpa.saneka.Grupo;
import es.uma.informatica.jpa.saneka.GruposPorAsignatura;
import es.uma.informatica.jpa.saneka.Matricula;
import es.uma.informatica.jpa.saneka.Optativa;
import es.uma.informatica.jpa.saneka.Titulacion;
import es.uma.informatica.jpa.saneka.Usuario;

public class BaseDatos {
	
	public static void inicializaBaseDatos(String nombreUnidadPersistencia) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreUnidadPersistencia);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		//Rellenar con la base de datos para los test
	
		//Centro
		List<Titulacion> titulaciones = new ArrayList<Titulacion>();
		Centro centro = new Centro(123, "informatica", "avenida de andalucia n11","23446",titulaciones);
		em.persist(centro);
		
		//Titulacion
		
		List<Centro> centros = new ArrayList<Centro>();
		centros.add(centro);
		Titulacion titu = new Titulacion(1234,"infor",6, centros);
		em.persist(titu);
		
		//Alumno
		Alumno alumno1 = new Alumno("446753A", "Diego", "Centeno", "07143291@uma.es");
		em.persist(alumno1);
		Alumno alumno2 = new Alumno("770341P", "Alvaro", "Moreno", "07198655@uma.es");
		em.persist(alumno2);
		Alumno alumno3 = new Alumno("872339Z", "Lin", "Ye", "65712347@uma.es");
		em.persist(alumno3);
		Alumno alumno4 = new Alumno("374147G", "Rafael", "Martin", "07182345@uma.es");
		em.persist(alumno4);
		
		//Usuarios Alumnos
		Usuario userA1 = new Usuario("07143291@uma.es", "123", false);
		em.persist(userA1);
		Usuario userA2 = new Usuario("07198655@uma.es", "123", false);
		em.persist(userA2);
		Usuario userA3 = new Usuario("65712347@uma.es", "123", false);
		em.persist(userA3);
		Usuario userA4 = new Usuario("07182345@uma.es", "123", false);
		em.persist(userA4);
		
		//Usuarios Secretaria
		Usuario userS1 = new Usuario("sec1@uma.es", "123", true);
		em.persist(userS1);
		
		//Expediente
		Expediente exp = new Expediente(12345, titu, alumno1);
		exp.setActivo(true);
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
		Grupo grupo = new Grupo(420, 3, "B", "tarde", false, titu);
		em.persist(grupo);
		
		//Grupos Por Asignatura
		GruposPorAsignatura gpa = new GruposPorAsignatura(3, asig, grupo);
		em.persist(gpa);
		
		//Clase
		Clase clase = new Clase(23, "8:45", asig, grupo);
		em.persist(clase);
		
		//Asignaturas Matricula
		AsignaturasMatricula am = new AsignaturasMatricula(asig, matr);
		em.persist(am);
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}
}