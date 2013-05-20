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
    public Object selecionar(String id);
    public void atualizar(int id, Object object);
    public void remover(String id);
    public List<Object> listar();
    
}





