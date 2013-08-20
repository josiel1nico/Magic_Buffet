/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesDAO;

import InterfaceDAO.BuscaInterface;
import InterfaceDAO.BuscaMultiplaInterface;
import InterfaceDAO.GenericInterface;
import controler.Festa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Mensagens;
/**
 *
 * @author Josiel
 */
public class FestaDAO extends ConectionDAO implements GenericInterface, BuscaMultiplaInterface, BuscaInterface {
    
    Mensagens mensagem = new Mensagens();
    
    @Override
    public Object buscar(String... args) {

        String buscarFesta = "SELECT * FROM festa WHERE IdFesta LIKE '" + args[0] + "'";

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
                festa.setDataInicio(result.getString("datainicio"));
                festa.setDataFim(result.getString("dataFim"));
                festa.setHoraInicio(result.getTime("horaInicio"));
                festa.setExterno(result.getBoolean("externo"));
                festa.setQuantidadeConvidados(result.getInt("quantidadeconvidados"));
                festa.setEstiloFesta(result.getString("estiloFesta"));
            }

        } catch (SQLException ex) {
            mensagem.imprimeErro("Erro ao buscar Festa", ex.getMessage());
        }

        fechar();
        return festa;
    }
                     
    public ArrayList<Festa> buscarFesta(String data) {
        
        String buscarFestas = "SELECT * FROM festa WHERE datainicio LIKE '" + data + "'";
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
                festa.setDataInicio(result.getString("datainicio"));
                festa.setDataFim(result.getString("dataFim"));
                festa.setHoraInicio(result.getTime("horaInicio"));
                festa.setExterno(result.getBoolean("externo"));
                festa.setQuantidadeConvidados(result.getInt("quantidadeconvidados"));
                festa.setEstiloFesta(result.getString("estiloFesta"));
                
                festas.add(festa);
            }
        } catch (SQLException ex) {
            mensagem.imprimeErro("Erro ao Buscar Todas as Festa", ex.getMessage());
        }
        
        return festas;
    }

   @Override
    public ArrayList<Object> buscar() {
        
        String buscarFestas = "SELECT * FROM festa " + ";";
        ArrayList<Object> festas = new ArrayList<>();
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
                festa.setDataInicio(result.getString("datainicio"));
                festa.setDataFim(result.getString("dataFim"));
                festa.setHoraInicio(result.getTime("horaInicio"));
                festa.setExterno(result.getBoolean("externo"));
                festa.setQuantidadeConvidados(result.getInt("quantidadeconvidados"));
                festa.setEstiloFesta(result.getString("estiloFesta"));
                
                festas.add(festa);
            }
        } catch (SQLException ex) {
            mensagem.imprimeErro("Erro ao Buscar Todas as Festa", ex.getMessage());
        }
       
        
        return festas;
    }

    @Override
    public boolean criar(Object object) {
             String criarFesta = "INSERT INTO festa "
                + "(IdFesta, clienteCPF, idTema, localizacaoCEP, idPacote, datainicio, "
                + "dataFim, horaInicio, externo, quantidadeconvidados, estiloFesta)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";


        
        try {
            Festa festa = (Festa) object;
            conectar(criarFesta);
            conn.setAutoCommit(false);
            pstm.setString(1, festa.getIdFesta());
            pstm.setString(2, festa.getPessoaCPF());
            pstm.setString(3, festa.getTema());
            pstm.setString(4, festa.getLocal());
            pstm.setString(5, festa.getPacote());
            pstm.setString(6, festa.getDataInicio());
            pstm.setString(7, festa.getDataFim());
            pstm.setTime(8, festa.getHoraInicio());
            pstm.setBoolean(9, festa.isExterno());
            pstm.setInt(10, festa.getQuantidadeConvidados());
            pstm.setString(11, festa.getEstiloFesta());
            pstm.execute();
            conn.commit();
            fechar();
            return true;

        } catch (SQLException ex) {
            try {
                conn.rollback();
                mensagem.imprimeErro("Erro ao cadastrar Festa", ex.getMessage());
                return false;
            } catch (SQLException ex1) {
                Logger.getLogger(FestaDAO.class.getName()).log(Level.SEVERE, null, ex1);
                return false;
            }
        }
    }

    @Override
    public boolean atualizar(Object object) {
          String atualiza = "UPDATE festa SET "
                + "clienteCPF = ?,"
                + "idTema = ?,"
                + "localizacaoCEP = ?,"
                + "idPacote = ?,"
                + "datainicio = ?,"
                + "dataFim = ?,"
                + "horaInicio = ?,"
                + "externo = ?,"
                + "quantidadeconvidados = ?,"
                + "estiloFesta = ? "
                + "WHERE IdFesta = ?";

        conectar(atualiza);
        try {
            Festa festa = (Festa) object;
            pstm.setString(1, festa.getIdFesta());
            pstm.setString(2, festa.getPessoaCPF());
            pstm.setString(3, festa.getTema());
            pstm.setString(4, festa.getLocal());
            pstm.setString(5, festa.getPacote());
            pstm.setString(6, festa.getDataInicio());
            pstm.setString(7, festa.getDataFim());
            pstm.setTime(8, festa.getHoraInicio());
            pstm.setBoolean(9, festa.isExterno());
            pstm.setInt(10, festa.getQuantidadeConvidados());
            pstm.setString(11, festa.getEstiloFesta());

            pstm.executeUpdate();
            System.out.println("Festa Atualizada");
            fechar();
            return true;

        } catch (SQLException ex) {
            mensagem.imprimeErro("Erro ao atualizar Festa", ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean remover(Object object) {
        
        String remover = "DELETE FROM festa WHERE idFesta = ? ";

        conectar(remover);
        try {
            Festa festa = (Festa) object;
            pstm.setString(1, festa.getIdFesta());
            pstm.execute();
            fechar();
            return true;
        } catch (SQLException ex) {
            mensagem.imprimeErro("Erro ao Remover Festa", ex.getMessage());
            return false;
        }
    }


}
