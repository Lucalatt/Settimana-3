package app;

import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Person2;
import entities.Project1;

public class Main3 {
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EsercizioMattina-Giorno3-primaryKey-Mapping-Cascading");
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();
	
	public static void populateDB() {
		t.begin();
		
		Project1 p1 = new Project1();
		p1.setName("red project");
		p1.setDescription("this is a red project");
		
		Project1 p2 = new Project1();
		p2.setName("green project");
		p2.setDescription("this is a green project");
		
		Project1 p3 = new Project1();
		p3.setName("pink project");
		p3.setDescription("this is a pink project");
		
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		
		Person2 person1 = em.find(Person2.class, 1);
		Person2 person2 = em.find(Person2.class, 2);
		
		person1.setProjects(new HashSet<>() {{
			add(p1);
			add(p2);
		}});
		
		person2.setProjects(new HashSet<>() {{
			add(p1);
			add(p3);
		}});
		
		em.persist(person1);
		em.persist(person2);
		t.commit();
	}
	
	public static void getPersonInfo(int id) {
		Person2 p = em.find(Person2.class, id);
		System.out.println("Info Person: " + p);
		System.out.println("Progetti:");
		for(Project1 project : p.getProjects()) {
			System.out.println(project);
		}
	}
	
	
	public static void main(String[] args) {
		
		boolean populateDB = false;
		if(populateDB) {
			populateDB();			
		}

	}

}
