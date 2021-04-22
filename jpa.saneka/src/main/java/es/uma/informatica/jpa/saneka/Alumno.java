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

public class Alumno implements Serializable {

	   
	@Id
	private String DNI;
	@Column(unique=true,nullable=false)
	private String Nombre;
	@Column(unique=true,nullable=false)
	private String Apellido1;
	private String Apellido2;
	private Integer Num_expediente;
	private Integer Num_archivo;
	private String Email_institucional;
	private String Email_personal;
	private String Telefono;
	private String Movil;
	private String Direccion_notificacion;
	private String Localidad_notificacion;
	private String Provincia_notificaccion;
	private String CP_notificacion;
	private String Fecha_matricula;
	private String Turno_preferente;
	private String Grupos_asignados;
	private Double Nota_media;
	private Integer Creditos_superados;
	private Integer Creditos_FB;
	private Integer Creditos_OB;
	private Integer Creditos_OP;
	private Integer Creditos_CF;
	private Integer Creditos_PE;
	private Integer Creditos_TF;
	private static final long serialVersionUID = 1L;
	@OneToMany(targetEntity=Expediente.class,mappedBy="alumno")
	private List<Expediente> expedientes;
	
	public List<Expediente> getExpedientes() {
		return expedientes;
	}
	public void setExpedientes(List<Expediente> expedientes) {
		this.expedientes = expedientes;
	}
	public Alumno() {
		super();
	}   

