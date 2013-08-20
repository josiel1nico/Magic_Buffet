    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesDAO;

import InterfaceDAO.BuscaInterface;
import InterfaceDAO.BuscaMultiplaInterface;
import InterfaceDAO.GenericInterface;
import controler.Localizacao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import view.Mensagens;


/**
 *
 * @author Josiel
 */
public class LocalizacaoDAO extends ConectionDAO implements GenericInterface, BuscaInterface, BuscaMultiplaInterface {

    private Mensagens mensagem =  new Mensagens();
    @Override
    public boolean criar(Object object) {

        String criarLocalizacao;
        criarLocalizacao = "INSERT INTO localizacao(IdLocalizacao,CEP,Numero,Rua,Bairro,Cidade) "
                + "VALUES(?,?,?,?,?,?)";

        conectar(criarLocalizacao);

        try {
            Localizacao localizacao = (Localizacao) object;
            pstm.setString(1, localizacao.getIdLocalizacao());
            pstm.setString(2, localizacao.getCEP());
            pstm.setInt(3, localizacao.getNumero());
            pstm.setString(4, localizacao.getRua());
            pstm.setString(5, localizacao.getBairro());
            pstm.setString(6, localizacao.getCidade());
            pstm.execute();
            pstm.close();
            return true;

        } catch (SQLException ex) {
           mensagem.imprimeErro("Erro ao inserir localizacao", ex.getMessage());
            return false;
        }
    }

    
    
    public Localizacao buscar2() {

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
           mensagem.imprimeErro("Erro ao buscar Localizacao", ex.getMessage());
        }
        fechar();
        return localizacao;
    }
    
    @Override
    public Object buscar(String...args) {

        String buscarLocalizacao = "SELECT * FROM localizacao WHERE CEP LIKE '"+ args[0] + "'";

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
            mensagem.imprimeErro("Erro ao buscar Localizacao", ex.getMessage());
        }
        fechar();
        return localizacao;
    }

    // TÁ COM PROBLEMA REFAZER
    @Override
    public boolean atualizar(Object object) {

        String atualiza = "UPDATE localizacao SET " 
                + "CEP = ?,"
                + "Numero = ?,"
                + "Rua = ?,"
                + "Bairro = ?,"
                + "Cidade = ? "
                + "WHERE IdLocalizacao = ?";

        conectar(atualiza);

        try {
            Localizacao localizacao = (Localizacao) object;
            pstm.setString(1, localizacao.getCEP());
            pstm.setInt(2, localizacao.getNumero());
            pstm.setString(3, localizacao.getRua());
            pstm.setString(4, localizacao.getBairro());
            pstm.setString(5, localizacao.getCidade());
            pstm.setString(6, localizacao.getIdLocalizacao());

            pstm.executeUpdate();
            System.out.println("Localizacao Atualizada");
            fechar();
            return true;

        } catch (SQLException ex) {
            mensagem.imprimeErro("Erro ao Atualizar Localizacao", ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean remover(Object object) {
        String remove = "DELETE FROM localizacao WHERE IdLocalizacao = ?";
        conectar(remove);
        try {
            Localizacao localizacao = (Localizacao) object;
            pstm.setString(1, localizacao.getIdLocalizacao());
            pstm.execute();
            fechar();
            System.out.println("Localizacao removida com sucesso");
            return true;
        } catch (SQLException e) {
            mensagem.imprimeErro("Erro ao apagar Localizacao", e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Object> buscar() {

        String buscarTodos = "SELECT *  FROM localizacao";

        ArrayList<Object> locais = new ArrayList<>();
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
            mensagem.imprimeErro("Erro ao Buscar todas as Localizacoes", ex.getMessage());
        }
        return locais;
    }

}
