/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacoteDAO;

import controler.Gerente;
import controler.Pessoa;

/**
 *
 * @author Josiel
 */
public class TesteDAO {
    
    public static void main(String[] args) {
        
        PessoaDAO cl = new PessoaDAO();
       Pessoa p = new Pessoa();
     
       Pessoa ps = new Pessoa();
//       cl.criar(p);
       ps = cl.buscarPessoa("928924");
       
        System.out.println("Nome " + ps.getPnome());
       //cl.remover(p);
    }
}
        
        

        
        
        