	public String getDNI() {
		return this.DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public String getApellido1() {
		return this.Apellido1;
	}

	public void setApellido1(String Apellido1) {
		this.Apellido1 = Apellido1;
	}   
	public String getApellido2() {
		return this.Apellido2;
	}

	public void setApellido2(String Apellido2) {
		this.Apellido2 = Apellido2;
	}   
	public Integer getNum_expediente() {
		return this.Num_expediente;
	}

	public void setNum_expediente(Integer Num_expediente) {
		this.Num_expediente = Num_expediente;
	}   
	public Integer getNum_archivo() {
		return this.Num_archivo;
	}

	public void setNum_archivo(Integer Num_archivo) {
		this.Num_archivo = Num_archivo;
	}   
	public String getEmail_institucional() {
		return this.Email_institucional;
	}

	public void setEmail_institucional(String Email_institucional) {
		this.Email_institucional = Email_institucional;
	}   
	public String getEmail_personal() {
		return this.Email_personal;
	}

	public void setEmail_personal(String Email_personal) {
		this.Email_personal = Email_personal;
	}   
	public String getTelefono() {
		return this.Telefono;
	}

	public void setTelefono(String Telefono) {
		this.Telefono = Telefono;
	}   
	public String getMovil() {
		return this.Movil;
	}

	public void setMovil(String Movil) {
		this.Movil = Movil;
	}   
	public String getDireccion_notificacion() {
		return this.Direccion_notificacion;
	}

	public void setDireccion_notificacion(String Direccion_notificacion) {
		this.Direccion_notificacion = Direccion_notificacion;
	}   
	public String getLocalidad_notificacion() {
		return this.Localidad_notificacion;
	}

	public void setLocalidad_notificacion(String Localidad_notificacion) {
		this.Localidad_notificacion = Localidad_notificacion;
	}   
	public String getProvincia_notificaccion() {
		return this.Provincia_notificaccion;
	}

	public void setProvincia_notificaccion(String Provincia_notificaccion) {
		this.Provincia_notificaccion = Provincia_notificaccion;
	}   
	public String getCP_notificacion() {
		return this.CP_notificacion;
	}

	public void setCP_notificacion(String CP_notificacion) {
		this.CP_notificacion = CP_notificacion;
	}   
	public String getFecha_matricula() {
		return this.Fecha_matricula;
	}

	public void setFecha_matricula(String Fecha_matricula) {
		this.Fecha_matricula = Fecha_matricula;
	}   
	public String getTurno_preferente() {
		return this.Turno_preferente;
	}

	public void setTurno_preferente(String Turno_preferente) {
		this.Turno_preferente = Turno_preferente;
	}   
	public String getGrupos_asignados() {
		return this.Grupos_asignados;
	}

	public void setGrupos_asignados(String Grupos_asignados) {
		this.Grupos_asignados = Grupos_asignados;
	}   
	public Double getNota_media() {
		return this.Nota_media;
	}

	public void setNota_media(Double Nota_media) {
		this.Nota_media = Nota_media;
	}   
	public Integer getCreditos_superados() {
		return this.Creditos_superados;
	}

	public void setCreditos_superados(Integer Creditos_superados) {
		this.Creditos_superados = Creditos_superados;
	}   
	public Integer getCreditos_FB() {
		return this.Creditos_FB;
	}

	public void setCreditos_FB(Integer Creditos_FB) {
		this.Creditos_FB = Creditos_FB;
	}   
	public Integer getCreditos_OB() {
		return this.Creditos_OB;
	}

	public void setCreditos_OB(Integer Creditos_OB) {
		this.Creditos_OB = Creditos_OB;
	}   
	public Integer getCreditos_OP() {
		return this.Creditos_OP;
	}

	public void setCreditos_OP(Integer Creditos_OP) {
		this.Creditos_OP = Creditos_OP;
	}   
	public Integer getCreditos_CF() {
		return this.Creditos_CF;
	}

	public void setCreditos_CF(Integer Creditos_CF) {
		this.Creditos_CF = Creditos_CF;
	}   
	public Integer getCreditos_PE() {
		return this.Creditos_PE;
	}

	public void setCreditos_PE(Integer Creditos_PE) {
		this.Creditos_PE = Creditos_PE;
	}   
	public Integer getCreditos_TF() {
		return this.Creditos_TF;
	}

	public void setCreditos_TF(Integer Creditos_TF) {
		this.Creditos_TF = Creditos_TF;
	}
	
	public Alumno(Alumno a) {
		this.expedientes = a.getExpedientes();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Apellido1 == null) ? 0 : Apellido1.hashCode());
		result = prime * result + ((Apellido2 == null) ? 0 : Apellido2.hashCode());
		result = prime * result + ((CP_notificacion == null) ? 0 : CP_notificacion.hashCode());
		result = prime * result + ((Creditos_CF == null) ? 0 : Creditos_CF.hashCode());
		result = prime * result + ((Creditos_FB == null) ? 0 : Creditos_FB.hashCode());
		result = prime * result + ((Creditos_OB == null) ? 0 : Creditos_OB.hashCode());
		result = prime * result + ((Creditos_OP == null) ? 0 : Creditos_OP.hashCode());
		result = prime * result + ((Creditos_PE == null) ? 0 : Creditos_PE.hashCode());
		result = prime * result + ((Creditos_TF == null) ? 0 : Creditos_TF.hashCode());
		result = prime * result + ((Creditos_superados == null) ? 0 : Creditos_superados.hashCode());
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		result = prime * result + ((Direccion_notificacion == null) ? 0 : Direccion_notificacion.hashCode());
		result = prime * result + ((Email_institucional == null) ? 0 : Email_institucional.hashCode());
		result = prime * result + ((Email_personal == null) ? 0 : Email_personal.hashCode());
		result = prime * result + ((Fecha_matricula == null) ? 0 : Fecha_matricula.hashCode());
		result = prime * result + ((Grupos_asignados == null) ? 0 : Grupos_asignados.hashCode());
		result = prime * result + ((Localidad_notificacion == null) ? 0 : Localidad_notificacion.hashCode());
		result = prime * result + ((Movil == null) ? 0 : Movil.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((Nota_media == null) ? 0 : Nota_media.hashCode());
		result = prime * result + ((Num_archivo == null) ? 0 : Num_archivo.hashCode());
		result = prime * result + ((Num_expediente == null) ? 0 : Num_expediente.hashCode());
		result = prime * result + ((Provincia_notificaccion == null) ? 0 : Provincia_notificaccion.hashCode());
		result = prime * result + ((Telefono == null) ? 0 : Telefono.hashCode());
		result = prime * result + ((Turno_preferente == null) ? 0 : Turno_preferente.hashCode());
		result = prime * result + ((expedientes == null) ? 0 : expedientes.hashCode());
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
		if (Apellido1 == null) {
			if (other.Apellido1 != null)
				return false;
		} else if (!Apellido1.equals(other.Apellido1))
			return false;
		if (Apellido2 == null) {
			if (other.Apellido2 != null)
				return false;
		} else if (!Apellido2.equals(other.Apellido2))
			return false;
		if (CP_notificacion == null) {
			if (other.CP_notificacion != null)
				return false;
		} else if (!CP_notificacion.equals(other.CP_notificacion))
			return false;
		if (Creditos_CF == null) {
			if (other.Creditos_CF != null)
				return false;
		} else if (!Creditos_CF.equals(other.Creditos_CF))
			return false;
		if (Creditos_FB == null) {
			if (other.Creditos_FB != null)
				return false;
		} else if (!Creditos_FB.equals(other.Creditos_FB))
			return false;
		if (Creditos_OB == null) {
			if (other.Creditos_OB != null)
				return false;
		} else if (!Creditos_OB.equals(other.Creditos_OB))
			return false;
		if (Creditos_OP == null) {
			if (other.Creditos_OP != null)
				return false;
		} else if (!Creditos_OP.equals(other.Creditos_OP))
			return false;
		if (Creditos_PE == null) {
			if (other.Creditos_PE != null)
				return false;
		} else if (!Creditos_PE.equals(other.Creditos_PE))
			return false;
		if (Creditos_TF == null) {
			if (other.Creditos_TF != null)
				return false;
		} else if (!Creditos_TF.equals(other.Creditos_TF))
			return false;
		if (Creditos_superados == null) {
			if (other.Creditos_superados != null)
				return false;
		} else if (!Creditos_superados.equals(other.Creditos_superados))
			return false;
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equals(other.DNI))
			return false;
		if (Direccion_notificacion == null) {
			if (other.Direccion_notificacion != null)
				return false;
		} else if (!Direccion_notificacion.equals(other.Direccion_notificacion))
			return false;
		if (Email_institucional == null) {
			if (other.Email_institucional != null)
				return false;
		} else if (!Email_institucional.equals(other.Email_institucional))
			return false;
		if (Email_personal == null) {
			if (other.Email_personal != null)
				return false;
		} else if (!Email_personal.equals(other.Email_personal))
			return false;
		if (Fecha_matricula == null) {
			if (other.Fecha_matricula != null)
				return false;
		} else if (!Fecha_matricula.equals(other.Fecha_matricula))
			return false;
		if (Grupos_asignados == null) {
			if (other.Grupos_asignados != null)
				return false;
		} else if (!Grupos_asignados.equals(other.Grupos_asignados))
			return false;
		if (Localidad_notificacion == null) {
			if (other.Localidad_notificacion != null)
				return false;
		} else if (!Localidad_notificacion.equals(other.Localidad_notificacion))
			return false;
		if (Movil == null) {
			if (other.Movil != null)
				return false;
		} else if (!Movil.equals(other.Movil))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (Nota_media == null) {
			if (other.Nota_media != null)
				return false;
		} else if (!Nota_media.equals(other.Nota_media))
			return false;
		if (Num_archivo == null) {
			if (other.Num_archivo != null)
				return false;
		} else if (!Num_archivo.equals(other.Num_archivo))
			return false;
		if (Num_expediente == null) {
			if (other.Num_expediente != null)
				return false;
		} else if (!Num_expediente.equals(other.Num_expediente))
			return false;
		if (Provincia_notificaccion == null) {
			if (other.Provincia_notificaccion != null)
				return false;
		} else if (!Provincia_notificaccion.equals(other.Provincia_notificaccion))
			return false;
		if (Telefono == null) {
			if (other.Telefono != null)
				return false;
		} else if (!Telefono.equals(other.Telefono))
			return false;
		if (Turno_preferente == null) {
			if (other.Turno_preferente != null)
				return false;
		} else if (!Turno_preferente.equals(other.Turno_preferente))
			return false;
		if (expedientes == null) {
			if (other.expedientes != null)
				return false;
		} else if (!expedientes.equals(other.expedientes))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Alumno [DNI=" + DNI + ", Nombre=" + Nombre + ", Apellido1=" + Apellido1 + ", Apellido2=" + Apellido2
				+ ", Num_expediente=" + Num_expediente + ", Num_archivo=" + Num_archivo + ", Email_institucional="
				+ Email_institucional + ", Email_personal=" + Email_personal + ", Telefono=" + Telefono + ", Movil="
				+ Movil + ", Direccion_notificacion=" + Direccion_notificacion + ", Localidad_notificacion="
				+ Localidad_notificacion + ", Provincia_notificaccion=" + Provincia_notificaccion + ", CP_notificacion="
				+ CP_notificacion + ", Fecha_matricula=" + Fecha_matricula + ", Turno_preferente=" + Turno_preferente
				+ ", Grupos_asignados=" + Grupos_asignados + ", Nota_media=" + Nota_media + ", Creditos_superados="
				+ Creditos_superados + ", Creditos_FB=" + Creditos_FB + ", Creditos_OB=" + Creditos_OB
				+ ", Creditos_OP=" + Creditos_OP + ", Creditos_CF=" + Creditos_CF + ", Creditos_PE=" + Creditos_PE
				+ ", Creditos_TF=" + Creditos_TF + ", expedientes=" + expedientes + "]";
	}

	
   
	
	
}
