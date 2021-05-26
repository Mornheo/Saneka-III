package es.uma.informatica.ejb.saneka;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.exceptions.GrupoExistenteException;
import es.uma.informatica.ejb.exceptions.GrupoNoEncontradoException;
import es.uma.informatica.ejb.exceptions.TitulacionNoEncontradoException;
import es.uma.informatica.jpa.saneka.Grupo;
import es.uma.informatica.jpa.saneka.Titulacion;
@Stateless
public class GrupoEJB implements GestionGrupo{
	private static final Logger LOG = Logger.getLogger(GrupoEJB.class.getCanonicalName());
	@PersistenceContext(name="jpa.saneka")
	private EntityManager em;
	@Override
	public void insertarGrupo(Integer titu, Grupo grupo) throws TitulacionNoEncontradoException,GrupoExistenteException {
		Titulacion titulacion = em.find(Titulacion.class,titu);
		if(titulacion == null) {
			throw new TitulacionNoEncontradoException();
		}
		Grupo grupoExistente = em.find(Grupo.class,grupo.getId());
		if(grupoExistente != null) {
			throw new GrupoExistenteException();
		}
		grupo.setTitulacion(titulacion);
		em.persist(grupo);
	}

	@Override
	public List<Grupo> obtenerGruposDeTitulacion(Integer titu) throws TitulacionNoEncontradoException{
		Titulacion titulacion = em.find(Titulacion.class,titu);
		if(titulacion == null) {
			throw new TitulacionNoEncontradoException();
		}
		return new ArrayList<>(titulacion.getGrupos());
	}

	@Override
	public void actualizarGrupo(Integer titu, Grupo grupo) throws TitulacionNoEncontradoException, GrupoNoEncontradoException {
		// Actualiza curso, letra,turno,ingles,plaza
		Titulacion titulacion = em.find(Titulacion.class,titu);
		if(titulacion == null) {
			throw new TitulacionNoEncontradoException();
		}
		Grupo grupoExistente = em.find(Grupo.class,grupo.getId());
		if(grupoExistente == null) {
			throw new GrupoNoEncontradoException();
		}
		grupoExistente.setCurso(grupo.getCurso());
		grupoExistente.setLetra(grupo.getLetra());
		grupoExistente.setTurno(grupo.getTurno());
		grupoExistente.setIngles(grupo.getIngles());
		em.persist(titulacion);	
	}

	@Override
	public void eliminarGrupo(Integer titu, Grupo grupo) throws TitulacionNoEncontradoException, GrupoNoEncontradoException{
		Titulacion titulacion = em.find(Titulacion.class,titu);
		if(titulacion == null) {
			throw new TitulacionNoEncontradoException();
		}
		Grupo grupoExistente = em.find(Grupo.class,grupo.getId());
		if(grupoExistente == null) {
			throw new GrupoNoEncontradoException();
		}
		List<Grupo> grupos = titulacion.getGrupos();
		grupos.remove(grupo);
		titulacion.setGrupos(grupos);
		em.persist(titulacion);
	}
	@Override
	public void eliminarTodosGrupos(Integer titu) throws TitulacionNoEncontradoException {
		Titulacion titulacion = em.find(Titulacion.class,titu);
		if(titulacion == null) {
			throw new TitulacionNoEncontradoException();
		}
		List<Grupo> grupos = new ArrayList<>();
		titulacion.setGrupos(grupos);
		em.persist(titulacion);
	}

	@Override
	public String mostrarGrupo(Grupo grupo) {
		return grupo.toString();
	}

	@Override
	public Grupo obtenerGrupo(Integer id) throws GrupoNoEncontradoException {
		Grupo grupo = em.find(Grupo.class,id);
		if(grupo == null) {
			throw new GrupoNoEncontradoException();
		}
		return grupo;
		
	}

}
