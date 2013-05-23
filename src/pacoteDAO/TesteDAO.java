/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacoteDAO;

import controler.Localizacao;
import controler.Pessoa;
import java.util.Iterator;

/**
 *
 * @author Josiel
 */
public class TesteDAO {
    
    public static void main(String[] args) {
     
        
   
        
            
        LocalizacaoDAO ldao = new LocalizacaoDAO();
        Localizacao l = new Localizacao();
        
        l.setCEP("1234543");
        l.setRua("Rua dos cariris");
        l.setNumero(91);
        l.setBairro("Amaral");
        
        //ldao.criar(l);
        
        for (int i = 0; i < 3; i++) {
            ldao.buscar("1234543");
        
  
        System.out.println("\nCEP: "+ l.getCEP()+
                            "\nRua: "+ l.getRua()+
                           "\nNumero: "+ l.getNumero()+
                            "\nBairro: "+ l.getBairro());
                
        }
        
        
   
    }
}
        
        

        
        
        

