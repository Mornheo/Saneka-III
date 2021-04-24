package es.uma.informatica.ejb.saneka;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.exceptions.ExpedienteExistenteException;
import es.uma.informatica.ejb.exceptions.ExpedienteNoEncontradoException;
import es.uma.informatica.ejb.exceptions.GpAExistenteException;
import es.uma.informatica.ejb.exceptions.GpANoEncontradoException;
import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.jpa.saneka.Expediente;
import es.uma.informatica.jpa.saneka.Grupos_por_asignatura;
import es.uma.informatica.jpa.saneka.Grupos_por_asignatura.Grupos_por_asignaturaId;

@Stateless
public class Grupos_por_asignaturaEJB implements GestionGrupos_por_asignatura{

	@PersistenceContext(name="SanekaTest")
	private EntityManager em;

	@Override
	public void insertarGpA(Grupos_por_asignaturaId id, Grupos_por_asignatura gpa) throws GpANoEncontradoException, GpAExistenteException {
		try {
			devolverGpA(id);
		} catch (GpANoEncontradoException e) {
			em.persist(gpa);
		}
		throw new GpAExistenteException();
	}

	@Override
	public void eliminarGpA(Grupos_por_asignaturaId id) throws SanekaException {
		Grupos_por_asignatura gpaEntity = devolverGpA(id);
		em.remove(gpaEntity);	
	}

	@Override
	public void modificarGpA(Grupos_por_asignaturaId id, Grupos_por_asignatura gpa) throws SanekaException {
		Grupos_por_asignatura gpaEntity = devolverGpA(id);
		gpaEntity.setOferta(gpa.getOferta());
		em.persist(gpaEntity);
	}

	@Override
	public String mostrarGpA(Grupos_por_asignaturaId id) throws SanekaException {
		Grupos_por_asignatura gpaEntity = devolverGpA(id);
		return gpaEntity.toString();
	}

	@Override
	public Grupos_por_asignatura devolverGpA(Grupos_por_asignaturaId id) throws GpANoEncontradoException {
		Grupos_por_asignatura gpaEntity = em.find(Grupos_por_asignatura.class, id);
		if(gpaEntity == null) {
			throw new GpANoEncontradoException();
		}
		return gpaEntity;
	}
}
