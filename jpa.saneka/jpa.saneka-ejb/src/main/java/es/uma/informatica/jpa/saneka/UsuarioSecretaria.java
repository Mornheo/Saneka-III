package es.uma.informatica.jpa.saneka;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="UsuarioSecretaria.findAll", query="SELECT us FROM UsuarioSecretaria us")
public class UsuarioSecretaria extends Usuario{

	private static final long serialVersionUID = 1L;
	public UsuarioSecretaria() {
		super();
	}
	public UsuarioSecretaria(String email, String pass) {  
    	super();
	}
}
