package es.uma.informatica.jpa.saneka;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity

public class Encuesta implements Serializable {

	   
	@Id
	private String fecha_de_envio;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn (nullable=false)
	private Expediente expediente;
	
	@ManyToMany
	@JoinTable
	private List<Grupos_por_asignatura> gpas;
	
	public Encuesta() {
		super();
	}  
	public Encuesta(String fecha, Expediente exp) {
		this.fecha_de_envio=fecha;
		this.expediente=exp;
	}   
	public String getFecha_de_envio() {
		return this.fecha_de_envio;
	}

	public void setFecha_de_envio(String fecha) {
		this.fecha_de_envio = fecha;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha_de_envio == null) ? 0 : fecha_de_envio.hashCode());
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
		Encuesta other = (Encuesta) obj;
		if (fecha_de_envio == null) {
			if (other.fecha_de_envio != null)
				return false;
		} else if (!fecha_de_envio.equals(other.fecha_de_envio))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Encuesta [Fecha_de_envio=" + fecha_de_envio + "]";
	}
   
}