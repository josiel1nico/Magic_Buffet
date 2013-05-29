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
import javax.swing.JOptionPane;

/**
 *
 * @author Josiel
 */
public class GerenteDAO extends PessoaDAO implements InterfacePessoaDAO {

    PreparedStatement pstm = null;
    Connection conn = null;

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

   

    @Override
    public void criar(Pessoa pessoa) {
        
    }

    @Override
    public Pessoa buscar(String cpf) {
        
        return  null;
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        
    }

    @Override
    public void remover(Pessoa pessoa) {
        
    }

    @Override
    public ArrayList<Pessoa> buscarPessoas() {
        return null;
    }
    
    
    public void conectar(String sql) {

        try {
            conn = new ConectionFactory().getConnection();
            pstm = conn.prepareStatement(sql);
        } catch (SQLException ex) {
            imprimeErro("Erro ao conectar", ex.getMessage());
        }
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
            imprimeErro("Erro ao fechar conexão", e.getMessage());
            //System.err.println("erro ao fechar conexao");
        }
    }

    private void imprimeErro(String msg, String msgErro) {
        JOptionPane.showMessageDialog(null, msg, "Erro crítico", 0);
        System.err.println(msg);
        System.out.println(msgErro);
        System.exit(0);
    }

    
}
