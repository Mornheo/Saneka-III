package es.uma.informatica.jpa.saneka;

import java.io.Serializable;
import java.lang.Integer;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Expediente
 *
 */
@Entity

public class Expediente implements Serializable {

	   
	@Id //@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private Integer num_expediente;
	private Boolean activo;
	private long nota_media_provisional;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Alumno alumno;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Titulacion titulacion;
	@OneToMany (mappedBy="expediente")
	private List<Encuesta> encuestas;
	@OneToMany (mappedBy="expediente")
	private List<Matricula> matriculas;
	
	public Expediente() {
		super();
	}   
	public Expediente(Integer num, Titulacion titu, Alumno al) {
		this.num_expediente = num;
		this.titulacion=titu;
		this.alumno=al;
	}   
	public Expediente(Integer num, Boolean active, long nota) {
		this.activo = active;
		this.nota_media_provisional = nota;
		this.num_expediente = num;
	}  
	public Integer getNum_expediente() {
		return this.num_expediente;
	}

	public void setNum_expediente(Integer num_expediente) {
		this.num_expediente = num_expediente;
	}   
	public boolean getActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}   
	public long getNota_media_provisional() {
		return this.nota_media_provisional;
	}

	public void setNota_media_provisional(long nota_media_provisional) {
		this.nota_media_provisional = nota_media_provisional;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((num_expediente == null) ? 0 : num_expediente.hashCode());
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
		Expediente other = (Expediente) obj;
		if (num_expediente == null) {
			if (other.num_expediente != null)
				return false;
		} else if (!num_expediente.equals(other.num_expediente))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Expediente [Num_expediente=" + num_expediente + ", Activo=" + activo + ", Nota_media_provisional="
				+ nota_media_provisional + "]";
	}
   
}
