package es.uma.informatica.sii.saneka.backing;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.ejb.saneka.GestionUsuario;
import es.uma.informatica.jpa.saneka.Usuario;

@Named(value = "usuarioVista")
@RequestScoped
public class UsuarioVista {
	@Inject 
	private  GestionUsuario gestion;
	public List<Usuario> listaUsuarios() throws SanekaException {
		return gestion.devolverUsuarios();
	}
	
}
