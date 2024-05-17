package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Método para obter uma conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/locadora";
        String user = "root";
        String password = "root";
        
        Connection connection = DriverManager.getConnection(url, user, password);
//        System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
        return connection;
    }
}
