
package UI;

import BLL.ClienteBLL;
import BLL.CopiaParaAlugarBLL;
import BLL.CopiaParaVenderBLL;
import BLL.PlataformaBLL;
import BLL.TituloBLL;
import javax.swing.JOptionPane;

public class frmCadJogo extends javax.swing.JFrame {

    /**
     * Creates new form frmCadJogo
     */
    public frmCadJogo() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbTitulo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbPlataforma = new javax.swing.JComboBox<>();
        btnCadJogo = new javax.swing.JButton();
        btnNovoTitulo = new javax.swing.JButton();
        btnNovaPlataforma = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("TÍTULO: ");

        cmbTitulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("PLATAFORMA: ");

        cmbPlataforma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCadJogo.setText("CADASTRAR JOGO");
        btnCadJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadJogoActionPerformed(evt);
            }
        });

        btnNovoTitulo.setText("NOVO TÍTULO");
        btnNovoTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoTituloActionPerformed(evt);
            }
        });

        btnNovaPlataforma.setText("NOVA PLATAFORMA");
        btnNovaPlataforma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaPlataformaActionPerformed(evt);
            }
        });

        jLabel3.setText("QUANTIDADE:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbTitulo, 0, 219, Short.MAX_VALUE)
                            .addComponent(cmbPlataforma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtQuantidade))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNovaPlataforma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNovoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCadJogo)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovoTitulo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovaPlataforma))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(btnCadJogo, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(98, 98, 98))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        TituloBLL tBLL = new TituloBLL();
        java.util.List<TituloBLL> titulos = tBLL.Consultar();
        
        PlataformaBLL pBLL = new PlataformaBLL();
        java.util.List<PlataformaBLL> plataformas = pBLL.Consultar();
        
        cmbTitulo.removeAllItems();
        cmbPlataforma.removeAllItems();
        
        for (int i = 0; i < titulos.size(); i++) {
            cmbTitulo.addItem(titulos.get(i).getNome());
        }
        
        for (int i = 0; i < plataformas.size(); i++) {
            cmbPlataforma.addItem(plataformas.get(i).getPlataforma());
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnNovaPlataformaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaPlataformaActionPerformed
        // TODO add your handling code here:
        frmCadPlataforma cadPlataforma = new frmCadPlataforma();
        cadPlataforma.setDefaultCloseOperation(HIDE_ON_CLOSE);
        cadPlataforma.setVisible(true);
    }//GEN-LAST:event_btnNovaPlataformaActionPerformed

    private void btnCadJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadJogoActionPerformed
        // TODO add your handling code here:
      
       
        BLL.CopiaParaVenderBLL cBLL = new CopiaParaVenderBLL();
        BLL.TituloBLL tBLL = new TituloBLL();
        BLL.PlataformaBLL pBLL = new PlataformaBLL();
        
        tBLL.setCodigo(cmbTitulo.getSelectedIndex());
        pBLL.setCodigo(cmbPlataforma.getSelectedIndex());
        
        cBLL.setTitulo(tBLL);
        cBLL.setPlataforma(pBLL);
        cBLL.setQuantidade(Integer.valueOf(txtQuantidade.getText()));
        
        // CADASTRAR
        if (cBLL.Cadastrar()) {
            JOptionPane.showMessageDialog(null, "DEU CERTO");
        }
        else{
            JOptionPane.showMessageDialog(null, "DEU NADA CERTO :(");
        }
        
        
        
    }//GEN-LAST:event_btnCadJogoActionPerformed

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
            java.util.logging.Logger.getLogger(frmCadJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCadJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCadJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCadJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCadJogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadJogo;
    private javax.swing.JButton btnNovaPlataforma;
    private javax.swing.JButton btnNovoTitulo;
    private javax.swing.JComboBox<String> cmbPlataforma;
    private javax.swing.JComboBox<String> cmbTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
