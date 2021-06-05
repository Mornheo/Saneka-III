package es.uma.informatica.jpa.saneka;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
/**
 * Entity implementation class for Entity: Matricula
 *
 */
@Entity
@IdClass(Matricula.MatriculaId.class)
public class Matricula implements Serializable {
	   
	@Id
	private String cursoAcademico;
	private String estado;
	private Integer numArchivo;
	private String turnoPreferente;
	@Column(nullable=false)
	private String fechaMatricula;
	private String nuevoIngreso;
	private String listadoAsignaturas;
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(nullable=false)
	private Expediente expediente;
	@OneToMany(mappedBy = "matricula")
	@Column(nullable=false)
	private List<Asignaturas_matricula> asignaturasMatriculas;
	
	public static class MatriculaId implements Serializable {
		private static final long serialVersionUID = 1L;
		private int expediente;
		private String cursoAcademico;
		
		public MatriculaId() {
			super();
		}
		
		public MatriculaId(String ref,Integer exp) {
			super();
			this.cursoAcademico=ref;
			this.expediente=exp;
		}
		
		public int getExpediente() {
			return expediente;
		}
		public void setExpediente(int expediente) {
			this.expediente = expediente;
		}
		public String getCurso_academico() {
			return cursoAcademico;
		}
		public void setCurso_academico(String curso_academico) {
			cursoAcademico = curso_academico;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((cursoAcademico == null) ? 0 : cursoAcademico.hashCode());
			result = prime * result + expediente;
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
			MatriculaId other = (MatriculaId) obj;
			if (cursoAcademico == null) {
				if (other.cursoAcademico != null)
					return false;
			} else if (!cursoAcademico.equals(other.cursoAcademico))
				return false;
			if (expediente != other.expediente)
				return false;
			return true;
		}
		
		
	}
	
	
	
	public Expediente getExpedientes() {
		return expediente;
	}
	
	public void setExpedientes(Expediente expedientes) {
		this.expediente = expedientes;
	}
	
	public Matricula() {
		super();
	}   
	
	public Matricula(String curso, String fecha, Expediente exp) {
		this.cursoAcademico=curso;
		this.fechaMatricula=fecha;
		this.expediente=exp;
	}

	public String getCursoAcademico() {
		return cursoAcademico;
	}

	public void setCursoAcademico(String cursoAcademico) {
		this.cursoAcademico = cursoAcademico;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getNumArchivo() {
		return numArchivo;
	}

	public void setNumArchivo(Integer numArchivo) {
		this.numArchivo = numArchivo;
	}

	public String getTurnoPreferente() {
		return turnoPreferente;
	}

	public void setTurnoPreferente(String turnoPreferente) {
		this.turnoPreferente = turnoPreferente;
	}

	public String getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(String fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public String getNuevoIngreso() {
		return nuevoIngreso;
	}

	public void setNuevoIngreso(String nuevoIngreso) {
		this.nuevoIngreso = nuevoIngreso;
	}

	public String getListadoAsignaturas() {
		return listadoAsignaturas;
	}

	public void setListadoAsignaturas(String listadoAsignaturas) {
		this.listadoAsignaturas = listadoAsignaturas;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public List<Asignaturas_matricula> getAsignaturas_matriculas() {
		return asignaturasMatriculas;
	}

	public void setAsignaturas_matriculas(List<Asignaturas_matricula> asignaturas_matriculas) {
		this.asignaturasMatriculas = asignaturas_matriculas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asignaturasMatriculas == null) ? 0 : asignaturasMatriculas.hashCode());
		result = prime * result + ((cursoAcademico == null) ? 0 : cursoAcademico.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((expediente == null) ? 0 : expediente.hashCode());
		result = prime * result + ((fechaMatricula == null) ? 0 : fechaMatricula.hashCode());
		result = prime * result + ((listadoAsignaturas == null) ? 0 : listadoAsignaturas.hashCode());
		result = prime * result + ((nuevoIngreso == null) ? 0 : nuevoIngreso.hashCode());
		result = prime * result + ((numArchivo == null) ? 0 : numArchivo.hashCode());
		result = prime * result + ((turnoPreferente == null) ? 0 : turnoPreferente.hashCode());
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
		Matricula other = (Matricula) obj;
		if (asignaturasMatriculas == null) {
			if (other.asignaturasMatriculas != null)
				return false;
		} else if (!asignaturasMatriculas.equals(other.asignaturasMatriculas))
			return false;
		if (cursoAcademico == null) {
			if (other.cursoAcademico != null)
				return false;
		} else if (!cursoAcademico.equals(other.cursoAcademico))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (expediente == null) {
			if (other.expediente != null)
				return false;
		} else if (!expediente.equals(other.expediente))
			return false;
		if (fechaMatricula == null) {
			if (other.fechaMatricula != null)
				return false;
		} else if (!fechaMatricula.equals(other.fechaMatricula))
			return false;
		if (listadoAsignaturas == null) {
			if (other.listadoAsignaturas != null)
				return false;
		} else if (!listadoAsignaturas.equals(other.listadoAsignaturas))
			return false;
		if (nuevoIngreso == null) {
			if (other.nuevoIngreso != null)
				return false;
		} else if (!nuevoIngreso.equals(other.nuevoIngreso))
			return false;
		if (numArchivo == null) {
			if (other.numArchivo != null)
				return false;
		} else if (!numArchivo.equals(other.numArchivo))
			return false;
		if (turnoPreferente == null) {
			if (other.turnoPreferente != null)
				return false;
		} else if (!turnoPreferente.equals(other.turnoPreferente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Matricula [cursoAcademico=" + cursoAcademico + ", estado=" + estado + ", numArchivo=" + numArchivo
				+ ", turnoPreferente=" + turnoPreferente + ", fechaMatricula=" + fechaMatricula + ", nuevoIngreso="
				+ nuevoIngreso + ", listadoAsignaturas=" + listadoAsignaturas + ", expediente=" + expediente
				+ ", asignaturas_matriculas=" + asignaturasMatriculas + "]";
	} 
	

   
}
