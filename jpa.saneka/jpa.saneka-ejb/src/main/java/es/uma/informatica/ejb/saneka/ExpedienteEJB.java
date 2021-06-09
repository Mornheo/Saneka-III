package es.uma.informatica.ejb.saneka;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.exceptions.ExpedienteExistenteException;
import es.uma.informatica.ejb.exceptions.ExpedienteNoEncontradoException;
import es.uma.informatica.jpa.saneka.Alumno;
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
	public void eliminarExpediente(Integer num) throws ExpedienteNoEncontradoException {
		Expediente expEntity = devolverExpediente(num);
		em.remove(expEntity);
	}

	@Override
	public void modificarExpediente(Integer num, Expediente exp) throws ExpedienteNoEncontradoException {
		Expediente expEntity = devolverExpediente(num);
		expEntity.setActivo(exp.getActivo());
		expEntity.setNotaMediaProvisional(exp.getNotaMediaProvisional());
		em.persist(expEntity);
		
	}

	@Override
	public String mostrarExpediente(Integer num) throws ExpedienteNoEncontradoException {
		Expediente expEntity = devolverExpediente(num);
		return expEntity.toString();
	}

	@Override
	public Expediente devolverExpediente(Integer num) throws ExpedienteNoEncontradoException {
		Expediente expEntity = em.find(Expediente.class, num);
		
		if(expEntity == null) {
			throw new ExpedienteNoEncontradoException();
		}
		return expEntity;
	}

	@Override
	public List<Expediente> devolverExpedientes() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Expediente.findAll", Expediente.class).getResultList();
	}

}
