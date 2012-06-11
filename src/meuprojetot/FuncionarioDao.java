package meuprojetot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FuncionarioDao {
 
    Connection conexao;
    
    public FuncionarioDao() throws SQLException{
        this.conexao = Conexao.getConexao();
    }
    
    public void CadastrarFuncionario(Funcionario funcionario) throws SQLException{
        
        String sql = "INSERT INTO funcionario (nome, email, telefone, salario) VALUES (?,?,?,?)";
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setString(1, funcionario.getNome());
        stmt.setString(2, funcionario.getEmail());
        stmt.setString(3, funcionario.getTelefone());
        stmt.setDouble(4, funcionario.getSalario()); 
        
        System.out.println(funcionario.getSalario());
        
        stmt.execute();
        
        // PS. não se pode colocar Views em Classes DAO (Model)
        JOptionPane.showMessageDialog(null, "Funcionario Cadastrado com Sucesso!");
    }
    
}
