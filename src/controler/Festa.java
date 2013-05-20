/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author Josiel
 */
public class Festa extends AbstractFesta {
   
    
    public Festa(int IdFesta, DataFesta DataHorario, Pessoa cpf, 
            Temas tema, Localizações local, Pacotes pacote, boolean externo, 
            int quantidadeConvidados, int numeroLocal, String CEPLocal) {
        
        this.setIdFesta(IdFesta);
        this.setDataHorario(DataHorario);
        this.setCpf(cpf);
        this.setTema(tema);
        this.setLocal(local);
        this.setNumeroLocal(numeroLocal);
        this.setPacote(pacote);
        this.setExterno(externo);
        this.setQuantidadeConvidados(quantidadeConvidados);
        this.setCEPLocal(CEPLocal);
    }


    
}
