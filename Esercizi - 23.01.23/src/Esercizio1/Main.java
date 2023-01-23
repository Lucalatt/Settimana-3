package Esercizio1;


import java.sql.Date;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DB db = new DB();
		db.connect();
		
		Clienti c1 = new Clienti ("Marco","Bianchi", LocalDate.of(1982, 01, 02) , "Lazio");
		
		
		boolean insertClient = false;
		if( insertClient ) {
			c1.insertClient();
		}
		
		boolean extractClient = true;
		if( extractClient ) {
			c1.extractClient();
		}
		
		db.disconnect();
	}

}
