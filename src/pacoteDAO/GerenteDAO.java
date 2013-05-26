/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacoteDAO;

import InterfaceDAO.InterfacePessoaDAO;
import conexao.ConectionFactory;
import controler.Gerente;
import controler.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Josiel
 */
public class GerenteDAO extends PessoaDAO implements InterfacePessoaDAO {

    PreparedStatement pstm = null;
    Connection con = null;

    public void criarGerente(Gerente gerente) {
        
        //String sql2 = "INSERT INTO Pessoa(gerente_Login)" + "VALUES(?)";

        String sql = "INSERT INTO Gerente"
                + "Login = ?, "
                + "Senha = ?";
        try {
            conectar(sql);

            pstm.setString(1, gerente.getLogin());
            pstm.setString(2, gerente.getSenha());
            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();

            fechar();
        }

    }

    public void conectar(String sql) throws SQLException {
        con = new ConectionFactory().getConnection();
        pstm = con.prepareStatement(sql);
    }

    public void fechar() {
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
            System.out.println("Conexão Fechada");
        } catch (Exception e) {
            System.err.println("erro ao fechar conexao");
        }
    }

    @Override
    public void criar(Pessoa pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pessoa buscar(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Pessoa pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pessoa> buscarPessoas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
