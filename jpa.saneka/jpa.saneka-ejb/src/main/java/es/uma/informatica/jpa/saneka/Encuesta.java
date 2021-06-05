package es.uma.informatica.jpa.saneka;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity

public class Encuesta implements Serializable {

	   
	@Id
	private String fechaDeEnvio;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn (nullable=false)
	private Expediente expediente;
	
	@ManyToMany
	@JoinTable
	private List<GruposPorAsignatura> gpas;
	
	public Encuesta() {
		super();
	}  
	public Encuesta(String fecha, Expediente exp) {
		this.fechaDeEnvio=fecha;
		this.expediente=exp;
	}   
	public String getFechaDeEnvio() {
		return this.fechaDeEnvio;
	}

	public void setFechaDeEnvio(String fecha) {
		this.fechaDeEnvio = fecha;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaDeEnvio == null) ? 0 : fechaDeEnvio.hashCode());
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
		if (fechaDeEnvio == null) {
			if (other.fechaDeEnvio != null)
				return false;
		} else if (!fechaDeEnvio.equals(other.fechaDeEnvio))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Encuesta [Fecha_de_envio=" + fechaDeEnvio + "]";
	}
   
}
