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
            pstm.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Pessoa buscarPessoa(String id) {

        String sql = "SELECT * FROM Pessoa WHERE cpf LIKE " + id; //busca apenas uma pessoa pelo CPF
        ResultSet rset;
        Pessoa pessoa = new Pessoa();
        try {
            conectar(sql);
            rset = pstm.executeQuery();
            while (rset.next()) {
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
            System.err.println("CPF De Pessoa nao confere com dados do banco");
        }
        fechar();
        return pessoa;
    }

    //Atualiza uma determinada pessoa
    @Override
    public void atualizar(String id,Object object) {
        Pessoa pessoa = (Pessoa) object;
        String sql;
        if(!pessoa.getGerenteLogin().equals(""))
        { 
            sql = "UPDATE Pessoa "
               + "SET cpf = ?" + pessoa.getCpf() +
                "gerenteLogin = ?" + pessoa.getGerenteLogin()  +
                "nome = ?" + pessoa.getPnome() +
                "rg = ?" + pessoa.getRg() +
                "rua = ?" + pessoa.getRua()+
                "numero = ?" + pessoa.getNumero() +
                "bairro = ?" + pessoa.getBairro() +
                "sep = ?" + pessoa.getCep() +
                "tipoPessoa = ?" + pessoa.getTipoPessoa() +
                "telefone = ?" + pessoa.getTelefone();
        }else 
        {
            
            sql = "UPDATE Pessoa "
               + "SET cpf = ?" + pessoa.getCpf() +
                "gerenteLogin = ?" + null  +
                "nome = ?" + pessoa.getPnome() +
                "rg = ?" + pessoa.getRg() +
                "rua = ?" + pessoa.getRua()+
                "numero = ?" + pessoa.getNumero() +
                "bairro = ?" + pessoa.getBairro() +
                "sep = ?" + pessoa.getCep() +
                "tipoPessoa = ?" + pessoa.getTipoPessoa() +
                "telefone = ?" + pessoa.getTelefone();
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

    @Override
    public List<Object> buscarPessoas(String nome) {
        
        return null;
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
}
