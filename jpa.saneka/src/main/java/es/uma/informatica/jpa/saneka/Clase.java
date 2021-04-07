package es.uma.informatica.jpa.saneka;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Clase implements Serializable {
	@EmbeddedId
	private ClaseId ID;
	private Date Hora_fin;
	private static final long serialVersionUID = 1L;
	public ClaseId getID() {
		return ID;
	}
	public void setID(ClaseId iD) {
		ID = iD;
	}
	public Date getHora_fin() {
		return Hora_fin;
	}
	public void setHora_fin(Date hora_fin) {
		Hora_fin = hora_fin;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
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
		Clase other = (Clase) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Clase [ID=" + ID + ", Hora_fin=" + Hora_fin + "]";
	}
	
	
	
	
}
