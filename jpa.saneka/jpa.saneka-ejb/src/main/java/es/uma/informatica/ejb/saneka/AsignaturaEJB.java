package es.uma.informatica.ejb.saneka;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.exceptions.AsignaturaExistenteException;
import es.uma.informatica.ejb.exceptions.AsignaturaNoEncontradoException;
import es.uma.informatica.jpa.saneka.Asignatura;

@Stateless
public class AsignaturaEJB implements GestionAsignatura{
	
		@PersistenceContext(name="SanekaTest")
		private EntityManager em;
		
		
	@Override
	public String mostrarAsignatura(Integer ref) throws AsignaturaNoEncontradoException {
		Asignatura existente = em.find(Asignatura.class, ref);
		if (existente==null) {
			throw new AsignaturaNoEncontradoException();
		}
		String res = existente.toString();
		System.out.println(res);
		return res;
	}

	@Override
	public void eliminarAsignatura(Integer ref) throws AsignaturaNoEncontradoException {
		Asignatura existente = em.find(Asignatura.class, ref);
		if(existente==null) {
			throw new AsignaturaNoEncontradoException();
		}
		em.remove(existente);
	}

	@Override
	public void insertarAsignatura(Integer ref, Asignatura asignatura) throws AsignaturaExistenteException {
		Asignatura existente = em.find(Asignatura.class, ref);
		if (existente!=null){
			throw new AsignaturaExistenteException();
		}
		em.persist(asignatura);
	}

	@Override
	public void modificarAsignatura(Integer ref, Asignatura asignatura) throws AsignaturaNoEncontradoException {
		Asignatura existente = em.find(Asignatura.class, ref);
		if (existente==null) {
			throw new AsignaturaNoEncontradoException();
		}
		existente.setNombre(asignatura.getNombre());
		existente.setCaracter(asignatura.getCaracter());
		existente.setCodigo(asignatura.getCodigo());
		existente.setCreditos_practica(asignatura.getCreditos_practica());
		existente.setCreditos_teoria(asignatura.getCreditos_teoria());
		existente.setCurso(asignatura.getCurso());
		existente.setDuracion(asignatura.getDuracion());
		existente.setOfertada(asignatura.getOfertada());
		existente.setOtro_idioma(asignatura.getOtro_idioma());
		existente.setPlazas(asignatura.getPlazas());
		existente.setTotal_creditos(asignatura.getTotal_creditos());
	}

	@Override
	public Asignatura devolverAsignatura(Integer ref) throws AsignaturaNoEncontradoException {
		Asignatura existente = em.find(Asignatura.class,ref);
		if (existente==null) {
			throw new AsignaturaNoEncontradoException();
		}
		return existente;
	}
	
	
	
}
