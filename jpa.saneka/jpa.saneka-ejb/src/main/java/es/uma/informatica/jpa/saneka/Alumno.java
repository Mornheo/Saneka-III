package es.uma.informatica.jpa.saneka;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Alumnos
 *
 */
@Entity
@NamedQuery(name = "Alumno.findAll", query = "select a from Alumno a")
public class Alumno implements Serializable {

	   
	@Id
	private String dni;
	@Column(unique=true,nullable=false)
	private String nombre;
	@Column(unique=true,nullable=false)
	private String apellido1;
	private String apellido2;
	private Integer numExpediente;
	private Integer numArchivo;
	@Column(nullable=false)
	private String emailInstitucional;
	private String emailPersonal;
	private String telefono;
	private String movil;
	private String direccionNotificacion;
	private String localidadNotificacion;
	private String provinciaNotificaccion;
	private String cpNotificacion;
	private String fechaMatricula;
	private String turnoPreferente;
	private String gruposAsignados;
	private Double notaMedia;
	private Integer creditosSuperados;
	private Integer creditosFb;
	private Integer creditosOb;
	private Integer creditosOp;
	private Integer creditosCf;
	private Integer creditosPe;
	private Integer creditosTf;
	private static final long serialVersionUID = 1L;
	@OneToMany(targetEntity=Expediente.class,mappedBy="alumno")
	private List<Expediente> expedientes;
	@OneToOne(mappedBy = "alumno")
	private Usuario usuario;
	
	public List<Expediente> getExpedientes() {
		return expedientes;
	}
	public void setExpedientes(List<Expediente> expedientes) {
		this.expedientes = expedientes;
	}
	
	public Alumno() {
		super();
	}
	
