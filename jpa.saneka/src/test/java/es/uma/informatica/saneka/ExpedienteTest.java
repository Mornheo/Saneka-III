package es.uma.informatica.saneka;

import static org.junit.Assert.*;

import java.util.Properties;
import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uma.informatica.ejb.exceptions.ExpedienteExistenteException;
import es.uma.informatica.ejb.exceptions.ExpedienteNoEncontradoException;
import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.ejb.saneka.GestionExpediente;
import es.uma.informatica.jpa.saneka.Expediente;

public class ExpedienteTest {

	private static final Logger LOG = Logger.getLogger(ExpedienteTest.class.getCanonicalName());
	
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SanekaTest";
	
	//Path a las entidades que se usaran en los test ~/classes/{MiClaseEJB}
	private static final String EXPEDIENTE_EJB = "java:global/classes/ExpedienteEJB";
	
	private static EJBContainer ejbContainer;
	private static Context ctx;
	
	//Declaramos las entidades a usar en los test
	private GestionExpediente gestionExpediente;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		Properties properties = new Properties();
		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		if (ejbContainer != null) {
			ejbContainer.close();
		}
	}

	@Before
	public void setUp() throws Exception {
		//Inicializamos las clases y la base de datos
		gestionExpediente = (GestionExpediente) ctx.lookup(EXPEDIENTE_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Test
	public void testInsertarExpediente() {
		try {
			Expediente exp = new Expediente(1);
			try {
				gestionExpediente.insertarExpediente(1, exp);
			} catch (ExpedienteExistenteException e) {
				fail("El expediente ya existe");
			}
		}catch (SanekaException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	@Test
	public void testModificarExpediente() {
		
		try {
			Expediente exp = new Expediente(1, true, 5);
			try {
				gestionExpediente.modificarExpediente(1, exp);
			} catch (ExpedienteNoEncontradoException e) {
				fail("Expediente no encontrado");
			}	
		} catch (SanekaException e) {
			throw new RuntimeException(e);
			
		}
	}

}
