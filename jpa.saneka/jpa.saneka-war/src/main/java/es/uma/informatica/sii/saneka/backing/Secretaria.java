package es.uma.informatica.sii.saneka.backing;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.ejb.exceptions.AlumnoNoEncontrado;
import es.uma.informatica.ejb.exceptions.AlumnoYaExistente;
import es.uma.informatica.ejb.exceptions.AsignaturaExistenteException;
import es.uma.informatica.ejb.exceptions.AsignaturaNoEncontradoException;
import es.uma.informatica.ejb.exceptions.CentroExistenteException;
import es.uma.informatica.ejb.exceptions.CentroNoEncontradoException;
import es.uma.informatica.ejb.exceptions.ClaseExistenteException;
import es.uma.informatica.ejb.exceptions.ClaseNoEncontradoException;
import es.uma.informatica.ejb.exceptions.ExpedienteExistenteException;
import es.uma.informatica.ejb.exceptions.ExpedienteNoEncontradoException;
import es.uma.informatica.ejb.exceptions.GrupoExistenteException;
import es.uma.informatica.ejb.exceptions.GrupoNoEncontradoException;
import es.uma.informatica.ejb.exceptions.MatriculaExistente;
import es.uma.informatica.ejb.exceptions.MatriculaNoExistente;
import es.uma.informatica.ejb.exceptions.OptativaExistenteException;
import es.uma.informatica.ejb.exceptions.OptativaNoEncontradoException;
import es.uma.informatica.ejb.exceptions.TitulacionExistenteException;
import es.uma.informatica.ejb.exceptions.TitulacionNoEncontradoException;
import es.uma.informatica.ejb.exceptions.UsuarioNoEncontradoException;
import es.uma.informatica.ejb.saneka.GestionAlumno;
import es.uma.informatica.ejb.saneka.GestionAsignatura;
import es.uma.informatica.ejb.saneka.GestionCentro;
import es.uma.informatica.ejb.saneka.GestionClase;
import es.uma.informatica.ejb.saneka.GestionExpediente;
import es.uma.informatica.ejb.saneka.GestionGrupo;
import es.uma.informatica.ejb.saneka.GestionMatricula;
import es.uma.informatica.ejb.saneka.GestionOptativa;
import es.uma.informatica.ejb.saneka.GestionTitulacion;
import es.uma.informatica.ejb.saneka.GestionUsuario;
import es.uma.informatica.jpa.saneka.Alumno;
import es.uma.informatica.jpa.saneka.Asignatura;
import es.uma.informatica.jpa.saneka.Centro;
import es.uma.informatica.jpa.saneka.Clase;
import es.uma.informatica.jpa.saneka.Expediente;
import es.uma.informatica.jpa.saneka.Grupo;
import es.uma.informatica.jpa.saneka.Matricula;
import es.uma.informatica.jpa.saneka.Matricula.MatriculaId;
import es.uma.informatica.jpa.saneka.Optativa;
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
	@Inject
	private GestionOptativa gestionOpt;
	
	private Alumno alumno;
	private String dni;
	private Asignatura asignatura;
	private Integer refAsig;
	private Centro centro;
	private Integer idCentro;
	private Clase clase;
	private Clase.ClaseId idClase;
	private Expediente expediente;
	private Integer exp;
	private Grupo grupo;
	private Integer idGrupo;
	private Matricula matricula;
	private String matr;
	private Titulacion titulacion;
	private Integer titu;
	private Optativa optativa;
	private Integer refOpt;
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Asignatura getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	public Centro getCentro() {
		return centro;
	}
	public void setCentro(Centro centro) {
		this.centro = centro;
	}
	public Clase getClase() {
		return clase;
	}
	public void setClase(Clase clase) {
		this.clase = clase;
	}
	public Expediente getExpediente() {
		return expediente;
	}
	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public Matricula getMatricula() {
		return matricula;
	}
	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	public Titulacion getTitulacion() {
		return titulacion;
	}
	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}
	public Optativa getOptativa() {
		return optativa;
	}
	public void setOptativa(Optativa optativa) {
		this.optativa = optativa;
	}
    public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Integer getRefAsig() {
		return refAsig;
	}
	public void setRefAsig(Integer refAsig) {
		this.refAsig = refAsig;
	}
	public Integer getIdCentro() {
		return idCentro;
	}
	public void setIdCentro(Integer idCentro) {
		this.idCentro = idCentro;
	}
	public Clase.ClaseId getIdClase() {
		return idClase;
	}
	public void setIdClase(Clase.ClaseId idClase) {
		this.idClase = idClase;
	}
	public Integer getExp() {
		return exp;
	}
	public void setExp(Integer exp) {
		this.exp = exp;
	}
	public Integer getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}
	public String getMatr() {
		return matr;
	}
	public void setMatr(String matr) {
		this.matr = matr;
	}
	public Integer getTitu() {
		return titu;
	}
	public void setTitu(Integer titu) {
		this.titu = titu;
	}
	public Integer getRefOpt() {
		return refOpt;
	}
	public void setRefOpt(Integer refOpt) {
		this.refOpt = refOpt;
	}


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
        availableItems.put("Titulacion", "Titulacion");
        availableItems.put("Optativa", "Optativa");
        
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
			case "Optativa": enlace= "crearOptativa.xhtml"; break;
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
			case "Optativa": enlace = "modificarOptativa.xhtml"; break;
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
			case "Optativa": enlace = "eliminarOptativa.xhtml"; break;
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
	public void crearAlumno(){
			try{
				gestionAlumno.insertarAlumno(alumno);
			} catch (AlumnoYaExistente e) {
	            FacesMessage fm = new FacesMessage("El alumno ya existe");
	            FacesContext.getCurrentInstance().addMessage("crearAlumno:errorDni", fm);
	        }
	}
	public void modificarAlumno() throws AlumnoNoEncontrado {
			gestionAlumno.modificarAlumno(dni,alumno);
	}
	public void eliminarAlumno(){
			try{
				gestionAlumno.eliminarAlumno(dni);
			} catch (AlumnoNoEncontrado e) {
	            FacesMessage fm = new FacesMessage("El alumno no se ha podido encontrar");
	            FacesContext.getCurrentInstance().addMessage("eliminarAlumno:errorDni", fm);
	        }
	}
	public void crearAsignatura(){
		try{
			gestionAsig.insertarAsignatura(asignatura.getReferencia(), asignatura);
		} catch (AsignaturaExistenteException e) {
            FacesMessage fm = new FacesMessage("La asignatura ya existe");
            FacesContext.getCurrentInstance().addMessage("crearAsignatura:errorRef", fm);
        }
	}
	public void modificarAsignatura() throws AsignaturaNoEncontradoException {
		gestionAsig.modificarAsignatura(refAsig, asignatura);
	}
	public void eliminarAsignatura(){
		try{
			gestionAsig.eliminarAsignatura(refAsig);
		} catch (AsignaturaNoEncontradoException e) {
            FacesMessage fm = new FacesMessage("La asignatura no se ha podido encontrar");
            FacesContext.getCurrentInstance().addMessage("eliminarAsignatura:errorRef", fm);
        }
	}
	public void crearCentro (){
		try{
			gestionCentro.insertarCentro(centro);
		} catch (CentroExistenteException e) {
            FacesMessage fm = new FacesMessage("El centro ya existe");
            FacesContext.getCurrentInstance().addMessage("crearCentro:errorId", fm);
        }
	}
	public void modificarCentro() throws CentroNoEncontradoException {
		gestionCentro.actualizarCentro(idCentro,centro);
	}
	public void eliminarCentro() {
		try{
			gestionCentro.eliminarCentro(idCentro);
		} catch (CentroNoEncontradoException e) {
            FacesMessage fm = new FacesMessage("El centro no se ha podido encontrar");
            FacesContext.getCurrentInstance().addMessage("eliminarCentro:errorId", fm);
        }
	}
	public void crearClase() {
		try{
			gestionClase.insertarClase(idGrupo, clase);
		} catch (GrupoNoEncontradoException e) {
            FacesMessage fm = new FacesMessage("El grupo no se ha podido encontrar");
            FacesContext.getCurrentInstance().addMessage("crearClase:errorGrupo", fm);
        } catch (ClaseExistenteException e) {
            FacesMessage fm = new FacesMessage("La clase ya existe");
            FacesContext.getCurrentInstance().addMessage("crearClase:errorClase", fm);
        }
	}
	public void modificarClase() throws GrupoNoEncontradoException, ClaseNoEncontradoException {
		gestionClase.actualizarClase(idGrupo,idClase, clase);
	}
	public void eliminarClase() {
		try{
			gestionClase.eliminarClase(idGrupo,idClase);
		} catch (GrupoNoEncontradoException e) {
            FacesMessage fm = new FacesMessage("El grupo no se ha podido encontrar");
            FacesContext.getCurrentInstance().addMessage("eliminarClase:errorGrupo", fm);
        } catch (ClaseNoEncontradoException e) {
            FacesMessage fm = new FacesMessage("La clase no se ha podido encontrar");
            FacesContext.getCurrentInstance().addMessage("eliminarClase:errorClase", fm);
        }
	}
	public void crearExpediente() {
		try{
			gestionExp.insertarExpediente(expediente.getNumExpediente(), expediente);
		} catch (ExpedienteExistenteException e) {
            FacesMessage fm = new FacesMessage("El expediente ya existe");
            FacesContext.getCurrentInstance().addMessage("crearExpediente:errorExp", fm);
        }
	}
	public void modificarExpediente() throws ExpedienteNoEncontradoException {
		gestionExp.modificarExpediente(exp, expediente);
	}
	public void eliminarExpediente() {
		try{
			gestionExp.eliminarExpediente(exp);
		} catch (ExpedienteNoEncontradoException e) {
            FacesMessage fm = new FacesMessage("El expediente no se ha podido encontrar");
            FacesContext.getCurrentInstance().addMessage("eliminarExpediente:errorExp", fm);
        }
	}
	public void crearGrupo() {
		try{
			gestionGrupo.insertarGrupo(titu, grupo);
		} catch (TitulacionNoEncontradoException e) {
            FacesMessage fm = new FacesMessage("La titulacion no se ha podido encontrar");
            FacesContext.getCurrentInstance().addMessage("crearGrupo:errorTitulacion", fm);
        } catch (GrupoExistenteException e) {
            FacesMessage fm = new FacesMessage("El grupo ya existe");
            FacesContext.getCurrentInstance().addMessage("crearGrupo:errorGrupo", fm);
        }
	}
	public void modificarGrupo() throws TitulacionNoEncontradoException, GrupoNoEncontradoException {
		gestionGrupo.actualizarGrupo(titu,idGrupo, grupo);
	}
	public void eliminarGrupo() {
		try{
			gestionGrupo.eliminarGrupo(titu, idGrupo);
		} catch (TitulacionNoEncontradoException e) {
            FacesMessage fm = new FacesMessage("La titulacion no se ha podido encontrar");
            FacesContext.getCurrentInstance().addMessage("eliminarGrupo:errorTitulacion", fm);
        } catch (GrupoNoEncontradoException e) {
            FacesMessage fm = new FacesMessage("El grupo no se ha podido encontrar");
            FacesContext.getCurrentInstance().addMessage("eliminarGrupo:errorGrupo", fm);
        }
	}
	public void crearMatricula() {
		try{
			gestionMatricula.insertarMatricula(exp, matricula);
		} catch (ExpedienteNoEncontradoException e) {
            FacesMessage fm = new FacesMessage("El expediente no se ha podido encontrar");
            FacesContext.getCurrentInstance().addMessage("crearMatricula:errorExpediente", fm);
        } catch (MatriculaExistente e) {
            FacesMessage fm = new FacesMessage("La matricula ya existe");
            FacesContext.getCurrentInstance().addMessage("crearMatricula:errorMatricula", fm);
        }
	}
	public void modificarMatricula() throws MatriculaNoExistente, ExpedienteNoEncontradoException {
		gestionMatricula.modificarMatricula(exp, matricula);
	}
	public void eliminarMatricula() {
		try{
			gestionMatricula.eliminarMatricula(exp,matr);
		} catch (MatriculaNoExistente e) {
            FacesMessage fm = new FacesMessage("La matricula no se ha podido encontrar");
            FacesContext.getCurrentInstance().addMessage("eliminarMatricula:errorMatricula", fm);
        } catch (ExpedienteNoEncontradoException e) {
            FacesMessage fm = new FacesMessage("El expediente no se ha podido encontrar");
            FacesContext.getCurrentInstance().addMessage("eliminarMatricula:errorExpediente", fm);
        }
	}
	public void crearTitulacion() {
		try{
			gestionTitu.insertarTitulacion(titulacion.getCodigo(), titulacion);
		} catch (TitulacionExistenteException e) {
            FacesMessage fm = new FacesMessage("La titulacion ya existe");
            FacesContext.getCurrentInstance().addMessage("crearTitulacion:errorId", fm);
        }
	}
	public void modificarTitulacion() throws TitulacionNoEncontradoException {
		gestionTitu.modificarTitulacion(titu, titulacion);
	}
	public void eliminarTitulacion() {
		try{
			gestionTitu.eliminarTitulacion(titu);
		} catch (TitulacionNoEncontradoException e) {
            FacesMessage fm = new FacesMessage("La titulacion no se ha podido encontrar");
            FacesContext.getCurrentInstance().addMessage("eliminarTitulacion:errorId", fm);
        }
	}
	public void crearOptativa() {
		try{
			gestionOpt.insertarOptativa(optativa.getReferencia(),optativa);
		} catch (OptativaExistenteException e) {
            FacesMessage fm = new FacesMessage("La optativa ya existe");
            FacesContext.getCurrentInstance().addMessage("crearOptativa:errorId", fm);
        }
	}
	public void modificarOptativa() throws OptativaNoEncontradoException {
		gestionOpt.modificarOptativa(refOpt, optativa);
	}
	public void eliminarOptativa() {
		try{
			gestionOpt.eliminarOptativa(refOpt);
		} catch (OptativaNoEncontradoException e) {
            FacesMessage fm = new FacesMessage("La optativa no se ha podido encontrar");
            FacesContext.getCurrentInstance().addMessage("eliminarOptativa:errorId", fm);
        }
	}
}
