package es.uma.informatica.ejb.saneka;

import javax.ejb.Local;

import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.jpa.saneka.Usuario;
@Local
public interface GestionUsuario {
    
    public void compruebaLogin(Usuario u) throws SanekaException;
    public Usuario refrescarUsuario(Usuario u) throws SanekaException;
	public String mostrarUsuario(String email) throws SanekaException;
	public void eliminarUsuario(String email) throws SanekaException;
	public void insertarUsuario(Usuario user) throws SanekaException;
	public void modificarUsuario(String email,String cons) throws SanekaException;
	public Usuario devolverUsuario(String email) throws SanekaException;

}
