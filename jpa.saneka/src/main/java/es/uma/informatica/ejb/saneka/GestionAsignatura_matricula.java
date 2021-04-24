package es.uma.informatica.ejb.saneka;

import es.uma.informatica.ejb.exceptions.AsignaturaNoEncontradoException;
import es.uma.informatica.ejb.exceptions.MatriculaExistente;
import es.uma.informatica.jpa.saneka.Asignaturas_matricula;

public interface GestionAsignatura_matricula {

	public void insertarAsignatura_matricula(Integer asig,Integer mat,Asignaturas_matricula a) throws MatriculaExistente, AsignaturaNoEncontradoException;
	
	public void modificarAsignatura_matricula(Integer asig,Integer mat,Asignaturas_matricula a);
	
	public void devolverAsignatura_matricula(Integer asig,Integer mat);
	
	public void eliminarAsignatura_matricula(Integer asig,Integer mat);

}
