package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.BoxSequence;

public class Main {
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EsercizioMattina-Giorno3-primaryKey-Mapping-Cascading");
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();

	public static void createBox(int w, int h) {
		
		BoxSequence box = new BoxSequence();
		box.setWidth(w);
		box.setHeight(h);
		
		t.begin();
		em.persist(box);
		t.commit();

	}
	
	public static void closeEm() {
		em.close();
		emf.close();
	}
	
	public static void main(String[] args) {
		createBox(200, 150);
		closeEm();
	}

}
