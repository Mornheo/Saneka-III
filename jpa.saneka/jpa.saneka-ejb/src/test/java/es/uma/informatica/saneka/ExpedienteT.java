package es.uma.informatica.saneka;

import static org.junit.Assert.*;


import java.util.Properties;
import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.apache.commons.math3.analysis.function.Exp;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uma.informatica.ejb.exceptions.ExpedienteExistenteException;
import es.uma.informatica.ejb.exceptions.ExpedienteNoEncontradoException;
import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.ejb.saneka.GestionAlumno;
import es.uma.informatica.ejb.saneka.GestionExpediente;
import es.uma.informatica.ejb.saneka.GestionTitulacion;
import es.uma.informatica.jpa.saneka.Alumno;
import es.uma.informatica.jpa.saneka.Expediente;
import es.uma.informatica.jpa.saneka.Titulacion;
import es.uma.informatica.sii.anotaciones.Requisitos;

public class ExpedienteT {

	private static final Logger LOG = Logger.getLogger(ExpedienteT.class.getCanonicalName());
	
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SanekaTest";
	
	//Path a las entidades que se usaran en los test ~/classes/{MiClaseEJB}
	private static final String EXPEDIENTE_EJB = "java:global/classes/ExpedienteEJB";
	private static final String TITULACION_EJB = "java:global/classes/TitulacionEJB";
	private static final String ALUMNO_EJB = "java:global/classes/AlumnoEJB";
	
	//Declaramos las entidades a usar en los test
	private GestionExpediente gestionExpediente;
	private GestionTitulacion gestionTitulacion;
	private GestionAlumno gestionAlumno;

