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
    private String nomePacote;
    private float precoPacote;

    
    
    public String getIdPacote() {
        return idPacote;
    }

    public void setIdPacote(String idPacote) {
        this.idPacote = idPacote;
    }


    public String getPacoteNome() {
        return nomePacote;
    }

    public void setPacoteNome(String PacoteNome) {
        this.nomePacote = PacoteNome;
    }

    public float getPrecoPacote() {
        return precoPacote;
    }

    public void setPrecoPacote(float precoPacote) {
        this.precoPacote = precoPacote;
    }

}
