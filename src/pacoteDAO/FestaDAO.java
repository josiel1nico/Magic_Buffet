/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacoteDAO;

import controler.Festa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author Josiel
 */
public class FestaDAO implements InterfaceDAO {
    
    private Connection conn;
    private PreparedStatement pstm;

    @Override
    public void criar(Object object) {
        Festa festa = (Festa) object;
        String sql;
        sql = sql = "INSERT INTO Festa (IdFesta,clienteCPF,IdTema,localizacaoCEP,datafesta,idItem,idPacote,externo,quantidadeconvidados)"
                + "VALUES(?,?,?,?,?,?,?,?,?)";
        
        
          
    }

    @Override
    public List<Object> buscar(String id) {
        return null;
    }

    @Override
    public List<Object> buscarObjects(String nome) {
        return null;
    }

    @Override
    public void atualizar(Object object) {
        
    }

    @Override
    public void remover(Object object) {
        
    }
    
}
