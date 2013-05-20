/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacoteDAO;

import controler.AbstractPessoa;

/**
 *
 * @author Josiel
 */
public interface IPessoaDAO {
    
    public void criar(AbstractPessoa abstractPessoa);
    public void selecionar(AbstractPessoa abstractPessoa);
    public void atualizar(AbstractPessoa abstractPessoa);
    public void remover(AbstractPessoa abstractPessoa);
    
    
}





