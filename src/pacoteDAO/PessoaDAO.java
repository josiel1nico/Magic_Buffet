/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacoteDAO;

import conexao.ConectionFactory;
import controler.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josiel e Andreza
 */
public class PessoaDAO implements InterfaceDAO {
    private Connection conn;
    private PreparedStatement pstm;
    
    @Override
    public void criar(Object object) {
        Pessoa pessoa = (Pessoa) object;
        String sql;
        sql = "INSERT INTO Pessoa (cpf,pnome,rg,rua,numero,bairro,cep,tipoPessoa,telefone)"
             + "VALUES(?,?,?,?,?,?,?,?,?)";
        try {                        
                conectar(sql);
                pstm.setString(1, pessoa.getCpf());
                pstm.setString(2, pessoa.getPnome());
                pstm.setInt(3, pessoa.getRg());
                pstm.setString(4, pessoa.getRua());
                pstm.setInt(5, pessoa.getNumero());
                pstm.setString(6, pessoa.getBairro());
                pstm.setString(7, pessoa.getCep());
                pstm.setString(8, pessoa.getTipoPessoa());
                pstm.setString(9, pessoa.getTelefone());

                pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }                       
    }

    @Override
    public Pessoa buscarPessoa(String id) {
       
        String sql = "SELECT * FROM Pessoa WHERE id = CPF";              
        ResultSet rset;
        Pessoa pessoa = new Pessoa();              
        try {           
            conectar(sql);
            rset = pstm.executeQuery();
            while(rset.next()){
                pessoa.setCpf(rset.getString("CPF"));
                pessoa.setRg(rset.getInt("RG"));
                pessoa.setCep(rset.getString("CEP"));
                pessoa.setRua(rset.getString("Rua"));
                pessoa.setBairro(rset.getString("Bairro"));
                pessoa.setTelefone(rset.getString("Telefone"));
                pessoa.setNumero(rset.getInt("Numero"));
                pessoa.setPnome(rset.getString("PNome"));
                pessoa.setTipoPessoa(rset.getString("TipoPessoa"));
                
            }
 
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }              
        fechar();
        return pessoa;                
    }
    
    public void conectar(String sql) throws SQLException{
            conn = new ConectionFactory().getConnection();
            pstm = conn.prepareStatement(sql);
    }
    
    public void fechar(){
        try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
        } catch (Exception e) {
            System.out.println("erro ao fechar conexao");
            }
    }
    
    @Override
    public void atualizar(int id, Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(String id) {
    }

  
}

