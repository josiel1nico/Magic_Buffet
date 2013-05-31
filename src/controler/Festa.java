/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Josiel
 */
public class Festa {
    
    private static final String PROVENCAL = "PROVENCAL";
    private static final String NORMAL = "NORMAL";
    
    private String tipoFesta;
    private String IdFesta;
    private Pessoa pessoaCPF;
    private Tema tema;
    private Localizacao local;
    private Pacote pacote;
    private Date dataInicio;
    private Date dataFim;
    private Time horaInicio;
    private boolean externo;
    private int quantidadeConvidados; //tres campos separando as idades

    public String getTipoFesta() {
        return tipoFesta;
    }

    public void setTipoFesta(String tipoFesta) {
        this.tipoFesta = tipoFesta;
    }
    
    public String getIdFesta() {
        return IdFesta;
    }

    public void setIdFesta(String IdFesta) {
        this.IdFesta = IdFesta;
    }

    public Pessoa getPessoaCPF() {
        return pessoaCPF;
    }

    public void setPessoaCPF(Pessoa pessoaCPF) {
        this.pessoaCPF = pessoaCPF;
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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
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
}
