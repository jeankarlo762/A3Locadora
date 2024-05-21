package database;

import java.sql.Connection;
import java.sql.SQLException;

public class BaseDeDados {
	

	  public static void main(String[] args) {
		  
	        try {
	            // Obtém uma conexão com o banco de dados
	            Connection connection = DatabaseConnection.getConnection();
	            System.out.println("Conexão bem-sucedida ao banco de dados.");
	            // Fecha a conexão
	            connection.close();
	        } catch (SQLException e) {
	            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
	        }
	    }
	}