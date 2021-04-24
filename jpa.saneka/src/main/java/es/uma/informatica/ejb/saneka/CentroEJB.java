package es.uma.informatica.ejb.saneka;


import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.exceptions.CentroExistenteException;
import es.uma.informatica.ejb.exceptions.CentroNoEncontradoException;
import es.uma.informatica.jpa.saneka.Centro;

@Stateless
public class CentroEJB implements GestionCentro{
	
	private static final Logger LOG = Logger.getLogger(CentroEJB.class.getCanonicalName());
	
	@PersistenceContext(name="jpa.saneka")
	private EntityManager em;
	@Override
	public void insertarCentro(Centro centro) throws CentroExistenteException{
		Centro centroExistente = em.find(Centro.class,centro.getID());
		if(centroExistente != null) {
			throw new CentroExistenteException();
		}
		em.persist(centro);
	}

	@Override
	public void actualizarCentro(Centro centro) throws CentroNoEncontradoException {
		// Que información podemos actualizar
		// Actualizamos Nombre,direccion,telefono y lista de titulacion
		Centro centroExistente = em.find(Centro.class,centro.getID());
		if(centroExistente == null) {
			throw new CentroNoEncontradoException();
		}
		centroExistente.setDireccion(centro.getDireccion());
		centroExistente.setNombre(centro.getNombre());
		centroExistente.setTLF_consejeria(centro.getTLF_consejeria());
		centroExistente.setTitulaciones(centro.getTitulaciones());
		em.persist(centroExistente);
	}

	@Override
	public void eliminarCentro(Centro centro) throws CentroNoEncontradoException{
		Centro centroExistente = em.find(Centro.class,centro);
		if(centroExistente == null) {
			throw new CentroNoEncontradoException();
		}
		em.remove(centro);
	}

	@Override
	public String mostrarCentro(Centro centro) {
		return centro.toString();
	}

	@Override
	public Centro obtenerCentro(Integer id) throws CentroNoEncontradoException {
		Centro centroExistente = em.find(Centro.class,id);
		if(centroExistente == null) {
			throw new CentroNoEncontradoException();
		}
		return centroExistente;
	}
	

}
