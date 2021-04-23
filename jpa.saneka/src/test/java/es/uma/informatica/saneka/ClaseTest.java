package es.uma.informatica.saneka;

import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.Properties;
import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uma.informatica.ejb.exceptions.CentroExistenteException;
import es.uma.informatica.ejb.saneka.GestionCentros;
import es.uma.informatica.ejb.saneka.GestionClases;
import es.uma.informatica.jpa.saneka.Asignatura;
import es.uma.informatica.jpa.saneka.Centro;
import es.uma.informatica.jpa.saneka.Clase;
import es.uma.informatica.jpa.saneka.Grupo;

public class ClaseTest {
	private static final Logger LOG = Logger.getLogger(ClaseTest.class.getCanonicalName());
	private static final String CLASES_EJB = "java:global/classes/ClasesEJB";
	private static final String ASIGNATURAS_EJB = "java:global/classes/AsignaturaEJB";
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SanekaTest";
	
	private static EJBContainer ejbContainer;
	private static Context ctx;
	
	private GestionClases gestionClase;
	private GestionAsignaturas gestionAsignatura;
	
	@BeforeClass
	public static void setUpClass() throws Exception {
		Properties properties = new Properties();
		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}
	@Before
	public void setUp() throws Exception {
		gestionClase = (GestionClases) ctx.lookup(CLASES_EJB);
		gestionAsignatura = (GestionAsignatura) ctx.lookup(ASIGNATURAS_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	@Test
	public void testIntertarClase() {
		Grupo grupo = new Grupo(3,"C","Manana",false);
		Asignatura asig = new Asignatura();
		Clase clase = new Clase(2,Date.valueOf("2021-04-11"),grupo,Date.valueOf("2021-04-12"),asig);
		try {
			gestionClase.insertarClase(asig.getReferencia(), clase);
		}catch(CentroExistenteException e) {
			fail("Lanzó excepción al insertar");
		}		
	}

}
