package es.uma.informatica.saneka;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


import javax.naming.Context;


import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.ejb.exceptions.TitulacionExistenteException;
import es.uma.informatica.ejb.exceptions.TitulacionNoEncontradoException;
import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.ejb.saneka.GestionTitulacion;
import es.uma.informatica.jpa.saneka.Centro;
import es.uma.informatica.jpa.saneka.Titulacion;
import es.uma.informatica.sii.anotaciones.Requisitos;

public class TitulacionT {
	
	private static final Logger LOG = Logger.getLogger(Titulacion.class.getCanonicalName());
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SanekaTest";
	
	//Path a las entidades que se usaran en los test ~/classes/{MiClaseEJB}
	private static final String Titulacion_EJB = "java:global/classes/TitulacionEJB";
	private static final String TITULACION_EJB = "java:global/classes/TitulacionEJB";
	
	private static Context ctx;
	
	//Declaramos las entidades a usar en los test
	private GestionTitulacion gestionTitulacion;



	@Before
	public void setUp() throws Exception {
		//Inicializamos las clases y la base de datos
		gestionTitulacion = (GestionTitulacion) SuiteTest.ctx.lookup(TITULACION_EJB);
		gestionTitulacion = (GestionTitulacion) SuiteTest.ctx.lookup(Titulacion_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Requisitos({"RF-8"})
	@Test
	public void introducirTitulacion() throws SanekaException {
		
		List<Titulacion> titulaciones = new ArrayList<>();
		Centro centro = new Centro(123, "informatica", "avenida de andalucia n11","23446",titulaciones);
		
		List<Centro> centros = new ArrayList<Centro>();
		centros.add(centro);
		
		Integer ref = 11113;
		Titulacion titul = new Titulacion(ref, "test", 6, centros);
		
		try {
			gestionTitulacion.insertarTitulacion(ref, titul);
		} catch (TitulacionExistenteException aee) {
			fail("Titulacion ya existente");
		}	
	}
	
	@Requisitos({"RF-8"})
	@Test (expected = TitulacionExistenteException.class)
	public void introducirTitulacionExistente() throws SanekaException {
		
		List<Titulacion> titulaciones = new ArrayList<>();
		Centro centro = new Centro(123, "informatica", "avenida de andalucia n11","23446",titulaciones);
		
		List<Centro> centros = new ArrayList<Centro>();
		centros.add(centro);
		
		Integer ref = 1234;
		Titulacion titul = new Titulacion(ref, "test", 6, centros);
		
		gestionTitulacion.insertarTitulacion(ref, titul);
		
		fail("ERROR: la Titulacion se introducio correctamente, deberia haber saltado excepcion");
	}
	
	@Requisitos({"RF-8"})
	@Test
	public void eliminarTitulacion() throws SanekaException {
		
		List<Titulacion> titulaciones = new ArrayList<>();
		Centro centro = new Centro(123, "informatica", "avenida de andalucia n11","23446",titulaciones);
		
		List<Centro> centros = new ArrayList<Centro>();
		centros.add(centro);
		
		Integer ref = 11113;
		Titulacion titul = new Titulacion(ref, "infor", 6, centros);
		
		try {
			gestionTitulacion.insertarTitulacion(ref, titul);
		} catch (TitulacionExistenteException aee) {
			fail("Titulacion ya existente");
		}	
		
		try {
			gestionTitulacion.eliminarTitulacion(ref);
		} catch (TitulacionNoEncontradoException aee) {
			fail("Titulacion no existe");
		}	
	}
	
	@Requisitos({"RF-8"})
	@Test (expected = TitulacionNoEncontradoException.class)
	public void eliminarTitulacionNoExistente() throws SanekaException {
		
		gestionTitulacion.eliminarTitulacion(1237);
		
		fail("ERROR: la Titulacion se elimino correctamente, deberia haber saltado excepcion");
	}
	
	@Requisitos({"RF-2"})
	@Test
	public void modificarTitulacion() throws SanekaException{
		
		List<Titulacion> titulaciones = new ArrayList<>();
		Centro centro = new Centro(123, "informatica", "avenida de andalucia n11","23446",titulaciones);
		
		List<Centro> centros = new ArrayList<Centro>();
		centros.add(centro);
		
		Integer ref = 1234;
		Titulacion titul = gestionTitulacion.devolverTitulacion(ref);
		Integer creditos = 70;
		titul.setCreditos(creditos);
		
		try {
			gestionTitulacion.modificarTitulacion(ref, titul);
		} catch (TitulacionNoEncontradoException aee){
			fail("Titulacion no encontrada");
		}
		
		assertEquals(gestionTitulacion.devolverTitulacion(ref).getCreditos(), creditos);
		
	}
	
	@Requisitos({"RF-2"})
	@Test (expected = TitulacionNoEncontradoException.class)
	public void modificarTitulacionNoExistente() throws SanekaException{
		
		Integer ref = 1236;
		Titulacion titul = gestionTitulacion.devolverTitulacion(ref);
		Integer creditos = 70;
		titul.setCreditos(creditos);
		
			gestionTitulacion.modificarTitulacion(ref, titul);
			
			fail("ERROR: la Titulacion se modifico correctamente, deberia haber saltado excepcion");
	}
	
	@Requisitos({"RF-2"})
	@Test
	public void mostrarTitulacion() throws SanekaException{
		
		List<Titulacion> titulaciones = new ArrayList<>();
		Centro centro = new Centro(123, "informatica", "avenida de andalucia n11","23446",titulaciones);
		
		List<Centro> centros = new ArrayList<Centro>();
		centros.add(centro);
		
		Integer ref = 1234;
		
		Titulacion titul = new Titulacion(1234, "infor", 70, centros);
		
		String Titulacion = null;
		
		try {
			Titulacion = gestionTitulacion.mostrarTitulacion(ref);
		} catch (TitulacionNoEncontradoException aee){
			fail("Titulacion no encontrada");
		}
		
		assertEquals(Titulacion, titul.toString());
		
	}
	
	@Test (expected = TitulacionNoEncontradoException.class)
	public void mostrarTitulacionNoExistente() throws SanekaException{
		
		Integer ref = 1236;
		
		gestionTitulacion.mostrarTitulacion(ref);
		
	}
	
	@Requisitos({"RF-3"})
	@Test
	public void devolverTitulacion() throws SanekaException{
		
		List<Titulacion> titulaciones = new ArrayList<>();
		Centro centro = new Centro(123, "informatica", "avenida de andalucia n11","23446",titulaciones);
		
		List<Centro> centros = new ArrayList<Centro>();
		centros.add(centro);
		
		Integer ref = 1234;
		
		Titulacion titul = new Titulacion(1234, "infor", 6, centros);
		
		Titulacion as = gestionTitulacion.devolverTitulacion(ref);
		
		assertEquals(titul, as);
		
	}
	
	@Requisitos({"RF-3"})
	@Test (expected = TitulacionNoEncontradoException.class)
	public void devolverTitulacionNoExistente() throws SanekaException{
		
		Integer ref = 1236;
		
		Titulacion as = gestionTitulacion.devolverTitulacion(ref);
		
	}
	
}
