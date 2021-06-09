

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
		
		Centro centro1 = new Centro(123, "informatica", "avenida de andalucia n11","23446",titulaciones);
		Centro centro2 = new Centro(124, "informatica", "avenida de andalucia n11","23446",titulaciones);
		Centro centro3 = new Centro(125, "informatica", "avenida de andalucia n11","23446",titulaciones);
		em.persist(centro1);
		em.persist(centro2);
		em.persist(centro3);
		
		//Titulacion
		
		List<Centro> centros = new ArrayList<Centro>();
		centros.add(centro1);
		Titulacion titu1 = new Titulacion(1234,"infor",6, centros);
		Titulacion titu2 = new Titulacion(1235,"infor",6, centros);
		Titulacion titu3 = new Titulacion(1236,"infor",6, centros);
		em.persist(titu1);
		em.persist(titu2);
		em.persist(titu3);
		
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
		Expediente exp1 = new Expediente(12345, titu1, alumno1);
		Expediente exp2 = new Expediente(12346, titu1, alumno1);
		Expediente exp3 = new Expediente(12347, titu1, alumno1);
		Expediente exp4 = new Expediente(12348, titu1, alumno1);
		Expediente exp5 = new Expediente(12349, titu1, alumno1);
		exp1.setActivo(true);
		exp2.setActivo(true);
		exp3.setActivo(true);
		exp4.setActivo(true);
		exp5.setActivo(true);
		em.persist(exp1);
		em.persist(exp2);
		em.persist(exp3);
		em.persist(exp4);
		em.persist(exp5);
		
		//Asignatura
		Asignatura asig1 = new Asignatura(232, true, 101, 6, titu1);
		Asignatura asig2 = new Asignatura(233, true, 101, 6, titu1);
		Asignatura asig3 = new Asignatura(234, true, 101, 6, titu1);
		Asignatura asig4 = new Asignatura(235, true, 101, 6, titu1);
		em.persist(asig1);
		em.persist(asig2);
		em.persist(asig3);
		em.persist(asig4);
		
		//Optativa
		Optativa opt1 = new Optativa(240, true, 102, 6, titu1);
		Optativa opt2 = new Optativa(241, true, 102, 6, titu1);
		Optativa opt3 = new Optativa(242, true, 102, 6, titu1);
		em.persist(opt1);
		em.persist(opt2);
		em.persist(opt3);
		
		//Encuesta
		Encuesta encu1 = new Encuesta("23/04/2021", exp1);
		Encuesta encu2 = new Encuesta("24/04/2021", exp1);
		Encuesta encu3 = new Encuesta("25/04/2021", exp1);
		em.persist(encu1);
		em.persist(encu2);
		em.persist(encu3);
		
		//Matricula
		Matricula matr1 = new Matricula("3", "12/09/2020", exp1);
		Matricula matr2 = new Matricula("4", "12/09/2020", exp2);
		Matricula matr3 = new Matricula("5", "12/09/2020", exp3);
		Matricula matr4 = new Matricula("6", "12/09/2020", exp4);
		em.persist(matr1);
		em.persist(matr2);
		em.persist(matr3);
		em.persist(matr4);
		
		//Grupo
		Grupo grupo1 = new Grupo(420, 3, "B", "tarde", false, titu1);
		Grupo grupo2 = new Grupo(421, 4, "B", "tarde", false, titu1);
		Grupo grupo3 = new Grupo(422, 1, "B", "tarde", false, titu1);
		Grupo grupo4 = new Grupo(423, 2, "B", "tarde", false, titu1);
		Grupo grupo5 = new Grupo(424, 5, "B", "tarde", false, titu1);
		em.persist(grupo1);
		em.persist(grupo2);
		em.persist(grupo3);
		em.persist(grupo4);
		em.persist(grupo5);
		
		//Grupos Por Asignatura
		GruposPorAsignatura gpa1 = new GruposPorAsignatura(3, asig1, grupo1);
		GruposPorAsignatura gpa2 = new GruposPorAsignatura(4, asig2, grupo2);
		GruposPorAsignatura gpa3 = new GruposPorAsignatura(5, asig3, grupo3);
		em.persist(gpa1);
		em.persist(gpa2);
		em.persist(gpa3);
		
		//Clase
		Clase clase1 = new Clase(23, "8:45", asig1, grupo1);
		Clase clase2 = new Clase(24, "9:45", asig2, grupo2);
		Clase clase3 = new Clase(25, "10:45", asig3, grupo3);
		em.persist(clase1);
		em.persist(clase2);
		em.persist(clase3);
		
		//Asignaturas Matricula
		AsignaturasMatricula am1 = new AsignaturasMatricula(asig1, matr1);
		AsignaturasMatricula am2 = new AsignaturasMatricula(asig2, matr2);
		AsignaturasMatricula am3 = new AsignaturasMatricula(asig3, matr3);
		em.persist(am1);
		em.persist(am2);
		em.persist(am3);
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}
}