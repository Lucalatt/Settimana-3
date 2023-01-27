package gestioneEventi;

import java.time.LocalDate;
import entities.TipoEvento;
import eventoDAO.EventoDAO;


public class Main extends EventoDAO {

	public static void main(String[] args) {

		boolean save = false;
		boolean getById = false;
		boolean delete = false;
		boolean refresh = true;
		
		if( save ) 
			save("Italia - Francia", LocalDate.parse("2023-06-02"), TipoEvento.PUBBLICO, "Sei Nazioni", 80_000 );
		
		if( getById )
			getById(1);
		
		if( delete )
			delete(2);
		
		if( refresh )
			refresh(3, LocalDate.parse("2023-12-02"), TipoEvento.PRIVATO);

	}
	
	

}
