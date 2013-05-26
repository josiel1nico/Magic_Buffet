/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDAO;

import controler.Tema;
import java.util.ArrayList;

/**
 *
 * @author Josiel
 */
public interface InterfaceTemaDAO {
    
    public void criar(Tema tema);

    public Tema buscar(String idTema);

    public void atualizar(Tema tema);

    public void remover(Tema tema);

    public ArrayList<Tema> buscarTema();
}
