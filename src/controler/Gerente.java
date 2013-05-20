/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author Josiel
 */

public class Gerente extends AbstractPessoa {
    private String login;
    private String senha;

    public Gerente(String cpf, String Pnome, int rg, String rua, int numero, 
            String bairro, String tipoPessoa, String cep, String telefone, String login, String senha) {
        
        super(cpf, Pnome, rg, rua, numero, bairro, tipoPessoa, cep, telefone);
        this.login = login;
        this.senha = senha;
        
        
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
   
    
}
