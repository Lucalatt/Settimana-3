/*
 User (id, nickname, tasks, course_id)
Course( id, name)
Task(id, priority, description, open (boolean))  priority -> Priority enum (LOW, HIGH)

Creare 4 utenti, 2 corsi, e 5 task. Collegamenti a piacere.
Stampare le info dei 4 utenti, stabilendo anche le loro task e il corso a cui partecipano
Stampare solo gli utenti che hanno task aperte
 */

package userapp;

import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import userapp.entities.Course;
import userapp.entities.Priority;
import userapp.entities.Task;
import userapp.entities.User;

public class App {
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EsercizioMattina-Giorno3-primaryKey-Mapping-Cascading");
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();
	
	public static void printInfo(int id) {
		User u = em.find(User.class, id);
		
		System.out.println("Info utente " + u.getNickname() + ":");
		System.out.println("Corso: " + u.getCourse().getName());
		System.out.println("Tasks: ");
		for(Task t : u.getTasks()) {
			System.out.println(t.getDescription());
			System.out.println(t.getPriority());
			System.out.println(t.getOpen());
		}
	}

	public static void makeData() {
		t.begin();
		
		Course c1 = new Course();
		c1.setName("Corso Java");
		
		Course c2 = new Course();
		c2.setName("Corso JavaScript");
		
		em.persist(c1);
		em.persist(c2);
		
		Task t1 = new Task();
		t1.setDescription("Task 1");
		t1.setPriority(Priority.HIGH);
		t1.setOpen(true);
		
		Task t2 = new Task();
		t2.setDescription("Task 2");
		t2.setPriority(Priority.LOW);
		t2.setOpen(false);
		
		Task t3 = new Task();
		t3.setDescription("Task 3");
		t3.setPriority(Priority.HIGH);
		t3.setOpen(false);
		
		em.persist(t1);
		em.persist(t2);
		em.persist(t3);
		
		User u1 = new User("mario", c1);
		User u2 = new User("anna", c1);
		User u3 = new User("luca", c1);
		User u4 = new User("gino", c2);
		
		u1.setTasks(new HashSet<>() {{
			add(t1);
			add(t2);
		}});
		
		u2.setTasks(new HashSet<>() {{
			add(t1);
		}});
		
		u3.setTasks(new HashSet<>() {{
			add(t3);
			add(t2);
		}});
		
		u4.setTasks(new HashSet<>() {{
			add(t3);
		}});
		
		em.persist(u1);
		em.persist(u2);
		em.persist(u3);
		em.persist(u4);
		t.commit();
	}
	
	public static void main(String[] args) {
		
		//makeData();
		
		printInfo(1);

	}

}
