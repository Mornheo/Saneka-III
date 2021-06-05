package es.uma.informatica.ejb.saneka;

import javax.ejb.Local;

import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.jpa.saneka.GruposPorAsignatura;
import es.uma.informatica.jpa.saneka.GruposPorAsignatura.GruposPorAsignaturaId;

@Local
public interface GestionGrupos_por_asignatura {
	
	/*
	 * Inserta en la base de datos una nueva GpA.
	 * Si ya existe lanzará una excepción.
	 * @Param id PK de GpA.
	 * @Param gpa El GpA a insertar.
	 */
	public void insertarGpA(GruposPorAsignaturaId id, GruposPorAsignatura gpa) throws SanekaException;
	
	/*
	 * Elimina de la base de datos el GpA asociado a la clave 
	 * primaria introducida si existe. En otro caso lanzará una
	 * excepción.
	 * @Param id La PK del GpA a eliminar.
	 */
	public void eliminarGpA(GruposPorAsignaturaId id) throws SanekaException;
	
	/*
	 * Modifica el campo Ofertada.
	 * @Param id Pk del GpA a modificar.
	 * @Param gpa GpA con los nuevos datos.
	 */
	public void modificarGpA(GruposPorAsignaturaId id, GruposPorAsignatura gpa) throws SanekaException;
	
	/*
	 * Muestra un toString() de GpA.
	 * @Param id PK del GpA a mostrar.
	 */
	public String mostrarGpA(GruposPorAsignaturaId id) throws SanekaException;
	
	/*
	 * Devuelve un GpA asociada a la PK id.
	 * @Param id PK del GpA a devolver.
	 */
	public GruposPorAsignatura devolverGpA(GruposPorAsignaturaId id) throws SanekaException;
}
