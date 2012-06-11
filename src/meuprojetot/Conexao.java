package meuprojetot;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection getConexao() throws SQLException{

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Conectado com Sucesso");
return DriverManager.getConnection(
		"jdbc:mysql://localhost/sisvenda","root", ""); 
		} catch (ClassNotFoundException e) {
			throw new SQLException("Erro ao conectar: " + 
							e.getMessage());
		}
	}
}
