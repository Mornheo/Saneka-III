package es.uma.informatica.ejb.saneka;






import java.util.List;


import javax.ejb.Local;

import es.uma.informatica.ejb.exceptions.ContraseniaInvalidaException;
import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.ejb.exceptions.UsuarioExistenteException;
import es.uma.informatica.ejb.exceptions.UsuarioNoEncontradoException;
import es.uma.informatica.jpa.saneka.Usuario;

@Local
public interface GestionUsuario {
    public void compruebaLogin(Usuario u) throws UsuarioNoEncontradoException, ContraseniaInvalidaException;
    public Usuario refrescarUsuario(Usuario u) throws SanekaException;
	public String mostrarUsuario(String email) throws SanekaException;
	public void eliminarUsuario(String email) throws UsuarioNoEncontradoException ;
	public void insertarUsuario(Usuario user) throws UsuarioExistenteException;
	public void modificarUsuario(String email,String cons) throws UsuarioNoEncontradoException ;
	public Usuario devolverUsuario(String email) throws UsuarioNoEncontradoException ;
	public List<Usuario> devolverUsuarios() throws SanekaException;
}
