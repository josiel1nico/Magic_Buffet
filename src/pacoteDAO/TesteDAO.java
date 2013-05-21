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
        
        p.setCpf("12345");
        p.setPnome("Joao");
        p.setRg(12345);
        p.setRua("Rua das viegas");
        p.setNumero(405);
        p.setBairro("Lagoa Nova");
        p.setCep("5000000");
        p.setTipoPessoa(Pessoa.CLIENTE);
        p.setTelefone("88888888");
        
      // cl.buscarPessoa("12345");
       
       Pessoa ps = new Pessoa();
       ps =  cl.buscarPessoa("12345");

        System.out.println("Nome " + ps.getPnome());
       //cl.remover(p);
    }
}
        
        

        
        
        

