package eventoDAO;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Evento;
import entities.TipoEvento;
import utils.JpaUtil;

public class EventoDAO extends JpaUtil {

	public static void save(String titolo, LocalDate data, TipoEvento tipoEvento, String descrizione,
			int partecipanti) {

		try {
			Evento e = new Evento();
			e.setTitolo(titolo);
			e.setData(data);
			e.setTipoEvento(tipoEvento);
			e.setDescrizione(descrizione);
			e.setPartecipanti(partecipanti);

			t.begin();
			em.persist(e);
			t.commit();

			System.out.println("Evento inserito correttamente!");
		} catch (Exception e) {
			System.out.println("Errore nell'inserimento dell'evento");
		}

	}
	
	public static Evento getEvento(int id) {
		Evento e = em.find(Evento.class, id);
		return e;
		
	}
	
	public static void persist(Object entity) {
		t.begin();
		em.persist(entity);
		t.commit();
	}

	public static void getById(int id) {
		Evento e = em.find(Evento.class, id);

		if (e == null) {
			System.out.println( "L'evento con l'id " + id + " non è stato trovato!");
			return;
		}

		System.out.println("Dati Evento #" + id);
		System.out.printf("Titolo: %s | Data evento: %s | Tipologia: %s | Descrizione: %s | Numero Partecipanti: %d%n",
				e.getTitolo(), e.getData().toString(), e.getTipoEvento().toString(), e.getDescrizione(),
				e.getPartecipanti());
	}
	
	public static void delete(int id) {
		Evento e = em.find(Evento.class, id);
		
		if( e == null ) {
			System.out.println( "L'evento con l'id " + id + " non è stato trovato!" );
			return;
		}
		
		t.begin();
		em.remove(e);
		t.commit();
		
		System.out.println( "L'evento con l'id " + id + " è stato eliminato!" );
	}
	

	public static void refresh(int id, LocalDate dataEvento, TipoEvento tipoEvento) {
		Evento e = getEvento(id);
		if( e == null ) return;
		
		try {
			e.setData(dataEvento);
			e.setTipoEvento(tipoEvento);
			
			persist(e);
			
			System.out.println("L'evento con l'id " + id + " è stato aggiornato!");
		}
		catch(Exception f) {
			System.out.println( "Errore nella modifica dell'evento!" );
		}
		
	}

}
