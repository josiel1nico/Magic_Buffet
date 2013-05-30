/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesDAO;

import InterfaceDAO.InterfacePessoaDAO;
import controler.Gerente;
import controler.Pessoa;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Josiel
 */
public class GerenteDAO extends PessoaDAO implements InterfacePessoaDAO {


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
}
