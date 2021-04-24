package es.uma.informatica.ejb.saneka;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.exceptions.OptativaExistenteException;
import es.uma.informatica.ejb.exceptions.OptativaNoExistenteException;
import es.uma.informatica.jpa.saneka.Optativa;

@Stateless
public class OptativaEJB implements GestionOptativa{

	@PersistenceContext(name="jpa.saneka")
	private EntityManager em;
	
	@Override
	public String mostrarOptativa(Optativa optativa) throws OptativaNoExistenteException {
		Optativa existente = em.find(Optativa.class, optativa.getReferencia());
		if (existente==null) {
			throw new OptativaNoExistenteException();
		}
		String res = existente.toString();
		System.out.println(res);
		return res;
	}

	@Override
	public void eliminarOptativa(Optativa optativa) throws OptativaNoExistenteException {
		Optativa existente = em.find(Optativa.class, optativa.getReferencia());
		if(existente==null) {
			throw new OptativaNoExistenteException();
		}
		em.remove(existente);
		
	}

	@Override
	public void insertarOptativa(Optativa optativa) throws OptativaExistenteException {
		Optativa existente = em.find(Optativa.class, optativa.getReferencia());
		if (existente!=null){
			throw new OptativaExistenteException();
		}
		em.persist(optativa);
		
	}

	@Override
	public void modificarOptativa(Optativa optativa) throws OptativaNoExistenteException {
		Optativa existente = em.find(Optativa.class, optativa.getReferencia());
		if (existente==null) {
			throw new OptativaNoExistenteException();
		}
		existente.setAsignatura(optativa.getAsignatura());
		existente.setCaracter(optativa.getCaracter());
		existente.setCodigo_1(optativa.getCodigo_1());
		existente.setCreditos_practica(optativa.getCreditos_practica());
		existente.setCreditos_teoria(optativa.getCreditos_teoria());
		existente.setCurso(optativa.getCurso());
		existente.setDuracion(optativa.getDuracion());
		existente.setOfertada(optativa.getOfertada());
		existente.setOtro_idioma(optativa.getOtro_idioma());
		existente.setPlazas(optativa.getPlazas());
		existente.setTotal_creditos(optativa.getTotal_creditos());
		
	}
	
	public Optativa devolverOptativa(Integer ref) throws OptativaNoExistenteException{
		Optativa existente = em.find(Optativa.class, ref);
		if (existente==null) {
			throw new OptativaNoExistenteException();
		}
		
		return existente;
		
		
	}

	
}
