package br.com.contatos.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	String driver = "org.postgresql.Driver";
    String usuario = "postgres";
    String senha = "postgres";
    String url = "jdbc:postgresql://localhost:5432/Contatos";
    
	public Connection getConnection() {
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url,usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
}
