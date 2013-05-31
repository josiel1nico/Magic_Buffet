/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesDAO;

import InterfaceDAO.InterfaceTemaDAO;
import controler.Tema;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Josiel
 */
public class TemaDAO extends  ConectionDAO implements InterfaceTemaDAO {

    @Override
    public void criar(Tema tema) {

        String criar = "INSERT INTO tema (IdTema, Tnome)"
                + "VALUES(?, ?)";
        conectar(criar);
        try {
            pstm.setString(1, tema.getIdTema());
            pstm.setString(2, tema.getTnome());            
            pstm.execute();
            pstm.close();

        } catch (SQLException ex) {
            imprimeErro("Erro Criar Tema", ex.getMessage());
        }
    }

    @Override
    public Tema buscar(String idTema) {
        String buscaTema = "SELECT * FROM Tema WHERE IdTema LIKE " + idTema;
        ResultSet result;
        Tema tema = new Tema();

        conectar(buscaTema);
        try {
            result = pstm.executeQuery();
            while (result.next()) {
                tema.setIdTema(result.getString("IdTema"));
                tema.setTnome(result.getString("Tnome"));                
            }

        } catch (SQLException ex) {
            imprimeErro("Tema nao cadastrado", ex.getMessage());
        }
        fechar();
        return tema;
    }

    @Override
    public void atualizar(Tema tema) {
        String atualizar = "UPDATE Tema SET "
                + "Tnome = ?,"                
                + "WHERE IdTema = ?";

        conectar(atualizar);
        try {
            pstm.setString(1, tema.getTnome());
            pstm.setString(2, tema.getIdTema());            

            pstm.executeUpdate();
            System.out.println("Tema atualizado");
            fechar();

        } catch (SQLException ex) {
            imprimeErro("Tema nao Atualizado", ex.getMessage());
        }


    }

    @Override
    public void remover(Tema tema) {

        String remove = "DELETE FROM Tema WHERE IdTema = ?";
        conectar(remove);
        try {
            pstm.setString(1, tema.getIdTema());
            pstm.execute();
            pstm.close();
            System.out.println("Tema Removido com sucesso");
        } catch (SQLException ex) {
            imprimeErro("Erro ao Remover Tema", ex.getMessage());
        }

    }

    @Override
    public ArrayList<Tema> buscarTema() {
        
        String BuscaTodos = "SELECT * FROM Tema ";
        
        ArrayList<Tema> temas = new ArrayList<>();
        ResultSet result;
        conectar(BuscaTodos);
        try {
            result = pstm.executeQuery();
            while (result.next()) {
                
                Tema tema = new Tema();
                tema.setIdTema(result.getString("IdTema"));
                tema.setTnome(result.getString("Tnome"));                
                
                temas.add(tema);
            }
            return temas;
        } catch (SQLException ex) {
            imprimeErro("Erro ao Buscar todos os Temas", ex.getMessage());
        }       
        return null;
    }
}
