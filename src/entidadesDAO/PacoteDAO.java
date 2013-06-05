/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesDAO;

import InterfaceDAO.InterfacePacoteDAO;
import controler.Item;
import controler.Pacote;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**DateDate
 *
 * @author Josiel
 */
public class PacoteDAO extends ConectionDAO implements InterfacePacoteDAO {

    public void criarItensPacote(Pacote pacote){
          for (String item : pacote.getItensPacote()) {

                String insert = "INSERT INTO pacote_contem_item (chavePacote, chaveItem, nomePacote)"
                        + "VALUES (?,?,?)";
                
             
              try {
                    conectar(insert);                    
                    pstm.setString(1, pacote.getIdPacote());
                    pstm.setString(2, item);
                    pstm.setString(3, pacote.getPacoteNome());
                    pstm.execute();
                    pstm.close();
              } catch (SQLException ex) {
                   imprimeErro("Erro ao Cadastrar itens em um Pacote", ex.getMessage());
              }           
            }
    }
    
    @Override
    public void criar(Pacote pacote) {
        String criar = "INSERT INTO pacote (IdPacote,NomePacote,PrecoPacote) VALUES(?,?,?)";

        conectar(criar);
        try {                        
            pstm.setString(1, pacote.getIdPacote());
            pstm.setString(2, pacote.getPacoteNome());
            pstm.setDouble(3, pacote.getPrecoPacote());            
            pstm.execute();                   
            pstm.close();
            criarItensPacote(pacote);
        } catch (SQLException ex) {            
            imprimeErro("Erro ao Cadastrar um Pacote", ex.getMessage());
        }
        
    }

    @Override
    public Pacote buscar(String idPacote) {

        String busca = "SELECT * FROM pacote WHERE idPacote LIKE " + idPacote;
        ResultSet result;
        Pacote pacote = new Pacote();
        conectar(busca);
        try {
            result = pstm.executeQuery();
            while (result.next()) {
                pacote.setIdPacote(result.getString("IdPacote"));
                pacote.setPacoteNome(result.getString("nomePacote"));
                pacote.setPrecoPacote(result.getFloat("precoPacote"));
            }
        } catch (SQLException ex) {
            imprimeErro("Erro ao Buscar um Pacote", ex.getMessage());
        }
        fechar();
        return pacote;
    }
    
    
     
    public Pacote buscarPorNome(String nome) {

        String busca = "SELECT * FROM pacote WHERE nomePacote LIKE '" + nome + "'";
        ResultSet result;
        Pacote pacote = new Pacote();
        conectar(busca);
        try {
            result = pstm.executeQuery();
            while (result.next()) {
                pacote.setIdPacote(result.getString("IdPacote"));
                pacote.setPacoteNome(result.getString("nomePacote"));
                pacote.setPrecoPacote(result.getFloat("precoPacote"));
            }
        } catch (SQLException ex) {
            imprimeErro("Erro ao Buscar um Pacote", ex.getMessage());
        }
        fechar();
        return pacote;
    }
    
    

    @Override
    public void atualizar(Pacote pacote) {

        String atualiza = "UPDATE pacote SET "
                + "nomePacote = ?,"
                + "precoPacote = ?"
                + "WHERE IdPacote = ?";
        conectar(atualiza);
        try {
            pstm.setString(1, pacote.getPacoteNome());
            pstm.setFloat(2, pacote.getPrecoPacote());
            pstm.setString(3, pacote.getIdPacote());
            pstm.executeUpdate();
            System.out.println("Pacote Atualizado");
            fechar();
        } catch (SQLException ex) {
            imprimeErro("Erro ao Atualizar um Pacote", ex.getMessage());
        }
    }

    @Override
    public void remover(Pacote pacote) {

        String remover = "DELETE FROM pacote WHERE IdPacote = ?";

        conectar(remover);
        try {
            pstm.setString(1, pacote.getIdPacote());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            imprimeErro("Erro ao Remover um Pacote", ex.getMessage());
        }
    }

    @Override
    public ArrayList<Pacote> buscarPacote() {

        String buscapacotes = "SELECT * FROM pacote";
        ArrayList<Pacote> pacotes = new ArrayList<>();
        ResultSet result;
        conectar(buscapacotes);
        try {
            result = pstm.executeQuery();
            while (result.next()) {
                Pacote pacote = new Pacote();
                pacote.setIdPacote(result.getString("IdPacote"));
                pacote.setPacoteNome(result.getString("nomePacote"));
                pacote.setPrecoPacote(result.getFloat("precoPacote"));

                pacotes.add(pacote);
            }
            return pacotes;

        } catch (SQLException ex) {
            imprimeErro("Erro ao Buscar Vários Pacotes", ex.getMessage());
        }
        return null;
    }
}
