/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.Pessoa;
import javax.swing.JOptionPane;
import entidadesDAO.PessoaDAO;

/**
 *
 * @author andreza
 */
public class Resultado extends javax.swing.JFrame {

    /**
     * Creates new form ResultadoCliente
     */
    private  String tipo;    


    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setCep(String cep) {
        textoCep.setText(cep);
    }

    public void setCidadee(String cidade) {
        textoCidade.setText(cidade);
    }
    
    public void setCpf(String cpf) {
        textoCPF.setText(cpf);
    }

    public void setRua(String rua) {
        textoRua.setText(rua);        
    }

    public void setBairro(String bairro) {
        textoBairro.setText(bairro);              
    }

    public void setNumero(String numero) {
        numeroTexto.setText(numero);        
    }

    public void setRG(String RG) {        
        textoRG.setText(RG);
    }

    public void setTelefone(String telefone) {
        textoTelefone.setText(telefone);                
    }

  
    public void setNome(String nome) {
        textoNome.setText(nome);        
    }
    
    
    public Resultado() {
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeLabel = new javax.swing.JLabel();
        cpfLabel = new javax.swing.JLabel();
        textoNome = new javax.swing.JTextField();
        textoCPF = new javax.swing.JTextField();
        RGLabel = new javax.swing.JLabel();
        textoRG = new javax.swing.JTextField();
        bairroLabel = new javax.swing.JLabel();
        ruaLabel = new javax.swing.JLabel();
        textoBairro = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        textoRua = new javax.swing.JTextField();
        RGLabel1 = new javax.swing.JLabel();
        textoCep = new javax.swing.JTextField();
        telefoneLabel = new javax.swing.JLabel();
        textoTelefone = new javax.swing.JTextField();
        editarButton = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        cidadelabel = new javax.swing.JLabel();
        textoCidade = new javax.swing.JTextField();
        ceplabel = new javax.swing.JLabel();
        numeroTexto = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        fecharButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nomeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nomeLabel.setText("Nome");

        cpfLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cpfLabel.setText("CPF");

        textoNome.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        textoCPF.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        RGLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RGLabel.setText("RG");

        textoRG.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        bairroLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bairroLabel.setText("Bairro");

        ruaLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ruaLabel.setText("Rua");

        textoBairro.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        textoRua.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        textoRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoRuaActionPerformed(evt);
            }
        });

        RGLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RGLabel1.setText("Numero");

        textoCep.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        telefoneLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        telefoneLabel.setText("Telefone");

        textoTelefone.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        editarButton.setText("Editar");
        editarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarButtonActionPerformed(evt);
            }
        });

        excluir.setText("Excluir");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        cidadelabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cidadelabel.setText("Cidade");

        textoCidade.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        ceplabel.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        ceplabel.setText("CEP");

        numeroTexto.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        numeroTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroTextoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("Informações do Cliente");

        fecharButton.setText("Fechar");
        fecharButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(editarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bairroLabel)
                                    .addComponent(ruaLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textoRua, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(textoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(textoBairro))
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ceplabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(RGLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textoCep)
                                            .addComponent(numeroTexto)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(fecharButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))))
                            .addComponent(cidadelabel))
                        .addGap(61, 61, 61))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cpfLabel)
                                        .addGap(241, 241, 241)
                                        .addComponent(RGLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(textoRG, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nomeLabel)
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(telefoneLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(textoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLabel)
                    .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfLabel)
                    .addComponent(textoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RGLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefoneLabel)
                    .addComponent(textoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ruaLabel)
                    .addComponent(textoRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bairroLabel)
                    .addComponent(textoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RGLabel1)
                    .addComponent(numeroTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cidadelabel)
                    .addComponent(textoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ceplabel)
                    .addComponent(textoCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecharButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textoRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoRuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoRuaActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        // TODO add your handling code here:
        int resposta = JOptionPane.showConfirmDialog( null,"Tem certeza que quer exlcuir o cliente do sistema?","Confirmação", JOptionPane.YES_NO_OPTION);
        if(resposta == JOptionPane.YES_OPTION){
            PessoaDAO pessoa = new PessoaDAO();                                
            Pessoa p = pessoa.buscar(textoCPF.getText(),tipo);        
            pessoa.remover(p);
            JOptionPane.showMessageDialog(this,"Cliente Removido");
            this.dispose();
        }       
    }//GEN-LAST:event_excluirActionPerformed

    private void editarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarButtonActionPerformed
        // TODO add your handling code here:                
        
        
        this.textoBairro.setEditable(true);               
        this.textoBairro.setEnabled(true); 
        this.textoCep.setEditable(true);        
        this.textoCep.setEnabled(true);
        this.textoTelefone.setEditable(true);
        this.textoTelefone.setEnabled(true);
        this.textoRua.setEditable(true);
        this.textoRua.setEnabled(true);
        this.numeroTexto.setEditable(true);
        this.numeroTexto.setEnabled(true);
        this.textoCidade.setEditable(true);
        this.textoCidade.setEnabled(true);
        fecharButton.setText("Salvar");                
    }//GEN-LAST:event_editarButtonActionPerformed

    private void fecharButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharButtonActionPerformed
        // TODO add your handling code here:
        if(fecharButton.getText().equals("Fechar")){            
            TelaInicial tela = TelaInicial.getInstance();    
            tela.setVisible(true);
            this.dispose();
        }
        else{            
            int resposta = JOptionPane.showConfirmDialog( null,"Tem certeza que quer editar?","Confirmação", JOptionPane.YES_NO_OPTION);
            if(resposta == JOptionPane.YES_OPTION){
                PessoaDAO pessoa = new PessoaDAO();                   
                Pessoa p = pessoa.buscar(textoCPF.getText(),tipo);
                p.setBairro(textoBairro.getText());
                p.setCep(textoCep.getText());
                p.setCidade(textoCidade.getText());
                p.setCpf(textoCPF.getText());
                p.setNumero(Integer.parseInt(numeroTexto.getText()));
                p.setPnome(textoNome.getText());
                p.setRg(Integer.parseInt(textoRG.getText()));
                p.setRua(textoRua.getText());
                p.setTelefone(textoTelefone.getText()); 
                p.setTipoPessoa(tipo);
                pessoa.atualizar(p);   
                JOptionPane.showMessageDialog(this,"Cliente Editado");
                this.dispose();
                
            }            
            
        }
    }//GEN-LAST:event_fecharButtonActionPerformed

    private void numeroTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroTextoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Resultado().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RGLabel;
    private javax.swing.JLabel RGLabel1;
    private javax.swing.JLabel bairroLabel;
    private javax.swing.JLabel ceplabel;
    private javax.swing.JLabel cidadelabel;
    private javax.swing.JLabel cpfLabel;
    private javax.swing.JButton editarButton;
    private javax.swing.JButton excluir;
    private javax.swing.JButton fecharButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel nomeLabel;
    public javax.swing.JTextField numeroTexto;
    private javax.swing.JLabel ruaLabel;
    private javax.swing.JLabel telefoneLabel;
    public javax.swing.JTextField textoBairro;
    public javax.swing.JTextField textoCPF;
    public javax.swing.JTextField textoCep;
    public javax.swing.JTextField textoCidade;
    public javax.swing.JTextField textoNome;
    public javax.swing.JTextField textoRG;
    public javax.swing.JTextField textoRua;
    public javax.swing.JTextField textoTelefone;
    // End of variables declaration//GEN-END:variables
}