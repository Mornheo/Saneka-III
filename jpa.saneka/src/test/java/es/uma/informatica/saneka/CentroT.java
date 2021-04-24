package es.uma.informatica.saneka;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;



import java.util.ArrayList;

import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import es.uma.informatica.ejb.exceptions.CentroExistenteException;
import es.uma.informatica.ejb.exceptions.CentroNoEncontradoException;
import es.uma.informatica.ejb.saneka.GestionCentro;
import es.uma.informatica.jpa.saneka.Centro;
import es.uma.informatica.jpa.saneka.Titulacion;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

public class CentroT {
	private static final Logger LOG = Logger.getLogger(CentroT.class.getCanonicalName());
	private static final String CENTRO_EJB = "java:global/classes/CentroEJB";
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "jpa.saneka";

	
	private static EJBContainer ejbContainer;
	private static Context ctx;
	
	private GestionCentro gestionCentro;
	@BeforeClass
	public static void setUpClass() {
		Properties properties = new Properties();
		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}
	@Before
	public void setup() throws NamingException  {
		gestionCentro= (GestionCentro) ctx.lookup(CENTRO_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	public void testInsertarCentro() {
		List<Titulacion> titu= new ArrayList<>();
		
		try {
			Centro centro = new Centro(11,"computadores","Calle Miguel ","0894343",titu);
			gestionCentro.insertarCentro(centro);
		}catch(CentroExistenteException e) {
			fail("No deberia lanzar exception ");
		}
	}
	
	@Test 
	public void testInsertarCentroExistente() {
		final Integer idCentro = 11;
		
		try {
			Centro centro = gestionCentro.obtenerCentro(idCentro);
			gestionCentro.insertarCentro(centro);
			fail("Debe lanzar excepción");
		}catch(CentroExistenteException | CentroNoEncontradoException e) {
			fail("Debe lanzar excepción de centro existente");
		}
	}
	@Test
	public void testModificarCentro() {
		
		try {
			Centro centro = new Centro(123,"informatica","Calle Miguel ","789");
			gestionCentro.actualizarCentro(centro);
			assertTrue(gestionCentro.obtenerCentro(123).getNombre() == "informatica");
			assertTrue(gestionCentro.obtenerCentro(123).getDireccion() == "Calle Miguel ");
			assertTrue(gestionCentro.obtenerCentro(123).getTLF_consejeria() == "789");
		} catch (CentroNoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void testModificarCentroNoEncontrado(){
		
		try {
			Centro centro = new Centro(4657,"informatica","Calle Miguel ","789");
			gestionCentro.actualizarCentro(centro);
		} catch (CentroNoEncontradoException e) {
			fail("Debería lanzar excepción de centro no encontrado");
		}
		
	}
	
	@Test
	public void testEliminarCentro() {
		
		try {
			Centro centro = new Centro(123,"informatica","avenida de andalucia n 11 ","0894343");
			gestionCentro.eliminarCentro(centro);
			
		} catch (CentroNoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void testEliminarCentroNoEncontrado() {
		try {
			Centro centro = new Centro(1234,"informatica","avenida de andalucia n 11 ","0894343");
			
			gestionCentro.eliminarCentro(centro);
		} catch (CentroNoEncontradoException e) {
			fail("Debería lanzar excepción de centro no encontrado");
		}
		
	}
	
	@AfterClass
	public static void tearDownClass() {
		if (ejbContainer != null) {
			ejbContainer.close();
		}
	}
	
}
