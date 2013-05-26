/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDAO;

import controler.DataFesta;
import java.util.ArrayList;

/**
 *
 * @author Josiel
 */
public interface InterfaceDataFestaDAO {

    public void criar(DataFesta dataFesta);

    public DataFesta buscar(String iDDataFesta);

    public void atualizar(DataFesta dataFesta);

    public void remover(DataFesta dataFesta);

    public ArrayList<DataFesta> buscarDataFesta();
}
