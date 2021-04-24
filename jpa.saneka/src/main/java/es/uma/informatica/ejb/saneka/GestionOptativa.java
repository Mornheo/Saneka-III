package es.uma.informatica.ejb.saneka;

import javax.ejb.Local;

import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.jpa.saneka.Optativa;

@Local
public interface GestionOptativa {
	
	public String mostrarOptativa(Integer ref) throws SanekaException;
	
	public void eliminarOptativa(Integer ref) throws SanekaException;
	
	public void insertarOptativa(Integer ref, Optativa optativa) throws SanekaException;
	
	public void modificarOptativa(Integer ref, Optativa optativa) throws SanekaException;
	
	public Optativa devolverOptativa(Integer ref) throws SanekaException;
	
}
