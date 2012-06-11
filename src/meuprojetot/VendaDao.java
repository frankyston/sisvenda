package meuprojetot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VendaDao {
    
    Connection conexao;
    public VendaDao() throws SQLException{
        this.conexao = Conexao.getConexao();
    }
    
    public void CadastrarVenda(Venda venda) throws SQLException{
        
        String sql = "INSERT INTO venda (funcionario, cliente, produto, pagamento) VALUES (?,?,?,?)";
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setString(1, venda.getFuncionario());
        stmt.setString(2, venda.getCliente());
        stmt.setString(3, venda.getProduto());
        stmt.setDouble(4, venda.getPagamento());
        
        stmt.execute();
        
        // PS. não se pode colocar Views em Classes DAO (Model)
        JOptionPane.showMessageDialog(null, "Venda Cadastrado com Sucesso!");
        
        stmt.close();
    }
    
    public ArrayList<String> getFuncionarios() throws SQLException{
        
        String sql = "SELECT * FROM funcionario";
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<String> funcionarios = new ArrayList<String>();
        
        while(rs.next()){
            funcionarios.add(rs.getString("nome"));
        }
        
        return funcionarios;
        
    }
    
    public ArrayList<String> getClientes() throws SQLException{
        
        String sql = "SELECT * FROM cliente";
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<String> clientes = new ArrayList<String>();
        
        while(rs.next()){
            clientes.add(rs.getString("nome"));
        }
        
        return clientes;
        
    }
    
    public void RemoverVenda(int id) throws SQLException{
        String sql = "DELETE FROM venda WHERE id = ?";
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setInt(1, id);
        
        int result = stmt.executeUpdate();
        
        if(result == 1){
            JOptionPane.showMessageDialog(null, "Venda Removido com Sucesso!");
        } else{
            JOptionPane.showMessageDialog(null, "Erro ao Remover Venda!");
        }
        stmt.close();
    }
    
    public ArrayList<Venda> getVendas() throws SQLException{
        
        String sql = "SELECT * FROM venda";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<Venda> vendas = new ArrayList<Venda>();
        
        while(rs.next()){
            Venda v = new Venda();
            v.setFuncionario(rs.getString("funcionario"));
            v.setCliente(rs.getString("cliente"));
            v.setProduto(rs.getString("produto"));
            v.setPagamento(rs.getDouble("pagamento"));
            
            vendas.add(v);
        }
        
        return vendas;
    }
}
