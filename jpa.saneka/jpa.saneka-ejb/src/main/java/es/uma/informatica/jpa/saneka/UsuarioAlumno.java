package es.uma.informatica.jpa.saneka;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="UsuarioAlumno.findAll", query="SELECT ua FROM UsuarioAlumno ua")
public class UsuarioAlumno extends Usuario{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UsuarioAlumno() {
		super();
	}

}
