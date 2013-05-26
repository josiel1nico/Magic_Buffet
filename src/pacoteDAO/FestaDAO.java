/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacoteDAO;

import InterfaceDAO.InterfaceFestaDAO;
import controler.Festa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Josiel
 */
public class FestaDAO implements InterfaceFestaDAO {

    private Connection conn;
    private PreparedStatement pstm;

    @Override
    public void criar(Festa festa) {
        String sql;
        sql = sql = "INSERT INTO Festa "
                + "IdFesta = ?,"
                + "clienteCPF = ?,"
                + "IdTema = ?,"
                + "localizacaoCEP = ?,"
                + "datafesta = ?,"
                + "idItem = ?,"
                + "idPacote = ?,"
                + "externo = ?,"
                + "quantidadeconvidados = ?";
    }

    @Override
    public Festa buscar(String idFesta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Festa festa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Festa festa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Festa> buscarFesta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
