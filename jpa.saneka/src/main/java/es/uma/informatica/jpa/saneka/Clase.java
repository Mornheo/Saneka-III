package es.uma.informatica.jpa.saneka;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@IdClass(Clase.ClaseId.class)
public class Clase implements Serializable {
	public static class ClaseId implements Serializable {
		private static final long serialVersionUID = 1L;
		private int Dia;
		private Date Hora_inicio;
		private int grupo;
		public ClaseId() {}
		public ClaseId(int dia,Date hora,int grupo) {
			super();
			Dia = dia;
			Hora_inicio = hora;
			this.grupo = grupo;
		}
		public int getDia() {
			return Dia;
		}

		public void setDia(int dia) {
			Dia = dia;
		}

		public Date getHora_inicio() {
			return Hora_inicio;
		}

		public void setHora_inicio(Date hora_inicio) {
			Hora_inicio = hora_inicio;
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
			result = prime * result + Dia;
			result = prime * result + ((Hora_inicio == null) ? 0 : Hora_inicio.hashCode());
			result = prime * result + grupo;
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
			if (Dia != other.Dia)
				return false;
			if (Hora_inicio == null) {
				if (other.Hora_inicio != null)
					return false;
			} else if (!Hora_inicio.equals(other.Hora_inicio))
				return false;
			if (grupo != other.grupo)
				return false;
			return true;
		}
		
	}
	@Id
	private int Dia;
	@Id
	@Temporal(TemporalType.DATE)
	private Date Hora_inicio;
	@Id
	@ManyToOne
	@JoinColumn(nullable=false)
	private Grupo grupo;
	@Temporal(TemporalType.DATE)
	private Date Hora_fin;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Asignatura asignatura;
	private static final long serialVersionUID = 1L;
	public int getDia() {
		return Dia;
	}
	public void setDia(int dia) {
		Dia = dia;
	}
	public Date getHora_inicio() {
		return Hora_inicio;
	}
	public void setHora_inicio(Date hora_inicio) {
		Hora_inicio = hora_inicio;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public Date getHora_fin() {
		return Hora_fin;
	}
	public void setHora_fin(Date hora_fin) {
		Hora_fin = hora_fin;
	}
	
	public Asignatura getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	
	@Override
	public String toString() {
		return "Clase [Dia=" + Dia + ", Hora_inicio=" + Hora_inicio + ", grupo=" + grupo + ", Hora_fin=" + Hora_fin
				+ "]";
	}	
}
