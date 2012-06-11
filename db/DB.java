package db;

import java.sql.*;

public class DB {
    
    public static void main(String[] args) throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/mysql","root", "");
            
            PreparedStatement stmt = conexao.prepareStatement("CREATE DATABASE IF NOT EXISTS sisvenda");
            stmt.execute();
            
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/sisvenda","root", "");
            System.out.println("Banco Criando com Sucesso");
            
            stmt = conexao.prepareStatement("CREATE TABLE cliente (id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, email varchar(100), telefone varchar(10), cpf varchar(11))");
            stmt.execute();
            System.out.println("Tabela Cliente criando com Sucesso");
            
            stmt = conexao.prepareStatement("CREATE TABLE funcionario (id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, nome varchar(100), email varchar(100), telefone varchar(10), salario varchar(10))");
            stmt.execute();
            System.out.println("Tabela Funcionario criando com Sucesso");
            
            stmt = conexao.prepareStatement("CREATE TABLE users (id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, nome varchar(100), email varchar(100), telefone varchar(10), login varchar(30), senha varchar(30))");
            stmt.execute();
            System.out.println("Tabela Users criando com Sucesso");
            
            stmt = conexao.prepareStatement("CREATE TABLE venda (id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, funcionario varchar(100), cliente varchar(100), produto varchar(100), pagamento double(5,2))");
            stmt.execute();
            System.out.println("Tabela Venda criando com Sucesso");
            
            System.out.println("Fim...");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no Banco de Dados" + ex);
        }
    }
    
}
