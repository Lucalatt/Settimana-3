package Esercizio1;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.Date;

public class Clienti extends DB {

	String nome;
	String cognome;
	LocalDate data_nascita;
	String regione_residenza;

	public Clienti(String nome, String cognome, LocalDate data_nascita, String regione_residenza) {
		super();

		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		this.regione_residenza = regione_residenza;
	}

	public void insertClient() {

		try {
			String sql = "INSERT INTO clienti  (nome, cognome, data_nascita, regione_residenza) VALUES (?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, nome);
			stmt.setString(2, cognome);
			stmt.setDate(3, java.sql.Date.valueOf(data_nascita));
			stmt.setString(4, regione_residenza);
			stmt.execute();

			System.out.println("Insert is successful!");
		} catch (SQLException e) {
			System.out.println("There was an error during inserting data");
			e.printStackTrace();
		}

	}

	public void extractClient() {

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT nome, cognome, regione_residenza FROM clienti WHERE data_nascita BETWEEN '1982-01-01' AND '1982-12-31'");

			System.out.println("Clienti:");
			while (rs.next()) {
				System.out.printf("Nome: %s%nCognome: %s%nResidenza: %s%n",

						rs.getString("nome"), rs.getString("cognome"), rs.getString("regione_residenza"));
				System.out.println("-----------------------------------------------");
			}

		} catch (SQLException e) {
			System.out.println("There was an error during selecting data");
			e.printStackTrace();
		}

	}

}
