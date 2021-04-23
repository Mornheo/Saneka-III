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
	private Integer Num_expediente;
	private Boolean Activo;
	private long Nota_media_provisional;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@Column(nullable=false)
	private Alumno alumno;
	@ManyToOne
	@Column(nullable=false)
	private Titulacion titulacion;
	@OneToMany (mappedBy="expediente")
	private List<Encuesta> encuestas;
	@OneToMany (mappedBy="expediente")
	private List<Matricula> matriculas;
	
	public Expediente() {
		super();
	}   
	public Expediente(Integer num, Titulacion titu, Alumno al) {
		this.Num_expediente = num;
		this.titulacion=titu;
		this.alumno=al;
	}   
	public Expediente(Integer num, Boolean active, long nota) {
		this.Activo = active;
		this.Nota_media_provisional = nota;
		this.Num_expediente = num;
	}  
	public Integer getNum_expediente() {
		return this.Num_expediente;
	}

	public void setNum_expediente(Integer Num_expediente) {
		this.Num_expediente = Num_expediente;
	}   
	public boolean getActivo() {
		return this.Activo;
	}

	public void setActivo(boolean Activo) {
		this.Activo = Activo;
	}   
	public long getNota_media_provisional() {
		return this.Nota_media_provisional;
	}

	public void setNota_media_provisional(long Nota_media_provisional) {
		this.Nota_media_provisional = Nota_media_provisional;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Num_expediente == null) ? 0 : Num_expediente.hashCode());
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
		if (Num_expediente == null) {
			if (other.Num_expediente != null)
				return false;
		} else if (!Num_expediente.equals(other.Num_expediente))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Expediente [Num_expediente=" + Num_expediente + ", Activo=" + Activo + ", Nota_media_provisional="
				+ Nota_media_provisional + "]";
	}
   
}
