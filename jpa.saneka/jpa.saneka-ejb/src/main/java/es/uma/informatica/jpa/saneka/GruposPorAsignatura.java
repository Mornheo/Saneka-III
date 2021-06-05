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
@IdClass(GruposPorAsignatura.GruposPorAsignaturaId.class)
public class GruposPorAsignatura implements Serializable {
	@Id
	private Integer cursoAcademico;
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
	public static class GruposPorAsignaturaId implements Serializable {

		private static final long serialVersionUID = 1L;
		private int cursoAcademico;
		private int asignatura;
		private int grupo;
		public GruposPorAsignaturaId() {
			super();
		}
		public GruposPorAsignaturaId(Integer curso, Integer asig, Integer grupo) {
			this.cursoAcademico=curso;
			this.asignatura=asig;
			this.grupo=grupo;
		}
		public int getCursoAcademico() {
			return cursoAcademico;
		}
		public void setCursoAcademico(int curso) {
			cursoAcademico = curso;
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
			result = prime * result + cursoAcademico;
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
			GruposPorAsignaturaId other = (GruposPorAsignaturaId) obj;
			if (cursoAcademico != other.cursoAcademico)
				return false;
			if (asignatura != other.asignatura)
				return false;
			if (grupo != other.grupo)
				return false;
			return true;
		}
		
	}

	public GruposPorAsignatura() {
		super();
	}  
	public GruposPorAsignatura(Integer curso, Asignatura asig, Grupo grupo) {
		this.cursoAcademico=curso;
		this.asignatura=asig;
		this.grupo=grupo;
	} 
	
	public Integer getCursoAcademico() {
		return this.cursoAcademico;
	}

	public void setCursoAcademico(Integer Curso_academico) {
		this.cursoAcademico = Curso_academico;
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
		result = prime * result + ((cursoAcademico == null) ? 0 : cursoAcademico.hashCode());
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
		GruposPorAsignatura other = (GruposPorAsignatura) obj;
		if (cursoAcademico == null) {
			if (other.cursoAcademico != null)
				return false;
		} else if (!cursoAcademico.equals(other.cursoAcademico))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Grupos_por_asignatura [Curso_academico=" + cursoAcademico + ", Oferta=" + Oferta + "]";
	}
   
}
