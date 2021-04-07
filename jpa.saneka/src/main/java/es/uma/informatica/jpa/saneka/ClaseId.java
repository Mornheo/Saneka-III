package es.uma.informatica.jpa.saneka;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
@Embeddable
public class ClaseId implements Serializable{
	private Integer Dia;
	private Date Hora_inicio;
	private static final long serialVersionUID = 1L;
		
	public Integer getDia() {
			return Dia;
	}
	public void setDia(Integer dia) {
			Dia = dia;
	}
	public Date getHora_inicio() {
			return Hora_inicio;
	}
	public void setHora_inicio(Date hora_inicio) {
			Hora_inicio = hora_inicio;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Dia == null) ? 0 : Dia.hashCode());
		result = prime * result + ((Hora_inicio == null) ? 0 : Hora_inicio.hashCode());
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
		ClaseId other = (ClaseId) obj;
		if (Dia == null) {
			if (other.Dia != null)
				return false;
		} else if (!Dia.equals(other.Dia))
			return false;
		if (Hora_inicio == null) {
			if (other.Hora_inicio != null)
				return false;
		} else if (!Hora_inicio.equals(other.Hora_inicio))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ClaseId [Dia=" + Dia + ", Hora_inicio=" + Hora_inicio + "]";
	}
	
	

}
