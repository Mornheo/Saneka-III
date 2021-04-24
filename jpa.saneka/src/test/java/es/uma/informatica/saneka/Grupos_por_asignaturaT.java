package es.uma.informatica.saneka;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.ejb.exceptions.ExpedienteNoEncontradoException;
import es.uma.informatica.ejb.exceptions.GpAExistenteException;
import es.uma.informatica.ejb.exceptions.GpANoEncontradoException;
import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.ejb.saneka.GestionAsignatura;
import es.uma.informatica.ejb.saneka.GestionGrupo;
import es.uma.informatica.ejb.saneka.GestionGrupos_por_asignatura;
import es.uma.informatica.jpa.saneka.Asignatura;
import es.uma.informatica.jpa.saneka.Grupo;
import es.uma.informatica.jpa.saneka.Grupos_por_asignatura;
import es.uma.informatica.jpa.saneka.Grupos_por_asignatura.Grupos_por_asignaturaId;
import es.uma.informatica.sii.anotaciones.Requisitos;

public class Grupos_por_asignaturaT {
private static final Logger LOG = Logger.getLogger(ExpedienteT.class.getCanonicalName());
	
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SanekaTest";
	
	//Path a las entidades que se usaran en los test ~/classes/{MiClaseEJB}
	private static final String GRUPOS_POR_ASIGNATURA_EJB = "java:global/classes/Grupos_por_asignaturaEJB";
	private static final String ASIGNATURA_EJB = "java:global/classes/AsignaturaEJB";
	private static final String GRUPO_EJB = "java:global/classes/GrupoEJB";
	
	//Declaramos las entidades a usar en los test
	private GestionGrupo gestionGrupo;
	private GestionAsignatura gestionAsignatura;
	private GestionGrupos_por_asignatura gestionGpa;

