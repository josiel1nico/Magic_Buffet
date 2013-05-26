/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author Josiel
 */
public class Pacote {
    
    private String idPacote;
    private int pacote_idPacote; //pode ser null
    private String PacoteNome;
    private double preco;

    public String getIdPacote() {
        return idPacote;
    }

    public void setIdPacote(String idPacote) {
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
