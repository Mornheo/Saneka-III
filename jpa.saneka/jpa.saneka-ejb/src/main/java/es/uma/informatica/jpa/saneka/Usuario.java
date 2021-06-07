package es.uma.informatica.jpa.saneka;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public abstract class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String emailInstitucional;
    @XmlTransient
    @JsonbTransient
    private String contrasenia;
    
    public Usuario() {
    	super();
    }
    public Usuario(String email, String pass) {
    	emailInstitucional = email;
    	contrasenia = pass;
    }
	public String getEmailInstitucional() {
		return emailInstitucional;
	}
	public void setEmailInstitucional(String emailInstitucional) {
		this.emailInstitucional = emailInstitucional;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailInstitucional == null) ? 0 : emailInstitucional.hashCode());
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
		Usuario other = (Usuario) obj;
		if (emailInstitucional == null) {
			if (other.emailInstitucional != null)
				return false;
		} else if (!emailInstitucional.equals(other.emailInstitucional))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Usuario [emailInstitucional=" + emailInstitucional + ", contrasenia=" + contrasenia + "]";
	}
    
}