	@Before
	public void setUp() throws Exception {
		//Inicializamos las clases y la base de datos
		gestionGpa = (GestionGrupos_por_asignatura) SuiteTest.ctx.lookup(GRUPOS_POR_ASIGNATURA_EJB);
		gestionAsignatura = (GestionAsignatura) SuiteTest.ctx.lookup(ASIGNATURA_EJB);
		gestionGrupo = (GestionGrupo) SuiteTest.ctx.lookup(GRUPO_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF-8"})
	@Test
	public void testInsertarGrupo_por_asignatura() {
		Grupos_por_asignatura gpa = new Grupos_por_asignatura();
		Grupos_por_asignaturaId id = new Grupos_por_asignaturaId();
			try {
				Asignatura asigEntity = gestionAsignatura.devolverAsignatura(232);
				Grupo grupoEntity = gestionGrupo.obtenerGrupo(3);
				gpa = new Grupos_por_asignatura(1, asigEntity, grupoEntity);
				id = new Grupos_por_asignaturaId(1, asigEntity.getReferencia(), grupoEntity.getID());
				gestionGpa.insertarGpA(id, gpa);
			} catch (GpAExistenteException e) {
				fail("El GpA ya existe");
			}catch (SanekaException e) {
			//OK
		}
		
		Grupos_por_asignatura gpaEntity = new Grupos_por_asignatura();
		try {
			gpaEntity = gestionGpa.devolverGpA(id);
		} catch (SanekaException e) {
			fail("No se inserto");
		}
		assertEquals(gpaEntity.hashCode(), gpa.hashCode());
	}
	
	@Requisitos({"RF-8"})
	@Test
	public void testInsertarGrupo_por_asignaturaExistente() {
		Grupos_por_asignatura gpa = new Grupos_por_asignatura();
		Grupos_por_asignaturaId id = new Grupos_por_asignaturaId();
			try {
				Asignatura asigEntity = gestionAsignatura.devolverAsignatura(232);
				Grupo grupoEntity = gestionGrupo.obtenerGrupo(3);
				gpa = new Grupos_por_asignatura(3, asigEntity, grupoEntity);
				id = new Grupos_por_asignaturaId(3, asigEntity.getReferencia(), grupoEntity.getID());
				gestionGpa.insertarGpA(id, gpa);
				fail("El GpA no deberia poder introducirse");
			} catch (GpAExistenteException e) {
				//OK
			}catch (SanekaException e) {
				fail("El GpA no deberia poder introducirse");
		}
	}
	
	@Requisitos({"RF-8"})
	@Test
	public void testEliminarGrupo_por_asignatura() {
		Grupos_por_asignaturaId id = new Grupos_por_asignaturaId();
		try {
			id = new Grupos_por_asignaturaId(3, 232, 420);
			gestionGpa.eliminarGpA(id);
		} catch (GpANoEncontradoException e) {
			fail("No encontró el GpA");
		}catch (SanekaException e) {
			//OK
		}
		try {
			gestionGpa.devolverGpA(id);
		}catch(GpANoEncontradoException e) {
			//OK
		}catch (SanekaException e) {
			//OK
		}
	}
	
	@Requisitos({"RF-8"})
	@Test
	public void testEliminarGrupo_por_asignaturaNoEncontrado() {
		try {
			Grupos_por_asignaturaId id = new Grupos_por_asignaturaId();
			gestionGpa.eliminarGpA(id);
			fail("No debería existir el GpA");
		} catch (GpANoEncontradoException e) {
			//OK
		}catch (SanekaException e) {
			fail("No debería existir el GpA");
		}
	}
	
	@Requisitos({"RF-2"})
	@Test
	public void testModificarGrupo_por_asignatura() {
		Grupos_por_asignatura gpa = new Grupos_por_asignatura();
		Grupos_por_asignaturaId id = new Grupos_por_asignaturaId();
		try {
			Asignatura asigEntity = gestionAsignatura.devolverAsignatura(232);
			Grupo grupoEntity = gestionGrupo.obtenerGrupo(3);
			gpa = new Grupos_por_asignatura(3, asigEntity, grupoEntity);
			id = new Grupos_por_asignaturaId(3, asigEntity.getReferencia(), grupoEntity.getID());
			gestionGpa.modificarGpA(id, gpa);
		} catch (GpANoEncontradoException e) {
			fail("GpA no encontrado");
		} catch (SanekaException e) {
		//OK
	}
		Grupos_por_asignatura gpaEntity = new Grupos_por_asignatura();
		try {
			gpaEntity = gestionGpa.devolverGpA(id);
		} catch (SanekaException e) {
			e.printStackTrace();
		}
		assertEquals(gpaEntity.getOferta(), gpa.getOferta());
	}
	
	@Requisitos({"RF-2"})
	@Test
	public void testModificarGrupo_por_asignaturaNoEncontrado() {
		Grupos_por_asignatura gpa = new Grupos_por_asignatura();
		Grupos_por_asignaturaId id = new Grupos_por_asignaturaId();
		try {
			Asignatura asigEntity = gestionAsignatura.devolverAsignatura(232);
			Grupo grupoEntity = gestionGrupo.obtenerGrupo(3);
			gpa = new Grupos_por_asignatura(3, asigEntity, grupoEntity);
			id = new Grupos_por_asignaturaId(3, asigEntity.getReferencia(), grupoEntity.getID());
			gestionGpa.modificarGpA(id, gpa);
			fail("GpA no deberia encontrarlo");
		} catch (GpANoEncontradoException e) {
			//OK
		} catch (SanekaException e) {
			fail("GpA no deberia encontrarlo");
		}
	}
	
	@Requisitos({"RF-3"})
	@Test
	public void testDevolverGrupo_por_asignatura() {
		Grupos_por_asignatura gpa = new Grupos_por_asignatura();
		Grupos_por_asignaturaId id = new Grupos_por_asignaturaId();
		try {
			Asignatura asigEntity = gestionAsignatura.devolverAsignatura(232);
			Grupo grupoEntity = gestionGrupo.obtenerGrupo(3);
			gpa = new Grupos_por_asignatura(3, asigEntity, grupoEntity);
			id = new Grupos_por_asignaturaId(3, asigEntity.getReferencia(), grupoEntity.getID());
			Grupos_por_asignatura gpaEntity = gestionGpa.devolverGpA(id);
			assertEquals(gpaEntity.hashCode(), gpa.hashCode());
		} catch (ExpedienteNoEncontradoException e) {
			fail("El GpA no se ha encontrado");
		}catch (SanekaException e) {
		throw new RuntimeException(e);
		}
	}
	
	@Requisitos({"RF-3"})
	@Test
	public void testDevolverGrupo_por_asignaturaNoEncontrado() {
		Grupos_por_asignatura gpa = new Grupos_por_asignatura();
		Grupos_por_asignaturaId id = new Grupos_por_asignaturaId();
		try {
			Asignatura asigEntity = gestionAsignatura.devolverAsignatura(232);
			Grupo grupoEntity = gestionGrupo.obtenerGrupo(3);
			gpa = new Grupos_por_asignatura(3, asigEntity, grupoEntity);
			id = new Grupos_por_asignaturaId(3, asigEntity.getReferencia(), grupoEntity.getID());
			Grupos_por_asignatura gpaEntity = gestionGpa.devolverGpA(id);
			assertEquals(gpaEntity.hashCode(), gpa.hashCode());
			fail("El GpA no deberia encontrarse");
		} catch (ExpedienteNoEncontradoException e) {
			//OK
		}catch (SanekaException e) {
			fail("El GpA no deberia encontrarse");
		}
	}
	
	@Requisitos({"RF-3"})
	@Test
	public void testMostrarGrupo_por_asignatura() {
		try {
			Asignatura asigEntity = gestionAsignatura.devolverAsignatura(232);
			Grupo grupoEntity = gestionGrupo.obtenerGrupo(3);
			Grupos_por_asignaturaId id = new Grupos_por_asignaturaId(3, asigEntity.getReferencia(), grupoEntity.getID());
			String gpaCadena = gestionGpa.mostrarGpA(id);
			Grupos_por_asignatura gpaEntity = gestionGpa.devolverGpA(id);
			assertEquals(gpaEntity.toString(), gpaCadena);
		} catch (GpANoEncontradoException e) {
			fail("No encuentra el GpA");
		}catch (SanekaException e) {
			//OK
		}
	}
}

