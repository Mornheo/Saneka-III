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
import es.uma.informatica.sii.anotaciones.Requisitos;

public class MatriculaT {

	private static final String MATRICULA_EJB = "java:global/classes/MatriculaEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SanekaTest";
	
	
	private static Context ctx;
	private GestionMatricula gestionMatricula;
	

	@Before
	public void setUp() throws NamingException {
		gestionMatricula=(GestionMatricula) SuiteTest.ctx.lookup(MATRICULA_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Requisitos({"RF-8"})
	@Test
	public void testInsertarCorrecto() {
		try {
		Alumno a=new Alumno(null, null, null, null);
		a.setDni("090");
		a.setNombre("Diego");
		a.setApellido1("Centeno");
		a.setApellido2("Linares");
		Centro centro = new Centro(123, "informatica", "avenida de andalucia n11");
		List<Centro> centros = new ArrayList<Centro>();
		centros.add(centro);
		Titulacion titu = new Titulacion(1234,"infor",6, centros);
		Expediente exp = new Expediente(12345, titu, a);
		Matricula m=new Matricula("2", "12/09/2019", exp);

		gestionMatricula.insertarMatricula(exp.getNumExpediente(),m);
		try {
			assertEquals(m.toString(),gestionMatricula.mostrarMatricula(exp.getNumExpediente(), m.getCursoAcademico()));
		}catch(SanekaException e) {
			fail("No deberia salir esto");
		}
		}catch(MatriculaExistente | ExpedienteNoEncontradoException e) {
			fail("Matricula ya existente o expediente no encontrado");
		}

	}
	
	@Requisitos({"RF-8"})
	@Test
	public void testInsertarMatriculaYaExistente() {
		try {
		Alumno a=new Alumno(null, null, null, null);
		a.setDni("090");
		a.setNombre("Diego");
		a.setApellido1("Centeno");
		a.setApellido2("Linares");
		Centro centro = new Centro(123, "informatica", "avenida de andalucia n11");
		List<Centro> centros = new ArrayList<Centro>();
		centros.add(centro);
		Titulacion titu = new Titulacion(1234,"infor",6, centros);
		Expediente exp = new Expediente(12345, titu, a);
		Matricula m=new Matricula("3", "12/09/2020", exp);
		gestionMatricula.insertarMatricula(exp.getNumExpediente(),m);
		fail("Matricula Existente");
		}catch(MatriculaExistente | ExpedienteNoEncontradoException e){
			//OK
		}
	}
	
	@Requisitos({"RF-2"})
	@Test
	public void testModificarMatriculaCorrecto() {
		try {
		Alumno a=new Alumno(null, null, null, null);
		a.setDni("090");
		a.setNombre("Diego");
		a.setApellido1("Centeno");
		a.setApellido2("Linares");
		Centro centro = new Centro(123, "informatica", "avenida de andalucia n11");
		List<Centro> centros = new ArrayList<Centro>();
		centros.add(centro);
		Titulacion titu = new Titulacion(1234,"infor",6, centros);
		Expediente exp = new Expediente(12345, titu, a);
		Matricula m=new Matricula("3", "12/09/2019", exp);
		m.setEstado("Correcto");
		gestionMatricula.modificarMatricula(exp.getNumExpediente(), m);
		try {
			assertEquals(m.toString(),gestionMatricula.mostrarMatricula(exp.getNumExpediente(), m.getCursoAcademico()));
		}catch(SanekaException e) {
			fail("No se ha modificado");
		}
			
		}catch(MatriculaNoExistente|ExpedienteNoEncontradoException e) {
			fail("Matricula ya existente o expediente no encontrado");
		}
	}
	
	@Requisitos({"RF-2"})
	@Test
	public void testModificarMatriculaNoExistente() {
		try {
		Alumno a=new Alumno(null, null, null, null);
		a.setDni("090");
		a.setNombre("Diego");
		a.setApellido1("Centeno");
		a.setApellido2("Linares");
		Centro centro = new Centro(123, "informatica", "avenida de andalucia n11");
		List<Centro> centros = new ArrayList<Centro>();
		centros.add(centro);
		Titulacion titu = new Titulacion(1234,"infor",6, centros);
		Expediente exp = new Expediente(12345, titu, a);
		Matricula m=new Matricula("1", "12/09/2019", exp);
		gestionMatricula.modificarMatricula(exp.getNumExpediente(),m);
		fail("Matricula No Existente");
		}catch(MatriculaNoExistente | ExpedienteNoEncontradoException e){
			//OK
		}
	}
	
	@Requisitos({"RF-2"})
	@Test
	public void testModificarExpedienteaNoExistente() {
		try {
		Alumno a=new Alumno(null, null, null, null);
		a.setDni("090");
		a.setNombre("Diego");
		a.setApellido1("Centeno");
		a.setApellido2("Linares");
		Centro centro = new Centro(123, "informatica", "avenida de andalucia n11");
		List<Centro> centros = new ArrayList<Centro>();
		centros.add(centro);
		Titulacion titu = new Titulacion(1234,"infor",6, centros);
		Expediente exp = new Expediente(123456, titu, a);
		Matricula m=new Matricula("1", "12/09/2019", exp);
		gestionMatricula.modificarMatricula(exp.getNumExpediente(),m);
		fail("Expediente No Existente");
		}catch(MatriculaNoExistente | ExpedienteNoEncontradoException e){
			//OK
		}
	}
	
	@Requisitos({"RF-3"})
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
	
	@Requisitos({"RF-3"})
	@Test
	public void testMostrarMatriculaMatriculaNoExistente() {
		try {
		Integer exp=12345;
		String curso="1";
		gestionMatricula.mostrarMatricula(exp, curso);
		fail("Matricula no existente");
		}catch(SanekaException e) {
			//OK	
		}
	}
	
	@Requisitos({"RF-8"})
	@Test
	public void testEliminarcorrecto() {
		try {
			Alumno a=new Alumno(null, null, null, null);
			a.setDni("090");
			a.setNombre("Diego");
			a.setApellido1("Centeno");
			a.setApellido2("Linares");
			Centro centro = new Centro(123, "informatica", "avenida de andalucia n11");
			List<Centro> centros = new ArrayList<Centro>();
			centros.add(centro);
			Titulacion titu = new Titulacion(1234,"infor",6, centros);
			Expediente exp = new Expediente(12345, titu, a);
			Matricula m=new Matricula("4", "12/09/2019", exp);

			gestionMatricula.insertarMatricula(exp.getNumExpediente(),m);
			Integer expe=12345;
			String curso="4";
			gestionMatricula.eliminarMatricula(expe, curso);
		try {
			gestionMatricula.mostrarMatricula(expe, curso);
			fail("Matricula no existente");
		}catch(ExpedienteNoEncontradoException|MatriculaNoExistente e) {
			fail("fallo");
		}
		
		}catch(SanekaException e) {
			//OK
		}
	}
	
	@Requisitos({"RF-8"})
	@Test
	public void testEliminarMatriculaNoExistente() {
		try {
		Integer exp=12345;
		String curso="1";
		gestionMatricula.eliminarMatricula(exp, curso);
		fail("Matricula no existente");
		}catch(SanekaException e) {
			//OK	
		}
	}
	
	@Requisitos({"RF-3"})
	@Test
	public void testDevolverCorrecto() {
		try {
		Integer exp=12345;
		String curso="3";
		assertEquals(gestionMatricula.devolverMatricula(exp, curso).toString(),
				"Matricula [Curso_academico=" + "3" + ", Estado=" + null + ", Num_archivo=" + null
				+ ", Turno_preferente=" + null + ", Fecha_matricula=" + "12/09/2020" + ", Nuevo_ingreso="
				+ null + ", Listado_asignaturas=" + null + "]"
				);
		}catch(ExpedienteNoEncontradoException|MatriculaNoExistente e) {
			fail("Matricula ya existente o expediente no encontrado");	
		}
	}
	
	@Requisitos({"RF-3"})
	@Test
	public void testDevolveraMatriculaNoExistente() {
		try {
		Integer exp=12345;
		String curso="1";
		gestionMatricula.devolverMatricula(exp, curso);
		fail("Matricula no existente");
		}catch(SanekaException e) {
			//OK
		}
	}

}
