/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import controler.Pessoa;
import java.util.ArrayList;
import java.util.Iterator;

import entidadesDAO.PessoaDAO;

/**
 *
 * @author Josiel
 */
public class TestePessoa {

    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa();
        PessoaDAO pdao = new PessoaDAO();

        pessoa.setCpf("89123123");
        pessoa.setGerenteLogin(null);
        pessoa.setPnome("Marcos Carreiro");
        pessoa.setRg(13902312);
        pessoa.setRua("Rua do Ria Pardo");
        pessoa.setNumero(90);
        pessoa.setBairro("Monte Castelo");
        pessoa.setCep("59212-000");
        pessoa.setTipoPessoa("CLIENTE");
        pessoa.setTelefone("9932121");
        pessoa.setCidade("Assu");
        
        pdao.criar(pessoa);
        
        Pessoa p = pdao.buscar("89123123");
        
        System.out.println("Nome: " + p.getPnome());
        
        p.setPnome("Carlos Henrique");
        
        pdao.atualizar(p);
        
        System.out.println("Nome: " + p.getPnome());
        
        pdao.remover(p);
        //System.out.println("Nome: " + p.getPnome());
              

        ArrayList<Pessoa> resultado = pdao.buscarPessoas();
              
         for (Iterator<Pessoa> iterator = resultado.iterator(); iterator.hasNext();) {
            Pessoa p1 = iterator.next();
            
             System.out.println("Pessoa encontrada: " + p1.getPnome());
            
        }
   
        
        
                
        
        
        
        
        
        
        
        
        /*
         "\nCPF: " + resultado.getCpf()
         + "\nNome: " + resultado.getPnome()
         + "\nCidade: " + resultado.getCidade());

        
         
         Localizacao l = new Localizacao();

         l.setIdLocalizacao("80965");
         l.setCEP("59200121");
         l.setRua("Rua do Mel");
         l.setBairro("Aracaju");
         l.setNumero(20);
         l.setCidade("Natal");

         LocalizacaoDAO ldao = new LocalizacaoDAO();
         //ldao.criar(l);


                
        
         System.out.println("\n"
         + "\nIdLocalização: " + l.getIdLocalizacao()
         + "\nCEP: " + l.getCEP()
         + "\nRua: " + l.getRua()
         + "\nNumero: " + l.getNumero()
         + "\nBairro: " + l.getBairro()
         + "\nCidade: " + l.getCidade());
        
        

         //ldao.atualizar(res);

         Localizacao res = ldao.buscar("80965");
        
         res.setBairro("Centro");
         res.setCidade("Santa Cruz");
         System.out.println("\n"
         + "\nIdLocalização: " + res.getIdLocalizacao()
         + "\nCEP: " + res.getCEP()
         + "\nRua: " + res.getRua()
         + "\nNumero: " + res.getNumero()
         + "\nBairro: " + res.getBairro()
         + "\nCidade: " + res.getCidade());

         ldao.remover(res);
         */

    }
}
