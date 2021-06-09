package es.uma.informatica.sii.saneka;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.uma.informatica.jpa.saneka.Usuario;

public class BaseDato {
	public static void inicializar(String unidadPersistencia) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(unidadPersistencia);
		EntityManager em = emf.createEntityManager();
		
		/* Comentar la línea de abajo si los datos se incluyen en un script de SQL */
		datos(em); 
		
		em.close();
		emf.close();
		
	}
	public static void datos(EntityManager em) {
		Usuario user1 = new Usuario("123@uma.es","123",false);
		Usuario user2 = new Usuario("secretaria@uma.es","sec",true);
		em.getTransaction().begin();
		em.persist(user1);
		em.persist(user2);
		em.getTransaction().commit();
	}

}
