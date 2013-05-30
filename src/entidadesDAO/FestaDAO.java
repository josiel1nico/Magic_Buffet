/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesDAO;

import InterfaceDAO.InterfaceFestaDAO;
import controler.Festa;
import java.util.ArrayList;

/**
 *
 * @author Josiel
 */
public class FestaDAO extends ConectionDAO implements InterfaceFestaDAO {


    @Override
    public void criar(Festa festa) {
        String conectar = "INSERT INTO Festa "
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
