/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesDAO;

import InterfaceDAO.InterfaceGerenteDAO;
import controler.Gerente;
import java.sql.SQLException;


/**
 *
 * @author Josiel
 */
public class GerenteDAO extends PessoaDAO implements InterfaceGerenteDAO {


    @Override
    public void criarGerente(Gerente gerente) {
        
        String sql = "INSERT INTO gerente(Login,Senha)" + "VALUES (?,?)";
        try {
            conectar(sql);

            pstm.setString(1, gerente.getLogin());
            pstm.setString(2, gerente.getSenha());
            pstm.execute();
            pstm.close();

        } catch (SQLException ex) {
            imprimeErro("Erro ao Cadastrar as informações do Gerente", ex.getMessage());
            fechar();
        }

    }
}
