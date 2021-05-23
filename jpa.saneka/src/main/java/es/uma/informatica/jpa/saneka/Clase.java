package es.uma.informatica.jpa.saneka;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@IdClass(Clase.ClaseId.class)
public class Clase implements Serializable {
	public static class ClaseId implements Serializable {
		private static final long serialVersionUID = 1L;
		private int dia;
		private String horaInicio;
		private int grupo;
		public ClaseId() {super();}
		public ClaseId(Integer dia,String hora,Integer grupo) {
			super();
			this.dia = dia;
			horaInicio = hora;
			this.grupo = grupo;
		}
		public int getDia() {
			return dia;
		}
		public void setDia(int dia) {
			this.dia = dia;
		}
		public String getHoraInicio() {
			return horaInicio;
		}
		public void setHoraInicio(String horaInicio) {
			this.horaInicio = horaInicio;
		}
		public int getGrupo() {
			return grupo;
		}
		public void setGrupo(int grupo) {
			this.grupo = grupo;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + dia;
			result = prime * result + grupo;
			result = prime * result + ((horaInicio == null) ? 0 : horaInicio.hashCode());
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
			ClaseId other = (ClaseId) obj;
			if (dia != other.dia)
				return false;
			if (grupo != other.grupo)
				return false;
			if (horaInicio == null) {
				if (other.horaInicio != null)
					return false;
			} else if (!horaInicio.equals(other.horaInicio))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "ClaseId [dia=" + dia + ", horaInicio=" + horaInicio + ", grupo=" + grupo + "]";
		}
		
	}
	@Id
	private int dia;
	@Id
	private String horaInicio;
	@Id
	@ManyToOne
	@JoinColumn(unique=true,nullable=false)
	private Grupo grupo;
	private String horaFin;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Asignatura asignatura;
	private static final long serialVersionUID = 1L;
	public Clase() {
		super();
	}
	public Clase(Integer dia, String hora, Asignatura asig, Grupo grupo) {
		this.dia=dia;
		this.horaInicio=hora;
		this.asignatura=asig;
		this.grupo=grupo;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public Asignatura getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	@Override
	public String toString() {
		return "Clase [dia=" + dia + ", horaInicio=" + horaInicio + ", grupo=" + grupo + ", horaFin=" + horaFin
				+ ", asignatura=" + asignatura + "]";
	}
}
