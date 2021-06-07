package es.uma.informatica.ejb.saneka;

import java.util.List;

import java.util.Random;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import es.uma.informatica.ejb.exceptions.ContraseniaInvalidaException;
import es.uma.informatica.ejb.exceptions.OptativaNoEncontradoException;
import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.ejb.exceptions.UsuarioExistenteException;
import es.uma.informatica.ejb.exceptions.UsuarioInactivoException;
import es.uma.informatica.ejb.exceptions.UsuarioNoEncontradoException;
import es.uma.informatica.jpa.saneka.Usuario;
import es.uma.informatica.ejb.exceptions.ValidacionIncorrectaException;

@Stateless
public class UsuarioEJB implements GestionUsuario{
	private static final int TAM_CADENA_VALIDACION = 20;
	@PersistenceContext(name="jpa.saneka")
	private EntityManager em;
	private boolean esAlumno;
	@Override
	public String mostrarUsuario(String email) throws SanekaException {
		Usuario existente = em.find(Usuario.class, email);
		if (existente==null) {
			throw new UsuarioNoEncontradoException();
		}
		String res = existente.toString();
		//System.out.println(res);
		return res;
	}

	@Override
	public void eliminarUsuario(String email) throws SanekaException {
		// TODO Auto-generated method stub
		Usuario u = devolverUsuario(email);
		em.remove(u);
	}

	@Override
	public void insertarUsuario(Usuario user) throws SanekaException {
		// TODO Auto-generated method stub
		Usuario u = em.find(Usuario.class,user.getEmailInstitucional());
		if(u!= null) {
			throw new UsuarioExistenteException();
		}
		em.persist(u);
	}

	@Override
	public void modificarUsuario(String email,String cons) throws SanekaException {
		// TODO Auto-generated method stub
		Usuario u = em.find(Usuario.class,email);
		if(u== null) {
			throw new UsuarioNoEncontradoException();
		}
		u.setContrasenia(cons);
		em.persist(u);
	}

	@Override
	public Usuario devolverUsuario(String email) throws SanekaException {
		Usuario u = em.find(Usuario.class, email);
		return u;
	}


	@Override
	public void compruebaLogin(Usuario u) throws SanekaException {
		// TODO Auto-generated method stub
    	Usuario user = em.find(Usuario.class, u.getEmailInstitucional());
        if (user == null) {
            throw new UsuarioNoEncontradoException();
        }
        if (!user.getContrasenia().equals(u.getContrasenia())) {
            throw new ContraseniaInvalidaException();
        }
	}

	@Override
	public Usuario refrescarUsuario(Usuario u) throws SanekaException {
		// TODO Auto-generated method stub
	 	compruebaLogin(u);
        Usuario user = em.find(Usuario.class, u.getEmailInstitucional());
        em.refresh(user);
        return user;
	}
	
	@Override
	public List<Usuario> devolverUsuarios() throws SanekaException {
		TypedQuery<Usuario> query =
			      em.createNamedQuery("Usuario.findAll",Usuario.class);
		List<Usuario> results = query.getResultList();
		return results;
	}

	
}
