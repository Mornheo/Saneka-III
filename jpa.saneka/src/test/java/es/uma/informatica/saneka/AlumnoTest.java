package es.uma.informatica.saneka;

import static org.junit.Assert.*;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uma.informatica.ejb.exceptions.AlumnoNoEncontrado;
import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.ejb.saneka.GestionAlumno;
import es.uma.informatica.jpa.saneka.Alumno;

public class AlumnoTest {
	
	private static final String ALUMNOS_EJB = "java:global/classes/AlumnoEJB";
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SanekaTest";

	private static EJBContainer ejbContainer;
	private static Context ctx;
	
	private GestionAlumno gestionAlumno;
	
	@BeforeClass
	public static void setUpClass() throws Exception {
		Properties properties = new Properties();
		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}

	@AfterClass
	public static void tearDownClass(){
		if (ejbContainer != null) {
			ejbContainer.close();
		}
	}

	@Before
	public void setup() throws NamingException {
		gestionAlumno=(GestionAlumno) ctx.lookup(ALUMNOS_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Test
	public void testInsetar() {
		try {
			Alumno a=new Alumno();
			a.setDNI("100");
			a.setNombre("Pepe");
			a.setApellido1("Aparaicio");
			gestionAlumno.insertarAlumno(a);
			try {
			String dni="100";
			gestionAlumno.mostrarAlumno(dni);
			}catch(AlumnoNoEncontrado e) {
				fail("Alumno no encontrado");
			}
		}catch(SanekaException e){
			throw new RuntimeException(e);
		}
		
	}
	
	public void testEliminar() {
		try {
			String dni="090";
			
		}
	}
	
}
