/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import controler.Pacote;
import entidadesDAO.PacoteDAO;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Josiel
 */
public class TestePacote {
    
    public static void main(String[] args) {
        
        PacoteDAO pdao = new PacoteDAO();
        Pacote p = new Pacote();
        
        p.setIdPacote("10");
        p.setPacoteNome("Pacote Básico");
        p.setPrecoPacote(500);
       // pdao.criar(p);
           
        Pacote pac = pdao.buscar("10");
        
        pac.setPrecoPacote(1500);
        
        pdao.atualizar(pac);
               
        
        //pdao.remover(pac);
        
        ArrayList<Pacote> resultado = pdao.buscarPacote();
        
        for (Iterator<Pacote> iterator = resultado.iterator(); iterator.hasNext();) {
            Pacote pacote = iterator.next();
            System.out.println("Identificador do Pacote: " + pacote.getIdPacote());
            System.out.println("Nome do Pacote: " + pacote.getPacoteNome());
            System.out.println("Preco do Pacote: " + pacote.getPrecoPacote());
            System.out.println("\n");
        }
    }
    
}
