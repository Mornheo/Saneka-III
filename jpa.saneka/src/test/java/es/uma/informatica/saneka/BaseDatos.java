package es.uma.informatica.saneka;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.uma.informatica.jpa.saneka.Expediente;

public class BaseDatos {
	public static void inicializaBaseDatos(String nombreUnidadPersistencia) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreUnidadPersistencia);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		//Rellenar con la base de datos para los test
		Expediente exp = new Expediente(12345);
		em.persist(exp);
		Expediente exp2 = new Expediente(1);
		em.persist(exp2);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
