package es.uma.informatica.ejb.saneka;

import javax.ejb.Local;

import es.uma.informatica.jpa.saneka.Asignatura;
import es.uma.informatica.jpa.saneka.Optativa;

@Local
public interface GestionOptativa {
	
	public String mostrarOptativa(Optativa optativa);
	
	public void eliminarOptativa(Optativa optativa);
	
	public void insertarOptativa(Optativa optativa);
	
	public void modificarOptativa(Optativa optativa);
	
}
