package es.uma.informatica.ejb.saneka;

import javax.ejb.Local;

import es.uma.informatica.ejb.exceptions.OptativaExistenteException;
import es.uma.informatica.ejb.exceptions.OptativaNoExistenteException;
import es.uma.informatica.jpa.saneka.Asignatura;
import es.uma.informatica.jpa.saneka.Optativa;

@Local
public interface GestionOptativa {
	
	public String mostrarOptativa(Optativa optativa) throws OptativaNoExistenteException;
	
	public void eliminarOptativa(Optativa optativa) throws OptativaNoExistenteException;
	
	public void insertarOptativa(Optativa optativa) throws OptativaExistenteException;
	
	public void modificarOptativa(Optativa optativa) throws OptativaNoExistenteException;
	
}
