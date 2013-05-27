/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import controler.Localizacao;
import java.util.ArrayList;
import java.util.Iterator;
import entidadesDAO.LocalizacaoDAO;

/**
 *
 * @author Josiel
 */
public class TesteLocalizacao {

    public static void main(String[] args) {

        Localizacao l = new Localizacao();
        LocalizacaoDAO ldao = new LocalizacaoDAO();
        /*
         l.setCEP("59252341");
         l.setRua("Rua Manguaratuba");
         l.setBairro("Satélite");
         l.setNumero(78);
         l.setCidade("Natal");
         l.setIdLocalizacao("450");
         ldao.criar(l);
         ldao.remover(l);
        
         *  System.out.println("Numero: " + l2.getNumero());
         */
        Localizacao l2 = ldao.buscar("327");
        
        System.out.println("\n");
        
        System.out.println("ID Localizacao: " + l2.getIdLocalizacao());
        System.out.println("Rua: " + l2.getRua());
        System.out.println("Numero: " + l2.getNumero());

        l2.setCEP("59600000");
        l2.setBairro("Centro");
        l2.setCidade("Natal");
        l2.setNumero(60);
        
        ldao.atualizar(l2);

        System.out.println("\n");

        System.out.println("ID Localizacao: " + l2.getIdLocalizacao());
        System.out.println("Rua: " + l2.getRua());
        System.out.println("Numero: " + l2.getNumero());


        ArrayList<Localizacao> resultado = ldao.buscarLocalizacoes();
        
        System.out.println("\nID E NOME DE TODAS AS LOCALIZACOES\n");
        
        for (Iterator<Localizacao> iterator = resultado.iterator(); iterator.hasNext();) {
            Localizacao localizacao = iterator.next();
            System.out.println("Identificador da Localizacao: " + localizacao.getIdLocalizacao());
            System.out.println("Nome da Rua: " + localizacao.getRua());
            System.out.println("");
            
        }
    }
}
