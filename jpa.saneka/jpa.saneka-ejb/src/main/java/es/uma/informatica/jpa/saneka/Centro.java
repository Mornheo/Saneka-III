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
import javax.persistence.NamedQuery;
@Entity
@NamedQuery(name = "Centro.findAll", query = "select cen from Centro cen")
public class Centro implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id 
	private Integer id;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String direccion;
	private String teleConsejeria;
	@ManyToMany
	//@JoinTable(name="Centro_Titulacion", joinColumns={ @JoinColumn(name="centro_id") }, inverseJoinColumns={ @JoinColumn(name="titulacion_id") })
	@JoinTable()
	private List<Titulacion> titulaciones;
	public Centro() {
		super();
	}
	public Centro (Integer id, String nombre, String dir) {
		this.id=id;
		this.nombre=nombre;
		direccion=dir;
	}
	
	public Centro(Integer id,String nombre,String direccion,String telefono, List<Titulacion> titu) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		teleConsejeria = telefono;
		titulaciones = titu;
	}
	public Centro(Integer id,String nombre,String direccion,String telefono) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		teleConsejeria = telefono;
	}
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
	public String getTeleConsejeria() {
		return teleConsejeria;
	}
	public void setTeleConsejeria(String teleConsejeria) {
		this.teleConsejeria = teleConsejeria;
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
		return "Centro [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", teleConsejeria="
				+ teleConsejeria + ", titulaciones=" + titulaciones + "]";
	}
	
	
	
}
