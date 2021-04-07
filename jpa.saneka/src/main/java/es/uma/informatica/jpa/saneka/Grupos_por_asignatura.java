package es.uma.informatica.jpa.saneka;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Grupos_por_asignatura
 *
 */
@Entity

public class Grupos_por_asignatura implements Serializable {

	   
	@Id
	private Integer Curso_academico;
	private boolean Oferta;
	private static final long serialVersionUID = 1L;

	public Grupos_por_asignatura() {
		super();
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
