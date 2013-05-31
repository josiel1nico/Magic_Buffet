/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesDAO;

import InterfaceDAO.InterfaceFestaDAO;
import controler.Festa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Josiel
 */
public class FestaDAO extends ConectionDAO implements InterfaceFestaDAO {

    @Override
    public void criar(Festa festa) {

        String criarFesta = "INSERT INTO Festa "
                + "(IdFesta, clienteCPF, idTema, localizacaoCEP, idPacote, datainicio, "
                + "dataiFim, horaInicio, externo, quantidadeconvidados, estiloFesta)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";


        conectar(criarFesta);
        try {
            pstm.setString(1, festa.getIdFesta());
            pstm.setString(2, festa.getPessoaCPF());
            pstm.setString(3, festa.getTema());
            pstm.setString(4, festa.getLocal());
            pstm.setString(5, festa.getPacote());
            pstm.setDate(6, festa.getDataInicio());
            pstm.setDate(7, festa.getDataFim());
            pstm.setTime(8, festa.getHoraInicio());
            pstm.setBoolean(9, festa.isExterno());
            pstm.setInt(10, festa.getQuantidadeConvidados());
            pstm.setString(11, festa.getEstiloFesta());

            pstm.execute();
            fechar();

        } catch (SQLException ex) {
            imprimeErro("Erro ao cadastrar Festa", ex.getMessage());
        }

    }

    @Override
    public Festa buscar(String idFesta) {

        String buscarFesta = "SELECT * FROM festa WHERE IdFesta LIKE" + idFesta + ";";

        conectar(buscarFesta);
        Festa festa = new Festa();
        ResultSet result;
        try {
            result = pstm.executeQuery();

            while (result.next()) {

                festa.setIdFesta(result.getString("IdFesta"));
                festa.setPessoaCPF(result.getString("clienteCPF"));
                festa.setTema(result.getString("idTema"));
                festa.setLocal(result.getString("localizacaoCEP"));
                festa.setPacote(result.getString("idPacote"));
                festa.setDataInicio(result.getDate("datainicio"));
                festa.setDataFim(result.getDate("dataiFim"));
                festa.setHoraInicio(result.getTime("horaInicio"));
                festa.setExterno(result.getBoolean("externo"));
                festa.setQuantidadeConvidados(result.getInt("quantidadeconvidados"));
                festa.setEstiloFesta(result.getString("estiloFesta"));
            }

        } catch (SQLException ex) {
            imprimeErro("Erro ao buscar Festa", ex.getMessage());
        }

        fechar();
        return festa;
    }

    @Override
    public void atualizar(Festa festa) {

        String atualiza = "UPDATE festa SET "
                + "clienteCPF = ?,"
                + "idTema = ?,"
                + "localizacaoCEP = ?,"
                + "idPacote = ?,"
                + "datainicio = ?,"
                + "dataiFim = ?,"
                + "horaInicio = ?,"
                + "externo = ?,"
                + "quantidadeconvidados = ?,"
                + "estiloFesta = ? "
                + "WHERE IdFesta = ?";

        conectar(atualiza);
        try {
            pstm.setString(1, festa.getIdFesta());
            pstm.setString(2, festa.getPessoaCPF());
            pstm.setString(3, festa.getTema());
            pstm.setString(4, festa.getLocal());
            pstm.setString(5, festa.getPacote());
            pstm.setDate(6, festa.getDataInicio());
            pstm.setDate(7, festa.getDataFim());
            pstm.setTime(8, festa.getHoraInicio());
            pstm.setBoolean(9, festa.isExterno());
            pstm.setInt(10, festa.getQuantidadeConvidados());
            pstm.setString(11, festa.getEstiloFesta());

            pstm.executeUpdate();
            System.out.println("Festa Atualizada");
            fechar();

        } catch (SQLException ex) {
            imprimeErro("Erro ao atualizar Festa", ex.getMessage());
        }
    }

    @Override
    public void remover(Festa festa) {

        String remover = "DELETE FROM festa WHERE idFesta = ? ";

        conectar(remover);
        try {
            pstm.setString(1, festa.getIdFesta());
            pstm.execute();
            fechar();
        } catch (SQLException ex) {
            imprimeErro("Erro ao Remover Festa", ex.getMessage());
        }
    }

    @Override
    public ArrayList<Festa> buscarFesta() {
        
        String buscarFestas = "SELECT * FROM festa " + ";";
        ArrayList<Festa> festas = new ArrayList<>();
        ResultSet result;
        
        conectar(buscarFestas);
        try {
            result = pstm.executeQuery();
            while (result.next()) {
                
                Festa festa = new Festa();

                festa.setIdFesta(result.getString("IdFesta"));
                festa.setPessoaCPF(result.getString("clienteCPF"));
                festa.setTema(result.getString("idTema"));
                festa.setLocal(result.getString("localizacaoCEP"));
                festa.setPacote(result.getString("idPacote"));
                festa.setDataInicio(result.getDate("datainicio"));
                festa.setDataFim(result.getDate("dataiFim"));
                festa.setHoraInicio(result.getTime("horaInicio"));
                festa.setExterno(result.getBoolean("externo"));
                festa.setQuantidadeConvidados(result.getInt("quantidadeconvidados"));
                festa.setEstiloFesta(result.getString("estiloFesta"));
                
                festas.add(festa);
            }
        } catch (SQLException ex) {
            imprimeErro("Erro ao Buscar Todas as Festa", ex.getMessage());
        }
        
        return festas;
    }
}
