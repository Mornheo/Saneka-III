package es.uma.informatica.saneka;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.ejb.exceptions.ExpedienteExistenteException;
import es.uma.informatica.ejb.exceptions.GpAExistenteException;
import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.ejb.saneka.GestionAsignatura;
import es.uma.informatica.ejb.saneka.GestionEncuesta;
import es.uma.informatica.ejb.saneka.GestionExpediente;
import es.uma.informatica.ejb.saneka.GestionGrupo;
import es.uma.informatica.ejb.saneka.GestionGrupos_por_asignatura;
import es.uma.informatica.jpa.saneka.Alumno;
import es.uma.informatica.jpa.saneka.Asignatura;
import es.uma.informatica.jpa.saneka.Expediente;
import es.uma.informatica.jpa.saneka.Grupo;
import es.uma.informatica.jpa.saneka.Grupos_por_asignatura;
import es.uma.informatica.jpa.saneka.Grupos_por_asignatura.Grupos_por_asignaturaId;
import es.uma.informatica.jpa.saneka.Titulacion;

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
			throw new RuntimeException(e);
		}
		
		Grupos_por_asignatura gpaEntity = new Grupos_por_asignatura();
		try {
			gpaEntity = gestionGpa.devolverGpA(id);
		} catch (SanekaException e) {
			fail("No se inserto");
		}
		assertEquals(gpaEntity.hashCode(), gpa.hashCode());
	}
	
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
	
	@Test
	public void testEliminarGrupo_por_asignatura() {
		
	}
	@Test
	public void testEliminarGrupo_por_asignaturaNoEncontrado() {
		
	}
	@Test
	public void testModificarGrupo_por_asignatura() {
		
	}
	@Test
	public void testModificarGrupo_por_asignaturaNoEncontrado() {
		
	}
	@Test
	public void testDevolverGrupo_por_asignatura() {
		
	}
	@Test
	public void testDevolverGrupo_por_asignaturaNoEncontrado() {
		
	}
	@Test
	public void testMostrarGrupo_por_asignatura() {
		
	}
	
}
