package esercizio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main1 {

	static Connection conn = null;

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/U4-D11?useSSL=false";
		String username = "postgres";
		String password = "epicode";
		try {
			System.out.println("connessione...");
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("connesso!!!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// insertClienti(4, "erz", "ciu", 1980, "Sicilia");
		insertFatture(1, "Azienda", 150, 20, 100, 68749, 2015);
	}

	public static void insertFatture(Integer numeroFattura, String tipologia, Integer Importo, Integer Iva,
			Integer IdCliente, Integer NumeroFornitore, Integer DataFattura) {
		String sqlInsert = "INSERT INTO public.fatture (numeroFattura,tipologia,Importo,Iva,IdCliente,NumeroFornitore,DataFattura) VALUES(?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sqlInsert);
			stmt.setInt(1, 1);
			stmt.setString(2, "Azienda");
			stmt.setInt(3, 150);
			stmt.setInt(4, 20);
			stmt.setInt(5, 100);
			stmt.setInt(6, 68749);
			stmt.setInt(7, 2015);
			stmt.execute();
			System.out.println("Fattura inserito!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}