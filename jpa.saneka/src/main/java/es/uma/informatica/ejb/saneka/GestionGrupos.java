package es.uma.informatica.ejb.saneka;

import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.ejb.exceptions.GrupoExistenteException;
import es.uma.informatica.ejb.exceptions.GrupoNoEncontradoException;
import es.uma.informatica.ejb.exceptions.TitulacionNoEncontradoException;
import es.uma.informatica.jpa.saneka.Grupo;

@Local
public interface GestionGrupos {
	public void insertarGrupo(String titu,Grupo grupo) throws TitulacionNoEncontradoException, GrupoExistenteException;
	public List<Grupo> obtenerGruposDeTitulacion(String titu) throws TitulacionNoEncontradoException;
	public void actualizarGrupo(String titu,Grupo grupo) throws TitulacionNoEncontradoException, GrupoNoEncontradoException;
	public void eliminarGrupo(String titu,Grupo grupo) throws TitulacionNoEncontradoException, GrupoExistenteException;
	public void eliminarTodosGrupos(String titu) throws TitulacionNoEncontradoException;
	public String mostrarGrupo(Grupo grupo);

}
