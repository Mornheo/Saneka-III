package es.uma.informatica.ejb.saneka;

import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.exceptions.ExpedienteNoEncontradoException;
import es.uma.informatica.ejb.exceptions.MatriculaExistente;
import es.uma.informatica.ejb.exceptions.MatriculaNoExistente;
import es.uma.informatica.jpa.saneka.Alumno;
import es.uma.informatica.jpa.saneka.Expediente;
import es.uma.informatica.jpa.saneka.Matricula;

@Stateless
public class MatriculaEJB implements GestionMatricula{

	@PersistenceContext(name="jpa.saneka")
	private EntityManager em;

	@Override
	public void insertarMatricula(Integer exp,Matricula matricula) throws ExpedienteNoEncontradoException,MatriculaExistente {
		// TODO Auto-generated method stub
		Expediente ex = em.find(Expediente.class, exp);
		if (ex == null) {
			throw new ExpedienteNoEncontradoException();
		}
		Matricula mat=em.find(Matricula.class,new Matricula.MatriculaId(matricula.getCursoAcademico(),exp));
			if(mat!=null) {
				throw new MatriculaExistente();
			}
		matricula.setExpedientes(ex);
		em.persist(matricula);		
	}

	@Override
	public void modificarMatricula(Integer exp,Matricula matricula) throws MatriculaNoExistente, ExpedienteNoEncontradoException{
		Expediente ex = em.find(Expediente.class, exp);
		if (ex == null) {
			throw new ExpedienteNoEncontradoException();
		}
		
		Matricula mat=em.find(Matricula.class,new Matricula.MatriculaId(matricula.getCursoAcademico(),exp));
				if(mat==null) {
					throw new MatriculaNoExistente();
				}
		
		mat.setEstado(matricula.getEstado());
		mat.setFechaMatricula(matricula.getFechaMatricula());
		mat.setNuevoIngreso(matricula.getNuevoIngreso());
		mat.setTurnoPreferente(mat.getTurnoPreferente());
		em.persist(mat);
	}

	@Override
	public String mostrarMatricula(Integer exp,String curso) throws ExpedienteNoEncontradoException,MatriculaNoExistente {
		Expediente e=em.find(Expediente.class,exp);
		if(e==null) {
			throw new ExpedienteNoEncontradoException();
		}
		Matricula mat=em.find(Matricula.class,new Matricula.MatriculaId(curso,exp));
		if(mat==null) {
			throw new MatriculaNoExistente();
		}
		return mat.toString();
		
	}

	@Override
	public void eliminarMatricula(Integer exp,String curso) throws MatriculaNoExistente,ExpedienteNoEncontradoException {
		Expediente e=em.find(Expediente.class,exp);
		if(e==null) {
			throw new ExpedienteNoEncontradoException();
		}
		Matricula mat=em.find(Matricula.class,new Matricula.MatriculaId(curso,exp));
		if(mat==null) {
			throw new MatriculaNoExistente();
		}
		em.remove(mat);
		
	}
	
	@Override
	public Matricula devolverMatricula(Integer exp,String curso) throws ExpedienteNoEncontradoException,MatriculaNoExistente {
		Expediente e=em.find(Expediente.class,exp);
		if(e==null) {
			throw new ExpedienteNoEncontradoException();
		}
		Matricula mat=em.find(Matricula.class,new Matricula.MatriculaId(curso,exp));
		if(mat==null) {
			throw new MatriculaNoExistente();
		}
		return mat;
		
	}

	@Override
	public List<Matricula> devolverMatriculas() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Matricula.findAll", Matricula.class).getResultList();
	}
	
	
}
