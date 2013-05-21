/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author Josiel
 */
public class Pacotes {
    
    private int idPacote;
    private int pacote_idPacote; //pode ser null
    private String PacoteNome;
    private double preco;

    
    
    public int getIdPacote() {
        return idPacote;
    }

    public void setIdPacote(int idPacote) {
        this.idPacote = idPacote;
    }

    public int getPacote_idPacote() {
        return pacote_idPacote;
    }

    public void setPacote_idPacote(int pacote_idPacote) {
        this.pacote_idPacote = pacote_idPacote;
    }

    public String getPacoteNome() {
        return PacoteNome;
    }

    public void setPacoteNome(String PacoteNome) {
        this.PacoteNome = PacoteNome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
    
}
