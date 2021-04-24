package es.uma.informatica.saneka;

import static org.junit.Assert.*;

import java.util.logging.Logger;


import javax.naming.Context;


import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.ejb.exceptions.OptativaExistenteException;
import es.uma.informatica.ejb.exceptions.OptativaNoEncontradoException;
import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.ejb.saneka.GestionOptativa;
import es.uma.informatica.ejb.saneka.GestionTitulacion;
import es.uma.informatica.jpa.saneka.Optativa;
import es.uma.informatica.jpa.saneka.Titulacion;

public class OptativaT {
	
	private static final Logger LOG = Logger.getLogger(Optativa.class.getCanonicalName());
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SanekaTest";
	
	//Path a las entidades que se usaran en los test ~/classes/{MiClaseEJB}
	private static final String OPTATIVA_EJB = "java:global/classes/OptativaEJB";
	private static final String TITULACION_EJB = "java:global/classes/TitulacionEJB";
	
	private static Context ctx;
	
	//Declaramos las entidades a usar en los test
	private GestionOptativa gestionOptativa;
	
	private GestionTitulacion gestionTitulacion;


	@Before
	public void setUp() throws Exception {
		//Inicializamos las clases y la base de datos
		gestionTitulacion = (GestionTitulacion) SuiteTest.ctx.lookup(TITULACION_EJB);
		gestionOptativa = (GestionOptativa) SuiteTest.ctx.lookup(OPTATIVA_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	public void introducirOptativa() throws SanekaException {
		
		Titulacion titul = gestionTitulacion.devolverTitulacion(1234);
		Integer ref = 11112;
		Optativa op = new Optativa(ref, true, 201, 6, titul);
		
		try {
			gestionOptativa.insertarOptativa(ref, op);
		} catch (OptativaExistenteException aee) {
			fail("Optativa ya existente");
		}	
	}
	
	@Test (expected = OptativaExistenteException.class)
	public void introducirOptativaExistente() throws SanekaException {
		
		Titulacion titul = gestionTitulacion.devolverTitulacion(1234);
		Integer ref = 233;
		Optativa as = new Optativa(ref, true, 201, 6, titul);
		
		gestionOptativa.insertarOptativa(ref, as);
		
		fail("ERROR: la Optativa se introducio correctamente, deberia haber saltado excepcion");
	}
	
	@Test
	public void eliminarOptativa() throws SanekaException {
		
		Titulacion titul = gestionTitulacion.devolverTitulacion(1234);
		Integer ref = 11112;
		Optativa as = new Optativa(ref, true, 201, 6, titul);
		
		try {
			gestionOptativa.insertarOptativa(ref, as);
		} catch (OptativaExistenteException aee) {
			fail("Optativa ya existente");
		}	
		
		try {
			gestionOptativa.eliminarOptativa(ref);
		} catch (OptativaNoEncontradoException aee) {
			fail("Optativa no existe");
		}	
	}
	
	@Test (expected = OptativaNoEncontradoException.class)
	public void eliminarOptativaNoExistente() throws SanekaException {
		
		gestionOptativa.eliminarOptativa(1234);
		
		fail("ERROR: la Optativa se elimino correctamente, deberia haber saltado excepcion");
	}
	
	@Test
	public void modificarOptativa() throws SanekaException{
		
		Integer ref = 233;
		Optativa asig = gestionOptativa.devolverOptativa(ref);
		String duracion = "320";
		asig.setDuracion(duracion);
		
		try {
			gestionOptativa.modificarOptativa(ref, asig);
		} catch (OptativaNoEncontradoException aee){
			fail("Optativa no encontrada");
		}
		
		assertEquals(gestionOptativa.devolverOptativa(ref).getDuracion(), duracion);
		
	}
	
	@Test (expected = OptativaNoEncontradoException.class)
	public void modificarOptativaNoExistente() throws SanekaException{
		
		Integer ref = 1235;
		Optativa asig = gestionOptativa.devolverOptativa(ref);
		String duracion = "320";
		asig.setDuracion(duracion);
		
			gestionOptativa.modificarOptativa(ref, asig);
			
			fail("ERROR: la Optativa se modifico correctamente, deberia haber saltado excepcion");
	}
	
	@Test
	public void mostrarOptativa() throws SanekaException{
		
		Integer ref = 233;
		Titulacion titu = gestionTitulacion.devolverTitulacion(1234);
		
		Optativa asig = new Optativa(233, true, 102, 6, titu);
	
		
	
		String Optativa = null;
		
		try {
			Optativa = gestionOptativa.mostrarOptativa(ref);
		} catch (OptativaNoEncontradoException aee){
			fail("Optativa no encontrada");
		}
		
		assertEquals(Optativa, asig.toString());
		
	}
	
	@Test (expected = OptativaNoEncontradoException.class)
	public void mostrarOptativaNoExistente() throws SanekaException{
		
		Integer ref = 1235;
		
		gestionOptativa.mostrarOptativa(ref);
		
	}
	
	@Test
	public void devolverOptativa() throws SanekaException{
		
		Integer ref = 233;
		Titulacion titu = gestionTitulacion.devolverTitulacion(1234);
		
		Optativa asig = new Optativa(233, true, 102, 6, titu);
		
		Optativa as = gestionOptativa.devolverOptativa(ref);
		
		assertEquals(asig, as);
		
	}
	
	@Test (expected = OptativaNoEncontradoException.class)
	public void devolverOptativaNoExistente() throws SanekaException{
		
		Integer ref = 1235;
		
		Optativa as = gestionOptativa.devolverOptativa(ref);
		
	}
	
}