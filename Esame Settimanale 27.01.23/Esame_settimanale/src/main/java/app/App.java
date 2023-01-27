package app;

import java.time.LocalDate;

import ap.DAO.ElementoDAO;
import ap.DAO.PrestitoDAO;
import ap.DAO.UtenteDAO;
import entities.ElementoBiblioteca;
import entities.Libro;
import entities.Periodicita;
import entities.Prestito;
import entities.Rivista;
import entities.Utente;

public class App {
	
	public static Libro saveLibro() {
		Libro l = new Libro();
		l.setTitolo("Pinocchio");
		l.setAutore("Collodi");
		l.setNPagine(250);
		l.setGenere("Fantasy");
		l.setAnnoPubblicazione(1850);
		
		ElementoDAO elementoDAO = new ElementoDAO();
	        elementoDAO.save(l);
		
	        return l;
	}
	public static Rivista saveRivista() {
		Rivista r = new Rivista();
		r.setTitolo("New Magazine");
		r.setPeriodicita(Periodicita.SETTIMANALE);
		r.setNPagine(20);
		r.setAnnoPubblicazione(2022);
		
		ElementoDAO elementoDAO = new ElementoDAO();
		elementoDAO.save(r);
		
		return r;
		
	}
	public static Utente saveUtente() {
		Utente u = new Utente();
		u.setNome("Giuseppe");
		u.setCognome("Morricone");
		u.setDatanascita(LocalDate.parse("2005-01-28"));
		
		UtenteDAO utenteDAO = new UtenteDAO();
		utenteDAO.save(u);
		
		return u;
		
	}
	
	
	public static Prestito savePrestito(Utente utente, ElementoBiblioteca elemento) {
		Prestito p = new Prestito();
		p.setUtente_id(utente.getNumerotessera());
		p.setPrestato(elemento.getTitolo());
		p.setInizioprestito(LocalDate.parse("2022-12-25"));
		p.setRestituzioneprevista(p.getInizioprestito().plusDays(30));
		p.setRestituzioneeffettiva(null);
		
		PrestitoDAO prestitoDAO = new PrestitoDAO();
		prestitoDAO.save(p);
		
		return p;
		
	}
	
	public static void delete() {
		ElementoDAO elementoDAO = new ElementoDAO();
		elementoDAO.deleteByISBN(0);
		
	}
	public static void searchISBN() {
		ElementoDAO elementoDAO = new ElementoDAO();
		elementoDAO.ricercaByISBN(450000000000300L);
		
	}
	public static void searchAutore() {
		ElementoDAO elementoDAO = new ElementoDAO();
		elementoDAO.ricercaByAutore("C. S. Lewis");
		
	}
	public static void searchAnno() {
		ElementoDAO elementoDAO = new ElementoDAO();
		elementoDAO.ricercaByAnno(2022);
		
	}
	
	public static void searchTitoloParz() {
		ElementoDAO elementoDAO = new ElementoDAO();
		elementoDAO.ricercaParzialeTitolo("Le cronache");
		
	}
	public static void searchTessera() {
		PrestitoDAO prestitoDAO = new PrestitoDAO();
		prestitoDAO.ricercaByTessera(1);
		
	}
	public static void searchScaduti() {
		PrestitoDAO prestitoDAO = new PrestitoDAO();
		prestitoDAO.ricercaScaduti();
		
	}
	


	public static void main(String[] args) {

		//Libro libro = saveLibro();
		
		//Utente utente = saveUtente();
		
		//Rivista rivista = saveRivista();
		
		//searchISBN();
		//searchAutore();
		//searchAnno();
		//searchTitoloParz();
		//searchTessera();
		//searchScaduti();
		
		//Prestito prestito = savePrestito(utente, libro);
		
		
		
		
		
	}

}