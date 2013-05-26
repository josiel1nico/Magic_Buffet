/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDAO;

import controler.Pacote;
import java.util.ArrayList;

/**
 *
 * @author Josiel
 */
public interface InterfacePacoteDAO {

    public void criar(Pacote pacote);

    public Pacote buscar(String idPacote);

    public void atualizar(Pacote pacote);

    public void remover(Pacote pacote);

    public ArrayList<Pacote> buscarPacote();
}
