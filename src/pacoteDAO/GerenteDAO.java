/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacoteDAO;

import conexao.ConectionFactory;
import controler.Gerente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Josiel
 */
public class GerenteDAO extends PessoaDAO {
    
      PreparedStatement pstm = null;
      Connection con = null;
    
    public void criarGerente(Object object){
        Gerente gerente = (Gerente) object;
        //String sql2 = "INSERT INTO Pessoa(gerente_Login)" + "VALUES(?)";
        
        String sql = "INSERT INTO Gerente(Login, Senha)" + "VALUES(?,?)";
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
    
}
