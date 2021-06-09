package es.uma.informatica.ejb.saneka;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.exceptions.OptativaExistenteException;
import es.uma.informatica.ejb.exceptions.OptativaNoEncontradoException;
import es.uma.informatica.jpa.saneka.Alumno;
import es.uma.informatica.jpa.saneka.Optativa;

@Stateless
public class OptativaEJB implements GestionOptativa{

	@PersistenceContext(name="jpa.saneka")
	private EntityManager em;
	
	@Override
	public String mostrarOptativa(Integer ref) throws OptativaNoEncontradoException {
		Optativa existente = em.find(Optativa.class, ref);
		if (existente==null) {
			throw new OptativaNoEncontradoException();
		}
		String res = existente.toString();
		System.out.println(res);
		return res;
	}

	@Override
	public void eliminarOptativa(Integer ref) throws OptativaNoEncontradoException {
		Optativa existente = em.find(Optativa.class, ref);
		if(existente==null) {
			throw new OptativaNoEncontradoException();
		}
		em.remove(existente);
		
	}

	@Override
	public void insertarOptativa(Integer ref, Optativa optativa) throws OptativaExistenteException {
		Optativa existente = em.find(Optativa.class, ref);
		if (existente!=null){
			throw new OptativaExistenteException();
		}
		em.persist(optativa);
		
	}

	@Override
	public void modificarOptativa(Integer ref, Optativa optativa) throws OptativaNoEncontradoException {
		Optativa existente = em.find(Optativa.class, ref);
		if (existente==null) {
			throw new OptativaNoEncontradoException();
		}
		existente.setNombre(optativa.getNombre());
		existente.setCaracter(optativa.getCaracter());
		existente.setCodigo(optativa.getCodigo());
		existente.setCreditos_practica(optativa.getCreditos_practica());
		existente.setCreditos_teoria(optativa.getCreditos_teoria());
		existente.setCurso(optativa.getCurso());
		existente.setDuracion(optativa.getDuracion());
		existente.setOfertada(optativa.getOfertada());
		existente.setOtro_idioma(optativa.getOtro_idioma());
		existente.setPlazas(optativa.getPlazas());
		existente.setTotal_creditos(optativa.getTotal_creditos());
		
	}
	
	public Optativa devolverOptativa(Integer ref) throws OptativaNoEncontradoException{
		Optativa existente = em.find(Optativa.class, ref);
		if (existente==null) {
			throw new OptativaNoEncontradoException();
		}
		
		return existente;
		
		
	}

	@Override
	public List<Optativa> devolverOptativas() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Optativa.findAll", Optativa.class).getResultList();
	}

	
}
