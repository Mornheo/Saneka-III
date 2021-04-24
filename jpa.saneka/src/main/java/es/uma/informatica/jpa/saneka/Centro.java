package es.uma.informatica.jpa.saneka;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Centro implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id @Column(unique=true,nullable=false)
	private Integer ID;
	@Column(nullable=false)
	private String Nombre;
	@Column(nullable=false)
	private String Direccion;
	private String TLF_consejeria;
	@ManyToMany
	//@JoinTable(name="Centro_Titulacion", joinColumns={ @JoinColumn(name="centro_id") }, inverseJoinColumns={ @JoinColumn(name="titulacion_id") })
	@JoinTable()
	private List<Titulacion> titulaciones;
	public Centro() {
		super();
	}
	public Centro (Integer id, String nombre, String dir) {
		ID=id;
		Nombre=nombre;
		Direccion=dir;
	}

	public Centro(Integer id,String nombre,String direccion,String telefono, List<Titulacion> titu) {
		ID = id;
		Nombre = nombre;
		Direccion = direccion;
		TLF_consejeria = telefono;
		titulaciones = titu;
	}
	public Centro(Integer id,String nombre,String direccion,String telefono) {
		ID = id;
		Nombre = nombre;
		Direccion = direccion;
		TLF_consejeria = telefono;
	}
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
	
	public List<Titulacion> getTitulaciones() {
		return titulaciones;
	}
	public void setTitulaciones(List<Titulacion> titulaciones) {
		this.titulaciones = titulaciones;
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
