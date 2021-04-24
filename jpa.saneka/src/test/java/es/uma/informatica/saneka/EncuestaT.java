package es.uma.informatica.saneka;

import static org.junit.Assert.*;


import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.ejb.exceptions.EncuestaExistenteException;
import es.uma.informatica.ejb.exceptions.EncuestaNoEncontradoException;
import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.ejb.saneka.GestionEncuesta;
import es.uma.informatica.ejb.saneka.GestionExpediente;
import es.uma.informatica.jpa.saneka.Encuesta;
import es.uma.informatica.jpa.saneka.Expediente;

public class EncuestaT {
	
private static final Logger LOG = Logger.getLogger(ExpedienteT.class.getCanonicalName());
	
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SanekaTest";
	
	//Path a las entidades que se usaran en los test ~/classes/{MiClaseEJB}
	private static final String EXPEDIENTE_EJB = "java:global/classes/ExpedienteEJB";
	private static final String ENCUESTA_EJB = "java:global/classes/EncuestaEJB";
	
	//Declaramos las entidades a usar en los test
	private GestionExpediente gestionExpediente;
	private GestionEncuesta gestionEncuesta;

	@Before
	public void setUp() throws Exception {
		//Inicializamos las clases y la base de datos
		gestionEncuesta = (GestionEncuesta) SuiteTest.ctx.lookup(ENCUESTA_EJB);
		gestionExpediente = (GestionExpediente) SuiteTest.ctx.lookup(EXPEDIENTE_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Test
	public void testInsertarEncuesta() {
		Expediente expEntity = gestionExpediente.devolverExpediente(12345);	
		Encuesta enc = new Encuesta("12/12/2020", expEntity);
		try {
			gestionEncuesta.insertarEncuesta("12/12/2020", enc);
		} catch (EncuestaExistenteException e) {
			fail("La encuesta ya existe");
		} catch (SanekaException e1) {
			throw new RuntimeException(e1);
		}
		Encuesta encEntity = gestionEncuesta.devolverEncuesta("12/12/2020");
		assertEquals(expEntity.hashCode(), enc.hashCode());
	}
	
	@Test
	public void testInsertarEncuestaExistente() {
		Expediente expEntity = gestionExpediente.devolverExpediente(12345);	
		Encuesta enc = new Encuesta("23/04/2021", expEntity);
		try {
			gestionEncuesta.insertarEncuesta("23/04/2021", enc);
			fail("Deberia encontrarla");
		} catch (EncuestaExistenteException e) {
			//OK
		} catch (SanekaException e) {
			fail("Deberia encontrarla");
		}
	}
	
	@Test
	public void testEliminarEncuesta() {
		try {
			gestionEncuesta.eliminarEncuesta("23/04/2021");
		} catch (EncuestaNoEncontradoException e) {
			fail("No encontró la encuesta");
		}catch (SanekaException e) {
			throw new RuntimeException(e);
		}
		try {
			gestionEncuesta.devolverEncuesta("23/04/2021");
		}catch(EncuestaNoEncontradoException e) {
			//OK
		}catch (SanekaException e1) {
			throw new RuntimeException(e1);
		}
	}
	
	@Test
	public void testEliminarEncuestaNoEncontrada() {
		try {
			gestionEncuesta.eliminarEncuesta("12/12/2020");
			fail("No debería existir la encuesta");
		} catch (EncuestaNoEncontradoException e) {
			//OK
		}catch (SanekaException e) {
			fail("No debería existir la encuesta");
		}
	}
	@Test
	public void testMostrarEncuesta() {
		
		try {
			String encCadena = gestionEncuesta.mostrarEncuesta("23/04/2021");
			Encuesta encEntity = gestionEncuesta.devolverEncuesta("23/04/2021");
			assertEquals(encEntity.toString(), encCadena);
		} catch (EncuestaNoEncontradoException e) {
			fail("No encuentra la encuesta");
		}catch (SanekaException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void testDevolverEncuesta() {
		Expediente expEntity = gestionExpediente.devolverExpediente(12345);	
		Encuesta enc = new Encuesta("23/04/2021", expEntity);
			try {
				Encuesta encEntity = gestionEncuesta.devolverEncuesta("23/04/2021");
				assertEquals(encEntity.hashCode(), enc.hashCode());
			} catch (EncuestaNoEncontradoException e) {
				fail("La encuesta no se ha encontrado");
			}catch (SanekaException e1) {
			throw new RuntimeException(e1);
		}
	}
	@Test
	public void testDevolverEncuestaNoEncontrada() {
		Expediente expEntity = gestionExpediente.devolverExpediente(12345);	
		Encuesta enc = new Encuesta("12/12/2020", expEntity);
			try {
				Encuesta encEntity = gestionEncuesta.devolverEncuesta("23/04/2021");
				fail("La encuesta no deberia estar");
			} catch (EncuestaNoEncontradoException e) {
				
			}catch (SanekaException e1) {
				fail("La encuesta no deberia estar");
		}
	}

}
