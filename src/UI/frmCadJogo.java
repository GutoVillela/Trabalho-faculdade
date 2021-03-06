
package UI;

import BLL.ClienteBLL;
import BLL.CopiaParaAlugarBLL;
import BLL.CopiaParaVenderBLL;
import BLL.PlataformaBLL;
import BLL.TituloBLL;
import java.awt.Dialog;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class frmCadJogo extends javax.swing.JFrame {

    /**
     * Creates new form frmCadJogo
     */
    public frmCadJogo() {
        initComponents();
    }
    
    List<TituloBLL> titulos;
    List<PlataformaBLL> plataformas;
    
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
        spnQuantidade = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TÍTULO: ");

        cmbTitulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PLATAFORMA: ");

        cmbPlataforma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCadJogo.setBackground(new java.awt.Color(0, 0, 0));
        btnCadJogo.setForeground(new java.awt.Color(255, 255, 255));
        btnCadJogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/cadastrar.png"))); // NOI18N
        btnCadJogo.setToolTipText("Salvar");
        btnCadJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadJogoActionPerformed(evt);
            }
        });

        btnNovoTitulo.setBackground(new java.awt.Color(0, 0, 0));
        btnNovoTitulo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovoTitulo.setText("NOVO TÍTULO");
        btnNovoTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoTituloActionPerformed(evt);
            }
        });

        btnNovaPlataforma.setBackground(new java.awt.Color(0, 0, 0));
        btnNovaPlataforma.setForeground(new java.awt.Color(255, 255, 255));
        btnNovaPlataforma.setText("NOVA PLATAFORMA");
        btnNovaPlataforma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaPlataformaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("QUANTIDADE:");

        spnQuantidade.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel4.setFont(new java.awt.Font("Perpetua Titling MT", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/cadastrarjogo.png"))); // NOI18N
        jLabel4.setText("CADASTRAR JOGO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCadJogo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNovaPlataforma, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(btnNovoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnNovoTitulo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnNovaPlataforma))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(29, 29, 29)
                .addComponent(btnCadJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AtualizarPlataformas(){
        PlataformaBLL pBLL = new PlataformaBLL();
        plataformas = pBLL.Consultar();
        
        
        cmbPlataforma.removeAllItems();
        
        
        for (int i = 0; i < plataformas.size(); i++) {
            cmbPlataforma.addItem(plataformas.get(i).getPlataforma());
        }
    }
    
    private void AtualizarTitulos(){
        TituloBLL tBLL = new TituloBLL();
        titulos = tBLL.Consultar();
        
        cmbTitulo.removeAllItems();
        
        for (int i = 0; i < titulos.size(); i++) {
            cmbTitulo.addItem(titulos.get(i).getNome());
        }
    }
    
    private void btnNovoTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoTituloActionPerformed

        frmCadTitulo cadTitulo = new frmCadTitulo(); // INSTÂNCIA DO JFRAME QUE EU VOU COPIAR
        
        JDialog dialogo = new JDialog(this, cadTitulo.getTitle(), true); // INSTÂNCIA DO JDIALOG QUE VAI RECEBER O MEU JFRAME
        
        // COLOCAR TODOS OS COMPONENTES DO JFRAME DENTRO DO MEU JDIALOG
        for (int i = 0; i < cadTitulo.getComponentCount(); i++) {
            
            dialogo.add(cadTitulo.getComponent(i));
            
        }
        
        // DEFINIR TAMANHO do JDialog IDÊNTICO AO MEU JFRAME
        dialogo.setSize(cadTitulo.getSize());
        
        // DEIXAR A POSIÇÃO DO DIÁLOGO RELATIVO À ESTE FORM
        dialogo.setLocationRelativeTo(this);
        
        //EXIBIR DIÁLOGO PRONTO
        dialogo.setVisible(true);
        
        //DEPOIS DE EXIBIR O DIÁLOGO, ATUALIZAR TÍTULOS
        AtualizarTitulos();
        
    }//GEN-LAST:event_btnNovoTituloActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        AtualizarTitulos();
        AtualizarPlataformas();
        
        
    }//GEN-LAST:event_formWindowOpened

    private void btnNovaPlataformaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaPlataformaActionPerformed
        // TODO add your handling code here:
        frmCadPlataforma cadPlataforma = new frmCadPlataforma(); // INSTÂNCIA DO JFRAME QUE EU VOU COPIAR
        
        JDialog dialogo = new JDialog(this, cadPlataforma.getTitle(), true); // INSTÂNCIA DO JDIALOG QUE VAI RECEBER O MEU JFRAME
        
        // COLOCAR TODOS OS COMPONENTES DO JFRAME DENTRO DO MEU JDIALOG
        for (int i = 0; i < cadPlataforma.getComponentCount(); i++) {
            
            dialogo.add(cadPlataforma.getComponent(i));
            
        }
        
        // DEFINIR TAMANHO do JDialog IDÊNTICO AO MEU JFRAME
        dialogo.setSize(cadPlataforma.getSize());
        
        // DEIXAR A POSIÇÃO DO DIÁLOGO RELATIVO À ESTE FORM
        dialogo.setLocationRelativeTo(this);
        
        //EXIBIR DIÁLOGO PRONTO
        dialogo.setVisible(true);
        
        //DEPOIS DE EXIBIR O DIÁLOGO, ATUALIZAR PLATAFORMAS
        AtualizarPlataformas();
        
        
    }//GEN-LAST:event_btnNovaPlataformaActionPerformed

    private void btnCadJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadJogoActionPerformed
    
       //DEFININDO ATRIBUTOS 
        BLL.CopiaParaAlugarBLL cpaBLL = new CopiaParaAlugarBLL();
        
        cpaBLL.getTitulo().setCodigo(titulos.get(cmbTitulo.getSelectedIndex()).getCodigo());
        cpaBLL.getPlataforma().setCodigo(plataformas.get(cmbPlataforma.getSelectedIndex()).getCodigo());
        cpaBLL.setQuantidade(Integer.valueOf(spnQuantidade.getValue().toString()));
        cpaBLL.setAtivo(true);
        
        // CADASTRAR
        if (cpaBLL.Cadastrar()) {
            int escolha = JOptionPane.showConfirmDialog(null, "Jogo cadastrado com sucesso.\nDeseja cadastrar outro jogo?", "CADASTRO REALIZADO COM SUCESSO", JOptionPane.YES_NO_OPTION);
            
            //CASO O USUÁRIO ESCOLHA NÃO
            if (escolha == JOptionPane.NO_OPTION) {
                this.setVisible(false);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Aconteceu um erro!", "ERRO", JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner spnQuantidade;
    // End of variables declaration//GEN-END:variables
}
