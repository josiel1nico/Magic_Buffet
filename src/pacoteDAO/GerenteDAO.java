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
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Josiel
 */
public class GerenteDAO extends PessoaDAO {
    
    public void criarGerente(Object object){
        Gerente gerente = (Gerente) object;
        //String sql2 = "INSERT INTO Pessoa(gerente_Login)" + "VALUES(?)";
        
        String sql = "INSERT INTO Gerente(Login, Senha)" + "VALUES(?,?)";
        PreparedStatement pstm = null;
        Connection con = null;

        try {
            con = new ConectionFactory().getConnection();
            pstm = con.prepareStatement(sql);           

            pstm.setString(1, gerente.getLogin());
            pstm.setString(2, gerente.getSenha());
         

            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }

  
    
}
