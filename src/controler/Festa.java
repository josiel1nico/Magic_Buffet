/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author Josiel
 */
public class Festa {
    
    private String IdFesta;
    private DataFesta DataHorario;
    private Pessoa cpf;
    private Tema tema;
    private Localizacao local;
    private Pacote pacote;
    private boolean externo;
    private int quantidadeConvidados; //tres campos separando as idades
    private int numeroLocal;
    private String CEPLocal;

    
    
    public String getIdFesta() {
        return IdFesta;
    }

    public void setIdFesta(String IdFesta) {
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

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Localizacao getLocal() {
        return local;
    }

    public void setLocal(Localizacao local) {
        this.local = local;
    }

    public Pacote getPacote() {
        return pacote;
    }

    public void setPacote(Pacote pacote) {
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
