package es.uma.informatica.jpa.saneka;

import es.uma.informatica.jpa.saneka.Asignatura;
import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Optativa
 *
 */
@Entity

public class Optativa extends Asignatura implements Serializable {

	
	private String Mencion;
	private static final long serialVersionUID = 1L;
	
	@ManyToMany
	private List<Titulacion> titulaciones;
	

	public Optativa() {
		super();
	} 
	public Optativa(Integer ref, Boolean ofe, Integer cod, Integer credT, Titulacion titu) {
		super(ref, ofe, cod, credT, titu);
	}  
	public String getMencion() {
		return this.Mencion;
	}

	public void setMencion(String Mencion) {
		this.Mencion = Mencion;
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	@Override
	public String toString() {
		return super.toString();
	}
   
}
