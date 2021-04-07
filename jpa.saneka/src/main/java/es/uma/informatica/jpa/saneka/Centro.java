package es.uma.informatica.jpa.saneka;
import javax.persistence.*;
@Entity
public class Centro {
	@Id@GeneratedValue
	private Integer ID;
	@Column(unique=true,nullable=false)
	private String Nombre;
	@Column(nullable=false)
	private String Direccion;
	private String TLF_consejeria;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getTLF_consejeria() {
		return TLF_consejeria;
	}
	public void setTLF_consejeria(String tLF_consejeria) {
		TLF_consejeria = tLF_consejeria;
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
		Centro other = (Centro) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Centro [ID=" + ID + ", Nombre=" + Nombre + ", Direccion=" + Direccion + ", TLF_consejeria="
				+ TLF_consejeria + "]";
	}
	
	
}
