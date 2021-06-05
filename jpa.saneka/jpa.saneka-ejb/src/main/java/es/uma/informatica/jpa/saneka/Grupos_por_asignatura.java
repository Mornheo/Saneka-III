package es.uma.informatica.jpa.saneka;

import java.io.Serializable;
import java.lang.Integer;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Grupos_por_asignatura
 *
 */
@Entity
@IdClass(Grupos_por_asignatura.Grupos_por_asignaturaId.class)
public class Grupos_por_asignatura implements Serializable {
	@Id
	private Integer curso_academico;
	private Boolean oferta;
	private static final long serialVersionUID = 1L;
	@ManyToMany (mappedBy = "gpas")
	private List<Encuesta> encuestas;
	
	@Id
	@ManyToOne
	private Asignatura asignatura;
	@Id
	@ManyToOne
	private Grupo grupo;
	public static class Grupos_por_asignaturaId implements Serializable {

		private static final long serialVersionUID = 1L;
		private int curso;
		private int asignatura;
		private int grupo;
		public Grupos_por_asignaturaId() {
			super();
		}
		public Grupos_por_asignaturaId(Integer curso, Integer asig, Integer grupo) {
			this.curso=curso;
			this.asignatura=asig;
			this.grupo=grupo;
		}
		public int getCurso_academico() {
			return curso;
		}
		public void setCurso_academico(int curso_academico) {
			curso = curso_academico;
		}
		public int getAsignatura() {
			return asignatura;
		}
		public void setAsignatura(int asignatura) {
			this.asignatura = asignatura;
		}
		public int getGrupo() {
			return grupo;
		}
		public void setGrupo(int grupo) {
			this.grupo = grupo;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + curso;
			result = prime * result + asignatura;
			result = prime * result + grupo;
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
			Grupos_por_asignaturaId other = (Grupos_por_asignaturaId) obj;
			if (curso != other.curso)
				return false;
			if (asignatura != other.asignatura)
				return false;
			if (grupo != other.grupo)
				return false;
			return true;
		}
		
	}

	public Grupos_por_asignatura() {
		super();
	}  
	public Grupos_por_asignatura(Integer curso, Asignatura asig, Grupo grupo) {
		this.curso_academico=curso;
		this.asignatura=asig;
		this.grupo=grupo;
	} 
	
	public Integer getCurso_academico() {
		return this.curso_academico;
	}

	public void setCurso_academico(Integer curso) {
		this.curso_academico = curso;
	}   
	public boolean getOferta() {
		return this.oferta;
	}

	public void setOferta(boolean oferta) {
		this.oferta = oferta;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso_academico == null) ? 0 : curso_academico.hashCode());
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
		Grupos_por_asignatura other = (Grupos_por_asignatura) obj;
		if (curso_academico == null) {
			if (other.curso_academico != null)
				return false;
		} else if (!curso_academico.equals(other.curso_academico))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Grupos_por_asignatura [Curso_academico=" + curso_academico + ", Oferta=" + oferta + "]";
	}
   
}
