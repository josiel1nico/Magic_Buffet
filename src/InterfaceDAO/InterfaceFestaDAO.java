/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDAO;

import controler.Festa;
import java.util.ArrayList;

/**
 *
 * @author Josiel
 */
public interface InterfaceFestaDAO {

    public void criar(Festa festa);

    public Festa buscar(String  idFesta);
    
    public void atualizar(Festa festa);

    public void remover(Festa festa);

    public ArrayList<Festa> buscarFesta();
}
