package es.uma.informatica.jpa.saneka;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Asignatura
 *
 */
@Entity
@NamedQuery(name = "Asignatura.findAll", query = "select asig from Asignatura asig")
public class Asignatura implements Serializable {

	   
	@Id @Column(unique=true,nullable=false)
	private Integer referencia;
	@Column(nullable = false)
	private Boolean ofertada;
	@Column(nullable = false)
	private Integer codigo;
	private String nombre;
	private Integer curso;
	@Column(nullable = false)
	private Integer creditosTeoria;
	private Integer creditosPractica;
	private Integer totalCreditos;
	private String caracter;
	private String duracion;
	private String plazas;
	private String otro_idioma;
	
	
	@ManyToOne
	@JoinColumn (nullable = false)
	private Titulacion titulacion;
	@OneToMany(mappedBy = "asignatura")
	private List<Clase> clases;
	@OneToMany(mappedBy = "asignatura")
	private List<GruposPorAsignatura> grupos;
	@OneToMany(mappedBy ="asignatura")
	private List<AsignaturasMatricula> asignaturasMatricula;
	
	private static final long serialVersionUID = 1L;

	public Asignatura() {
		super();
	}  
	public Asignatura(Integer ref, Boolean ofe, Integer cod, Integer credT, Titulacion titu) {
		this.referencia=ref;
		this.ofertada=ofe;
		this.codigo=cod;
		this.creditosTeoria=credT;
		this.titulacion=titu;		
	}   
	public Integer getReferencia() {
		return this.referencia;
	}

	public void setReferencia(Integer Referencia) {
		this.referencia = Referencia;
	}   
	public Boolean getOfertada() {
		return this.ofertada;
	}

	public void setOfertada(Boolean Ofertada) {
		this.ofertada = Ofertada;
	}   
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCreditosTeoria() {
		return creditosTeoria;
	}
	public void setCreditosTeoria(Integer creditosTeoria) {
		this.creditosTeoria = creditosTeoria;
	}
	public Integer getCreditosPractica() {
		return creditosPractica;
	}
	public void setCreditosPractica(Integer creditosPractica) {
		this.creditosPractica = creditosPractica;
	}
	public Integer getCurso() {
		return this.curso;
	}

	public void setCurso(Integer Curso) {
		this.curso = Curso;
	}   
	public Integer getCreditos_teoria() {
		return this.creditosTeoria;
	}

	public void setCreditos_teoria(Integer Creditos_teoria) {
		this.creditosTeoria = Creditos_teoria;
	}   
	public Integer getCreditos_practica() {
		return this.creditosPractica;
	}

	public void setCreditos_practica(Integer Creditos_practica) {
		this.creditosPractica = Creditos_practica;
	}   
	public Integer getTotal_creditos() {
		return this.totalCreditos;
	}

	public void setTotal_creditos(Integer Total_creditos) {
		this.totalCreditos = Total_creditos;
	}   
	public String getCaracter() {
		return this.caracter;
	}

	public void setCaracter(String Caracter) {
		this.caracter = Caracter;
	}   
	public String getDuracion() {
		return this.duracion;
	}

	public void setDuracion(String Duracion) {
		this.duracion = Duracion;
	}   
	public String getPlazas() {
		return this.plazas;
	}

	public void setPlazas(String Plazas) {
		this.plazas = Plazas;
	}   
	public String getOtro_idioma() {
		return this.otro_idioma;
	}

	public void setOtro_idioma(String Otro_idioma) {
		this.otro_idioma = Otro_idioma;
	}
	
	
	public Titulacion getTitulacion() {
		return titulacion;
	}
	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}
	public List<Clase> getClases() {
		return clases;
	}
	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}
	public List<GruposPorAsignatura> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<GruposPorAsignatura> grupos) {
		this.grupos = grupos;
	}
	public List<AsignaturasMatricula> getAsignaturas_matricula() {
		return asignaturasMatricula;
	}
	public void setAsignaturas_matricula(List<AsignaturasMatricula> asignaturas_matricula) {
		this.asignaturasMatricula = asignaturas_matricula;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((referencia == null) ? 0 : referencia.hashCode());
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
		Asignatura other = (Asignatura) obj;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Asignatura [Referencia=" + referencia + ", Ofertada=" + ofertada + ", Codigo_1=" + codigo
				+ ", Asignatura=" + nombre + ", Curso=" + curso + ", Creditos_teoria=" + creditosTeoria
				+ ", Creditos_practica=" + creditosPractica + ", Total_creditos=" + totalCreditos + ", Caracter="
				+ caracter + ", Duracion=" + duracion + ", Plazas=" + plazas + ", Otro_idioma=" + otro_idioma + "]";
	}
	
	
   
}
