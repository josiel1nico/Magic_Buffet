/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author Josiel
 */
public abstract class PessoaChainResp {
    
    public enum TipoPessoa {
    GERENTE,
    CLIENTE,    
    MONITOR
}
    protected PessoaChainResp next;
    protected TipoPessoa identificadorTipo;
    
    public PessoaChainResp(TipoPessoa tipo){
        next = null;
        identificadorTipo = tipo;
    }
    
    public void setNext(PessoaChainResp pessoa){
        if(next == null){
            next = pessoa;
        }
        else {
            next.setNext(pessoa);
        }
    }
    
    
    
    
    
    
}
