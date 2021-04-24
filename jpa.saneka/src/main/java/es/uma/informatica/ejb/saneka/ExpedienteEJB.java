package es.uma.informatica.ejb.saneka;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.exceptions.ExpedienteExistenteException;
import es.uma.informatica.ejb.exceptions.ExpedienteNoEncontradoException;
import es.uma.informatica.jpa.saneka.Expediente;

@Stateless
public class ExpedienteEJB implements GestionExpediente{
	
	@PersistenceContext(name="SanekaTest")
	private EntityManager em;

	@Override
	public void insertarExpediente(Integer num, Expediente exp) throws ExpedienteExistenteException {
		Expediente expEntity = em.find(Expediente.class, num);
		
		if(expEntity != null) {
			throw new ExpedienteExistenteException();
		}
		
		em.persist(exp);
	}

	@Override
	public void eliminarExpediente(Expediente exp) throws ExpedienteNoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarExpediente(Integer num, Expediente exp) throws ExpedienteNoEncontradoException {
		Expediente expEntity = em.find(Expediente.class, num);
		
		if(expEntity == null) {
			throw new ExpedienteNoEncontradoException();
		}
		expEntity.setActivo(exp.getActivo());
		expEntity.setNota_media_provisional(exp.getNota_media_provisional());
		em.persist(expEntity);
		
	}

	@Override
	public void mostrarExpediente(Expediente exp) throws ExpedienteNoEncontradoException {
		// TODO Auto-generated method stub
		
	}

}
