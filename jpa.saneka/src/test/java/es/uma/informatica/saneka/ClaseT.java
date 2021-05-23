package es.uma.informatica.saneka;

	import static org.junit.Assert.assertEquals;
	import static org.junit.Assert.assertTrue;
	import static org.junit.Assert.fail;

	import java.sql.Date;
	import java.util.List;
	import java.util.Properties;
	import java.util.logging.Logger;

	import javax.ejb.embeddable.EJBContainer;
	import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.AfterClass;
	import org.junit.Before;
	import org.junit.BeforeClass;
	import org.junit.Ignore;
	import org.junit.Test;

	import es.uma.informatica.ejb.exceptions.AsignaturaNoEncontradoException;
	import es.uma.informatica.ejb.exceptions.CentroExistenteException;
	import es.uma.informatica.ejb.exceptions.ClaseExistenteException;
	import es.uma.informatica.ejb.exceptions.ClaseNoEncontradoException;
	import es.uma.informatica.ejb.exceptions.GrupoNoEncontradoException;
	import es.uma.informatica.ejb.exceptions.SanekaException;
	import es.uma.informatica.ejb.saneka.GestionAsignatura;
	import es.uma.informatica.ejb.saneka.GestionCentro;
	import es.uma.informatica.ejb.saneka.GestionClase;
	import es.uma.informatica.ejb.saneka.GestionGrupo;
	import es.uma.informatica.ejb.saneka.GestionTitulacion;
	import es.uma.informatica.jpa.saneka.Asignatura;
	import es.uma.informatica.jpa.saneka.Centro;
	import es.uma.informatica.jpa.saneka.Clase;
	import es.uma.informatica.jpa.saneka.Grupo;
	import es.uma.informatica.jpa.saneka.Titulacion;
