package es.uma.informatica.jpa.saneka;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateSchema {

	public static void main(String[] args) {
		EntityManagerFactory emf;
		EntityManager em;
		emf = Persistence.createEntityManagerFactory("jpa.saneka");
		em = emf.createEntityManager();
		em.close();
		emf.close();
	}

}
