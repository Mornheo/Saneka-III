package es.uma.informatica.saneka;

import static org.junit.Assert.fail;

import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.ejb.exceptions.CentroExistenteException;
import es.uma.informatica.ejb.saneka.GestionCentros;
import es.uma.informatica.jpa.saneka.Centro;



public class CentroT {
	private static final Logger LOG = Logger.getLogger(CentroT.class.getCanonicalName());
	private static final String CENTRO_EJB = "java:global/classes/CentroEJB";
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SanekaTest";

	
	private GestionCentros gestionCentro;
	
	@Before
	public void setUp() throws Exception {
		//Inicializamos las clases y la base de datos
		gestionCentro = (GestionCentros) SuiteTest.ctx.lookup(CENTRO_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	public void testIntertarCentro() {
		//List<Titulacion> titulaciones = new ArrayList<>();
		Centro centro = new Centro(123,"informatica","avenida de andalucia nº 11 ","0894343");
		try {
			gestionCentro.insertarCentro(centro);
		}catch(CentroExistenteException e) {
			fail("Centro ya existe");
		}
	}

}
