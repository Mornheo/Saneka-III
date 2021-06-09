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
@NamedQuery(name = "Expediente.findAll", query = "select e from Expediente e")
public class Expediente implements Serializable {

	   
	@Id //@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private Integer numExpediente;
	private Boolean activo;
	private long notaMediaProvisional;
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
		this.numExpediente = num;
		this.titulacion=titu;
		this.alumno=al;
	}   
	public Expediente(Integer num, Boolean active, long nota) {
		this.activo = active;
		this.notaMediaProvisional = nota;
		this.numExpediente = num;
	}  
	public Integer getNumExpediente() {
		return this.numExpediente;
	}

	public void setNumExpediente(Integer num_expediente) {
		this.numExpediente = num_expediente;
	}   
	public boolean getActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}   
	public long getNotaMediaProvisional() {
		return this.notaMediaProvisional;
	}

	public void setNotaMediaProvisional(long nota) {
		this.notaMediaProvisional = nota;
	}
	
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	
	public Titulacion getTitulacion() {
		return titulacion;
	}
	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numExpediente == null) ? 0 : numExpediente.hashCode());
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
		if (numExpediente == null) {
			if (other.numExpediente != null)
				return false;
		} else if (!numExpediente.equals(other.numExpediente))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Expediente [Num_expediente=" + numExpediente + ", Activo=" + activo + ", Nota_media_provisional="
				+ notaMediaProvisional + "]";
	}
   
}
