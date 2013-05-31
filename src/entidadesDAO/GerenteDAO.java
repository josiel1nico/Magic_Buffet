/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesDAO;

import InterfaceDAO.InterfaceGerenteDAO;
import controler.Gerente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    
    @Override
    public Gerente buscarGerente(String login){
        String sql = "SELECT * FROM gerente WHERE Login LIKE '" + login + "'"; 
        conectar(sql);
        Gerente gerente = new Gerente();
        try {
            ResultSet result = pstm.executeQuery();
            while(result.next()){
                gerente.setSenha(result.getString("Senha"));
                gerente.setLogin(result.getString("Login"));                
            }
            
        } catch (SQLException ex) {
            imprimeErro("Erro ao Buscar Gerente", ex.getMessage());
        }   
        fechar();
        return gerente;
    }
    
    @Override
    public void removerGerente(Gerente gerente) {

        String sql = "DELETE FROM gerente WHERE login = ?";
        conectar(sql);

        try {
            pstm.setString(1, gerente.getLogin());
            pstm.execute();
            pstm.close();
            System.out.println("Pessoa removida com sucesso");
        } catch (SQLException ex) {
            imprimeErro("Erro ao Remover Gerente", ex.getMessage());
        }
    }

}
