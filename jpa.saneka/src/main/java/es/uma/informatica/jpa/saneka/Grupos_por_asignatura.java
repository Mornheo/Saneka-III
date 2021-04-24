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
	private Integer Curso_academico;
	private Boolean Oferta;
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
		private int Curso_academico;
		private int asignatura;
		private int grupo;
		public Grupos_por_asignaturaId() {
			super();
		}
		public int getCurso_academico() {
			return Curso_academico;
		}
		public void setCurso_academico(int curso_academico) {
			Curso_academico = curso_academico;
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
			result = prime * result + Curso_academico;
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
			if (Curso_academico != other.Curso_academico)
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
		this.Curso_academico=curso;
		this.asignatura=asig;
		this.grupo=grupo;
	} 
	
	public Integer getCurso_academico() {
		return this.Curso_academico;
	}

	public void setCurso_academico(Integer Curso_academico) {
		this.Curso_academico = Curso_academico;
	}   
	public boolean getOferta() {
		return this.Oferta;
	}

	public void setOferta(boolean Oferta) {
		this.Oferta = Oferta;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Curso_academico == null) ? 0 : Curso_academico.hashCode());
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
		if (Curso_academico == null) {
			if (other.Curso_academico != null)
				return false;
		} else if (!Curso_academico.equals(other.Curso_academico))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Grupos_por_asignatura [Curso_academico=" + Curso_academico + ", Oferta=" + Oferta + "]";
	}
   
}
