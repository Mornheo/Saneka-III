package es.uma.informatica.jpa.saneka;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String emailInstitucional;
    @XmlTransient
    @JsonbTransient
    private String contrasenia;
    @XmlTransient
    @JsonbTransient
    private String cadenaValidacion;
    
    public Usuario() {
    	super();
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
	public String getCadenaValidacion() {
		return cadenaValidacion;
	}
	public void setCadenaValidacion(String cadenaValidacion) {
		this.cadenaValidacion = cadenaValidacion;
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
		return "Usuario [emailInstitucional=" + emailInstitucional + ", contrasenia=" + contrasenia
				+ ", cadenaValidacion=" + cadenaValidacion + "]";
	}
    
}
