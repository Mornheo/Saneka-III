package es.uma.informatica.ejb.saneka;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.exceptions.EncuestaExistenteException;
import es.uma.informatica.ejb.exceptions.EncuestaNoEncontradoException;
import es.uma.informatica.jpa.saneka.Encuesta;

@Stateless
public class EncuestaEJB implements GestionEncuesta{
	
	@PersistenceContext(name="SanekaTest")
	private EntityManager em;
	
	@Override
	public void insertarEncuesta(String fecha, Encuesta enc) throws EncuestaExistenteException {
		Encuesta encEntity = em.find(Encuesta.class, fecha);
		if(encEntity != null) {
			throw new EncuestaExistenteException();
		}
		em.persist(enc);
	}

	@Override
	public void eliminarEncuesta(String fecha) throws EncuestaNoEncontradoException {
		Encuesta encEntity = devolverEncuesta(fecha);
		em.remove(encEntity);
	}

	@Override
	public String mostrarEncuesta(String fecha) throws EncuestaNoEncontradoException {
		Encuesta encEntity = devolverEncuesta(fecha);
		return encEntity.toString();
	}

	@Override
	public Encuesta devolverEncuesta(String fecha) throws EncuestaNoEncontradoException {
		Encuesta encEntity = em.find(Encuesta.class, fecha);
		if(encEntity == null) {
			throw new EncuestaNoEncontradoException();
		}
		return encEntity;
	}

}
