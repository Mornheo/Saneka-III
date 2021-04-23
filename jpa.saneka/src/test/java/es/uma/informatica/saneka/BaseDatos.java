package es.uma.informatica.saneka;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseDatos {
	public static void inicializaBaseDatos(String nombreUnidadPersistencia) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreUnidadPersistencia);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		//Rellenar con la base de datos para los test
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
