    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesDAO;

import InterfaceDAO.InterfaceLocalizacaoDAO;
import controler.Localizacao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Josiel
 */
public class LocalizacaoDAO extends ConectionDAO implements InterfaceLocalizacaoDAO {

    
    @Override
    public void criar(Localizacao localizacao) {

        String criarLocalizacao;
        criarLocalizacao = "INSERT INTO localizacao(IdLocalizacao,CEP,Numero,Rua,Bairro,Cidade) "
                + "VALUES(?,?,?,?,?,?)";

        conectar(criarLocalizacao);

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
            imprimeErro("Erro ao inserir localizacao", ex.getMessage());
        }
    }

    
    @Override
    public Localizacao buscar() {

        String buscarLocalizacao = "SELECT MAX(idLocalizacao) FROM localizacao";

        Localizacao localizacao = new Localizacao();
        conectar(buscarLocalizacao);

        try {
            ResultSet result;
            result = pstm.executeQuery();

            while (result.next()) {
                localizacao.setIdLocalizacao(result.getString("idLocalizacao"));
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

        String atualiza = "UPDATE localizacao SET " 
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
        String remove = "DELETE FROM localizacao WHERE IdLocalizacao = ?";
        conectar(remove);
        try {

            pstm.setString(1, localizacao.getIdLocalizacao());
            pstm.execute();
            fechar();
            System.out.println("Localizacao removida com sucesso");

        } catch (SQLException e) {
            imprimeErro("Erro ao apagar Localizacao", e.getMessage());
        }
    }

    @Override
    public ArrayList<Localizacao> buscarLocalizacoes() {

        String buscarTodos = "SELECT *  FROM localizacao";

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
            imprimeErro("Erro ao Buscar todas as Localizacoes", ex.getMessage());
        }
        return locais;
    }

}
