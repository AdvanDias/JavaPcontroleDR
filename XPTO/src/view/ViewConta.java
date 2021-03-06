/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerConta;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelCliente;
import model.ModelConta;

/**
 *
 * @author Advan
 */
public class ViewConta extends javax.swing.JFrame {

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
    Date dt = new Date();
    ModelConta modelConta = new ModelConta();
    ModelCliente modelCliente = new ModelCliente();
    ControllerConta controllerConta = new ControllerConta();
    List<ModelConta> listaConta = new ArrayList();
    String AltCadas = "Cadastrar";
    /**
     * Creates new form ViewConta
     */
    public ViewConta() {
        initComponents();
        carregarListaConta();
        setLocationRelativeTo(null);
        View_Con_Data.setText(formato.format(dt));
       
    }

    
     /**
     * Receber o id da view cliente
     * @param idcliente 
     */
    public void enviaidcliente(int idcliente){
        View_id_Cli.setText(Integer.toString(idcliente));
    }
    
     /**
     * Carregar Lista na tabela da view Cliente
     *  
     */
    private void carregarListaConta(){
        listaConta = controllerConta.getListaContaController();
        DefaultTableModel modelo = (DefaultTableModel) View_Conta_Table.getModel();
        modelo.setNumRows(0);
        
        for(int i = 0; i < listaConta.size(); i++){
            
                modelo.addRow(new Object[]{
                listaConta.get(i).getId_conta(),
                listaConta.get(i).getNomeconta(),
                listaConta.get(i).getAgencia(),
                listaConta.get(i).getConta()
  
            });
            
            
        }
    }
    
