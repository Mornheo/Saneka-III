package es.uma.informatica.saneka;

import static org.junit.Assert.*;

import java.util.logging.Logger;


import javax.naming.Context;


import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.ejb.exceptions.AsignaturaExistenteException;
import es.uma.informatica.ejb.exceptions.AsignaturaNoEncontradoException;
import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.ejb.saneka.GestionAsignatura;
import es.uma.informatica.ejb.saneka.GestionTitulacion;
import es.uma.informatica.jpa.saneka.Asignatura;
import es.uma.informatica.jpa.saneka.Titulacion;
import es.uma.informatica.sii.anotaciones.Requisitos;

public class AsignaturaT {
	
	private static final Logger LOG = Logger.getLogger(Asignatura.class.getCanonicalName());
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SanekaTest";
	
	//Path a las entidades que se usaran en los test ~/classes/{MiClaseEJB}
	private static final String ASIGNATURA_EJB = "java:global/classes/AsignaturaEJB";
	private static final String TITULACION_EJB = "java:global/classes/TitulacionEJB";
	
	private static Context ctx;
	
	//Declaramos las entidades a usar en los test
	private GestionAsignatura gestionAsignatura;
	
	private GestionTitulacion gestionTitulacion;


	@Before
	public void setUp() throws Exception {
		//Inicializamos las clases y la base de datos
		gestionTitulacion = (GestionTitulacion) SuiteTest.ctx.lookup(TITULACION_EJB);
		gestionAsignatura = (GestionAsignatura) SuiteTest.ctx.lookup(ASIGNATURA_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Requisitos({"RF-8"})
	@Test
	public void introducirAsignatura() throws SanekaException {
		
		Titulacion titul = gestionTitulacion.devolverTitulacion(1234);
		Integer ref = 11111;
		Asignatura as = new Asignatura(ref, true, 201, 6, titul);
		
		try {
			gestionAsignatura.insertarAsignatura(ref, as);
		} catch (AsignaturaExistenteException aee) {
			fail("Asignatura ya existente");
		}	
	}
	
	@Requisitos({"RF-8"})
	@Test (expected = AsignaturaExistenteException.class)
	public void introducirAsignaturaExistente() throws SanekaException {
		
		Titulacion titul = gestionTitulacion.devolverTitulacion(1234);
		Integer ref = 232;
		Asignatura as = new Asignatura(ref, true, 201, 6, titul);
		
		gestionAsignatura.insertarAsignatura(ref, as);
		
		fail("ERROR: la asignatura se introducio correctamente, deberia haber saltado excepcion");
	}
	
	@Requisitos({"RF-8"})
	@Test
	public void eliminarAsignatura() throws SanekaException {
		
		Titulacion titul = gestionTitulacion.devolverTitulacion(1234);
		Integer ref = 11111;
		Asignatura as = new Asignatura(ref, true, 201, 6, titul);
		
		try {
			gestionAsignatura.insertarAsignatura(ref, as);
		} catch (AsignaturaExistenteException aee) {
			fail("Asignatura ya existente");
		}	
		
		try {
			gestionAsignatura.eliminarAsignatura(ref);
		} catch (AsignaturaNoEncontradoException aee) {
			fail("Asignatura no existe");
		}	
	}
	
	@Requisitos({"RF-8"})
	@Test (expected = AsignaturaNoEncontradoException.class)
	public void eliminarAsignaturaNoExistente() throws SanekaException {
		
		gestionAsignatura.eliminarAsignatura(1234);
		
		fail("ERROR: la asignatura se elimino correctamente, deberia haber saltado excepcion");
	}
	
	@Requisitos({"RF-2"})
	@Test
	public void modificarAsignatura() throws SanekaException{
		
		Integer ref = 232;
		Asignatura asig = gestionAsignatura.devolverAsignatura(ref);
		String duracion = "320";
		asig.setDuracion(duracion);
		
		try {
			gestionAsignatura.modificarAsignatura(ref, asig);
		} catch (AsignaturaNoEncontradoException aee){
			fail("Asignatura no encontrada");
		}
		
		assertEquals(gestionAsignatura.devolverAsignatura(ref).getDuracion(), duracion);
		
	}
	
	@Requisitos({"RF-2"})
	@Test (expected = AsignaturaNoEncontradoException.class)
	public void modificarAsignaturaNoExistente() throws SanekaException{
		
		Integer ref = 1234;
		Asignatura asig = gestionAsignatura.devolverAsignatura(ref);
		String duracion = "320";
		asig.setDuracion(duracion);
		
			gestionAsignatura.modificarAsignatura(ref, asig);
			
			fail("ERROR: la asignatura se modifico correctamente, deberia haber saltado excepcion");
	}
	
	@Requisitos({"RF-3"})
	@Test
	public void mostrarAsignatura() throws SanekaException{
		
		Integer ref = 232;
		Titulacion titu = gestionTitulacion.devolverTitulacion(1234);
		
		Asignatura asig = new Asignatura(232, true, 101, 6, titu);
		
		String asignatura = null;
		
		try {
			asignatura = gestionAsignatura.mostrarAsignatura(ref);
		} catch (AsignaturaNoEncontradoException aee){
			fail("Asignatura no encontrada");
		}
		
		assertEquals(asignatura, asig.toString());
		
	}
	
	@Requisitos({"RF-3"})
	@Test (expected = AsignaturaNoEncontradoException.class)
	public void mostrarAsignaturaNoExistente() throws SanekaException{
		
		Integer ref = 1234;
		
		gestionAsignatura.mostrarAsignatura(ref);
		
	}
	
	@Requisitos({"RF-3"})
	@Test
	public void devolverAsignatura() throws SanekaException{
		
		Integer ref = 232;
		Titulacion titu = gestionTitulacion.devolverTitulacion(1234);
		
		Asignatura asig = new Asignatura(232, true, 101, 6, titu);
		
		Asignatura as = gestionAsignatura.devolverAsignatura(ref);
		
		assertEquals(asig, as);
		
	}
	
	@Requisitos({"RF-3"})
	@Test (expected = AsignaturaNoEncontradoException.class)
	public void devolverAsignaturaNoExistente() throws SanekaException{
		
		Integer ref = 1234;
		
		Asignatura as = gestionAsignatura.devolverAsignatura(ref);
		
	}
	
}

