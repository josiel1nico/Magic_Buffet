/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesDAO;

import InterfaceDAO.InterfaceItemDAO;
import controler.Item;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Josiel
 */
public class ItemDAO extends ConectionDAO implements InterfaceItemDAO {


    @Override
    public void criar(Item item) {

        String criar = "INSERT INTO item (idItem, nomeItem, quantidadeTotal, precoUnidade)"
                + "VALUES (?,?,?,?)";

        conectar(criar);
        try {
            pstm.setString(1, item.getIdItem());
            pstm.setString(2, item.getNomeItem());
            pstm.setInt(3, item.getQuantidadeTotal());
            pstm.setFloat(4, item.getPrecoUnidade());

            pstm.execute();
            pstm.close();

        } catch (SQLException ex) {
            imprimeErro("Erro ao Cadastrar um Item", ex.getMessage());
        }

    }

    @Override
    public Item buscar(String idItem) {
        String buscar = "SELECT * FROM Item WHERE IdItem LIKE " + idItem;
        ResultSet result;
        conectar(buscar);
        Item item = new Item();

        try {
            result = pstm.executeQuery();

            while (result.next()) {

                item.setIdItem(result.getString("idItem"));
                item.setNomeItem(result.getString("nomeItem"));
                item.setQuantidadeTotal(result.getInt("quantidadeTotal"));
                item.setPrecoUnidade(result.getFloat("precoUnidade"));
            }
        } catch (SQLException ex) {
            imprimeErro("Erro ao Buscar um Item", ex.getMessage());
        }
        fechar();
        return item;
    }

    @Override
    public void atualizar(Item item) {

        String atualiza = "UPDATE Item SET "
                + "nomeItem = ?,"
                + "quantidadeTotal = ?,"
                + "precoUnidade = ?"
                + "WHERE idItem = ?";

        conectar(atualiza);

        try {
            pstm.setString(1, item.getNomeItem());
            pstm.setInt(2, item.getQuantidadeTotal());
            pstm.setFloat(3, item.getPrecoUnidade());
            pstm.setString(4, item.getIdItem());

            pstm.executeUpdate();
            System.out.println("Item Atualizado");
            fechar();
        } catch (SQLException ex) {
            imprimeErro("Erro ao Atualizar um item", ex.getMessage());
        }
    }

    @Override
    public void remover(Item item) {

        String remover = "DELETE FROM Item WHERE idItem = ?";

        conectar(remover);

        try {
            pstm.setString(1, item.getIdItem());
            pstm.execute();
            pstm.close();

        } catch (SQLException ex) {
            imprimeErro("Erro ao Remover um item", ex.getMessage());
        }
    }

    @Override
    public ArrayList<Item> buscarItens() {

        String buscarItens = "SELECT * FROM Item ";
        
        ArrayList<Item> itens = new ArrayList<>();
        ResultSet result;
        conectar(buscarItens);

        try {
            result = pstm.executeQuery();
            while (result.next()) {
                Item item = new Item();
                item.setIdItem(result.getString("idItem"));
                item.setNomeItem(result.getString("nomeItem"));
                item.setQuantidadeTotal(result.getInt("quantidadeTotal"));
                item.setPrecoUnidade(result.getFloat("precoUnidade"));
                
                itens.add(item);
            }
            return itens;
            
        } catch (SQLException ex) {
            imprimeErro("Erro ao Buscar um Item", ex.getMessage());
        }
        return null;      
    }
}
