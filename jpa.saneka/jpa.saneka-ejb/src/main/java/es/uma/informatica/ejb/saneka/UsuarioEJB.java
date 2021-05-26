package es.uma.informatica.ejb.saneka;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.exceptions.ContraseniaInvalidaException;
import es.uma.informatica.ejb.exceptions.OptativaNoEncontradoException;
import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.ejb.exceptions.UsuarioExistenteException;
import es.uma.informatica.ejb.exceptions.UsuarioInactivaException;
import es.uma.informatica.ejb.exceptions.UsuarioNoEncontradoException;
import es.uma.informatica.jpa.saneka.Usuario;
import es.uma.informatica.ejb.exceptions.ValidacionIncorrectaException;

public class UsuarioEJB implements GestionUsuario{
	private static final int TAM_CADENA_VALIDACION = 20;
	@PersistenceContext(name="jpa.saneka")
	private EntityManager em;
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
	public void validarCuenta(String email, String validacion) throws SanekaException {
		// TODO Auto-generated method stub
		Usuario u = em.find(Usuario.class, email);
        if (u == null) {
            throw new UsuarioNoEncontradoException();
        }

        if (u.getCadenaValidacion() == null) {
            // la cuenta ya está activa
            return;
        }

        if (!u.getCadenaValidacion().equals(validacion)) {
            throw new ValidacionIncorrectaException();
        }
        // else
        // Eliminamos la cadena de validación, indicando que ya está activa la cuenta
        u.setCadenaValidacion(null);
	}

	@Override
	public void compruebaLogin(Usuario u) throws SanekaException {
		// TODO Auto-generated method stub
    	Usuario user = em.find(Usuario.class, u.getEmailInstitucional());
        if (user == null) {
            throw new UsuarioNoEncontradoException();
        }

        if (user.getCadenaValidacion() != null) {
            throw new UsuarioInactivaException();
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
	
	 private String generarCadenaAleatoria() {
	        Random rnd = new Random(System.currentTimeMillis());
	        StringBuilder sb = new StringBuilder();

	        for (int i = 0; i < TAM_CADENA_VALIDACION; i++) {
	            int v = rnd.nextInt(62);
	            if (v < 26) {
	                sb.append((char) ('a' + v));
	            } else if (v < 52) {
	                sb.append((char) ('A' + v - 26));
	            } else {
	                sb.append((char) ('0' + v - 52));
	            }
	        }

	        return sb.toString();

	    }

}
