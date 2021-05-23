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
import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.ejb.saneka.GestionCentro;
import es.uma.informatica.jpa.saneka.Centro;
import es.uma.informatica.jpa.saneka.Titulacion;
import es.uma.informatica.sii.anotaciones.Requisitos;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

public class CentroT {
	private static final Logger LOG = Logger.getLogger(CentroT.class.getCanonicalName());
	private static final String CENTRO_EJB = "java:global/classes/CentroEJB";
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SanekaTest";

	private static Context ctx;
	
	private GestionCentro gestionCentro;
	@Before
	public void setup() throws NamingException  {
		gestionCentro= (GestionCentro) SuiteTest.ctx.lookup(CENTRO_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Requisitos({"RF-8"})
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
	
	@Requisitos({"RF-8"})
	@Test (expected = CentroExistenteException.class)
	public void testInsertarCentroExistente() throws SanekaException {
		final Integer idCentro = 123;
		
		
			Centro centro = gestionCentro.obtenerCentro(idCentro);
			gestionCentro.insertarCentro(centro);
		
			fail("Debe lanzar excepción de centro existente");
		
	}
	
	@Requisitos({"RF-2"})
	@Test 
	public void testModificarCentro() {
		List<Titulacion> titu= new ArrayList<>();
		try {
			Centro centro = new Centro(11,"computadores","Calle Miguel ","0894343",titu);
			centro.setDireccion("direccion");
			centro.setTeleConsejeria("789");
			centro.setNombre("informatica");
			gestionCentro.actualizarCentro(centro);
			assertTrue(gestionCentro.obtenerCentro(123).getNombre() == "informatica");
			assertTrue(gestionCentro.obtenerCentro(123).getDireccion() == "direccion");
			assertTrue(gestionCentro.obtenerCentro(123).getTeleConsejeria() == "789");
		} catch (CentroNoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Requisitos({"RF-2"})
	@Test (expected = CentroNoEncontradoException.class )
	public void testModificarCentroNoEncontrado() throws CentroNoEncontradoException{
		List<Titulacion> titu= new ArrayList<>();
			Centro centro = new Centro(4657,"informatica","Calle Miguel ","789",titu);
			gestionCentro.actualizarCentro(centro);
		
			fail("Debería lanzar excepción de centro no encontrado");
		
		
	}
	
	@Requisitos({"RF-8"})
	@Test
	public void testEliminarCentro() {
			try {
				List<Titulacion> titu= new ArrayList<>();
				Centro centro = new Centro(12,"computadores","Calle Miguel ","0894343",titu);
				gestionCentro.insertarCentro(centro);
				gestionCentro.eliminarCentro(12, centro);
			} catch (CentroNoEncontradoException | CentroExistenteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	@Requisitos({"RF-8"})
	@Test (expected =CentroNoEncontradoException.class)
	public void testEliminarCentroNoEncontrado() throws SanekaException {
		final Integer idCentro = 11;
		Centro centro = gestionCentro.obtenerCentro(idCentro);
		centro.setId(19);
		try {
			gestionCentro.eliminarCentro(11, centro);
			fail("Debería lanzar excepción de centro no encontrado");
		}catch (CentroNoEncontradoException e){
			//OK
		}	
		
	}
}
