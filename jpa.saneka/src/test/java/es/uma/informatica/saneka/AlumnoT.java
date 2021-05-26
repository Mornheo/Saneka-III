package es.uma.informatica.saneka;

import static org.junit.Assert.*;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
	
import es.uma.informatica.ejb.exceptions.AlumnoNoEncontrado;
import es.uma.informatica.ejb.exceptions.AlumnoYaExistente;
import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.ejb.saneka.GestionAlumno;
import es.uma.informatica.jpa.saneka.Alumno;
import es.uma.informatica.sii.anotaciones.Requisitos;
	
public class AlumnoT {
	
	private static final String ALUMNOS_EJB = "java:global/classes/AlumnoEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SanekaTest";
	
	private static Context ctx;
	private GestionAlumno gestionAlumno;
	

	@Before
	public void setup() throws NamingException {
		gestionAlumno=(GestionAlumno) SuiteTest.ctx.lookup(ALUMNOS_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF-8"})
	@Test
	public void testInsertarCorrectamente() {
		try {
			Alumno a=new Alumno("100", "Pepe", "Aparicio", "27181291@uma.es");
			gestionAlumno.insertarAlumno(a);
			try {
			String dni="100";
			gestionAlumno.mostrarAlumno(dni);
			}catch(AlumnoNoEncontrado e) {
				fail("Alumno no encontrado");
			}
		}catch(SanekaException e){
			throw new RuntimeException(e);
		}
		
	}
	
	@Requisitos({"RF-8"})
	@Test
	public void testInsertarYaExistente() {
		try {
			Alumno a=new Alumno("090", "Pepe", "Aparicio", "27181291@uma.es");
			gestionAlumno.insertarAlumno(a);
			fail("Alumno ya existente");
		}
		catch(AlumnoYaExistente e){
			//OK
		}
				
			
	}
	
	@Requisitos({"RF-8"})
	@Test
	public void testEliminarCorrectamente() {
		try {
			Alumno a=new Alumno("091", "Pepe", "Aparicio", "27181291@uma.es");
			gestionAlumno.insertarAlumno(a);
			String dni="091";
			gestionAlumno.eliminarAlumno(dni);
			try {
				gestionAlumno.mostrarAlumno(dni);
				fail("Alumno no encontrado");
			}catch(AlumnoNoEncontrado e){
				//OK
			}
		}catch(AlumnoNoEncontrado | AlumnoYaExistente e){
			fail("Alumno no encontrado");
		}
		
	}
	
	@Requisitos({"RF-8"})
	@Test
	public void testEliminarNoExistente() {
		try {
			String dni="000";
			gestionAlumno.eliminarAlumno(dni);
			fail("Alumno no encontrado");
	}catch(AlumnoNoEncontrado e) {
		//OK
		}
	}
	
	@Requisitos({"RF-2"})
	@Test
	public void testModificarAlumnoCorrecto() {
		try {
			Alumno a=new Alumno(null, null, null, null);
			a.setDni("090");
			a.setApellido1("Bezoya");
			gestionAlumno.modificarAlumno(a);
			assertNotEquals(a.getApellido1(),"Centeno");
		}catch(SanekaException e) {
			fail("No se ha cambiado");
		}
	}
	
	@Requisitos({"RF-2"})
	@Test
	public void testModificarAlumnoNoEncontrado() {
		try {
			Alumno a=new Alumno(null, null, null, null);
			a.setDni("000");
			a.setApellido1("Bezoya");
			gestionAlumno.modificarAlumno(a);
			fail("No se ha encontrado");
		}catch(AlumnoNoEncontrado e) {
			//OK
		}
	}
	
	@Requisitos({"RF-3"})
	@Test
	public void testMostrar() {
		try {
			String dni="090";
			gestionAlumno.mostrarAlumno(dni);
		}catch(AlumnoNoEncontrado e) {
			fail("Alumno no encontrado");
		}
	}
	
	@Requisitos({"RF-3"})
	@Test
	public void testMostrarAlumnoNoEncontrado() {
		try {
			String dni="000";
			gestionAlumno.mostrarAlumno(dni);
			fail("Alumno no encontrado");
		}catch(AlumnoNoEncontrado e) {
			//OK
		}
	}
	
	@Requisitos({"RF-3"})
	@Test
	public void testDevolver() {
		try {
			String dni="090";
			gestionAlumno.devolverAlumno(dni);
		}catch(AlumnoNoEncontrado e) {
			fail("Alumno no encontrado");
		}
	}
	
	@Requisitos({"RF-3"})
	@Test
	public void testDevolverAlumnoNoEncontrado() {
		try {
			String dni="000";
			gestionAlumno.devolverAlumno(dni);
			fail("Alumno no encontrado");
		}catch(AlumnoNoEncontrado e) {
			//OK
		}
	}
	
	
}
