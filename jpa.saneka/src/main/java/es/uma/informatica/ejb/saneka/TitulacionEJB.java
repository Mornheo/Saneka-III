package es.uma.informatica.ejb.saneka;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.exceptions.OptativaExistenteException;
import es.uma.informatica.ejb.exceptions.OptativaNoExistenteException;
import es.uma.informatica.ejb.exceptions.TitulacionExistenteException;
import es.uma.informatica.ejb.exceptions.TitulacionNoExistenteException;
import es.uma.informatica.jpa.saneka.Optativa;
import es.uma.informatica.jpa.saneka.Titulacion;

@Stateless
public class TitulacionEJB implements GestionTitulacion{

	@PersistenceContext(name="jpa.saneka")
	private EntityManager em;
	
	@Override
	public String mostrarTitulacion(Titulacion titulacion) throws TitulacionNoExistenteException {
		Titulacion existente = em.find(Titulacion.class, titulacion.getCodigo());
		if (existente==null) {
			throw new TitulacionNoExistenteException();
		}
		
		String res = existente.toString();
		System.out.println(res);
		return res;
	}

	@Override
	public void eliminarTitulacion(Titulacion titulacion) throws TitulacionNoExistenteException {
		Titulacion existente = em.find(Titulacion.class, titulacion.getCodigo());
		if(existente==null) {
			throw new TitulacionNoExistenteException();
		}
		em.remove(existente);
		
		
	}

	@Override
	public void insertarTitulacion(Titulacion titulacion) throws TitulacionExistenteException {
		Titulacion existente = em.find(Titulacion.class, titulacion.getCodigo());
		if (existente!=null){
			throw new TitulacionExistenteException();
		}
		em.persist(titulacion);
		
	}

	@Override
	public void modificarTitulacion(Titulacion titulacion) throws TitulacionNoExistenteException {
		Titulacion existente = em.find(Titulacion.class, titulacion.getCodigo());
		if (existente==null) {
			throw new TitulacionNoExistenteException();
		}
		
		existente.setCreditos(titulacion.getCreditos());
		existente.setNombre(titulacion.getNombre());
		
	}

}
