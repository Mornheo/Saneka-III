package es.uma.informatica.ejb.saneka;

import javax.ejb.Local;

import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.jpa.saneka.Optativa;

@Local
public interface GestionOptativa {
	
	public String mostrarOptativa(Optativa optativa) throws SanekaException;
	
	public void eliminarOptativa(Optativa optativa) throws SanekaException;
	
	public void insertarOptativa(Optativa optativa) throws SanekaException;
	
	public void modificarOptativa(Optativa optativa) throws SanekaException;
	
	public Optativa devolverOptativa(Integer ref) throws SanekaException;
	
}
