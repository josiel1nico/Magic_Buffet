/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDAO;

import controler.Itens;
import java.util.ArrayList;

/**
 *
 * @author Josiel
 */
public interface InterfaceItensDAO {

    public void criar(Itens itens);

    public Itens buscar(String idItem);

    public void atualizar(Itens itens);

    public void remover(Itens itens);

    public ArrayList<Itens> buscarItens();
}
