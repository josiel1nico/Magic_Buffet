/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDAO;


import controler.Localizacao;
import java.util.ArrayList;

/**
 *
 * @author Josiel
 */
public interface InterfaceLocalizacaoDAO {

    public void criar(Localizacao localizacao);

    public Localizacao buscar();

    public void atualizar(Localizacao localizacao);

    public void remover(Localizacao localizacao);

    public ArrayList<Localizacao> buscarLocalizacoes();
}
