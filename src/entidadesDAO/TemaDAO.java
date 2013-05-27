/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesDAO;

import InterfaceDAO.InterfaceTemaDAO;
import conexao.ConectionFactory;
import controler.Tema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Josiel
 */
public class TemaDAO implements InterfaceTemaDAO {

    private Connection conn;
    private PreparedStatement pstm;

    @Override
    public void criar(Tema tema) {

        String criar = "INSERT INTO Tema (IdTema, Tnome, TipoFesta)"
                + "VALUES(?, ?, ?)";
        conectar(criar);
        try {
            pstm.setString(1, tema.getIdTema());
            pstm.setString(2, tema.getTnome());
            pstm.setString(3, tema.getTipoFesta());
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
                tema.setTipoFesta(result.getString("TipoFesta"));
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
                + "TipoFesta = ? "
                + "WHERE IdTema = ?";

        conectar(atualizar);
        try {
            pstm.setString(1, tema.getTnome());
            pstm.setString(2, tema.getTipoFesta());
            pstm.setString(3, tema.getIdTema());

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
                tema.setTipoFesta(result.getString("TipoFesta"));
                
                temas.add(tema);
            }
            return temas;
        } catch (SQLException ex) {
            imprimeErro("Erro ao Buscar todos os Temas", ex.getMessage());
        }       
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
