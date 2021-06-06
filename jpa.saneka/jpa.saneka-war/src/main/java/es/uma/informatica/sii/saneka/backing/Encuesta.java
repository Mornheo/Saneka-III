package es.uma.informatica.sii.saneka.backing;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.jpa.saneka.Asignatura;
import es.uma.informatica.jpa.saneka.Usuario;
@Named(value = "encuesta")
@RequestScoped
public class Encuesta implements Serializable{
	@Inject
	private InfoSesion sesion;
	private String turnoPreferente;
	private List<Asignatura> listaAsignatura;
	private List<String> turnoPosible = Arrays.asList("Tarde","Mañana"); 
	public Encuesta() {};
	public Usuario getUsuario() {
		return sesion.getUsuario();
	}
	public String enviar() {
			return "encuetaExito.xhtml";
		
	}
	public String getTurnoPreferente() {
		return turnoPreferente;
	}
	public void setTurnoPreferente(String turnoPreferente) {
		this.turnoPreferente = turnoPreferente;
	}
	public List<Asignatura> getListaAsignatura() {
		return listaAsignatura;
	}
	public void setListaAsignatura(List<Asignatura> listaAsignatura) {
		this.listaAsignatura = listaAsignatura;
	}
	public List<String> getTurnoPosible() {
		return turnoPosible;
	}
	public void setTurnoPosible(List<String> turnoPosible) {
		this.turnoPosible = turnoPosible;
	}
}
