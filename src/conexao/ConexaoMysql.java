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
public class ConexaoMysql {

    Connection connection = null;

    public ConexaoMysql() {
    }
        
    public Connection Conectar() {
        
        //Carregando o jdbc Driver padrão
        String drivername = "com.mysql.jdbc.Driver";
        try {
            Class.forName(drivername);
            // Configurando a nossa conexão com um banco de dados//  
            String serverName = "localhost";    //caminho do servidor do BD  
            String mydatabase = "projetobd";        //nome do banco de dados  
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;  
            String username = "root";        //nome do usuario do BD        
            String password = "josiel";      //senha de acesso  
            
            System.out.println("Conectando ao BD");
            connection = DriverManager.getConnection(url, username, password);  
                      
        } catch (ClassNotFoundException ex) {   //Driver nao encontrado
            System.err.println("O driver especificado nao foi encontrado");
            return null;
        } catch (SQLException ex) {
            System.err.println("Nao foi possivel se conectar ao Banco de Dados");
            return null;
        }   
        return connection; 
      }
    
    
    
    //metodo que fecha conexao com o banco de dados
    public boolean Desconectar() {
        try {
            //fecha conexao
            System.out.println("Fechando a conexao...");
            connection.close();
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
            if (connection != null) {
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
        return Conectar();
    }

    
     public static void main(String[] args) {
        ConexaoMysql con = new ConexaoMysql();
        con.Conectar();
        con.StatusConexao();
        //con.Desconectar();
        
    }

}

