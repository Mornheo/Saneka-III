package es.uma.informatica.ejb.saneka;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.exceptions.TitulacionExistenteException;
import es.uma.informatica.ejb.exceptions.TitulacionNoEncontradoException;
import es.uma.informatica.jpa.saneka.Alumno;
import es.uma.informatica.jpa.saneka.Titulacion;

@Stateless
public class TitulacionEJB implements GestionTitulacion{

	@PersistenceContext(name="jpa.saneka")
	private EntityManager em;
	
	@Override
	public String mostrarTitulacion(Integer code) throws TitulacionNoEncontradoException {
		Titulacion existente = em.find(Titulacion.class, code);
		if (existente==null) {
			throw new TitulacionNoEncontradoException();
		}
		
		String res = existente.toString();
		System.out.println(res);
		return res;
	}

	@Override
	public void eliminarTitulacion(Integer code) throws TitulacionNoEncontradoException {
		Titulacion existente = em.find(Titulacion.class, code);
		if(existente==null) {
			throw new TitulacionNoEncontradoException();
		}
		em.remove(existente);
		
		
	}

	@Override
	public void insertarTitulacion(Integer code, Titulacion titulacion) throws TitulacionExistenteException {
		Titulacion existente = em.find(Titulacion.class, code);
		if (existente!=null){
			throw new TitulacionExistenteException();
		}
		em.persist(titulacion);
		
	}

	@Override
	public void modificarTitulacion(Integer code, Titulacion titulacion) throws TitulacionNoEncontradoException {
		Titulacion existente = em.find(Titulacion.class, code);
		if (existente==null) {
			throw new TitulacionNoEncontradoException();
		}
		
		existente.setCreditos(titulacion.getCreditos());
		existente.setNombre(titulacion.getNombre());
		
	}
	
	public Titulacion devolverTitulacion(Integer code) throws TitulacionNoEncontradoException{
		Titulacion existente = em.find(Titulacion.class, code);
		if (existente==null) {
			throw new TitulacionNoEncontradoException();
		}
		
		return existente;
	}

	@Override
	public List<Titulacion> devolverTitulaciones() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Titulacion.findAll", Titulacion.class).getResultList();
	}

}
