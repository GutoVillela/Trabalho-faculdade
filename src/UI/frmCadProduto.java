/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BLL.AcessorioBLL;

/**
 *
 * @author Guto
 */
public class frmCadProduto extends javax.swing.JFrame {

    /**
     * Creates new form frmCadProduto
     */
    public frmCadProduto() {
        initComponents();
    }
    
    private AcessorioBLL aBLL = new AcessorioBLL();
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgTipoProduto = new javax.swing.ButtonGroup();
        btnNovaPlataforma = new javax.swing.JButton();
        cmbPlataforma = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        rdbJogo = new javax.swing.JRadioButton();
        rdbAcessorio = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbTitulo = new javax.swing.JComboBox<>();
        btnNovoTitulo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnNovaPlataforma1 = new javax.swing.JButton();
        cmbPlataforma1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        btnCadJogo = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cmbTipoAcessorio = new javax.swing.JComboBox<>();
        btnNovoTipoAcessorio = new javax.swing.JButton();

        btnNovaPlataforma.setText("NOVA PLATAFORMA");
        btnNovaPlataforma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaPlataformaActionPerformed(evt);
            }
        });

        cmbPlataforma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tipo de produto: ");

        btgTipoProduto.add(rdbJogo);
        rdbJogo.setSelected(true);
        rdbJogo.setText("JOGO");
        rdbJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbJogoActionPerformed(evt);
            }
        });

        btgTipoProduto.add(rdbAcessorio);
        rdbAcessorio.setText("ACESSÓRIO");
        rdbAcessorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbAcessorioActionPerformed(evt);
            }
        });

        jLabel2.setText("NOME:");

        txtNomeProduto.setEnabled(false);
        txtNomeProduto.setFocusTraversalPolicyProvider(true);

        jLabel3.setText("TÍTULO: ");

        cmbTitulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnNovoTitulo.setText("NOVO TÍTULO");
        btnNovoTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoTituloActionPerformed(evt);
            }
        });

        jLabel4.setText("PLATAFORMA:");

        btnNovaPlataforma1.setText("NOVA PLATAFORMA");
        btnNovaPlataforma1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaPlataforma1ActionPerformed(evt);
            }
        });

        cmbPlataforma1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("QUANTIDADE: ");

        jLabel6.setText("PREÇO: ");

        btnCadJogo.setText("CADASTRAR JOGO");
        btnCadJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadJogoActionPerformed(evt);
            }
        });

        jLabel7.setText("TIPO DE ACESSÓRIO: ");

        cmbTipoAcessorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoAcessorio.setEnabled(false);

        btnNovoTipoAcessorio.setText("NOVO TIPO");
        btnNovoTipoAcessorio.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtNomeProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbTitulo, 0, 259, Short.MAX_VALUE)
                                    .addComponent(cmbPlataforma1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtQuantidade)
                                    .addComponent(txtPreco)
                                    .addComponent(cmbTipoAcessorio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnNovaPlataforma1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnNovoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btnNovoTipoAcessorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdbJogo)
                                .addGap(18, 18, 18)
                                .addComponent(rdbAcessorio)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadJogo)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rdbJogo)
                    .addComponent(rdbAcessorio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbTipoAcessorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovoTipoAcessorio))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovoTitulo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbPlataforma1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovaPlataforma1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCadJogo, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoTituloActionPerformed
        // TODO add your handling code here:
        frmCadTitulo cadTitulo = new frmCadTitulo();
        cadTitulo.setDefaultCloseOperation(HIDE_ON_CLOSE);
        cadTitulo.setVisible(true);

    }//GEN-LAST:event_btnNovoTituloActionPerformed

    private void btnNovaPlataformaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaPlataformaActionPerformed
        // TODO add your handling code here:
        frmCadPlataforma cadPlataforma = new frmCadPlataforma();
        cadPlataforma.setDefaultCloseOperation(HIDE_ON_CLOSE);
        cadPlataforma.setVisible(true);
    }//GEN-LAST:event_btnNovaPlataformaActionPerformed

    private void btnNovaPlataforma1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaPlataforma1ActionPerformed
        // TODO add your handling code here:
        frmCadPlataforma cadPlataforma = new frmCadPlataforma();
        cadPlataforma.setDefaultCloseOperation(HIDE_ON_CLOSE);
        cadPlataforma.setVisible(true);
    }//GEN-LAST:event_btnNovaPlataforma1ActionPerformed

    private void btnCadJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadJogoActionPerformed
        // TODO add your handling code here:
        
        aBLL.setNome(txtNomeProduto.getText());
        
        
        
        

    }//GEN-LAST:event_btnCadJogoActionPerformed

    private void rdbJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbJogoActionPerformed
        // TODO add your handling code here:
        
        if (rdbJogo.isSelected()) {
            
            txtNomeProduto.setEnabled(false);
            cmbTipoAcessorio.setEnabled(false);
            btnNovoTipoAcessorio.setEnabled(false);
            cmbTitulo.setEnabled(true);
            cmbPlataforma1.setEnabled(true);
            btnNovoTitulo.setEnabled(true);
            btnNovaPlataforma1.setEnabled(true);
            
        }
        else{
            txtNomeProduto.setEnabled(true);
            cmbTipoAcessorio.setEnabled(true);
            btnNovoTipoAcessorio.setEnabled(true);
            cmbTitulo.setEnabled(false);
            cmbPlataforma1.setEnabled(false);
            btnNovoTitulo.setEnabled(false);
            btnNovaPlataforma1.setEnabled(false);
        }
    }//GEN-LAST:event_rdbJogoActionPerformed

    private void rdbAcessorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbAcessorioActionPerformed
        // TODO add your handling code here:
        
        if (rdbJogo.isSelected()) {
            
            txtNomeProduto.setEnabled(false);
            cmbTipoAcessorio.setEnabled(false);
            btnNovoTipoAcessorio.setEnabled(false);
            cmbTitulo.setEnabled(true);
            cmbPlataforma1.setEnabled(true);
            btnNovoTitulo.setEnabled(true);
            btnNovaPlataforma1.setEnabled(true);
            
        }
        else{
            txtNomeProduto.setEnabled(true);
            cmbTipoAcessorio.setEnabled(true);
            btnNovoTipoAcessorio.setEnabled(true);
            cmbTitulo.setEnabled(false);
            cmbPlataforma1.setEnabled(false);
            btnNovoTitulo.setEnabled(false);
            btnNovaPlataforma1.setEnabled(false);
        }
        
    }//GEN-LAST:event_rdbAcessorioActionPerformed

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
            java.util.logging.Logger.getLogger(frmCadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCadProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgTipoProduto;
    private javax.swing.JButton btnCadJogo;
    private javax.swing.JButton btnNovaPlataforma;
    private javax.swing.JButton btnNovaPlataforma1;
    private javax.swing.JButton btnNovoTipoAcessorio;
    private javax.swing.JButton btnNovoTitulo;
    private javax.swing.JComboBox<String> cmbPlataforma;
    private javax.swing.JComboBox<String> cmbPlataforma1;
    private javax.swing.JComboBox<String> cmbTipoAcessorio;
    private javax.swing.JComboBox<String> cmbTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton rdbAcessorio;
    private javax.swing.JRadioButton rdbJogo;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
