/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author Josiel
 */
public class Itens {
    
    private int idItem;
    private String NomeItem;
    private int quantidadeTotal;
    private double preco_unidade;

    
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getNomeItem() {
        return NomeItem;
    }

    public void setNomeItem(String NomeItem) {
        this.NomeItem = NomeItem;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public double getPreco_unidade() {
        return preco_unidade;
    }

    public void setPreco_unidade(double preco_unidade) {
        this.preco_unidade = preco_unidade;
    }
    
    
}
