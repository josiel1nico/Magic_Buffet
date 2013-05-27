/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesDAO;

import InterfaceDAO.InterfaceLocalizacaoDAO;
import conexao.ConectionFactory;
import controler.Localizacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Josiel
 */
public class LocalizacaoDAO implements InterfaceLocalizacaoDAO {

    private Connection conn;
    private PreparedStatement pstm;

    @Override
    public void criar(Localizacao localizacao) {

        String SQL;
        SQL = "INSERT INTO Localizacao(IdLocalizacao,CEP,Numero,Rua,Bairro,Cidade) "
                + "VALUES(?,?,?,?,?,?)";

        conectar(SQL);

        try {

            pstm.setString(1, localizacao.getIdLocalizacao());
            pstm.setString(2, localizacao.getCEP());
            pstm.setInt(3, localizacao.getNumero());
            pstm.setString(4, localizacao.getRua());
            pstm.setString(5, localizacao.getBairro());
            pstm.setString(6, localizacao.getCidade());
            pstm.execute();
            pstm.close();

        } catch (SQLException ex) {
            imprimeErro("Erro ao inserir Localizacao", ex.getMessage());
        }
    }

    @Override
    public Localizacao buscar(String IdLocalizacao) {

        String buscarLocalizacao = "SELECT * FROM Localizacao WHERE IdLocalizacao LIKE " + IdLocalizacao;

        Localizacao localizacao = new Localizacao();
        conectar(buscarLocalizacao);

        try {
            ResultSet result;
            result = pstm.executeQuery();

            while (result.next()) {
                localizacao.setIdLocalizacao(result.getString("IdLocalizacao"));
                localizacao.setCEP(result.getString("CEP"));
                localizacao.setRua(result.getString("Rua"));
                localizacao.setNumero(result.getInt("Numero"));
                localizacao.setBairro(result.getString("Bairro"));
                localizacao.setCidade(result.getString("Cidade"));
            }

        } catch (SQLException ex) {
            imprimeErro("Erro ao buscar Localizacao", ex.getMessage());
        }
        fechar();
        return localizacao;
    }

    // TÁ COM PROBLEMA REFAZER
    @Override
    public void atualizar(Localizacao localizacao) {

        String atualiza = "UPDATE Localizacao SET"
                + "CEP = ?,"
                + "Numero = ?,"
                + "Rua = ?,"
                + "Bairro = ?,"
                + "Cidade = ? "
                + "WHERE IdLocalizacao = ?";

        conectar(atualiza);

        try {
            pstm.setString(1, localizacao.getCEP());
            pstm.setInt(2, localizacao.getNumero());
            pstm.setString(3, localizacao.getRua());
            pstm.setString(4, localizacao.getBairro());
            pstm.setString(5, localizacao.getCidade());
            pstm.setString(6, localizacao.getIdLocalizacao());

            pstm.executeUpdate();

            System.out.println("Localizacao Atualizada");
            fechar();

        } catch (SQLException ex) {
            imprimeErro("Erro ao Atualizar Localizacao", ex.getMessage());
        }
    }

    @Override
    public void remover(Localizacao localizacao) {
        String remove = "DELETE FROM Localizacao WHERE IdLocalizacao = ?";
        conectar(remove);
        try {

            pstm.setString(1, localizacao.getIdLocalizacao());
            pstm.execute();
            pstm.close();
            System.out.println("Localizacao removida com sucesso");

        } catch (SQLException e) {
            imprimeErro("Erro ao apagar Localizacao", e.getMessage());
        }
    }

    @Override
    public ArrayList<Localizacao> buscarLocalizacoes() {

        String buscarTodos = "SELECT *  FROM Localizacao";

        ArrayList<Localizacao> locais = new ArrayList<>();
        ResultSet result;
        conectar(buscarTodos);

        try {
            result = pstm.executeQuery();

            while (result.next()) {
                Localizacao localizacao = new Localizacao();
                localizacao.setIdLocalizacao(result.getString("IdLocalizacao"));
                localizacao.setCEP(result.getString("CEP"));
                localizacao.setRua(result.getString("Rua"));
                localizacao.setNumero(result.getInt("Numero"));
                localizacao.setBairro(result.getString("Bairro"));
                localizacao.setCidade(result.getString("Cidade"));

                locais.add(localizacao);
            }
        } catch (SQLException ex) {
            imprimeErro("Erro ao apagar Localizacao", ex.getMessage());
        }
        return locais;
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

    private Exception RuntimeException(SQLException ex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
