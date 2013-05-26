/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDAO;

import controler.Pessoa;
import java.util.ArrayList;

/**
 *
 * @author Josiel
 */
public interface InterfacePessoaDAO {

    public void criar(Pessoa pessoa);

    public Pessoa buscar(String cpf);

    public void atualizar(Pessoa pessoa);

    public void remover(Pessoa pessoa);

    public ArrayList<Pessoa> buscarPessoas();
}



 