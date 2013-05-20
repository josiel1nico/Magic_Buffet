/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacoteDAO;

import controler.Pessoa;

/**
 *
 * @author Josiel
 */
public class TesteDAO {
    
    public static void main(String[] args) {
        
        PessoaDAO cl = new PessoaDAO();
        Pessoa p = new Pessoa();
        
        p.setCpf("98989898");
        p.setPnome("Joao");
        p.setRg(12345);
        p.setRua("Rua das viegas");
        p.setNumero(405);
        p.setBairro("Lagoa Nova");
        p.setCep("5000000");
        p.setTipoPessoa(Pessoa.MONITOR);
        p.setTelefone("88888888");
        
        cl.criar(p);
    
    }
}
        
        

        
        
        

