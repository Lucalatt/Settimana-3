package app;

import java.time.LocalDate;

import DAO.ElementoDAO;
import DAO.PrestitoDAO;
import DAO.UtenteDAO;
import entities.ElementoBiblioteca;
import entities.Libro;
import entities.Periodicita;
import entities.Prestito;
import entities.Rivista;
import entities.Utente;

public class App {

	public static Libro saveLibro() {
		Libro l = new Libro();
		l.setTitolo("");
		l.setAutore("");
		l.setNPagine(00);
		l.setGenere("");
		l.setAnnoPubblicazione(0000);

		ElementoDAO elementoDAO = new ElementoDAO();
		elementoDAO.save(l);

		return l;
	}

	public static Rivista saveRivista() {
		Rivista r = new Rivista();
		r.setTitolo("");
		r.setPeriodicita(Periodicita.SETTIMANALE);
		r.setNPagine(00);
		r.setAnnoPubblicazione(0000);

		ElementoDAO elementoDAO = new ElementoDAO();
		elementoDAO.save(r);

		return r;

	}

	public static Utente saveUtente() {
		Utente u = new Utente();
		u.setNome("");
		u.setCognome("");
		u.setDatanascita(LocalDate.parse(""));

		UtenteDAO utenteDAO = new UtenteDAO();
		utenteDAO.save(u);

		return u;

	}

	public static Prestito savePrestito(Utente utente, ElementoBiblioteca elemento) {
		Prestito p = new Prestito();
		p.setUtente_id(utente.getNumerotessera());
		p.setPrestato(elemento.getTitolo());
		p.setInizioprestito(LocalDate.parse(""));
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
		elementoDAO.ricercaByISBN(00000000000000L);

	}

	public static void searchAutore() {
		ElementoDAO elementoDAO = new ElementoDAO();
		elementoDAO.ricercaByAutore("C. S. Lewis");

	}

	public static void searchAnno() {
		ElementoDAO elementoDAO = new ElementoDAO();
		elementoDAO.ricercaByAnno(0000);

	}

	public static void searchTitoloParz() {
		ElementoDAO elementoDAO = new ElementoDAO();
		elementoDAO.ricercaParzialeTitolo("");

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

		// Libro libro = saveLibro();

//		Utente utente = saveUtente();
//		
//		Rivista rivista = saveRivista();
//		
		// searchISBN();
		// searchAutore();
		// searchAnno();
		// searchTitoloParz();
		// searchTessera();
		// searchScaduti();

//		Prestito prestito = savePrestito(utente, libro);

	}

}
