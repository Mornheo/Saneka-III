package es.uma.informatica.jpa.saneka;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Asignatura
 *
 */
@Entity

public class Asignatura implements Serializable {

	   
	@Id 
	private Integer Referencia;
	@Column(nullable = false)
	private Boolean Ofertada;
	@Column(nullable = false)
	private Integer Codigo_1;
	private String Asignatura;
	private Integer Curso;
	@Column(nullable = false)
	private Integer Creditos_teoria;
	private Integer Creditos_practica;
	private Integer Total_creditos;
	private String Caracter;
	private String Duracion;
	private String Plazas;
	private String Otro_idioma;
	
	
	@ManyToOne
	@JoinColumn (nullable = false)
	private Titulacion titulacion;
	@OneToMany(mappedBy = "asignatura")
	private List<Clase> clases;
	@OneToMany(mappedBy = "asignatura")
	private List<Grupos_por_asignatura> grupos;
	@OneToMany(mappedBy ="asignatura")
	private List<Asignaturas_matricula> asignaturas_matricula;
	
	private static final long serialVersionUID = 1L;

	public Asignatura() {
		super();
	}  
	public Asignatura(Integer ref, Boolean ofe, Integer cod, Integer credT, Titulacion titu) {
		this.Referencia=ref;
		this.Ofertada=ofe;
		this.Codigo_1=cod;
		this.Creditos_teoria=credT;
		this.titulacion=titu;		
	}   
	public Integer getReferencia() {
		return this.Referencia;
	}

	public void setReferencia(Integer Referencia) {
		this.Referencia = Referencia;
	}   
	public Boolean getOfertada() {
		return this.Ofertada;
	}

	public void setOfertada(Boolean Ofertada) {
		this.Ofertada = Ofertada;
	}   
	public Integer getCodigo_1() {
		return this.Codigo_1;
	}

	public void setCodigo_1(Integer Codigo_1) {
		this.Codigo_1 = Codigo_1;
	}   
	public String getAsignatura() {
		return this.Asignatura;
	}

	public void setAsignatura(String Asignatura) {
		this.Asignatura = Asignatura;
	}   
	public Integer getCurso() {
		return this.Curso;
	}

	public void setCurso(Integer Curso) {
		this.Curso = Curso;
	}   
	public Integer getCreditos_teoria() {
		return this.Creditos_teoria;
	}

	public void setCreditos_teoria(Integer Creditos_teoria) {
		this.Creditos_teoria = Creditos_teoria;
	}   
	public Integer getCreditos_practica() {
		return this.Creditos_practica;
	}

	public void setCreditos_practica(Integer Creditos_practica) {
		this.Creditos_practica = Creditos_practica;
	}   
	public Integer getTotal_creditos() {
		return this.Total_creditos;
	}

	public void setTotal_creditos(Integer Total_creditos) {
		this.Total_creditos = Total_creditos;
	}   
	public String getCaracter() {
		return this.Caracter;
	}

	public void setCaracter(String Caracter) {
		this.Caracter = Caracter;
	}   
	public String getDuracion() {
		return this.Duracion;
	}

	public void setDuracion(String Duracion) {
		this.Duracion = Duracion;
	}   
	public String getPlazas() {
		return this.Plazas;
	}

	public void setPlazas(String Plazas) {
		this.Plazas = Plazas;
	}   
	public String getOtro_idioma() {
		return this.Otro_idioma;
	}

	public void setOtro_idioma(String Otro_idioma) {
		this.Otro_idioma = Otro_idioma;
	}
	
	
	public Titulacion getTitulacion() {
		return titulacion;
	}
	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}
	public List<Clase> getClases() {
		return clases;
	}
	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}
	public List<Grupos_por_asignatura> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupos_por_asignatura> grupos) {
		this.grupos = grupos;
	}
	public List<Asignaturas_matricula> getAsignaturas_matricula() {
		return asignaturas_matricula;
	}
	public void setAsignaturas_matricula(List<Asignaturas_matricula> asignaturas_matricula) {
		this.asignaturas_matricula = asignaturas_matricula;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Referencia == null) ? 0 : Referencia.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		if (Referencia == null) {
			if (other.Referencia != null)
				return false;
		} else if (!Referencia.equals(other.Referencia))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Asignatura [Referencia=" + Referencia + ", Ofertada=" + Ofertada + ", Codigo_1=" + Codigo_1
				+ ", Asignatura=" + Asignatura + ", Curso=" + Curso + ", Creditos_teoria=" + Creditos_teoria
				+ ", Creditos_practica=" + Creditos_practica + ", Total_creditos=" + Total_creditos + ", Caracter="
				+ Caracter + ", Duracion=" + Duracion + ", Plazas=" + Plazas + ", Otro_idioma=" + Otro_idioma + "]";
	}
	
	
   
}
