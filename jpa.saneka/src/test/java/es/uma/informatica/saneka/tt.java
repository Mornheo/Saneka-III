package es.uma.informatica.saneka;

import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.ejb.saneka.GestionAsignatura;
import es.uma.informatica.jpa.saneka.Asignatura;

public class tt {
	
private static final Logger LOG = Logger.getLogger(Asignatura.class.getCanonicalName());
	
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SanekaTest";
	
	//Path a las entidades que se usaran en los test ~/classes/{MiClaseEJB}
	private static final String ASIGNATURA_EJB = "java:global/classes/AsignaturaEJB";
	
	private static Context ctx;
	
	@Before
	public void setUp() throws Exception {
		//Inicializamos las clases y la base de datos
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Test
	public void introducirAsignatura() throws SanekaException {
		
	}
	
}
