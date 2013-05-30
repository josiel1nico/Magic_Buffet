/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDAO;


import controler.Item;
import java.util.ArrayList;

/**
 *
 * @author Josiel
 */
public interface InterfaceItensDAO {

    public void criar(Item itens);

    public Item buscar(String idItem);

    public void atualizar(Item itens);

    public void remover(Item itens);

    public ArrayList<Item> buscarItens();
}
