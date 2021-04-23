package es.uma.informatica.ejb.saneka;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.exceptions.AsignaturaNoEncontradoException;
import es.uma.informatica.ejb.exceptions.ClaseExistenteException;
import es.uma.informatica.ejb.exceptions.ClaseNoEncontradoException;
import es.uma.informatica.jpa.saneka.Asignatura;
import es.uma.informatica.jpa.saneka.Clase;

@Stateless
public class ClasesEJB implements GestionClases{
	
	private static final Logger LOG = Logger.getLogger(ClasesEJB.class.getCanonicalName());
	
	@PersistenceContext(name="jpa.saneka")
	private EntityManager em;
	@Override
	public void insertarClase(Integer asignatura, Clase clase) throws AsignaturaNoEncontradoException,ClaseExistenteException{
		Asignatura asignaturaEntity = em.find(Asignatura.class,asignatura);
		if(asignaturaEntity == null) {
			throw new AsignaturaNoEncontradoException();
		}
		Clase claseExistente = em.find(Clase.class, new Clase.ClaseId(clase.getDia(),clase.getHora_fin(),clase.getGrupo().getID()));
		if(claseExistente != null) {
			throw new ClaseExistenteException();
		}
		clase.setAsignatura(asignaturaEntity);
		em.persist(clase);
	}

	@Override
	public List<Clase> obtenerClasesDeAsignatura(Integer asignatura) throws AsignaturaNoEncontradoException {
		Asignatura asignaturaEntity = em.find(Asignatura.class,asignatura);
		if(asignaturaEntity == null) {
			throw new AsignaturaNoEncontradoException();
		}
		return new ArrayList<>(asignaturaEntity.getClases());
	}

	@Override
	public void actualizarClase(Integer asignatura, Clase clase) throws AsignaturaNoEncontradoException,ClaseNoEncontradoException {
		Asignatura asignaturaEntity = em.find(Asignatura.class,asignatura);
		if(asignaturaEntity == null) {
			throw new AsignaturaNoEncontradoException();
		}
		Clase claseExistente = em.find(Clase.class, new Clase.ClaseId(clase.getDia(),clase.getHora_fin(),clase.getGrupo().getID()));
		if(claseExistente == null) {
			throw new ClaseNoEncontradoException();
		}
		// Actualizamos 
		claseExistente.setAsignatura(clase.getAsignatura());
		claseExistente.setDia(clase.getDia());
		claseExistente.setGrupo(clase.getGrupo());
		claseExistente.setHora_fin(clase.getHora_fin());
		claseExistente.setHora_inicio(clase.getHora_inicio());
		em.persist(asignaturaEntity);
		
	}

	@Override
	public void eliminarClase(Integer asignatura, Clase clase) throws AsignaturaNoEncontradoException, ClaseNoEncontradoException {
		Asignatura asignaturaEntity = em.find(Asignatura.class,asignatura);
		if(asignaturaEntity == null) {
			throw new AsignaturaNoEncontradoException();
		}
		Clase claseExistente = em.find(Clase.class, new Clase.ClaseId(clase.getDia(),clase.getHora_fin(),clase.getGrupo().getID()));
		if(claseExistente == null) {
			throw new ClaseNoEncontradoException();
		}
		List<Clase> clases = asignaturaEntity.getClases();
		clases.remove(clase);
		asignaturaEntity.setClases(clases);
		em.persist(asignaturaEntity);
		
	}

	@Override
	public void eliminarTodosClases(Integer asignatura) throws AsignaturaNoEncontradoException {
		Asignatura asignaturaEntity = em.find(Asignatura.class,asignatura);
		if(asignaturaEntity == null) {
			throw new AsignaturaNoEncontradoException();
		}
		List<Clase> clases = new ArrayList<>();
		asignaturaEntity.setClases(clases);
		em.persist(asignaturaEntity);
		
	}
	


}
