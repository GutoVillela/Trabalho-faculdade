
package UI;

import BLL.CargoBLL; // IMPORTAÇÃO DA CLASSE BLL NECESSÁRIA
import BLL.CodigoDeCadastroBLL;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.parser.DTDConstants;

public class frmCadCodCadastro extends javax.swing.JFrame {

    // CONSTANTES DE CONTROLE
    private final int INDICE_COLUNA_COD_CADASTRO = 0; // ESTA CONSTANTE MAPEIA A POSIÇÃO DA COLUNA AONDE EXISTE O CÓDIGO DE CADASTRO NA TABELA
    private final int INDICE_COLUNA_CARGO = 1; // ESTA CONSTANTE MAPEIA A POSIÇÃO DA COLUNA AONDE EXISTE O CARGO NA TABELA
    
    private CargoBLL cBLL = new CargoBLL();// INSTÂNCIA DA CLASSE DE CARGO
    private List<CargoBLL> listaDeCargos;
    private CodigoDeCadastroBLL ccBLL = new CodigoDeCadastroBLL();
    private List<CodigoDeCadastroBLL> listaDeCodigos = new LinkedList<>();
    DefaultTableModel tableModel; // MODEL DA TABELA
    
    /**
     * Creates new form frmCadCodCadastro
     */
    public frmCadCodCadastro() {
        initComponents();
        this.setSize(655, 315);
        tableModel = (DefaultTableModel) tblCodigosGerados.getModel(); // ASSOCIAR MODEL DA TABELA 
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCodigosGerados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        spnQuantidade = new javax.swing.JSpinner();
        cmbCargos = new javax.swing.JComboBox<>();
        btnCadCargo = new javax.swing.JButton();
        btnGerarCodigos = new javax.swing.JButton();
        btnCadCodigos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(627, 280));
        setResizable(false);
        setSize(new java.awt.Dimension(620, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(15, 14, 14));

        tblCodigosGerados.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        tblCodigosGerados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cargo"
            }
        ));
        jScrollPane1.setViewportView(tblCodigosGerados);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GERAR CÓDIGO PARA O CARGO: ");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("QUANTOS CÓDIGOS:");

        spnQuantidade.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnQuantidade.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cmbCargos.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cmbCargos.setForeground(new java.awt.Color(255, 255, 255));
        cmbCargos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCadCargo.setBackground(new java.awt.Color(0, 0, 0));
        btnCadCargo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnCadCargo.setForeground(new java.awt.Color(255, 255, 255));
        btnCadCargo.setText("OUTRO");
        btnCadCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadCargoActionPerformed(evt);
            }
        });

        btnGerarCodigos.setBackground(new java.awt.Color(0, 0, 0));
        btnGerarCodigos.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnGerarCodigos.setForeground(new java.awt.Color(255, 255, 255));
        btnGerarCodigos.setText("GERAR");
        btnGerarCodigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarCodigosActionPerformed(evt);
            }
        });

        btnCadCodigos.setBackground(new java.awt.Color(0, 0, 0));
        btnCadCodigos.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnCadCodigos.setForeground(new java.awt.Color(255, 255, 255));
        btnCadCodigos.setText("CADASTRAR CÓDIGOS GERADOS");
        btnCadCodigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadCodigosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(61, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbCargos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spnQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCadCargo)
                                    .addComponent(btnGerarCodigos)))
                            .addComponent(btnCadCodigos, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbCargos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadCargo))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnGerarCodigos)
                    .addComponent(spnQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCadCodigos, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AtualizarCargos(){
        listaDeCargos = cBLL.Consultar();
        
        cmbCargos.removeAllItems();
        
        for (int i = 0; i < listaDeCargos.size(); i++) {
            cmbCargos.addItem(listaDeCargos.get(i).getCargo());
        }
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        AtualizarCargos();// ATUALIZAR A LISTA DE CARGOS ASSIM QUE O FORMULÁRIO ABRIR
    }//GEN-LAST:event_formWindowOpened

    private void btnCadCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadCargoActionPerformed
        // TODO add your handling code here:
        
        frmCadCargo cadCargo = new frmCadCargo();
        cadCargo.setDefaultCloseOperation(HIDE_ON_CLOSE);
        cadCargo.setVisible(true);
    }//GEN-LAST:event_btnCadCargoActionPerformed

    private void btnGerarCodigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarCodigosActionPerformed
        // TODO add your handling code here:
        int qtdCodigos = Integer.valueOf(spnQuantidade.getValue().toString());
        
        int qtdCodigosJaGeradosParaCargo = 0;
        
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            
            if(tableModel.getValueAt(i, INDICE_COLUNA_CARGO) == cmbCargos.getSelectedItem().toString()){
                qtdCodigosJaGeradosParaCargo++;
            }
            
        }
        
        CodigoDeCadastroBLL.qtdDeCodigosPreGerados = qtdCodigosJaGeradosParaCargo;
        
        for(int i = 0; i < qtdCodigos; i++){
            int codigoDoCargo = listaDeCargos.get(cmbCargos.getSelectedIndex()).getCodigo();
            //int proximoCodigo = Integer.parseInt(ccBLL.GerarProximo(codigoDoCargo)) + qtdCodigosJaGeradosParaCargo;
            
            String proximoCodigo = ccBLL.GerarProximo(codigoDoCargo);
            
            CodigoDeCadastroBLL codigoParaGerar = new CodigoDeCadastroBLL();
            codigoParaGerar.setCodigoDeCadastro(proximoCodigo);
            codigoParaGerar.getCargo().setCodigo(codigoDoCargo);
            codigoParaGerar.setAtivo(true);
            codigoParaGerar.setUtilizado(false);
            
            listaDeCodigos.add(codigoParaGerar);
            tableModel.insertRow(tableModel.getRowCount(), new Object[] { proximoCodigo, cmbCargos.getSelectedItem().toString()});
        }
        
        ccBLL.ResetarCodigos();
        
    }//GEN-LAST:event_btnGerarCodigosActionPerformed

    private void btnCadCodigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadCodigosActionPerformed
        
        if (ccBLL.Cadastrar(listaDeCodigos)) {
            JOptionPane.showMessageDialog(null, "FOI SIM");
        }
        else
            JOptionPane.showMessageDialog(null, "FOI NÃO :((");
        
        //REMOVER TODAS AS LINHAS
        
        
        
    }//GEN-LAST:event_btnCadCodigosActionPerformed

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
            java.util.logging.Logger.getLogger(frmCadCodCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCadCodCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCadCodCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCadCodCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCadCodCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadCargo;
    private javax.swing.JButton btnCadCodigos;
    private javax.swing.JButton btnGerarCodigos;
    private javax.swing.JComboBox<String> cmbCargos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spnQuantidade;
    private javax.swing.JTable tblCodigosGerados;
    // End of variables declaration//GEN-END:variables
}
