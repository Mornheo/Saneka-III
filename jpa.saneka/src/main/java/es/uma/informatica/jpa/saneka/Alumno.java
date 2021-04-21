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
	private Integer ID;
	@Column(unique=true,nullable=false)
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
	public Integer getID() {
		return this.ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
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
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
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
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Alumno [ID=" + ID + ", DNI=" + DNI + ", Nombre=" + Nombre + ", Apellido1=" + Apellido1 + ", Apellido2="
				+ Apellido2 + ", Num_expediente=" + Num_expediente + ", Num_archivo=" + Num_archivo
				+ ", Email_institucional=" + Email_institucional + ", Email_personal=" + Email_personal + ", Telefono="
				+ Telefono + ", Movil=" + Movil + ", Direccion_notificacion=" + Direccion_notificacion
				+ ", Localidad_notificacion=" + Localidad_notificacion + ", Provincia_notificaccion="
				+ Provincia_notificaccion + ", CP_notificacion=" + CP_notificacion + ", Fecha_matricula="
				+ Fecha_matricula + ", Turno_preferente=" + Turno_preferente + ", Grupos_asignados=" + Grupos_asignados
				+ ", Nota_media=" + Nota_media + ", Creditos_superados=" + Creditos_superados + ", Creditos_FB="
				+ Creditos_FB + ", Creditos_OB=" + Creditos_OB + ", Creditos_OP=" + Creditos_OP + ", Creditos_CF="
				+ Creditos_CF + ", Creditos_PE=" + Creditos_PE + ", Creditos_TF=" + Creditos_TF + "]";
	}
   
	
	
}
