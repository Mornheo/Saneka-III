package es.uma.informatica.ejb.saneka;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.exceptions.AsignaturaExistenteException;
import es.uma.informatica.ejb.exceptions.AsignaturaNoExistenteException;
import es.uma.informatica.jpa.saneka.Asignatura;

@Stateless
public class AsignaturaEJB implements GestionAsignatura{
	
		@PersistenceContext(name="jpa.saneka")
		private EntityManager em;
		
		
	@Override
	public String mostrarAsignatura(Asignatura asignatura) throws AsignaturaNoExistenteException {
		Asignatura existente = em.find(Asignatura.class, asignatura.getReferencia());
		if (existente==null) {
			throw new AsignaturaNoExistenteException();
		}
		String res = existente.toString();
		System.out.println(res);
		return res;
	}

	@Override
	public void eliminarAsignatura(Asignatura asignatura) throws AsignaturaNoExistenteException {
		Asignatura existente = em.find(Asignatura.class, asignatura.getReferencia());
		if(existente==null) {
			throw new AsignaturaNoExistenteException();
		}
		em.remove(existente);
	}

	@Override
	public void insertarAsignatura(Asignatura asignatura) throws AsignaturaExistenteException {
		Asignatura existente = em.find(Asignatura.class, asignatura.getReferencia());
		if (existente!=null){
			throw new AsignaturaExistenteException();
		}
		em.persist(asignatura);
	}

	@Override
	public void modificarAsignatura(Asignatura asignatura) throws AsignaturaNoExistenteException {
		Asignatura existente = em.find(Asignatura.class, asignatura.getReferencia());
		if (existente==null) {
			throw new AsignaturaNoExistenteException();
		}
		existente.setAsignatura(asignatura.getAsignatura());
		existente.setCaracter(asignatura.getCaracter());
		existente.setCodigo_1(asignatura.getCodigo_1());
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
	public Asignatura obtenerAsignatura(int ref) throws AsignaturaNoExistenteException {
		Asignatura existente = em.find(Asignatura.class, ref);
		if (existente==null) {
			throw new AsignaturaNoExistenteException();
		}
		return existente;
	}
	
	
	
}
