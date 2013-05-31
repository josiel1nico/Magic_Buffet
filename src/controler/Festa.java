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
    private String IdFesta;
    private String pessoaCPF;
    private String tema;
    private String local;
    private String pacote;
    private Date dataInicio;
    private Date dataFim;
    private Time horaInicio;
    private boolean externo;
    private int quantidadeConvidados; //tres campos separando as idades
    private String estiloFesta;

    public String getIdFesta() {
        return IdFesta;
    }

    public void setIdFesta(String IdFesta) {
        this.IdFesta = IdFesta;
    }

    public String getPessoaCPF() {
        return pessoaCPF;
    }

    public void setPessoaCPF(String pessoaCPF) {
        this.pessoaCPF = pessoaCPF;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getPacote() {
        return pacote;
    }

    public void setPacote(String pacote) {
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

    public String getEstiloFesta() {
        return estiloFesta;
    }

    public void setEstiloFesta(String tipoFesta) {
        this.estiloFesta = tipoFesta;
    }
}
