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
        
         */
        Localizacao l2 = ldao.buscar("450");
        
        System.out.println("Numero: " + l2.getNumero());

        l2.setNumero(90);

        //ldao.atualizar(l);
        
        //A FUNCAO DE ATUALIZAR LOCALIZAÇÃO TÁ COM PROBLEMAS
        
        ArrayList<Localizacao> resultado = ldao.buscarLocalizacoes();
        for (Iterator<Localizacao> iterator = resultado.iterator(); iterator.hasNext();) {
            Localizacao localizacao = iterator.next();

            System.out.println("Localizacao: " + localizacao.getIdLocalizacao());

        }



    }
}