	public Alumno(String dni, String nombre, String Apellido1, String email) {
		this.dni=dni;
		this.nombre=nombre;
		this.apellido1=Apellido1;
		this.emailInstitucional=email;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public Integer getNumExpediente() {
		return numExpediente;
	}
	public void setNumExpediente(Integer numExpediente) {
		this.numExpediente = numExpediente;
	}
	public Integer getNumArchivo() {
		return numArchivo;
	}
	public void setNumArchivo(Integer numArchivo) {
		this.numArchivo = numArchivo;
	}
	public String getEmailInstitucional() {
		return emailInstitucional;
	}
	public void setEmailInstitucional(String emailInstitucional) {
		this.emailInstitucional = emailInstitucional;
	}
	public String getEmailPersonal() {
		return emailPersonal;
	}
	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getMovil() {
		return movil;
	}
	public void setMovil(String movil) {
		this.movil = movil;
	}
	public String getDireccionNotificacion() {
		return direccionNotificacion;
	}
	public void setDireccionNotificacion(String direccionNotificacion) {
		this.direccionNotificacion = direccionNotificacion;
	}
	public String getLocalidadNotificacion() {
		return localidadNotificacion;
	}
	public void setLocalidadNotificacion(String localidadNotificacion) {
		this.localidadNotificacion = localidadNotificacion;
	}
	public String getProvinciaNotificaccion() {
		return provinciaNotificaccion;
	}
	public void setProvinciaNotificaccion(String provinciaNotificaccion) {
		this.provinciaNotificaccion = provinciaNotificaccion;
	}
	public String getCpNotificacion() {
		return cpNotificacion;
	}
	public void setCpNotificacion(String cpNotificacion) {
		this.cpNotificacion = cpNotificacion;
	}
	public String getFechaMatricula() {
		return fechaMatricula;
	}
	public void setFechaMatricula(String fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}
	public String getTurnoPreferente() {
		return turnoPreferente;
	}
	public void setTurnoPreferente(String turnoPreferente) {
		this.turnoPreferente = turnoPreferente;
	}
	public String getGruposAsignados() {
		return gruposAsignados;
	}
	public void setGruposAsignados(String gruposAsignados) {
		this.gruposAsignados = gruposAsignados;
	}
	public Double getNotaMedia() {
		return notaMedia;
	}
	public void setNotaMedia(Double notaMedia) {
		this.notaMedia = notaMedia;
	}
	public Integer getCreditosSuperados() {
		return creditosSuperados;
	}
	public void setCreditosSuperados(Integer creditosSuperados) {
		this.creditosSuperados = creditosSuperados;
	}
	public Integer getCreditosFb() {
		return creditosFb;
	}
	public void setCreditosFb(Integer creditosFb) {
		this.creditosFb = creditosFb;
	}
	public Integer getCreditosOb() {
		return creditosOb;
	}
	public void setCreditosOb(Integer creditosOb) {
		this.creditosOb = creditosOb;
	}
	public Integer getCreditosOp() {
		return creditosOp;
	}
	public void setCreditosOp(Integer creditosOp) {
		this.creditosOp = creditosOp;
	}
	public Integer getCreditosCf() {
		return creditosCf;
	}
	public void setCreditosCf(Integer creditosCf) {
		this.creditosCf = creditosCf;
	}
	public Integer getCreditosPe() {
		return creditosPe;
	}
	public void setCreditosPe(Integer creditosPe) {
		this.creditosPe = creditosPe;
	}
	public Integer getCreditosTf() {
		return creditosTf;
	}
	public void setCreditosTf(Integer creditosTf) {
		this.creditosTf = creditosTf;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido1 == null) ? 0 : apellido1.hashCode());
		result = prime * result + ((apellido2 == null) ? 0 : apellido2.hashCode());
		result = prime * result + ((cpNotificacion == null) ? 0 : cpNotificacion.hashCode());
		result = prime * result + ((creditosCf == null) ? 0 : creditosCf.hashCode());
		result = prime * result + ((creditosFb == null) ? 0 : creditosFb.hashCode());
		result = prime * result + ((creditosOb == null) ? 0 : creditosOb.hashCode());
		result = prime * result + ((creditosOp == null) ? 0 : creditosOp.hashCode());
		result = prime * result + ((creditosPe == null) ? 0 : creditosPe.hashCode());
		result = prime * result + ((creditosSuperados == null) ? 0 : creditosSuperados.hashCode());
		result = prime * result + ((creditosTf == null) ? 0 : creditosTf.hashCode());
		result = prime * result + ((direccionNotificacion == null) ? 0 : direccionNotificacion.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((emailInstitucional == null) ? 0 : emailInstitucional.hashCode());
		result = prime * result + ((emailPersonal == null) ? 0 : emailPersonal.hashCode());
		result = prime * result + ((expedientes == null) ? 0 : expedientes.hashCode());
		result = prime * result + ((fechaMatricula == null) ? 0 : fechaMatricula.hashCode());
		result = prime * result + ((gruposAsignados == null) ? 0 : gruposAsignados.hashCode());
		result = prime * result + ((localidadNotificacion == null) ? 0 : localidadNotificacion.hashCode());
		result = prime * result + ((movil == null) ? 0 : movil.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((notaMedia == null) ? 0 : notaMedia.hashCode());
		result = prime * result + ((numArchivo == null) ? 0 : numArchivo.hashCode());
		result = prime * result + ((numExpediente == null) ? 0 : numExpediente.hashCode());
		result = prime * result + ((provinciaNotificaccion == null) ? 0 : provinciaNotificaccion.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		result = prime * result + ((turnoPreferente == null) ? 0 : turnoPreferente.hashCode());
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
		Alumno other = (Alumno) obj;
		if (apellido1 == null) {
			if (other.apellido1 != null)
				return false;
		} else if (!apellido1.equals(other.apellido1))
			return false;
		if (apellido2 == null) {
			if (other.apellido2 != null)
				return false;
		} else if (!apellido2.equals(other.apellido2))
			return false;
		if (cpNotificacion == null) {
			if (other.cpNotificacion != null)
				return false;
		} else if (!cpNotificacion.equals(other.cpNotificacion))
			return false;
		if (creditosCf == null) {
			if (other.creditosCf != null)
				return false;
		} else if (!creditosCf.equals(other.creditosCf))
			return false;
		if (creditosFb == null) {
			if (other.creditosFb != null)
				return false;
		} else if (!creditosFb.equals(other.creditosFb))
			return false;
		if (creditosOb == null) {
			if (other.creditosOb != null)
				return false;
		} else if (!creditosOb.equals(other.creditosOb))
			return false;
		if (creditosOp == null) {
			if (other.creditosOp != null)
				return false;
		} else if (!creditosOp.equals(other.creditosOp))
			return false;
		if (creditosPe == null) {
			if (other.creditosPe != null)
				return false;
		} else if (!creditosPe.equals(other.creditosPe))
			return false;
		if (creditosSuperados == null) {
			if (other.creditosSuperados != null)
				return false;
		} else if (!creditosSuperados.equals(other.creditosSuperados))
			return false;
		if (creditosTf == null) {
			if (other.creditosTf != null)
				return false;
		} else if (!creditosTf.equals(other.creditosTf))
			return false;
		if (direccionNotificacion == null) {
			if (other.direccionNotificacion != null)
				return false;
		} else if (!direccionNotificacion.equals(other.direccionNotificacion))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (emailInstitucional == null) {
			if (other.emailInstitucional != null)
				return false;
		} else if (!emailInstitucional.equals(other.emailInstitucional))
			return false;
		if (emailPersonal == null) {
			if (other.emailPersonal != null)
				return false;
		} else if (!emailPersonal.equals(other.emailPersonal))
			return false;
		if (expedientes == null) {
			if (other.expedientes != null)
				return false;
		} else if (!expedientes.equals(other.expedientes))
			return false;
		if (fechaMatricula == null) {
			if (other.fechaMatricula != null)
				return false;
		} else if (!fechaMatricula.equals(other.fechaMatricula))
			return false;
		if (gruposAsignados == null) {
			if (other.gruposAsignados != null)
				return false;
		} else if (!gruposAsignados.equals(other.gruposAsignados))
			return false;
		if (localidadNotificacion == null) {
			if (other.localidadNotificacion != null)
				return false;
		} else if (!localidadNotificacion.equals(other.localidadNotificacion))
			return false;
		if (movil == null) {
			if (other.movil != null)
				return false;
		} else if (!movil.equals(other.movil))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (notaMedia == null) {
			if (other.notaMedia != null)
				return false;
		} else if (!notaMedia.equals(other.notaMedia))
			return false;
		if (numArchivo == null) {
			if (other.numArchivo != null)
				return false;
		} else if (!numArchivo.equals(other.numArchivo))
			return false;
		if (numExpediente == null) {
			if (other.numExpediente != null)
				return false;
		} else if (!numExpediente.equals(other.numExpediente))
			return false;
		if (provinciaNotificaccion == null) {
			if (other.provinciaNotificaccion != null)
				return false;
		} else if (!provinciaNotificaccion.equals(other.provinciaNotificaccion))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		if (turnoPreferente == null) {
			if (other.turnoPreferente != null)
				return false;
		} else if (!turnoPreferente.equals(other.turnoPreferente))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", numExpediente=" + numExpediente + ", numArchivo=" + numArchivo + ", emailInstitucional="
				+ emailInstitucional + ", emailPersonal=" + emailPersonal + ", telefono=" + telefono + ", movil="
				+ movil + ", direccionNotificacion=" + direccionNotificacion + ", localidadNotificacion="
				+ localidadNotificacion + ", provinciaNotificaccion=" + provinciaNotificaccion + ", cpNotificacion="
				+ cpNotificacion + ", fechaMatricula=" + fechaMatricula + ", turnoPreferente=" + turnoPreferente
				+ ", gruposAsignados=" + gruposAsignados + ", notaMedia=" + notaMedia + ", creditosSuperados="
				+ creditosSuperados + ", creditosFb=" + creditosFb + ", creditosOb=" + creditosOb + ", creditosOp="
				+ creditosOp + ", creditosCf=" + creditosCf + ", creditosPe=" + creditosPe + ", creditosTf="
				+ creditosTf + ", expedientes=" + expedientes + "]";
	}
	
	
	
   
	
	
}
