package es.uma.informatica.saneka;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uma.informatica.ejb.exceptions.ExpedienteNoEncontradoException;
import es.uma.informatica.ejb.exceptions.MatriculaExistente;
import es.uma.informatica.ejb.exceptions.MatriculaNoExistente;
import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.ejb.saneka.GestionAlumno;
import es.uma.informatica.ejb.saneka.GestionMatricula;
import es.uma.informatica.jpa.saneka.Alumno;
import es.uma.informatica.jpa.saneka.Centro;
import es.uma.informatica.jpa.saneka.Expediente;
import es.uma.informatica.jpa.saneka.Matricula;
import es.uma.informatica.jpa.saneka.Titulacion;

public class MatriculaTest {

	private static final String MATRICULA_EJB = "java:global/classes/MatriculaEJB";
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SanekaTest";
	
	private static EJBContainer ejbContainer;
	private static Context ctx;
	
	private GestionMatricula gestionMatricula;
	
	@BeforeClass
	public static void setUpClass() throws Exception {
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
	public void setUp() throws NamingException {
		gestionMatricula=(GestionMatricula) ctx.lookup(MATRICULA_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	public void testInsertarCorrecto() {
		try {
		Alumno a=new Alumno();
		a.setDNI("090");
		a.setNombre("Diego");
		a.setApellido1("Centeno");
		a.setApellido2("Linares");
		Centro centro = new Centro(123, "informatica", "avenida de andalucia n11");
		List<Centro> centros = new ArrayList<Centro>();
		centros.add(centro);
		Titulacion titu = new Titulacion(1234, centros);
		Expediente exp = new Expediente(12345, titu, a);
		Matricula m=new Matricula("2", "12/09/2019", exp);

		gestionMatricula.insertarMatricula(exp.getNum_expediente(),m);
		try {
			assertEquals(m.toString(),gestionMatricula.mostrarMatricula(exp.getNum_expediente(), m.getCurso_academico()));
		}catch(SanekaException e) {
			fail("No deberia salir esto");
		}
		}catch(MatriculaExistente | ExpedienteNoEncontradoException e) {
			fail("Matricula ya existente o expediente no encontrado");
		}

	}
	
	@Test
	public void testInsertarMatriculaYaExistente() {
		try {
		Alumno a=new Alumno();
		a.setDNI("090");
		a.setNombre("Diego");
		a.setApellido1("Centeno");
		a.setApellido2("Linares");
		Centro centro = new Centro(123, "informatica", "avenida de andalucia n11");
		List<Centro> centros = new ArrayList<Centro>();
		centros.add(centro);
		Titulacion titu = new Titulacion(1234, centros);
		Expediente exp = new Expediente(12345, titu, a);
		Matricula m=new Matricula("3", "12/09/2020", exp);
		gestionMatricula.insertarMatricula(exp.getNum_expediente(),m);
		fail("Matricula Existente");
		}catch(MatriculaExistente | ExpedienteNoEncontradoException e){
			//OK
		}
	}
	
	@Test
	public void testModificarMatriculaCorrecto() {
		try {
		Alumno a=new Alumno();
		a.setDNI("090");
		a.setNombre("Diego");
		a.setApellido1("Centeno");
		a.setApellido2("Linares");
		Centro centro = new Centro(123, "informatica", "avenida de andalucia n11");
		List<Centro> centros = new ArrayList<Centro>();
		centros.add(centro);
		Titulacion titu = new Titulacion(1234, centros);
		Expediente exp = new Expediente(12345, titu, a);
		Matricula m=new Matricula("3", "12/09/2019", exp);
		m.setEstado("Correcto");
		gestionMatricula.modificarMatricula(exp.getNum_expediente(), m);
		try {
			assertEquals(m.toString(),gestionMatricula.mostrarMatricula(exp.getNum_expediente(), m.getCurso_academico()));
		}catch(SanekaException e) {
			fail("No se ha modificado");
		}
			
		}catch(MatriculaNoExistente|ExpedienteNoEncontradoException e) {
			fail("Matricula ya existente o expediente no encontrado");
		}
	}
	
	@Test
	public void testModificarMatriculaNoExistente() {
		try {
		Alumno a=new Alumno();
		a.setDNI("090");
		a.setNombre("Diego");
		a.setApellido1("Centeno");
		a.setApellido2("Linares");
		Centro centro = new Centro(123, "informatica", "avenida de andalucia n11");
		List<Centro> centros = new ArrayList<Centro>();
		centros.add(centro);
		Titulacion titu = new Titulacion(1234, centros);
		Expediente exp = new Expediente(12345, titu, a);
		Matricula m=new Matricula("1", "12/09/2019", exp);
		gestionMatricula.modificarMatricula(exp.getNum_expediente(),m);
		fail("Matricula No Existente");
		}catch(MatriculaNoExistente | ExpedienteNoEncontradoException e){
			//OK
		}
	}
	
	@Test
	public void testModificarExpedienteaNoExistente() {
		try {
		Alumno a=new Alumno();
		a.setDNI("090");
		a.setNombre("Diego");
		a.setApellido1("Centeno");
		a.setApellido2("Linares");
		Centro centro = new Centro(123, "informatica", "avenida de andalucia n11");
		List<Centro> centros = new ArrayList<Centro>();
		centros.add(centro);
		Titulacion titu = new Titulacion(1234, centros);
		Expediente exp = new Expediente(123456, titu, a);
		Matricula m=new Matricula("1", "12/09/2019", exp);
		gestionMatricula.modificarMatricula(exp.getNum_expediente(),m);
		fail("Expediente No Existente");
		}catch(MatriculaNoExistente | ExpedienteNoEncontradoException e){
			//OK
		}
	}
	
	@Test
	public void testMostrarMatriculaCorrecto() {
		try {
		Integer exp=12345;
		String curso="3";
		assertEquals(gestionMatricula.mostrarMatricula(exp, curso),
				"Matricula [Curso_academico=" + "3" + ", Estado=" + null + ", Num_archivo=" + null
				+ ", Turno_preferente=" + null + ", Fecha_matricula=" + "12/09/2020" + ", Nuevo_ingreso="
				+ null + ", Listado_asignaturas=" + null + "]"
				);
		}catch(ExpedienteNoEncontradoException|MatriculaNoExistente e) {
			fail("Matricula ya existente o expediente no encontrado");	
		}
	}
	
	@Test
	public void testMostrarMatriculaMatriculaNoExistente() {
		try {
		Integer exp=12345;
		String curso="1";
		gestionMatricula.mostrarMatricula(exp, curso);
		fail("Matricula no existente");
		}catch(SanekaException e) {
			fail("Excepcion");	
		}
	}
	
	@Test
	public void testMostrarMatriculaExpedienteNoExistente() {
		try {
		Integer exp=1;
		String curso="1";
		gestionMatricula.mostrarMatricula(exp, curso);
		fail("Expediente no existente");
		}catch(SanekaException e) {
			fail("Excepcion");	
		}
	}
	
	@Test
	public void testEliminarcorrecto() {
		try {
			Integer exp=12345;
			String curso="3";
			gestionMatricula.eliminarMatricula(exp, curso);
		try {
			gestionMatricula.mostrarMatricula(exp, curso);
			fail("Matricula no existente");
		}catch(ExpedienteNoEncontradoException|MatriculaNoExistente e) {
			fail("fallo");
		}
		
		}catch(SanekaException e) {
			fail("fallo");
		}
	}
	
	@Test
	public void testEliminarExpedienteNoExistente() {
		try {
		Integer exp=1;
		String curso="3";
		gestionMatricula.eliminarMatricula(exp, curso);
		//fail("Expediente no existente");
		}catch(ExpedienteNoEncontradoException |MatriculaNoExistente e) {
			fail("Excepcion");	
		}
	}
	
	@Test
	public void testEliminarMatriculaNoExistente() {
		try {
		Integer exp=12345;
		String curso="1";
		gestionMatricula.eliminarMatricula(exp, curso);
		fail("Matricula no existente");
		}catch(SanekaException e) {
			fail("Excepcion");	
		}
	}

}
