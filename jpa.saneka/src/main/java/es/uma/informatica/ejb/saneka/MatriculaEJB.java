package es.uma.informatica.ejb.saneka;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.exceptions.MatriculaExistente;
import es.uma.informatica.ejb.exceptions.MatriculaNoExistente;
import es.uma.informatica.jpa.saneka.Expediente;
import es.uma.informatica.jpa.saneka.Matricula;

@Stateless
public class MatriculaEJB implements GestionMatricula{

	@PersistenceContext(name="jpa.saneka")
	private EntityManager em;

	@Override
	public void insertarMatricula(String exp,Matricula matricula) throws ExpedienteNoEncontrado,MatriculaExistente {
		// TODO Auto-generated method stub
		Expediente ex = em.find(Expediente.class, exp);
		if (ex == null) {
			throw new ExpedienteNoEncontrado();
		}
		Matricula mat=em.find(Matricula.class,matricula.getNum_archivo())
			if(mat!=null) {
				throw new MatriculaExistente();
			}
		matricula.setExpedientes(ex);
		em.persist(matricula);		
	}

	@Override
	public void modificarMatricula(Matricula matricula) throws MatriculaNoExistente{
		Matricula mat=em.find(Matricula.class,matricula.getNum_archivo());
				if(mat==null) {
					throw new MatriculaNoExistente();
				}
		
		mat.setEstado(matricula.getEstado());
		mat.setFecha_matricula(matricula.getFecha_matricula());
		mat.setNuevo_ingreso(matricula.getNuevo_ingreso());
		mat.setTurno_preferente(mat.getTurno_preferente());
		em.persist(mat);
	}

	@Override
	public void mostrarMatricula(String ref) throws MatriculaNoExistente {
		Matricula mat=em.find(Matricula.class,ref);
		if(mat==null) {
			throw new MatriculaNoExistente();
		}
		System.out.println(mat.toString());
		
	}

	@Override
	public void eliminarMatricula(String ref) throws MatriculaNoExistente {
		Matricula mat=em.find(Matricula.class,ref);
		if(mat==null) {
			throw new MatriculaNoExistente();
		}
		em.remove(mat);
		
	}
	
	
}
