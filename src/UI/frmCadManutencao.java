/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BLL.EquipamentoDoClienteBLL;
import BLL.FuncionarioBLL;
import BLL.PessoaFisicaBLL;
import BLL.TipoManutencaoBLL;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;

/**
 *
 * @author Uny
 */
public class frmCadManutencao extends javax.swing.JFrame {
    private PessoaFisicaBLL pfBLL =new PessoaFisicaBLL();
    private List<PessoaFisicaBLL> listaDePessoaFisica;
    
    private FuncionarioBLL fBLL= new FuncionarioBLL();
    private List<FuncionarioBLL> listaDeFuncionario;
    
    private TipoManutencaoBLL tmBLL = new TipoManutencaoBLL();
    private List<TipoManutencaoBLL> listaTipoManutencao;
    
    private EquipamentoDoClienteBLL ecBLL = new EquipamentoDoClienteBLL();
    private List<EquipamentoDoClienteBLL> listaEquipamentosDoCliente;
            
    private DefaultListModel modelDaList;
    /**
     * Creates new form frmCadManutencao
     */
    public frmCadManutencao() {
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

        btgManutencao = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        rdbLoja = new javax.swing.JRadioButton();
        rdbCliente = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbClientes = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txtHorario = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbTecnico = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbTipoDeManutencao = new javax.swing.JComboBox<>();
        btnCadTipoManutencao = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtParecerTecnico = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtTipoDeManutencao = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtEquipamentosDoCliente = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEquipamentoParaManutencao = new javax.swing.JList<>();
        btnDefeito = new javax.swing.JButton();
        btnOrcamento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/manutencao_equipamento.png"))); // NOI18N
        jLabel2.setText("Cadastro de Manuteção");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(229, 229, 229))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        btgManutencao.add(rdbLoja);
        rdbLoja.setForeground(new java.awt.Color(255, 255, 255));
        rdbLoja.setText("LOJA");

        btgManutencao.add(rdbCliente);
        rdbCliente.setForeground(new java.awt.Color(255, 255, 255));
        rdbCliente.setText("CLIENTE");
        rdbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbClienteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("MANUTENÇÃO");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CLIENTE");

        cmbClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DATA");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("HORARIO");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TECNICO");

        cmbTecnico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("VALOR");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("PARECER TECNICO");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TIPO DE MANUTENÇAO");

        cmbTipoDeManutencao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoDeManutencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoDeManutencaoActionPerformed(evt);
            }
        });

        btnCadTipoManutencao.setBackground(new java.awt.Color(51, 51, 51));
        btnCadTipoManutencao.setForeground(new java.awt.Color(255, 255, 255));
        btnCadTipoManutencao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/outra.png"))); // NOI18N
        btnCadTipoManutencao.setToolTipText("Adicionar");
        btnCadTipoManutencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadTipoManutencaoActionPerformed(evt);
            }
        });

        txtParecerTecnico.setColumns(20);
        txtParecerTecnico.setRows(5);
        jScrollPane4.setViewportView(txtParecerTecnico);

        txtTipoDeManutencao.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(txtTipoDeManutencao);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("EQUIPAMENTOS");

        txtEquipamentosDoCliente.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(txtEquipamentosDoCliente);

        jScrollPane1.setViewportView(txtEquipamentoParaManutencao);

        btnDefeito.setBackground(new java.awt.Color(51, 51, 51));
        btnDefeito.setForeground(new java.awt.Color(255, 255, 255));
        btnDefeito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/defeito.png"))); // NOI18N
        btnDefeito.setToolTipText("Defeito");

        btnOrcamento.setBackground(new java.awt.Color(51, 51, 51));
        btnOrcamento.setForeground(new java.awt.Color(255, 255, 255));
        btnOrcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/orcamento.png"))); // NOI18N
        btnOrcamento.setToolTipText("Orçamento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(rdbCliente)
                        .addGap(28, 28, 28)
                        .addComponent(rdbLoja))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(cmbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane3)
                                        .addComponent(cmbTipoDeManutencao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel9)))
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCadTipoManutencao)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDefeito)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOrcamento)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rdbCliente)
                    .addComponent(rdbLoja))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(cmbTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbTipoDeManutencao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCadTipoManutencao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDefeito, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnOrcamento, javax.swing.GroupLayout.Alignment.TRAILING))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbClienteActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_rdbClienteActionPerformed

    private void btnCadTipoManutencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadTipoManutencaoActionPerformed
        frmCadTipoManutencao cadTipoManutencao = new frmCadTipoManutencao(); // INSTÂNCIA DO JFRAME QUE EU VOU COPIAR
        
        JDialog dialogo = new JDialog(this, cadTipoManutencao.getTitle(), true); // INSTÂNCIA DO JDIALOG QUE VAI RECEBER O MEU JFRAME
        
        // COLOCAR TODOS OS COMPONENTES DO JFRAME DENTRO DO MEU JDIALOG
        for (int i = 0; i < cadTipoManutencao.getComponentCount(); i++) {
            
            dialogo.add(cadTipoManutencao.getComponent(i));
            
        }
        
        // DEFINIR TAMANHO do JDialog IDÊNTICO AO MEU JFRAME
        dialogo.setSize(cadTipoManutencao.getSize());
        
        // DEIXAR A POSIÇÃO DO DIÁLOGO RELATIVO À ESTE FORM
        dialogo.setLocationRelativeTo(this);
        
        //EXIBIR DIÁLOGO PRONTO
        dialogo.setVisible(true);
        
        //DEPOIS DE EXIBIR O DIÁLOGO, ATUALIZAR TIPOS DE MANUTENÇÃO
        CarregarTipoManutencao();
        
    }//GEN-LAST:event_btnCadTipoManutencaoActionPerformed

    private void CarregarTiposDeManutencao(){
        
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        listaDePessoaFisica = pfBLL.Consultar();
        CarregarClientes();
        
        listaDeFuncionario = fBLL.Consultar();
        CarregarFuncionarios();
        
        CarregarTipoManutencao();
        
        
    }//GEN-LAST:event_formWindowOpened

    private void cmbTipoDeManutencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoDeManutencaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoDeManutencaoActionPerformed
    private void CarregarClientes(){
        cmbClientes.removeAllItems();
        
        for(int i=0; i<listaDePessoaFisica.size(); i++){
            cmbClientes.addItem(listaDePessoaFisica.get(i).getNome());
        
        }
    }
    
    private void CarregarFuncionarios(){
        cmbTecnico.removeAllItems();
        
        for(int i=0; i<listaDeFuncionario.size(); i++){
            cmbTecnico.addItem(listaDeFuncionario.get(i).getNome());
        }
    }
    
    private void CarregarTipoManutencao(){
        
        listaTipoManutencao = tmBLL.Consultar();
        cmbTipoDeManutencao.removeAllItems();
        
        for (int i=0; i<listaTipoManutencao.size(); i++){
            
            cmbTipoDeManutencao.addItem(listaTipoManutencao.get(i).getTipoManutencao());
        }
        
        
    }
    private void CarregarEquipamentosDoCliente(){
        
        
        
    }
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
            java.util.logging.Logger.getLogger(frmCadManutencao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCadManutencao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCadManutencao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCadManutencao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCadManutencao().setVisible(true);
            }
        });
    }

    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgManutencao;
    private javax.swing.JButton btnCadTipoManutencao;
    private javax.swing.JButton btnDefeito;
    private javax.swing.JButton btnOrcamento;
    private javax.swing.JComboBox<String> cmbClientes;
    private javax.swing.JComboBox<String> cmbTecnico;
    private javax.swing.JComboBox<String> cmbTipoDeManutencao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JRadioButton rdbCliente;
    private javax.swing.JRadioButton rdbLoja;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JList<String> txtEquipamentoParaManutencao;
    private javax.swing.JList<String> txtEquipamentosDoCliente;
    private javax.swing.JFormattedTextField txtHorario;
    private javax.swing.JTextArea txtParecerTecnico;
    private javax.swing.JList<String> txtTipoDeManutencao;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
