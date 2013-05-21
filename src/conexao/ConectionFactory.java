/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Josiel
 */
public class ConectionFactory {
   
    Connection connection = null;
    
   public Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost/projetobd"; //+ serverName + "/" + mydatabase;  
            String username = "root";        //nome do usuario do BD        
            String password = "586865";      //senha de acesso  
            System.out.println("Conectando ao BD");
            
            connection =  DriverManager.getConnection(url, username, password);
            return connection;
            
        } catch (SQLException e) {
            System.err.println("Nao foi possivel se conectar ao Banco de Dados");
            throw new RuntimeException(e);
        }    
    }
}

/*    
    
          
       //metodo que fecha conexao com o banco de dados
    public boolean Desconectar() {
        try {
            //fecha conexao
            System.out.println("Fechando a conexao...");
            con.close();
            System.out.println("Conexao fechada");
            return true;
        } catch (SQLException ex) {
            System.err.println("Nao foi possivel fechar a conexao");
            return false;
        }     
    }
  
    //retorna o Status da conexao
    public String StatusConexao(){  
        
        String status;
            //Testa sua conexão//  
            if (con != null) {
                status = ("STATUS--->Conectado com sucesso!");
                System.out.println(status);
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
                System.out.println(status);
            }
            
        return status;
    }
    
    //Metodo reiniciar conexao
    public Connection ReiniciarConexao() {
        Desconectar();
        System.out.println("Reinicializando a conexao...");
        return getConnection();
    }
    

*/