     /**
     * Limpa Formulario do cliente
     * 
     */
    private void limparFormulario(){
       
        View_Con_Agen.setText("");
        View_Con_Con.setText("");
        View_Con_Ban.setText("");

        AltCadas = "Cadastrar";
       
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        View_Con_Con = new javax.swing.JTextField();
        View_Con_Agen = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        View_Conta_Table = new javax.swing.JTable();
        View_Con_Cadastra = new javax.swing.JButton();
        View_Con_Limpar = new javax.swing.JButton();
        View_Con_Alterar = new javax.swing.JButton();
        View_Con_Excluir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        View_id_Cli = new javax.swing.JTextField();
        View_Con_Ban = new javax.swing.JTextField();
        btn_volta_conta = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        View_Con_DR = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        View_Con_Data = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        View_Con_Valor = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Conta");

        jLabel2.setText("Agencia");

        jLabel3.setText("Banco");

        View_Conta_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Banco", "Agencia", "Conta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(View_Conta_Table);
        if (View_Conta_Table.getColumnModel().getColumnCount() > 0) {
            View_Conta_Table.getColumnModel().getColumn(0).setMinWidth(50);
            View_Conta_Table.getColumnModel().getColumn(0).setPreferredWidth(50);
            View_Conta_Table.getColumnModel().getColumn(0).setMaxWidth(50);
            View_Conta_Table.getColumnModel().getColumn(2).setMinWidth(100);
            View_Conta_Table.getColumnModel().getColumn(2).setPreferredWidth(100);
            View_Conta_Table.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        View_Con_Cadastra.setText("Cadastrar");
        View_Con_Cadastra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_Con_CadastraActionPerformed(evt);
            }
        });

        View_Con_Limpar.setText("Limpar");
        View_Con_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_Con_LimparActionPerformed(evt);
            }
        });

        View_Con_Alterar.setText("Alterar");
        View_Con_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_Con_AlterarActionPerformed(evt);
            }
        });

        View_Con_Excluir.setText("Excluir");
        View_Con_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_Con_ExcluirActionPerformed(evt);
            }
        });

        jLabel4.setText("Cliente");

        btn_volta_conta.setText("Voltar");
        btn_volta_conta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volta_contaActionPerformed(evt);
            }
        });

        jLabel5.setText("Tipo");

        View_Con_DR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Receita", "Dispesa" }));

        jLabel6.setText("Data");

        try {
            View_Con_Data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel7.setText("Valor");

        View_Con_Valor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_volta_conta, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(View_Con_DR, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(468, 468, 468)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE))
                                    .addComponent(View_Con_Data)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(View_Con_Agen, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(View_Con_Con, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(View_Con_Ban))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(View_id_Cli, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(59, 59, 59))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(View_Con_Cadastra, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(View_Con_Limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(View_Con_Alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(View_Con_Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(View_Con_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(View_Con_DR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(View_Con_Data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(View_Con_Con, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(View_Con_Agen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(View_id_Cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(View_Con_Ban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(3, 3, 3)
                .addComponent(View_Con_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(View_Con_Cadastra, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(View_Con_Limpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(View_Con_Alterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(View_Con_Excluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_volta_conta)
                .addContainerGap())
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

    private void View_Con_CadastraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_Con_CadastraActionPerformed
      
        modelConta = new ModelConta();
        String teste = View_Con_Ban.getText();
        modelConta.setConta(View_Con_Con.getText());
        modelConta.setAgencia(View_Con_Agen.getText());
        modelConta.setNomeconta(View_Con_Ban.getText());
        modelConta.setCliente_id_cliente(Integer.parseInt(View_id_Cli.getText()));
        modelConta.setTipo(View_Con_DR.getSelectedItem().toString());
        modelConta.setData(View_Con_Data.getText());
        modelConta.setValor(Float.parseFloat(View_Con_Valor.getText()));
       

        
        if(AltCadas.equals("Cadastrar")){
            
            if(controllerConta.salvarContaController(modelConta)){
                //cadastrou
                    JOptionPane.showMessageDialog(this, "Cadastro Realizado com Sucesso!", "Aten????o", JOptionPane.INFORMATION_MESSAGE);
                    //limpar
                    limparFormulario();
                    carregarListaConta();
                    //ViewEnderecoFecha();
                   
                }else{
                //n??o cadastrou
                    JOptionPane.showMessageDialog(this, "Erro ao Cadastrar", "Erro", JOptionPane.ERROR_MESSAGE);
                }
        }else{
             int linha = View_Conta_Table.getSelectedRow();
             int idConta = (int) View_Conta_Table.getValueAt(linha, 0);
             modelConta.setId_conta(idConta);
           if(controllerConta.atualizarContaController(modelConta)){
                //cadastrou
                    JOptionPane.showMessageDialog(this, "Atualiza????o feita com Sucesso!", "Aten????o", JOptionPane.INFORMATION_MESSAGE);
                    //limpar
                    limparFormulario();
                    carregarListaConta();
                }else{
                //n??o cadastrou
                    JOptionPane.showMessageDialog(this, "Erro na Atualiza????o", "Erro", JOptionPane.ERROR_MESSAGE);
                } 
        }
    }//GEN-LAST:event_View_Con_CadastraActionPerformed

    private void View_Con_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_Con_AlterarActionPerformed
        // TODO add your handling code here:
        AltCadas = "Alterar";
           modelConta = new ModelConta();
        int linha = View_Conta_Table.getSelectedRow();
        if(linha < 0){
            JOptionPane.showMessageDialog(this, "Endere??o n??o selecionado", "Alerta", JOptionPane.INFORMATION_MESSAGE);
        }else{
            int idConta = (int) View_Conta_Table.getValueAt(linha, 0);
            modelConta = controllerConta.getContaController(idConta);
            
            View_Con_Agen.setText(modelConta.getAgencia());
            View_Con_Con.setText(modelConta.getConta());
            View_Con_Ban.setText(modelConta.getNomeconta());
            View_id_Cli.setText(Integer.toString(modelConta.getCliente_id_cliente()));
          

        }
    }//GEN-LAST:event_View_Con_AlterarActionPerformed

    private void View_Con_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_Con_ExcluirActionPerformed
        // TODO add your handling code here:
        int linha = View_Conta_Table.getSelectedRow();
        if(linha < 0){
            JOptionPane.showMessageDialog(this, "Conta n??o selecionado", "Alerta", JOptionPane.INFORMATION_MESSAGE);
        }else{
            int codigo = (int) View_Conta_Table.getValueAt(linha, 0);
            if(controllerConta.excluirContaController(codigo)){
                carregarListaConta();
                
                JOptionPane.showMessageDialog(this, "Conta Exclu??da", "Aten????o", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(this, "Erro ao Excluir", "Erro", JOptionPane.ERROR);   
            }
            
            
        }
    }//GEN-LAST:event_View_Con_ExcluirActionPerformed

    private void View_Con_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_Con_LimparActionPerformed
        // TODO add your handling code here:
        limparFormulario();
    }//GEN-LAST:event_View_Con_LimparActionPerformed

    private void btn_volta_contaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volta_contaActionPerformed
        // TODO add your handling code here:
        ViewInicio v = new ViewInicio();
        v.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btn_volta_contaActionPerformed

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
            java.util.logging.Logger.getLogger(ViewConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewConta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField View_Con_Agen;
    private javax.swing.JButton View_Con_Alterar;
    private javax.swing.JTextField View_Con_Ban;
    private javax.swing.JButton View_Con_Cadastra;
    private javax.swing.JTextField View_Con_Con;
    private javax.swing.JComboBox<String> View_Con_DR;
    private javax.swing.JFormattedTextField View_Con_Data;
    private javax.swing.JButton View_Con_Excluir;
    private javax.swing.JButton View_Con_Limpar;
    private javax.swing.JFormattedTextField View_Con_Valor;
    private javax.swing.JTable View_Conta_Table;
    private javax.swing.JTextField View_id_Cli;
    private javax.swing.JButton btn_volta_conta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
