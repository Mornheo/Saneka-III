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
	private String Curso_academico;
	private String Estado;
	private Integer Num_archivo;
	private String Turno_preferente;
	@Column(nullable=false)
	private String Fecha_matricula;
	private String Nuevo_ingreso;
	private String Listado_asignaturas;
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(nullable=false)
	private Expediente expediente;
	@OneToMany(mappedBy = "matricula")
	@JoinColumn(nullable=false)
	private List<Asignaturas_matricula> asignaturas_matriculas;
	
	public static class MatriculaId implements Serializable {
		private static final long serialVersionUID = 1L;
		private int expediente;
		private String Curso_academico;
		
		public int getExpediente() {
			return expediente;
		}
		public void setExpediente(int expediente) {
			this.expediente = expediente;
		}
		public String getCurso_academico() {
			return Curso_academico;
		}
		public void setCurso_academico(String curso_academico) {
			Curso_academico = curso_academico;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((Curso_academico == null) ? 0 : Curso_academico.hashCode());
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
			if (Curso_academico == null) {
				if (other.Curso_academico != null)
					return false;
			} else if (!Curso_academico.equals(other.Curso_academico))
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
	public String getCurso_academico() {
		return this.Curso_academico;
	}

	public void setCurso_academico(String Curso_academico) {
		this.Curso_academico = Curso_academico;
	}   
	public String getEstado() {
		return this.Estado;
	}

	public void setEstado(String Estado) {
		this.Estado = Estado;
	}   
	public Integer getNum_archivo() {
		return this.Num_archivo;
	}

	public void setNum_archivo(Integer Num_archivo) {
		this.Num_archivo = Num_archivo;
	}   
	public String getTurno_preferente() {
		return this.Turno_preferente;
	}

	public void setTurno_preferente(String Turno_preferente) {
		this.Turno_preferente = Turno_preferente;
	}   
	public String getFecha_matricula() {
		return this.Fecha_matricula;
	}

	public void setFecha_matricula(String Fecha_matricula) {
		this.Fecha_matricula = Fecha_matricula;
	}   
	public String getNuevo_ingreso() {
		return this.Nuevo_ingreso;
	}

	public void setNuevo_ingreso(String Nuevo_ingreso) {
		this.Nuevo_ingreso = Nuevo_ingreso;
	}   
	public String getListado_asignaturas() {
		return this.Listado_asignaturas;
	}

	public void setListado_asignaturas(String Listado_asignaturas) {
		this.Listado_asignaturas = Listado_asignaturas;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Curso_academico == null) ? 0 : Curso_academico.hashCode());
		result = prime * result + ((Estado == null) ? 0 : Estado.hashCode());
		result = prime * result + ((Fecha_matricula == null) ? 0 : Fecha_matricula.hashCode());
		result = prime * result + ((Listado_asignaturas == null) ? 0 : Listado_asignaturas.hashCode());
		result = prime * result + ((Nuevo_ingreso == null) ? 0 : Nuevo_ingreso.hashCode());
		result = prime * result + ((Num_archivo == null) ? 0 : Num_archivo.hashCode());
		result = prime * result + ((Turno_preferente == null) ? 0 : Turno_preferente.hashCode());
		result = prime * result + ((asignaturas_matriculas == null) ? 0 : asignaturas_matriculas.hashCode());
		result = prime * result + ((expediente == null) ? 0 : expediente.hashCode());
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
		if (Curso_academico == null) {
			if (other.Curso_academico != null)
				return false;
		} else if (!Curso_academico.equals(other.Curso_academico))
			return false;
		if (Estado == null) {
			if (other.Estado != null)
				return false;
		} else if (!Estado.equals(other.Estado))
			return false;
		if (Fecha_matricula == null) {
			if (other.Fecha_matricula != null)
				return false;
		} else if (!Fecha_matricula.equals(other.Fecha_matricula))
			return false;
		if (Listado_asignaturas == null) {
			if (other.Listado_asignaturas != null)
				return false;
		} else if (!Listado_asignaturas.equals(other.Listado_asignaturas))
			return false;
		if (Nuevo_ingreso == null) {
			if (other.Nuevo_ingreso != null)
				return false;
		} else if (!Nuevo_ingreso.equals(other.Nuevo_ingreso))
			return false;
		if (Num_archivo == null) {
			if (other.Num_archivo != null)
				return false;
		} else if (!Num_archivo.equals(other.Num_archivo))
			return false;
		if (Turno_preferente == null) {
			if (other.Turno_preferente != null)
				return false;
		} else if (!Turno_preferente.equals(other.Turno_preferente))
			return false;
		if (asignaturas_matriculas == null) {
			if (other.asignaturas_matriculas != null)
				return false;
		} else if (!asignaturas_matriculas.equals(other.asignaturas_matriculas))
			return false;
		if (expediente == null) {
			if (other.expediente != null)
				return false;
		} else if (!expediente.equals(other.expediente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Matricula [Curso_academico=" + Curso_academico + ", Estado=" + Estado + ", Num_archivo=" + Num_archivo
				+ ", Turno_preferente=" + Turno_preferente + ", Fecha_matricula=" + Fecha_matricula + ", Nuevo_ingreso="
				+ Nuevo_ingreso + ", Listado_asignaturas=" + Listado_asignaturas + "]";
	}
   
}
