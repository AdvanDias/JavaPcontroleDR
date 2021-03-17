/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerIntegracao;
import javax.swing.JOptionPane;
import model.ModelIntegracao;

/**
 *
 * @author Marilia
 */
public class ViewInicio extends javax.swing.JFrame {

    ViewCliente viewCliente = new ViewCliente();
    ViewEndereco viewEndereco = new ViewEndereco();
    ViewConta viewConta = new ViewConta();
    ModelIntegracao modelIntegracao = new ModelIntegracao();
    ControllerIntegracao controllerIntegracao = new ControllerIntegracao();
    /**
     * Creates new form ViewInicio
     */
    public ViewInicio() {
        initComponents();
         setLocationRelativeTo(null);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BTN_CLIENTE = new javax.swing.JButton();
        BTN_ENDER = new javax.swing.JButton();
        BTN_CONTA = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BTN_CLIENTE.setText("CLIENTE");
        BTN_CLIENTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CLIENTEActionPerformed(evt);
            }
        });

        BTN_ENDER.setText("ENDEREÇO");
        BTN_ENDER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ENDERActionPerformed(evt);
            }
        });

        BTN_CONTA.setText("CONTA");
        BTN_CONTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CONTAActionPerformed(evt);
            }
        });

        jButton1.setText("SIMULAR MOVIMENTAÇÃO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(BTN_CLIENTE, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_ENDER, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(BTN_CONTA, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BTN_CLIENTE, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(BTN_ENDER, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(109, 109, 109)
                            .addComponent(BTN_CONTA, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_CLIENTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CLIENTEActionPerformed
        // TODO add your handling code here:
         viewCliente.setVisible(true);
         setVisible(false);
    }//GEN-LAST:event_BTN_CLIENTEActionPerformed

    private void BTN_ENDERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ENDERActionPerformed
        // TODO add your handling code here:
        viewEndereco.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_BTN_ENDERActionPerformed

    private void BTN_CONTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CONTAActionPerformed
        // TODO add your handling code here:
        viewConta.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_BTN_CONTAActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //SIMULANDO A INTEGRAÇÃO
        modelIntegracao = new ModelIntegracao();
        String nome_cliente = "Teste";//confere se tem
        String nome_conta = "integracao";//cadastra novo
        String conta = "85645878";
        String ag = "55";
        float valor = 500;
        String tipo = "Dispesa";
        String Data_Movi = "01/01/1991";
        
        modelIntegracao.setNome_clinte(nome_cliente);
        modelIntegracao.setNome_conta(nome_conta);
        modelIntegracao.setConta(conta);
        modelIntegracao.setAg(ag);
        modelIntegracao.setValor(valor);
        modelIntegracao.setTipo(tipo);
        modelIntegracao.setData_movi(Data_Movi);
        
        if(controllerIntegracao.salvarIntegracaoController(modelIntegracao)){
                //cadastrou
                if(controllerIntegracao.validaStatusController()){
                    //achou o 'E' na tabela integracao cliente não cadastrado
                    JOptionPane.showMessageDialog(this, "Integração Realizada com Sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    //integração OK
                     JOptionPane.showMessageDialog(this, "ERRO CLIENTE NÃO CADASTRADO NO SISTEMA", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                    
        }else{
           //não cadastrou
           JOptionPane.showMessageDialog(this, "Erro na Integração", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_CLIENTE;
    private javax.swing.JButton BTN_CONTA;
    private javax.swing.JButton BTN_ENDER;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