import es.uma.informatica.sii.anotaciones.Requisitos;

	public class ClaseT {
		
		private static final Logger LOG = Logger.getLogger(ClaseT.class.getCanonicalName());
		private static final String CLASE_EJB = "java:global/classes/ClaseEJB";
		private static final String ASIGNATURAS_EJB = "java:global/classes/AsignaturaEJB";
		private static final String GRUPO_EJB = "java:global/classes/GrupoEJB";
		private static final String TITULACION_EJB = "java:global/classes/TitulacionEJB";
		private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SanekaTest";
		
		
		private GestionClase gestionClase;
		private GestionAsignatura gestionAsignatura;
		private GestionGrupo gestionGrupo;
		private GestionTitulacion gestionTitulacion;
		private static Context ctx;
		
		@Before
		public void setup() throws NamingException  {
			gestionClase = (GestionClase) SuiteTest.ctx.lookup(CLASE_EJB);
			gestionAsignatura = (GestionAsignatura) SuiteTest.ctx.lookup(ASIGNATURAS_EJB);
			gestionGrupo = (GestionGrupo)  SuiteTest.ctx.lookup(GRUPO_EJB);
			gestionTitulacion = (GestionTitulacion)  SuiteTest.ctx.lookup(TITULACION_EJB);
			BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
		}
		
		@Requisitos({"RF-8"})
		@Test
		public void testIntertarClase() {
			final Integer idGrupo = 420;
			
			try {
				Grupo grupo = gestionGrupo.obtenerGrupo(idGrupo);
				Asignatura asig = gestionAsignatura.devolverAsignatura(232);
				Clase clase = new Clase(2,"2021-04-11",asig,grupo);
				gestionClase.insertarClase(grupo.getId(),clase);
			}catch (AsignaturaNoEncontradoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClaseExistenteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SanekaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				
				List<Clase> clases = gestionClase.obtenerClasesDeGrupo(idGrupo);
				assertEquals(1, clases.size());
				assertEquals(2,clases.get(0).getDia());
				assertEquals("2021-04-11",clases.get(0).getHoraInicio());
			}catch(SanekaException e) {
				fail("No debería lanzar excepción");
			}
		}
		
		@Requisitos({"RF-8"})
		@Test 
		public void testInsertarClaseGrupoNoEncontrado() {
			
			try {
				
				Titulacion titu = gestionTitulacion.devolverTitulacion(1234);
				Grupo grupo = new Grupo(34,4,"A","tarde",false,titu);
				Asignatura asig = gestionAsignatura.devolverAsignatura(232);
				Clase clase = new Clase(2,"2021-04-11",asig,grupo);
				gestionClase.insertarClase(grupo.getId(), clase);
				fail("Debería lanzar excepción de grupo no encontrado");
			}catch(SanekaException e) {
				
			}
			
			
		}
		
		@Requisitos({"RF-2"})
		@Test
		public void testModificarClase() {
			try {
				Titulacion titu = gestionTitulacion.devolverTitulacion(1234);
				System.out.println("hola");
				Grupo grupo = gestionGrupo.obtenerGrupo(123);
				Asignatura asig = new Asignatura(226,true,112,6,titu);
				Clase clase = new Clase(2,"2021-04-11",asig,grupo);
				gestionClase.actualizarClase(grupo.getId(), clase);
				
			} catch (SanekaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		@Requisitos({"RF-2"})
		@Test
		public void testModificarClaseGrupoNoEncontrado() {
			final Integer idGrupo = 123;
			final Integer otroId = 456;
			
			try {
				List<Clase> clases = gestionClase.obtenerClasesDeGrupo(idGrupo);
				Clase clase0 = clases.get(0);
				clase0.setDia(12);
				clase0.setHoraFin("25/6/2021");
				gestionClase.actualizarClase(otroId, clase0);
				fail("Debería lanzar excepción de Grupo no encontrado");
			} catch (GrupoNoEncontradoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClaseNoEncontradoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		@Requisitos({"RF-8"})
		@Test
		public void testEliminarClase() {
			final Integer idGrupo = 420;
			try {
				List<Clase> clases = gestionClase.obtenerClasesDeGrupo(idGrupo);
				Clase clase0 = clases.get(0);
				gestionClase.eliminarClase(idGrupo, clase0);
			} catch (GrupoNoEncontradoException | ClaseNoEncontradoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		@Requisitos({"RF-8"})
		@Test
		public void testEliminarClaseGrupoNoEncontrado() {
			final Integer idGrupo = 420;
			final Integer otroId = 456;
			List<Clase> clases;
			try {
				clases = gestionClase.obtenerClasesDeGrupo(idGrupo);
				Clase clase0 = clases.get(0);
				gestionClase.eliminarClase(otroId, clase0);
			} catch (GrupoNoEncontradoException | ClaseNoEncontradoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		@Requisitos({"RF-8"})
		@Test 
		public void testEliminarClaseNoEncontrado() {
			final Integer idGrupo = 420;
			List<Clase> clases;
			try {
				clases = gestionClase.obtenerClasesDeGrupo(idGrupo);
				Clase clase0 = clases.get(0);
				clase0.setDia(23);
				gestionClase.eliminarClase(idGrupo, clase0);
				fail("Debería lanzar la excepción de clase no encontrado");
			} catch (GrupoNoEncontradoException | ClaseNoEncontradoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		@Requisitos({"RF-8"})
		@Test
		public void testEliminarTodosClases() {
			final Integer idGrupo = 420;
			try {
				gestionClase.eliminarTodosClases(idGrupo);
				List<Clase> clases = gestionClase.obtenerClasesDeGrupo(idGrupo);
				assertEquals(0, clases.size());
			} catch (GrupoNoEncontradoException e) {
				fail("No debería lanzarse excepción");
			}
		}
		
		@Requisitos({"RF-8"})
		@Test
		public void testEliminarTodosClasesGrupoNoEncontrado() {
			final Integer otroId = 456;
			try {
				gestionClase.eliminarTodosClases(otroId);
			} catch (GrupoNoEncontradoException e) {
				fail("Debería lanzar la excepción de grupo no encontrado");
			}
		}

	}


