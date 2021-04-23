package es.uma.informatica.ejb.saneka;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.exceptions.ExpedienteExistenteException;
import es.uma.informatica.ejb.exceptions.ExpedienteNoEncontradoException;
import es.uma.informatica.jpa.saneka.Expediente;

@Stateless
public class ExpedienteEJB implements GestionExpediente{
	
	@PersistenceContext(name="jpa.saneka")
	private EntityManager em;

	@Override
	public void insertarExpediente(Expediente exp) throws ExpedienteExistenteException {
		Expediente expEntity = em.find(Expediente.class, exp);
		
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
	public void modificarExpediente(Expediente exp) throws ExpedienteNoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarExpediente(Expediente exp) throws ExpedienteNoEncontradoException {
		// TODO Auto-generated method stub
		
	}

}
