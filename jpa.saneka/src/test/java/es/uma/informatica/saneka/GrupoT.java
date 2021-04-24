package es.uma.informatica.saneka;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.*;

import es.uma.informatica.ejb.exceptions.GrupoExistenteException;
import es.uma.informatica.ejb.exceptions.GrupoNoEncontradoException;
import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.ejb.exceptions.TitulacionNoEncontradoException;
import es.uma.informatica.ejb.exceptions.TitulacionNoExistenteException;
import es.uma.informatica.ejb.saneka.GestionGrupo;
import es.uma.informatica.ejb.saneka.GestionTitulacion;
import es.uma.informatica.jpa.saneka.Grupo;
import es.uma.informatica.jpa.saneka.Titulacion;



public class GrupoT {
	private static final String GRUPO_EJB = "java:global/classes/GrupoEJB";
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String TITULACION_EJB = "java:global/classes/TitulacionEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SanekaTest";
	public static EJBContainer ejbContainer;
	public static Context ctx;
	private GestionGrupo gestionGrupo;
	private GestionTitulacion gestionTitulacion;
	
	
	
	@BeforeClass
	public static void setUpClass() {
		Properties properties = new Properties();
		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}
	@Before
	public void setup() throws NamingException  {
		gestionGrupo = (GestionGrupo) ctx.lookup(GRUPO_EJB);
		gestionTitulacion = (GestionTitulacion) ctx.lookup(TITULACION_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Test
	public void testInsertarGrupo() throws SanekaException{
		final Integer idTitu = 1234;
		Titulacion titu;
			titu = gestionTitulacion.obtenerTitulacion(idTitu);
			Grupo grupo = new Grupo(27,3, "B", "tarde", false,titu);
			gestionGrupo.insertarGrupo(idTitu, grupo);
		
			
			
			/*
		
		try {
			List<Grupo> grupos = gestionGrupo.obtenerGruposDeTitulacion(idTitu);
			assertEquals(2,grupos.size());
			assertEquals(new Integer(1234),grupos.get(1).getID());
			assertEquals(new Integer(3),grupos.get(1).getCurso());
			assertEquals("B",grupos.get(1).getLetra());
			assertEquals("tarde",grupos.get(1).getTurno());
			assertEquals(false,grupos.get(1).getIngles());
		} catch (TitulacionNoEncontradoException e) {
			fail("No debería lanzar excepción");
			e.printStackTrace();
		}
		*/
	}
	/*
	@Test
	public void testInsertarGrupoTitulacionNoEncontrado() throws TitulacionNoEncontradoException, GrupoExistenteException {
		final Integer idTitu = 1234;
		final Integer otroTitu = 98;
		Titulacion titu = new Titulacion();
			try {
				titu =gestionTitulacion.obtenerTitulacion(idTitu);
			} catch (TitulacionNoExistenteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				Grupo grupo = new Grupo(12,3, "B", "tarde", false,titu);
				gestionGrupo.insertarGrupo(otroTitu, grupo);
				fail("Debe lanzar excepción");
	}
	@Test
	public void testInsertarGrupoExistente() {
		final Integer idTitu = 1234;
		try {
			List<Grupo> grupos = gestionGrupo.obtenerGruposDeTitulacion(idTitu);
			gestionGrupo.insertarGrupo(idTitu, grupos.get(0));
			fail("Debe lanzar excepción de grupo existente");
		} catch (TitulacionNoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GrupoExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testObtenerGrupos() throws TitulacionNoExistenteException, GrupoExistenteException {
		try {
			final Integer idTitu = 1234;
			Titulacion titu = gestionTitulacion.obtenerTitulacion(idTitu);
			Grupo grupo = new Grupo(1,3, "B", "tarde", false,titu);
			gestionGrupo.insertarGrupo(1234, grupo);
			List<Grupo> grupos = gestionGrupo.obtenerGruposDeTitulacion(1234);
			assertEquals(1, grupos.size());
		} catch (TitulacionNoEncontradoException e) {
			fail("No debería lanzar excepción");
		}
	}
	@Test 
	public void testObtenerGruposTitulacionNoEncontrado() {
		try {
			List<Grupo> grupos = gestionGrupo.obtenerGruposDeTitulacion(1);
			fail("Debería lanzar excepción de Titulacion no encontrado");
		} catch (TitulacionNoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testModificarGrupo() throws GrupoExistenteException, TitulacionNoExistenteException {
		final Integer idTitu = 1234;
		final Integer ncurso =4;
		final String nletra = "B";
		final String nturno = "manyna";
		final Boolean ningle = true;
		Integer id = null;
		try {
			Titulacion titu = gestionTitulacion.obtenerTitulacion(idTitu);
			Grupo grupo = new Grupo(11,3, "B", "tarde", false,titu);
			gestionGrupo.insertarGrupo(idTitu, grupo);
			List<Grupo> grupos = gestionGrupo.obtenerGruposDeTitulacion(idTitu);
			Grupo grupo1 = grupos.get(0);
			id = grupo1.getID();
			grupo1.setCurso(ncurso); grupo.setTurno(nturno);
			grupo1.setLetra(nletra); grupo.setIngles(ningle);
			gestionGrupo.actualizarGrupo(idTitu, grupo1);
		} catch (TitulacionNoEncontradoException | GrupoNoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			final Integer idAct = id;
			Grupo grupoAct  = gestionGrupo.obtenerGrupo(idAct);
			assertEquals(ncurso,grupoAct.getCurso());
			assertEquals(nletra,grupoAct.getLetra());
			assertEquals(nturno,grupoAct.getTurno());
			assertEquals(ningle,grupoAct.getIngles());
			
		} catch (GrupoNoEncontradoException e) {
			fail("No debería lanzar excepción");
		}
		
	}
	@Test
	public void ActualizarGrupoTitulacionNoEncontrado(){
		final Integer idTitu = 1234;
		final Integer otroTitu = 98;
		final Integer ncurso =4;
		final String nletra = "B";
		final String nturno = "manyna";
		final Boolean ningle = true;
		
		
		try {
			List<Grupo> grupos = gestionGrupo.obtenerGruposDeTitulacion(idTitu);
			Grupo grupo = grupos.get(0);
			grupo.setCurso(ncurso); grupo.setTurno(nturno);
			grupo.setLetra(nletra); grupo.setIngles(ningle);
			gestionGrupo.actualizarGrupo(otroTitu, grupo);
			fail("Debería lanzar excepción de titulaicon no encontrado");
		} catch (TitulacionNoEncontradoException | GrupoNoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void testActualizarGrupoNoEncontrado() {
		final Integer idTitu = 1234;
		final Integer nId= 2;
		try {
			List<Grupo> grupos = gestionGrupo.obtenerGruposDeTitulacion(idTitu);
			Grupo grupo = grupos.get(0);
			grupo.setID(nId);
			gestionGrupo.actualizarGrupo(idTitu, grupo);
			fail("Debería lanzar excepción de grupo no encontrado");
		} catch (TitulacionNoEncontradoException | GrupoNoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testEliminarGrupo() throws TitulacionNoExistenteException {
		final Integer idTitu = 1234;
		List<Grupo> grupos;
		try {
			Titulacion titu = gestionTitulacion.obtenerTitulacion(idTitu);
			Grupo grupo = new Grupo(11,3, "B", "tarde", false,titu);
			Grupo gru = new Grupo(111,3, "A", "tarde", false,titu);
			gestionGrupo.insertarGrupo(idTitu, grupo);
			gestionGrupo.insertarGrupo(idTitu, gru);
			grupos = gestionGrupo.obtenerGruposDeTitulacion(idTitu);
			Grupo grupo1 = grupos.get(0);
			gestionGrupo.eliminarGrupo(idTitu, grupo1);
			assertEquals(1,grupos.size());
		} catch (TitulacionNoEncontradoException | GrupoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
		
	}
	@Test
	public void testEliminarGrupoTitulacionNoEncontrado() {
		final Integer idTitu = 1234;
		final Integer otroTitu = 98;
		List<Grupo> grupos;
		try {
			grupos = gestionGrupo.obtenerGruposDeTitulacion(idTitu);
			Grupo grupo = grupos.get(0);
			gestionGrupo.eliminarGrupo(otroTitu, grupo);
			fail("Debería lanzar la excepción de titulacion no encontrado");
		} catch (TitulacionNoEncontradoException | GrupoExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testEliminarGrupoNoEncontrado() {
		final Integer idTitu = 1234;
		final Integer nId= 2;
		
			
			try {
				List<Grupo> grupos = gestionGrupo.obtenerGruposDeTitulacion(idTitu);
				Grupo grupo = grupos.get(0);
				grupo.setID(nId);
				gestionGrupo.eliminarGrupo(idTitu, grupo);
				fail("Debería lanzar la excepción de grupo no encontrado");
			} catch (TitulacionNoEncontradoException | GrupoExistenteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	@Test
	public void testEliminarTodosGrupos() {
		final Integer idTitu = 1234;
		try {
			gestionGrupo.eliminarTodosGrupos(idTitu);
			List<Grupo> grupos = gestionGrupo.obtenerGruposDeTitulacion(idTitu);
			assertEquals(0,grupos.size());
		} catch (TitulacionNoEncontradoException e) {
			fail("No debería lanzarse excepción");
		}	
	}
	@Test
	public void testEliminarTodosGruposTitulacionNoEncontrado() {
		final Integer otroTitu = 98;
		try {
			gestionGrupo.eliminarTodosGrupos(otroTitu);
			fail("Debería lanzar la excepción de titulacion no encontrado");
		} catch (TitulacionNoEncontradoException e) {

		}
	}
	*/
	@AfterClass
	public static void tearDownClass() {
		if (ejbContainer != null) {
			ejbContainer.close();
		}
	}
	
	
	
}
