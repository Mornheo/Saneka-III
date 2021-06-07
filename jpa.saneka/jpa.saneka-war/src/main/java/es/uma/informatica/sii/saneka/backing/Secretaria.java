package es.uma.informatica.sii.saneka.backing;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.ejb.exceptions.AlumnoNoEncontrado;
import es.uma.informatica.ejb.exceptions.AlumnoYaExistente;
import es.uma.informatica.ejb.saneka.GestionAlumno;
import es.uma.informatica.ejb.saneka.GestionAsignatura;
import es.uma.informatica.ejb.saneka.GestionCentro;
import es.uma.informatica.ejb.saneka.GestionClase;
import es.uma.informatica.ejb.saneka.GestionExpediente;
import es.uma.informatica.ejb.saneka.GestionGrupo;
import es.uma.informatica.ejb.saneka.GestionMatricula;
import es.uma.informatica.ejb.saneka.GestionTitulacion;
import es.uma.informatica.ejb.saneka.GestionUsuario;
import es.uma.informatica.jpa.saneka.Alumno;
import es.uma.informatica.jpa.saneka.Asignatura;
import es.uma.informatica.jpa.saneka.Centro;
import es.uma.informatica.jpa.saneka.Clase;
import es.uma.informatica.jpa.saneka.Expediente;
import es.uma.informatica.jpa.saneka.Grupo;
import es.uma.informatica.jpa.saneka.Matricula;
import es.uma.informatica.jpa.saneka.Titulacion;

@Named(value = "secretaria")
@RequestScoped
public class Secretaria{
	private String selectedItem1; // +getter +setter
	private String selectedItem2;
	private String selectedItem3;
	@Inject
	private GestionAlumno gestionAlumno;
	@Inject 
	private GestionAsignatura gestionAsig;
	@Inject 
	private GestionCentro gestionCentro;
	@Inject
	private GestionClase gestionClase;
	@Inject
	private GestionExpediente gestionExp;
	@Inject
	private GestionGrupo gestionGrupo;
	@Inject 
	private GestionMatricula gestionMatricula;
	@Inject
	private GestionTitulacion gestionTitu;
	
	private Alumno alumno;
	private Asignatura asig;
	private Centro centro;
	private Clase clase;
	private Expediente exp;
	private Grupo grupo;
	private Matricula mat;
	private Titulacion titu;
	
    private Map<String, String> availableItems; // +getter
    public Secretaria() {
        availableItems = new LinkedHashMap<String, String>();
        availableItems.put("Alumno", "Alumno");
        availableItems.put("Asignatura", "Asignatura");
        availableItems.put("Centro", "Centro");
        availableItems.put("Clase", "Clase");
        availableItems.put("Expediente", "Expediente");
        availableItems.put("Grupo", "Grupo");
        availableItems.put("Matrícula", "Matrícula");
        availableItems.put("Titulacion", "Titulaicon");
        
    }
	public String getSelectedItem1() {
		return selectedItem1;
	}

	public void setSelectedItem1(String selectedItem1) {
		this.selectedItem1 = selectedItem1;
	}

	public String getSelectedItem2() {
		return selectedItem2;
	}

	public void setSelectedItem2(String selectedItem2) {
		this.selectedItem2 = selectedItem2;
	}

	public String getSelectedItem3() {
		return selectedItem3;
	}

	public void setSelectedItem3(String selectedItem3) {
		this.selectedItem3 = selectedItem3;
	}

	public Map<String, String> getAvailableItems() {
		return availableItems;
	}
	public void setAvailableItems(Map<String, String> availableItems) {
		this.availableItems = availableItems;
	}
	// Seleccion 
	public String crear() {
		String enlace = null;
		switch(selectedItem1) {
			case "Alumno": enlace = "crearAlumno.xhtml"; break;
			case "Asignatura": enlace = "crearAsignatura.xhtml";break;
			case "Centro": enlace = "crearCentro.xhtml";break;
			case "Clase": enlace = "crearClase.xhtml";break;
			case "Expediente": enlace = "crearExpediente.xhtml";break;
			case "Grupo": enlace = "crearGrupo.xhtml";break;
			case "Matrícula": enlace = "crearMatricula.xhtml"; break;
			case "Titulacion": enlace = "crearTitulacion.xhtml"; break;
		}
		return enlace;

		
	}
	public String modificar() {
		String enlace = null;
		switch(selectedItem2) {
			case "Alumno": enlace = "modificarAlumno.xhtml"; break;
			case "Asignatura": enlace = "modificarAsignatura.xhtml";break;
			case "Centro": enlace = "modificarCentro.xhtml";break;
			case "Clase": enlace = "modificarClase.xhtml";break;
			case "Expediente": enlace = "modificarExpediente.xhtml";break;
			case "Grupo": enlace = "modificarGrupo.xhtml";break;
			case "Matrícula": enlace = "modificarMatricula.xhtml"; break;
			case "Titulacion": enlace = "modificarTitulacion.xhtml"; break;
		}
		return enlace;

	}
	public String eliminar() {
		String enlace = null;
		switch(selectedItem3) {
			case "Alumno": enlace = "eliminarAlumno.xhtml"; break;
			case "Asignatura": enlace = "eliminarAsignatura.xhtml";break;
			case "Centro": enlace = "eliminarCentro.xhtml";break;
			case "Clase": enlace = "eliminarClase.xhtml";break;
			case "Expediente": enlace = "eliminarExpediente.xhtml";break;
			case "Grupo": enlace = "eliminarGrupo.xhtml";break;
			case "Matrícula": enlace = "eliminarMatricula.xhtml"; break;
			case "Titulacion": enlace = "eliminarTitulacion.xhtml"; break;
		}
		return enlace;

	}
	public String panelControl(){
		return "panelControl.xhtml";
	}
	public String volver(){
		return "login.xhtml";
	}
	// Metodos de insertar,modificar y eliminar
	public void crearAlumno() throws AlumnoYaExistente {
			gestionAlumno.insertarAlumno(alumno);
	}
	public void modificarAlumno() throws AlumnoNoEncontrado {
			gestionAlumno.modificarAlumno(alumno);
	}
	public void EliminarAlumno() throws AlumnoNoEncontrado{
			gestionAlumno.eliminarAlumno(alumno.getDni());
	}
		
}
