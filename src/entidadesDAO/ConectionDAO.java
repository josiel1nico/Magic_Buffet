/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesDAO;

import conexao.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Josiel
 */
public abstract class ConectionDAO {

    protected Connection conn;
    protected PreparedStatement pstm;

    protected void conectar(String conecta) {

        try {
            conn = new ConectionFactory().getConnection();
            pstm = conn.prepareStatement(conecta);
        } catch (SQLException ex) {
            imprimeErro("Erro ao conectar", ex.getMessage());
        }
    }

    protected void fechar() {
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            imprimeErro("Erro ao fechar conexão", e.getMessage());
        }
    }

    protected void imprimeErro(String msg, String msgErro) {
        JOptionPane.showMessageDialog(null, msg, "Erro crítico", 0);
        System.err.println(msg);
        System.out.println(msgErro);
        System.exit(0);
    }
}
