package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
/*
import entities.Car;

public class App {
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EsercizioMattina-Giorno3-primaryKey-Mapping-Cascading");
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();
	
	public static void insertCar(String plate, String country, String model, int maxSpeed) {
		Car c = new Car(plate, country, model, maxSpeed);
		
		t.begin();
		em.persist(c);
		t.commit();
	}

	public static void main(String[] args) {
		
		insertCar("AA 125 CC", "IT", "Panda", 120);
		insertCar("ED 444 FF", "FR", "Peugeot", 150);

	}

}
*/
