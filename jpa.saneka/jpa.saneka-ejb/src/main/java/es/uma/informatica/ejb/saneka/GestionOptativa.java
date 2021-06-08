package es.uma.informatica.ejb.saneka;

import javax.ejb.Local;

import es.uma.informatica.ejb.exceptions.OptativaExistenteException;
import es.uma.informatica.ejb.exceptions.OptativaNoEncontradoException;
import es.uma.informatica.jpa.saneka.Optativa;

@Local
public interface GestionOptativa {
	
	public String mostrarOptativa(Integer ref) throws OptativaNoEncontradoException;
	
	public void eliminarOptativa(Integer ref) throws OptativaNoEncontradoException;
	
	public void insertarOptativa(Integer ref, Optativa optativa) throws OptativaExistenteException;
	
	public void modificarOptativa(Integer ref, Optativa optativa) throws OptativaNoEncontradoException;
	
	public Optativa devolverOptativa(Integer ref) throws OptativaNoEncontradoException;
	
}
