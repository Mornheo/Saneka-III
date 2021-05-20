package es.uma.informatica.saneka;

import static org.junit.Assert.assertEquals;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.*;

import es.uma.informatica.ejb.exceptions.GrupoExistenteException;
import es.uma.informatica.ejb.exceptions.GrupoNoEncontradoException;
import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.ejb.exceptions.TitulacionNoEncontradoException;
import es.uma.informatica.ejb.saneka.GestionGrupo;
import es.uma.informatica.ejb.saneka.GestionTitulacion;
import es.uma.informatica.jpa.saneka.Asignatura;
import es.uma.informatica.jpa.saneka.Grupo;
import es.uma.informatica.jpa.saneka.Titulacion;
import es.uma.informatica.sii.anotaciones.Requisitos;



public class GrupoT {
	private static final Logger LOG = Logger.getLogger(GrupoT.class.getCanonicalName());
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SanekaTest";
	
	private static final String GRUPO_EJB = "java:global/classes/GrupoEJB";
	private static final String TITULACION_EJB = "java:global/classes/TitulacionEJB";

	private static Context ctx;
	
	private GestionGrupo gestionGrupo;
	private GestionTitulacion gestionTitulacion;
	@Before
	public void setup() throws NamingException  {
		gestionGrupo = (GestionGrupo)  SuiteTest.ctx.lookup(GRUPO_EJB);
		gestionTitulacion = (GestionTitulacion)  SuiteTest.ctx.lookup(TITULACION_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF-8"})
	@Test
	public void testInsertarGrupo() {
		final Integer idTitu = 1234;
		
		try {
			Titulacion titu = gestionTitulacion.devolverTitulacion(idTitu);
			Grupo grupo = new Grupo(27,4, "A", "tarde", false,titu);
			gestionGrupo.insertarGrupo(1234, grupo);
		} catch (TitulacionNoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GrupoExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SanekaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Grupo grupos = gestionGrupo.obtenerGrupo(27);
			//assertEquals(1,grupos.size());
		} catch (GrupoNoEncontradoException e) {
			fail("No debería lanzar excepción");
			e.printStackTrace();
		}
		
	}
	
	@Requisitos({"RF-8"})
	@Test
	public void testInsertarGrupoTitulacionNoEncontrado()  {
		final Integer idTitu = 1234;
		final Integer otroTitu = 98;
		Titulacion titu = new Titulacion();
			try {
				titu =gestionTitulacion.devolverTitulacion(idTitu);
				Grupo grupo = new Grupo(12,3, "C", "tarde", false,titu);
				gestionGrupo.insertarGrupo(otroTitu, grupo);
				fail("Debe lanzar excepción");
			} catch (TitulacionNoEncontradoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SanekaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	@Requisitos({"RF-8"})
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
	
	@Requisitos({"RF-3"})
	@Test
	public void testObtenerGrupos() {
		try {
			final Integer otroTitu = 1234;
			Titulacion titu = gestionTitulacion.devolverTitulacion(otroTitu);
			Grupo grupo = new Grupo(456,7, "N", "tarde", false,titu);
			gestionGrupo.insertarGrupo(otroTitu, grupo);
			List<Grupo> grupos = gestionGrupo.obtenerGruposDeTitulacion(otroTitu);
			assertEquals(1, grupos.size());
		} catch (TitulacionNoEncontradoException e) {
			fail("No debería lanzar excepción");
		} catch (SanekaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Requisitos({"RF-3"})
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
	
	@Requisitos({"RF-2"})
	@Test
	public void testModificarGrupo() throws GrupoExistenteException {
		final Integer idTitu = 456;
		final Integer ncurso =9;
		final String nletra = "G";
		final String nturno = "manyna";
		final Boolean ningle = true;
		Integer id = null;
		try {
			List<Grupo> grupos = gestionGrupo.obtenerGruposDeTitulacion(idTitu);
			Grupo grupo1 = grupos.get(0);
			id = grupo1.getID();
			grupo1.setCurso(ncurso); grupo1.setTurno(nturno);
			grupo1.setLetra(nletra); grupo1.setIngles(ningle);
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
	
	@Requisitos({"RF-2"})
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
	
	@Requisitos({"RF-2"})
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
	
	@Requisitos({"RF-8"})
	@Test
	public void testEliminarGrupo()  {
		final Integer idTitu = 1234;
		List<Grupo> grupos;
		try {
			
			
			Titulacion titu = gestionTitulacion.devolverTitulacion(idTitu);
			Grupo grupo = new Grupo(45,5, "L", "tarde", false,titu);
			gestionGrupo.insertarGrupo(idTitu, grupo);
			grupos = gestionGrupo.obtenerGruposDeTitulacion(idTitu);
			Grupo grupo1 = grupos.get(0);
			gestionGrupo.eliminarGrupo(idTitu, grupo1);
			assertEquals(0,grupos.size());
		} catch (TitulacionNoEncontradoException e ) {
			fail("No debería lanzarse excepción");
		} catch (SanekaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Requisitos({"RF-8"})
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
		} catch (TitulacionNoEncontradoException | GrupoNoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Requisitos({"RF-8"})
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
			} catch (TitulacionNoEncontradoException | GrupoNoEncontradoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Requisitos({"RF-8"})
	@Test
	public void testEliminarTodosGruposTitulacionNoEncontrado() {
		final Integer otroTitu = 98;
		try {
			gestionGrupo.eliminarTodosGrupos(otroTitu);
			fail("Debería lanzar la excepción de titulacion no encontrado");
		} catch (TitulacionNoEncontradoException e) {

		}
	}
}
