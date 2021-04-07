package es.uma.informatica.jpa.saneka;
import javax.persistence.*;
@Entity
public class Centro {
	@Id@GeneratedValue
	private int id;
	private String nombre;
	private String direccion;
	private String TLF_consejeria;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
		result = prime * result + ((TLF_consejeria == null) ? 0 : TLF_consejeria.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		if (TLF_consejeria == null) {
			if (other.TLF_consejeria != null)
				return false;
		} else if (!TLF_consejeria.equals(other.TLF_consejeria))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Centro [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", TLF_consejeria="
				+ TLF_consejeria + "]";
	}
	
	
}
