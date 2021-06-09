package es.uma.informatica.ejb.saneka;

import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.ejb.exceptions.CentroExistenteException;
import es.uma.informatica.ejb.exceptions.CentroNoEncontradoException;
import es.uma.informatica.jpa.saneka.Centro;
import es.uma.informatica.jpa.saneka.Usuario;
@Local
public interface GestionCentro {
	public void insertarCentro(Centro centro) throws CentroExistenteException;
	public void actualizarCentro(Integer id,Centro centro) throws CentroNoEncontradoException;
	public void eliminarCentro(Integer id) throws CentroNoEncontradoException;
	public String mostrarCentro(Centro centro);
	public Centro obtenerCentro(Integer id) throws CentroNoEncontradoException;
	public List<Centro> devolverCentros();
}
