/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacoteDAO;
import conexao.ConectionFactory;
import controler.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Josiel
 */
public class ItemDAO implements InterfaceDAO.InterfaceItensDAO {

    private Connection conn;
    private PreparedStatement pstm;

    @Override
    public void criar(Item item) {

        String criar = "INSERT INTO Item (idItem, nomeItem, quantidadeTotal, precoUnidade)"
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

    public void conectar(String sql) {

        try {
            conn = new ConectionFactory().getConnection();
            pstm = conn.prepareStatement(sql);
        } catch (SQLException ex) {
            imprimeErro("Erro ao conectar", ex.getMessage());
        }
    }

    public void fechar() {
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
            System.out.println("Conexão Fechada");
        } catch (Exception e) {
            imprimeErro("Erro ao fechar conexão", e.getMessage());
            //System.err.println("erro ao fechar conexao");
        }
    }

    private void imprimeErro(String msg, String msgErro) {
        JOptionPane.showMessageDialog(null, msg, "Erro crítico", 0);
        System.err.println(msg);
        System.out.println(msgErro);
        System.exit(0);
    }
}
