/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author Josiel
 */
public abstract class Festa {
    
    private int IdFesta;
    private DataFesta DataHorario;
    private Pessoa cpf;
    private Temas tema;
    private Localizacao local;
    private Pacotes pacote;
    private boolean externo;
    private int quantidadeConvidados; //tres campos separando as idades
    private int numeroLocal;
    private String CEPLocal;

    

     
    public int getIdFesta() {
        return IdFesta;
    }

    public void setIdFesta(int IdFesta) {
        this.IdFesta = IdFesta;
    }

    public DataFesta getDataHorario() {
        return DataHorario;
    }

    public void setDataHorario(DataFesta DataHorario) {
        this.DataHorario = DataHorario;
    }

    public Pessoa getCpf() {
        return cpf;
    }

    public void setCpf(Pessoa cpf) {
        this.cpf = cpf;
    }

    public Temas getTema() {
        return tema;
    }

    public void setTema(Temas tema) {
        this.tema = tema;
    }

    public Localizacao getLocal() {
        return local;
    }

    public void setLocal(Localizacao local) {
        this.local = local;
    }

    public Pacotes getPacote() {
        return pacote;
    }

    public void setPacote(Pacotes pacote) {
        this.pacote = pacote;
    }

    public boolean isExterno() {
        return externo;
    }

    public void setExterno(boolean externo) {
        this.externo = externo;
    }

    public int getQuantidadeConvidados() {
        return quantidadeConvidados;
    }

    public void setQuantidadeConvidados(int quantidadeConvidados) {
        this.quantidadeConvidados = quantidadeConvidados;
    }

    public int getNumeroLocal() {
        return numeroLocal;
    }

    public void setNumeroLocal(int numeroLocal) {
        this.numeroLocal = numeroLocal;
    }

    public String getCEPLocal() {
        return CEPLocal;
    }

    public void setCEPLocal(String CEPLocal) {
        this.CEPLocal = CEPLocal;
    }   
}
