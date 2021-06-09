package es.uma.informatica.jpa.saneka;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Grupo.findAll", query = "select g from Grupo g")
public class Grupo implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id 
	private Integer id;
	@Column(unique=true,nullable=false)
	private Integer curso;
	//@Column(unique=true,nullable=false)
	@Column(nullable=false)
	private String letra;
	@Column(nullable=false)
	private String turno;
	private Boolean ingles;
	private Boolean visible;
	private String asignar;
	private Integer plazas;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Titulacion titulacion;
	@ManyToOne
	private Grupo grupos;
	@OneToMany(targetEntity=Clase.class,mappedBy="grupo")
	private List<Clase> clases;
	@OneToMany(targetEntity=GruposPorAsignatura.class,mappedBy="grupo")
	private List<GruposPorAsignatura> gruposAsignatura;
	@OneToMany(targetEntity=AsignaturasMatricula.class,mappedBy="grupo")
	private List<AsignaturasMatricula> asignaturasMatricula;
	public Grupo() {
		super();
	}
	public Grupo (Integer id,Integer curso,String letra,String turno,Boolean ingles,Titulacion tit) {
		this.id = id;
		this.curso = curso;
		this.letra = letra;
		this.turno = turno;
		this.ingles = ingles;
		titulacion = tit;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCurso() {
		return curso;
	}
	public void setCurso(Integer curso) {
		this.curso = curso;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public Boolean getIngles() {
		return ingles;
	}
	public void setIngles(Boolean ingles) {
		this.ingles = ingles;
	}
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	public String getAsignar() {
		return asignar;
	}
	public void setAsignar(String asignar) {
		this.asignar = asignar;
	}
	public Integer getPlazas() {
		return plazas;
	}
	public void setPlazas(Integer plazas) {
		this.plazas = plazas;
	}
	public Titulacion getTitulacion() {
		return titulacion;
	}
	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}
	public Grupo getGrupos() {
		return grupos;
	}
	public void setGrupos(Grupo grupos) {
		this.grupos = grupos;
	}
	public List<Clase> getClases() {
		return clases;
	}
	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}
	public List<GruposPorAsignatura> getGruposAsignatura() {
		return gruposAsignatura;
	}
	public void setGruposAsignatura(List<GruposPorAsignatura> gruposAsignatura) {
		this.gruposAsignatura = gruposAsignatura;
	}
	public List<AsignaturasMatricula> getAsignaturasMatricula() {
		return asignaturasMatricula;
	}
	public void setAsignaturasMatricula(List<AsignaturasMatricula> asignaturasMatricula) {
		this.asignaturasMatricula = asignaturasMatricula;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Grupo other = (Grupo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Grupo [id=" + id + ", curso=" + curso + ", letra=" + letra + ", turno=" + turno + ", ingles=" + ingles
				+ ", visible=" + visible + ", asignar=" + asignar + ", plazas=" + plazas + ", titulacion=" + titulacion
				+ ", grupos=" + grupos + ", clases=" + clases + ", gruposAsignatura=" + gruposAsignatura
				+ ", asignaturasMatricula=" + asignaturasMatricula + "]";
	}
		
}
