/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author Josiel
 */
public class Tema {
    
    private static final String PROVENCAL = "PROVENCAL";
    private static final String NORMAL = "NORMAL";
    
    
    private String idTema;
    private String Tnome;
    private String TipoFesta; 

    public String getIdTema() {
        return idTema;
    }

    public void setIdTema(String idTema) {
        this.idTema = idTema;
    }

    public String getTnome() {
        return Tnome;
    }

    public void setTnome(String Tnome) {
        this.Tnome = Tnome;
    }

    public String getTipoFesta() {
        return TipoFesta;
    }

    public void setTipoFesta(String TipoFesta) {
        this.TipoFesta = TipoFesta;
    }
    
    
    
    
}
