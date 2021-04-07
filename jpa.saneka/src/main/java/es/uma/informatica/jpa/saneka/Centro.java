package es.uma.informatica.jpa.saneka;
import javax.persistence.*;
@Entity
public class Centro {
	@Id@GeneratedValue
	private Integer id;
	private String nombre;
	private String direccion;
	private String TLF_consejeria;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Centro [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", TLF_consejeria="
				+ TLF_consejeria + "]";
	}
	
	
	
	
}
