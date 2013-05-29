/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import controler.Item;
import entidadesDAO.ItemDAO;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Josiel
 */
public class TesteItem {

    public static void main(String[] args) {

        Item i = new Item();
        ItemDAO idao = new ItemDAO();
        /*
         i.setIdItem("50");
         i.setNomeItem("Cama Elástica");
         i.setQuantidadeTotal(5);
         i.setPrecoUnidade(100);
         
         idao.criar(i);
        
         Item item = idao.buscar("50");

         idao.remover(item);
         item.setNomeItem("Cama Elástica");
           
         System.out.println("Nome do Item: " + item.getNomeItem());
         System.out.println("Quantidade do Item: " + item.getQuantidadeTotal());
         System.out.println("Preco do Item: " + item.getPrecoUnidade());
         
         */


        ArrayList<Item> resultado = idao.buscarItens();

        for (Iterator<Item> it = resultado.iterator(); it.hasNext();) {
            Item item = it.next();

            System.out.println("Nome do Item: " + item.getNomeItem());
            System.out.println("Quantidade do Item: " + item.getQuantidadeTotal());
            System.out.println("Preco do Item: " + item.getPrecoUnidade());
            System.out.println("");

        }
    }
}
