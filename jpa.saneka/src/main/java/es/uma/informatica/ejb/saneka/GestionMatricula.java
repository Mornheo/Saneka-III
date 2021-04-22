package es.uma.informatica.ejb.saneka;

import es.uma.informatica.ejb.exceptions.ExpedienteNoEncontrado;
import es.uma.informatica.ejb.exceptions.MatriculaExistente;
import es.uma.informatica.ejb.exceptions.MatriculaNoExistente;
import es.uma.informatica.jpa.saneka.Expediente;
import es.uma.informatica.jpa.saneka.Matricula;

public interface GestionMatricula {

	void modificarMatricula (Matricula matricula) throws MatriculaNoExistente;

	void mostrarMatricula (String dni) throws MatriculaNoExistente;

	void eliminarMatricula (String dni) throws MatriculaNoExistente;

	void insertarMatricula(String exp, Matricula matricula) throws ExpedienteNoEncontrado,MatriculaExistente;
}