	@Before
	public void setUp() throws Exception {
		//Inicializamos las clases y la base de datos
		gestionTitulacion = (GestionTitulacion) SuiteTest.ctx.lookup(TITULACION_EJB);
		gestionExpediente = (GestionExpediente) SuiteTest.ctx.lookup(EXPEDIENTE_EJB);
		gestionAlumno = (GestionAlumno) SuiteTest.ctx.lookup(ALUMNO_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF-8"})
	@Test
	public void testInsertarExpediente() {
		Expediente exp = new Expediente();
			try {
				Titulacion tituEntity = gestionTitulacion.devolverTitulacion(1234);
				Alumno alumnoEntity = gestionAlumno.devolverAlumno("090");
				exp = new Expediente(1, tituEntity, alumnoEntity);
				gestionExpediente.insertarExpediente(1, exp);
			} catch (ExpedienteExistenteException e) {
				fail("El expediente ya existe");
			}catch (SanekaException e) {
			
		}
		
		Expediente expEntity = new Expediente();
		try {
			expEntity = gestionExpediente.devolverExpediente(1);
		} catch (SanekaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(expEntity.hashCode(), exp.hashCode());
	}
	
	@Requisitos({"RF-8"})
	@Test
	public void testInsertarExpedienteExistente() {
		
			try {
				Titulacion tituEntity = gestionTitulacion.devolverTitulacion(1234);
				Alumno alumnoEntity = gestionAlumno.devolverAlumno("090");
				Expediente exp = new Expediente(12345, tituEntity, alumnoEntity);
				gestionExpediente.insertarExpediente(12345, exp);
				fail("Deberia dar error porque ya existe");
			} catch (ExpedienteExistenteException e) {
				//OK
			}catch (SanekaException e) {
				//OK
		}
	}
	
	@Requisitos({"RF-8"})
	@Test
	public void testEliminarExpediente() {
		Expediente exp = new Expediente();
		try {
			Titulacion tituEntity = gestionTitulacion.devolverTitulacion(1234);
			Alumno alumnoEntity = gestionAlumno.devolverAlumno("090");
			exp = new Expediente(5, tituEntity, alumnoEntity);
			gestionExpediente.insertarExpediente(5, exp);
			gestionExpediente.eliminarExpediente(5);
		} catch (ExpedienteNoEncontradoException e) {
			fail("No encontr?? el expediente");
		}catch (SanekaException e) {
			throw new RuntimeException(e);
		}
		try {
			gestionExpediente.devolverExpediente(12345);
		}catch(ExpedienteNoEncontradoException e) {
			//OK
		}catch (SanekaException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Requisitos({"RF-8"})
	@Test
	public void testEliminarExpedienteNoEncontrado() {
		try {
			gestionExpediente.eliminarExpediente(12346);
			fail("No deber??a existir el expediente");
		} catch (ExpedienteNoEncontradoException e) {
			//OK
		}catch (SanekaException e) {
			fail("No deber??a existir el expediente");
		}
	}
	
	@Requisitos({"RF-2"})
	@Test
	public void testModificarExpediente() {
		Expediente exp = new Expediente();
			try {
				Titulacion tituEntity = gestionTitulacion.devolverTitulacion(1234);
				Alumno alumnoEntity = gestionAlumno.devolverAlumno("090");
				exp = new Expediente(12345, tituEntity, alumnoEntity);
				exp.setActivo(false);
				gestionExpediente.modificarExpediente(12345, exp);
			} catch (ExpedienteNoEncontradoException e) {
				fail("Expediente no encontrado");
			} catch (SanekaException e) {
			
		}
			Expediente expEntity = new Expediente();
			try {
				expEntity = gestionExpediente.devolverExpediente(12345);
			} catch (SanekaException e) {
				e.printStackTrace();
			}
			assertEquals(expEntity.getActivo(), exp.getActivo());
			assertEquals(expEntity.getNotaMediaProvisional(), exp.getNotaMediaProvisional());
	}
	
	@Requisitos({"RF-2"})
	@Test
	public void testModificarExpedienteNoEncontrado() {
		
			try {
				Titulacion tituEntity = gestionTitulacion.devolverTitulacion(1234);
				Alumno alumnoEntity = gestionAlumno.devolverAlumno("090");
				Expediente exp = new Expediente(12345, tituEntity, alumnoEntity);
				gestionExpediente.modificarExpediente(1, exp);
				fail("Deberia dar error porque no lo encuentra");
			} catch (ExpedienteNoEncontradoException e) {
				//OK
			}catch (SanekaException e) {
				fail("Deberia dar error porque no lo encuentra");
		}
	}
	
	@Requisitos({"RF-3"})
	@Test
	public void testDevolverExpediente() {
		
			try {
				Titulacion tituEntity = gestionTitulacion.devolverTitulacion(1234);
				Alumno alumnoEntity = gestionAlumno.devolverAlumno("090");
				Expediente exp = new Expediente(1, tituEntity, alumnoEntity);
				Expediente expEntity = gestionExpediente.devolverExpediente(1);
				assertEquals(expEntity.hashCode(), exp.hashCode());
			} catch (ExpedienteNoEncontradoException e) {
				fail("El expediente no se ha encontrado");
			}catch (SanekaException e) {
			throw new RuntimeException(e);
		}
			
	}
	
	@Requisitos({"RF-3"})
	@Test
	public void testDevolverExpedienteNoEncontrado() {
		
			try {
				Titulacion tituEntity = gestionTitulacion.devolverTitulacion(1234);
				Alumno alumnoEntity = gestionAlumno.devolverAlumno("090");
				Expediente exp = new Expediente(6, tituEntity, alumnoEntity);
				Expediente expEntity = gestionExpediente.devolverExpediente(6);
				fail("El expediente no deberia estar");
			} catch (ExpedienteNoEncontradoException e) {
				//OK
			}catch (SanekaException e) {
				//OK
		}
	}
	
	@Requisitos({"RF-3"})
	@Test
	public void testMostrarExpediente() {
		
		try {
			String expCadena = gestionExpediente.mostrarExpediente(12345);
			Expediente expEntity = gestionExpediente.devolverExpediente(12345);
			assertEquals(expEntity.toString(), expCadena);
		} catch (ExpedienteNoEncontradoException e) {
			fail("No encuentra el expediente");
		}catch (SanekaException e) {
			throw new RuntimeException(e);
		}
	}
}
