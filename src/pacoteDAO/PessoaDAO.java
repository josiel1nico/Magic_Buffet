/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacoteDAO;

import conexao.ConectionFactory;
import controler.Gerente;
import controler.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
        String SQL;
        SQL = "INSERT INTO Pessoa (cpf,gerente_Login,pnome,rg,rua,numero,bairro,cep,tipoPessoa,telefone)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            conectar(SQL);
            pstm.setString(1, pessoa.getCpf());
            pstm.setString(2, pessoa.getGerenteLogin());
            pstm.setString(3, pessoa.getPnome());
            pstm.setInt(4, pessoa.getRg());
            pstm.setString(5, pessoa.getRua());
            pstm.setInt(6, pessoa.getNumero());
            pstm.setString(7, pessoa.getBairro());
            pstm.setString(8, pessoa.getCep());
            pstm.setString(9, pessoa.getTipoPessoa());
            pstm.setString(10, pessoa.getTelefone());
            pstm.execute();
            pstm.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Pessoa buscar(String id) {

        String buscarPessoa = "SELECT * FROM Pessoa WHERE cpf LIKE " + id; //busca apenas uma pessoa pelo CPF
        ResultSet rset;
        Pessoa pessoa = new Pessoa();
        try {
            conectar(buscarPessoa);
            rset = pstm.executeQuery();
            while (rset.next()) {
                pessoa.setCpf(rset.getString("CPF"));
                pessoa.setRg(rset.getInt("RG"));
                pessoa.setGerenteLogin(rset.getString("Gerente_login"));
                pessoa.setCep(rset.getString("CEP"));
                pessoa.setRua(rset.getString("Rua"));
                pessoa.setBairro(rset.getString("Bairro"));
                pessoa.setTelefone(rset.getString("Telefone"));
                pessoa.setNumero(rset.getInt("Numero"));
                pessoa.setPnome(rset.getString("PNome"));
                pessoa.setTipoPessoa(rset.getString("TipoPessoa"));
            }
        } catch (SQLException ex) {
            System.err.println("CPF De Pessoa nao confere com dados do banco");
        }   
        fechar();
        return pessoa;
    }

    //Atualiza uma determinada pessoa
    @Override
    public void atualizar(Object object) {
        Pessoa pessoa = (Pessoa) object;
        String atualizar;
        
        atualizar = "UPDATE pessoa SET (gerenteLogin,pnome,rg,rua,numero,bairro,cep,tipoPessoa,telefone)"
                + "VALUES(?,?,?,?,?,?,?,?,?) WHERE cpf = ?";
        try {
            conectar(atualizar);
            pstm.setString(1, pessoa.getCpf());
            pstm.setString(2, pessoa.getGerenteLogin());
            pstm.setString(3, pessoa.getPnome());
            pstm.setInt(4, pessoa.getRg());
            pstm.setString(5, pessoa.getRua());
            pstm.setInt(6, pessoa.getNumero());
            pstm.setString(7, pessoa.getBairro());
            pstm.setString(8, pessoa.getCep());
            pstm.setString(9, pessoa.getTipoPessoa());
            pstm.setString(10, pessoa.getTelefone());
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
   }

    //REMOVE UMA PESSOA DO BANCO DE DADOS
    @Override
    public void remover(Object object) {
        Pessoa pessoa = (Pessoa) object;
        String sql = "DELETE FROM Pessoa where CPF = ?";
        try {
            conectar(sql);
            pstm.setString(1, pessoa.getCpf());
            pstm.execute();
            pstm.close();
            System.out.println("Pessoa removida com sucesso");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

   
    
    
    
    
    
    
     public void conectar(String sql) throws SQLException {
        conn = new ConectionFactory().getConnection();
        pstm = conn.prepareStatement(sql);
    }

    public void fechar() {
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
            System.out.println("Conexão Fechada");
        } catch (Exception e) {
            System.err.println("erro ao fechar conexao");
        }
    }

    @Override
    public List<Object> buscarObjects(String nome) {
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
