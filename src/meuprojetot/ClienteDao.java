package meuprojetot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteDao {
    
    Connection conexao;
    
    public ClienteDao() throws SQLException{
        this.conexao = Conexao.getConexao();
    }
    
    public void CadastrarCliente(Cliente cliente) throws SQLException{
        
        String sql = "INSERT INTO cliente (nome, email, telefone, cpf) VALUES (?,?,?,?)";
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getEmail());
        stmt.setString(3, cliente.getTelefone());
        stmt.setString(4, cliente.getCpf());
        
        stmt.execute();
        
        // PS. não se pode colocar Views em Classes DAO (Model)
        JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!");
        
    }
    
}
