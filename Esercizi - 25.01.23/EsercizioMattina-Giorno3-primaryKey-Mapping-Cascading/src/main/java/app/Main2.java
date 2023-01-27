package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Person;
import entities.PersonInfo;

public class Main2 {
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EsercizioMattina-Giorno3-primaryKey-Mapping-Cascading");
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();
	
	public static void insertPerson(String fn, String ln, double h, double w, String cf) {
		PersonInfo pi = new PersonInfo();
		pi.setHeight(h);
		pi.setWeight(w);
		pi.setCf(cf);
		
		
		Person p = new Person();
		p.setFirstname(fn);
		p.setLastname(ln);
		
		t.begin();
		em.persist(p);
		t.commit();
	}

	public static void main(String[] args) {
		
		insertPerson("Mario", "Rossi", 180, 80, "RSSMRI55E26F376X");
		insertPerson("Anna", "Bianchi", 168, 55, "BNCNNA98E26F376X");

	}

}
