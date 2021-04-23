package es.uma.informatica.saneka;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uma.informatica.ejb.exceptions.CentroExistenteException;
import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.ejb.saneka.GestionCentros;
import es.uma.informatica.jpa.saneka.Centro;
import es.uma.informatica.jpa.saneka.Titulacion;


public class CentroTest {
	private static final Logger LOG = Logger.getLogger(CentroTest.class.getCanonicalName());
	private static final String CENTRO_EJB = "java:global/classes/CentroEJB";
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SanekaTest";
	
	private static EJBContainer ejbContainer;
	private static Context ctx;
	
	private GestionCentros gestionCentro;
	@BeforeClass
	public static void setUpClass() throws Exception {
		Properties properties = new Properties();
		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}

	@Before
	public void setUp() throws Exception {
		gestionCentro = (GestionCentros) ctx.lookup(CENTRO_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	public void test() {
		
	public void testIntertarCentro() {
		//List<Titulacion> titulaciones = new ArrayList<>();
		Centro centro = new Centro(123,"informatica","avenida de andalucia nº 11 ","0894343");
		try {
			gestionCentro.insertarCentro(centro);
		}catch(CentroExistenteException e) {
			fail("Lanzó excepción al insertar");
		}		
	}

}
