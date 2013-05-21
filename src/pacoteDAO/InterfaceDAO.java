/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacoteDAO;

import java.util.List;

/**
 *
 * @author Josiel
 */
public interface InterfaceDAO {
    
    public void criar(Object object);
    public Object buscarPessoa(String id);
    public List<Object> buscarPessoas(String nome);
    public void atualizar(String id, Object object);
    public void remover(Object object);
    
    
}





