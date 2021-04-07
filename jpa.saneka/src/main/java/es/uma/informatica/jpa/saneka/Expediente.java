package es.uma.informatica.jpa.saneka;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Expediente
 *
 */
@Entity

public class Expediente implements Serializable {

	   
	@Id
	private Integer Num_expediente;
	private boolean Activo;
	private long Nota_media_provisional;
	private static final long serialVersionUID = 1L;

	public Expediente() {
		super();
	}   
	public Integer getNum_expediente() {
		return this.Num_expediente;
	}

	public void setNum_expediente(Integer Num_expediente) {
		this.Num_expediente = Num_expediente;
	}   
	public boolean getActivo() {
		return this.Activo;
	}

	public void setActivo(boolean Activo) {
		this.Activo = Activo;
	}   
	public long getNota_media_provisional() {
		return this.Nota_media_provisional;
	}

	public void setNota_media_provisional(long Nota_media_provisional) {
		this.Nota_media_provisional = Nota_media_provisional;
	}
   
}
