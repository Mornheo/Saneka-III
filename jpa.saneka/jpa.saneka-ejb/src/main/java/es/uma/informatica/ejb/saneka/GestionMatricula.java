package es.uma.informatica.ejb.saneka;

import java.util.List;

import es.uma.informatica.ejb.exceptions.ExpedienteNoEncontradoException;
import es.uma.informatica.ejb.exceptions.MatriculaExistente;
import es.uma.informatica.ejb.exceptions.MatriculaNoExistente;
import es.uma.informatica.jpa.saneka.Matricula;
import es.uma.informatica.jpa.saneka.Optativa;

public interface GestionMatricula {

	void modificarMatricula (Integer exp,Matricula matricula) throws MatriculaNoExistente,ExpedienteNoEncontradoException;

	void eliminarMatricula (Integer exp,String curso) throws MatriculaNoExistente,ExpedienteNoEncontradoException;

	void insertarMatricula(Integer exp, Matricula matricula) throws ExpedienteNoEncontradoException,MatriculaExistente;

	String mostrarMatricula(Integer exp,String curso) throws MatriculaNoExistente,ExpedienteNoEncontradoException;

	Matricula devolverMatricula(Integer exp, String curso) throws ExpedienteNoEncontradoException, MatriculaNoExistente;
	public List<Matricula> devolverMatriculas() ;
}
