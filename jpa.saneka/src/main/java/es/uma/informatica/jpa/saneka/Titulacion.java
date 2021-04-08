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

	   
	@Id @Column(nullable = false)
	private Integer Codigo;
	private String Nombre;
	private Integer Creditos;
	
	@OneToMany(mappedBy = "titulacion")
	private List<Grupo> grupos;
	@OneToMany(mappedBy = "titulacion")
	private List<Expediente> expedientes;
	
	@ManyToMany(mappedBy = "titulaciones")
	@JoinColumn(nullable = false)
	private List<Centro> centros;
	
	@OneToMany(mappedBy = "titulacion")
	private List<Asignatura> asignaturas;
	private static final long serialVersionUID = 1L;

	public Titulacion() {
		super();
	}   
	public Integer getCodigo() {
		return this.Codigo;
	}

	public void setCodigo(Integer Codigo) {
		this.Codigo = Codigo;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public Integer getCreditos() {
		return this.Creditos;
	}

	public void setCreditos(Integer Creditos) {
		this.Creditos = Creditos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Codigo == null) ? 0 : Codigo.hashCode());
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
		if (Codigo == null) {
			if (other.Codigo != null)
				return false;
		} else if (!Codigo.equals(other.Codigo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Titulacion [Codigo=" + Codigo + ", Nombre=" + Nombre + ", Creditos=" + Creditos + "]";
	}
   
}
