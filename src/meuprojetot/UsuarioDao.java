/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package meuprojetot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDao {
    
    Connection conexao;
    
    public UsuarioDao() throws SQLException{
        this.conexao = Conexao.getConexao();
    }
    
    public void CadastrarUsuario(Usuario usuario) throws SQLException{
        
        String sql = "INSERT INTO users (nome, email, telefone, login, senha) VALUES (?,?,?,?,?)";
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getEmail());
        stmt.setString(3, usuario.getTelefone());
        stmt.setString(4, usuario.getLogin());
        stmt.setString(5, usuario.getSenha());
        
        stmt.execute();
        // PS. não se pode colocar Views em Classes DAO (Model)
        JOptionPane.showMessageDialog(null, "Usuário Cadastrado com Sucesso!");
        
        stmt.close();
        
    }
    
    public void RemoverUsuario(String login) throws SQLException{
        
        String sql = "DELETE FROM users WHERE login = ?";
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setString(1, login);
        
        int result = stmt.executeUpdate();
        
        if(result == 1){
            JOptionPane.showMessageDialog(null, "Usuário Removido com Sucesso!");
        } else{
            JOptionPane.showMessageDialog(null, "Erro ao Remover Usuário!");
        }
    }
    
}
