/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import controler.Tema;
import java.util.ArrayList;
import java.util.Iterator;
import entidadesDAO.TemaDAO;

/**
 *
 * @author Josiel
 */
public class TesteTema {

    public static void main(String[] args) {

        TemaDAO tdao = new TemaDAO();
        Tema tema = new Tema();

        tema.setIdTema("5040");
        tema.setTnome("Branca de Neve");

        //tdao.criar(tema);
        Tema t = tdao.buscar("3012");
        
        //System.out.println("Identificador do Tema: " + t.getIdTema());
        //System.out.println("Tipo de Festa: " + t.getTipoFesta());
        //System.out.println("Nome do Tema da Festa: " + t.getTnome());
        
        
        //t.setTipoFesta("PROVENCAL");
        //t.setTnome("Carrossel");

        //tdao.atualizar(t);
        //tdao.remover(t);
         
        ArrayList<Tema> resultado = tdao.buscarTema();
        
        for (Iterator<Tema> iterator = resultado.iterator(); iterator.hasNext();) {
            Tema tema1 = iterator.next();
            
            System.out.println("Tema de Festa : " + tema1.getTnome());
            System.out.println("\n");
            
        }
    }
}
