/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacoteDAO;

import conexao.ConectionFactory;
import controler.Localizacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Josiel
 */
public class LocalizacaoDAO implements InterfaceDAO {

    private Connection conn;
    private PreparedStatement pstm;

    @Override
    public void criar(Object object) {
        Localizacao localizacao = (Localizacao) object;
        String SQL;
        SQL = "INSERT INTO Localizacao(idLocalizacao,cep,numero,rua,bairro) VALUES(?,?,?,?,?)";
        try {
            conectar(SQL);
            pstm.setInt(1, localizacao.getIdLocalizacao());
            pstm.setString(2, localizacao.getCEP());
            pstm.setInt(3, localizacao.getNumero());
            pstm.setString(4, localizacao.getRua());
            pstm.setString(5, localizacao.getBairro());
            pstm.execute();
            pstm.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Localizacao buscar(String nomeCep) {
        
        Localizacao localizacao = new Localizacao();
        String buscarLocalizacao = "SELECT * FROM Localizacao WHERE cep LIKE " + nomeCep;
        try {
            conectar(buscarLocalizacao);
            ResultSet rset;
            rset = pstm.executeQuery();

            while (rset.next()) {
                
                localizacao.setCEP(rset.getString("CEP"));
                localizacao.setRua(rset.getString("Rua"));
                localizacao.setNumero(rset.getInt("Numero"));
                localizacao.setBairro(rset.getString("Bairro"));
           }

        } catch (SQLException ex) {
            System.err.println("CEP nao cadastrado no banco");
        }
        fechar();
        return localizacao;
    }

    @Override
    public List<Object> buscarObjects(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void conectar(String sql) throws SQLException {
        conn = new ConectionFactory().getConnection();
        pstm = conn.prepareStatement(sql);
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
            System.err.println("erro ao fechar conexao");
        }
    }
}
