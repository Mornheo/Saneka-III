package es.uma.informatica.jpa.saneka;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Grupo implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id 
	private Integer ID;
	@Column(unique=true,nullable=false)
	private Integer Curso;
	@Column(unique=true,nullable=false)
	private String Letra;
	@Column(nullable=false)
	private String Turno;
	@Column(nullable=false)
	private Boolean Ingles;
	private Boolean Visible;
	private String Asignar;
	private Integer Plazas;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Titulacion titulacion;
	@OneToMany
	private List<Grupo> grupos;
	@OneToMany
	private List<Clase> clases;
	@OneToMany
	private List<Grupos_por_asignatura> grupos_asignatura;
	@OneToMany
	private List<Asignaturas_matricula> asignaturas_matricula;
	public Grupo (Integer curso,String letra,String turno,Boolean ingles) {
		Curso = curso;
		Letra = letra;
		Turno = turno;
		Ingles = ingles;
	}
	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getCurso() {
		return Curso;
	}

	public void setCurso(Integer curso) {
		Curso = curso;
	}

	public String getLetra() {
		return Letra;
	}

	public void setLetra(String letra) {
		Letra = letra;
	}

	public String getTurno() {
		return Turno;
	}

	public void setTurno(String turno) {
		Turno = turno;
	}
	public Boolean getIngles() {
		return Ingles;
	}

	public void setIngles(Boolean ingles) {
		Ingles = ingles;
	}

	public Boolean getVisible() {
		return Visible;
	}

	public void setVisible(Boolean visible) {
		Visible = visible;
	}

	public String getAsignar() {
		return Asignar;
	}

	public void setAsignar(String asignar) {
		Asignar = asignar;
	}

	public Integer getPlazas() {
		return Plazas;
	}

	public void setPlazas(Integer plazas) {
		Plazas = plazas;
	}
	
	public Titulacion getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	public List<Grupos_por_asignatura> getGrupos_asignatura() {
		return grupos_asignatura;
	}

	public void setGrupos_asignatura(List<Grupos_por_asignatura> grupos_asignatura) {
		this.grupos_asignatura = grupos_asignatura;
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
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
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
		Grupo other = (Grupo) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grupo [ID=" + ID + ", Curso=" + Curso + ", Letra=" + Letra + ", Turno=" + Turno + ", Ingles=" + Ingles
				+ ", Visible=" + Visible + ", Asignar=" + Asignar + ", Plazas=" + Plazas + "]";
	}

	
	
}
