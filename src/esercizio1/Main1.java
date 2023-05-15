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
			System.out.println("connesso!!!" + conn);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		insertClienti(4, "erz", "ciu", 1980, "Sicilia");
	}

	public static void insertClienti(Integer NumeroCliente, String Nome, String Cognome, Integer DataNascita,
			String RegioneResidenza) {
		String sqlInsert = "INSERT INTO public.clienti (NumeroCliente,Nome,Cognome,DataNascita,RegioneResidenza) VALUES(?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sqlInsert);
			stmt.setInt(1, NumeroCliente);
			stmt.setString(2, Nome);
			stmt.setString(3, Cognome);
			stmt.setInt(4, DataNascita);
			stmt.setString(5, RegioneResidenza);
			stmt.execute();
			System.out.println("Cliente inserito!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
