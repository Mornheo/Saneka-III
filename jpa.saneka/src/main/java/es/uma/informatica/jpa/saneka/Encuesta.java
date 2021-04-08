package es.uma.informatica.jpa.saneka;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity

public class Encuesta implements Serializable {

	   
	@Id
	@Temporal(TemporalType.DATE)
	private Date Fecha_de_envio;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Expediente expediente;
	
	@ManyToMany
	@JoinTable
	private List<Grupos_por_asignatura> gpas;
	
	public Encuesta() {
		super();
	}   
	public Date getFecha_de_envio() {
		return this.Fecha_de_envio;
	}

	public void setFecha_de_envio(Date Fecha_de_envio) {
		this.Fecha_de_envio = Fecha_de_envio;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Fecha_de_envio == null) ? 0 : Fecha_de_envio.hashCode());
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
		if (Fecha_de_envio == null) {
			if (other.Fecha_de_envio != null)
				return false;
		} else if (!Fecha_de_envio.equals(other.Fecha_de_envio))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Encuesta [Fecha_de_envio=" + Fecha_de_envio + "]";
	}
   
}
