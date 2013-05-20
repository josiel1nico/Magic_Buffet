/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.SQLException;
import pacoteDAO.PessoaDAO;


/**
 *
 * @author Josiel
 */
public class TestaConexao {
    
    public static void main(String[] args) throws SQLException {
        
        Connection connection = new ConectionFactory().getConnection();
        System.out.println("Conexao aberta");
        //connection.close();
        
        //criar um Cliente e salvar no banco
        
        
        
        
        
    }
}
