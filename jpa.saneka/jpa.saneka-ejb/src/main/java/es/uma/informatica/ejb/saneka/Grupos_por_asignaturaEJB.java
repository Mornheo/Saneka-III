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
import es.uma.informatica.jpa.saneka.GruposPorAsignatura;
import es.uma.informatica.jpa.saneka.GruposPorAsignatura.GruposPorAsignaturaId;

@Stateless
public class Grupos_por_asignaturaEJB implements GestionGrupos_por_asignatura{

	@PersistenceContext(name="SanekaTest")
	private EntityManager em;

	@Override
	public void insertarGpA(GruposPorAsignaturaId id, GruposPorAsignatura gpa) throws GpANoEncontradoException, GpAExistenteException {
		try {
			devolverGpA(id);
		} catch (GpANoEncontradoException e) {
			em.persist(gpa);
		}
		throw new GpAExistenteException();
	}

	@Override
	public void eliminarGpA(GruposPorAsignaturaId id) throws SanekaException {
		GruposPorAsignatura gpaEntity = devolverGpA(id);
		em.remove(gpaEntity);	
	}

	@Override
	public void modificarGpA(GruposPorAsignaturaId id, GruposPorAsignatura gpa) throws SanekaException {
		GruposPorAsignatura gpaEntity = devolverGpA(id);
		gpaEntity.setOferta(gpa.getOferta());
		em.persist(gpaEntity);
	}

	@Override
	public String mostrarGpA(GruposPorAsignaturaId id) throws SanekaException {
		GruposPorAsignatura gpaEntity = devolverGpA(id);
		return gpaEntity.toString();
	}

	@Override
	public GruposPorAsignatura devolverGpA(GruposPorAsignaturaId id) throws GpANoEncontradoException {
		GruposPorAsignatura gpaEntity = em.find(GruposPorAsignatura.class, id);
		if(gpaEntity == null) {
			throw new GpANoEncontradoException();
		}
		return gpaEntity;
	}
}
