package es.uma.informatica.jpa.saneka;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Titulacion
 *
 */
@Entity

public class Titulacion implements Serializable {

	   
	@Id @Column(unique=true,nullable=false)
	private Integer codigo;
	private String nombre;
	private Integer creditos;
	
	@OneToMany(mappedBy = "titulacion")
	private List<Grupo> grupos;
	@OneToMany(mappedBy = "titulacion")
	private List<Expediente> expedientes;
	
	@ManyToMany(mappedBy = "titulaciones")
	@Column(nullable = false)
	private List<Centro> centros;
	
	@ManyToMany(mappedBy = "titulaciones")
	private List<Optativa> optativas;
	
	@OneToMany(mappedBy = "titulacion")
	private List<Asignatura> asignaturas;
	private static final long serialVersionUID = 1L;

	public Titulacion() {
		super();
	}   
	public Titulacion(Integer cod,String nom,Integer cre, List<Centro> centros) {
		this.codigo=cod;
		this.creditos = cre;
		this.nombre = nom;
		this.centros=centros;
	}   
	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer Codigo) {
		this.codigo = Codigo;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String Nombre) {
		this.nombre = Nombre;
	}   
	public Integer getCreditos() {
		return this.creditos;
	}

	public void setCreditos(Integer Creditos) {
		this.creditos = Creditos;
	}
	
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	public List<Expediente> getExpedientes() {
		return expedientes;
	}
	public void setExpedientes(List<Expediente> expedientes) {
		this.expedientes = expedientes;
	}
	public List<Centro> getCentros() {
		return centros;
	}
	public void setCentros(List<Centro> centros) {
		this.centros = centros;
	}
	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Titulacion other = (Titulacion) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Titulacion [Codigo=" + codigo + ", Nombre=" + nombre + ", Creditos=" + creditos + "]";
	}
   
}
