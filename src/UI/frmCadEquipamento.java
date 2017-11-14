/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BLL.EquipamentoDaLojaBLL;
import BLL.EquipamentoDaManutencaoBLL;
import BLL.EquipamentoDoClienteBLL;
import BLL.PessoaFisicaBLL;
import BLL.TipoEquipamentoBLL;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Guto
 */
public class frmCadEquipamento extends javax.swing.JFrame {

    /**
     * Creates new form frmCadEquipamento
     */
    public frmCadEquipamento() {
        initComponents();
    }

    private List<TipoEquipamentoBLL> tiposDeEquipamentos;
    private TipoEquipamentoBLL teBLL = new TipoEquipamentoBLL();

    private PessoaFisicaBLL pfBLL = new PessoaFisicaBLL();
    private List<PessoaFisicaBLL> listaDePessoaFisica;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgDaLojaOuNao = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtNome = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnCadTipoEquipamento = new javax.swing.JButton();
        lblValorPorHora = new javax.swing.JLabel();
        txtValorPorHora = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        rdbDaLoja = new javax.swing.JRadioButton();
        cmbClientes = new javax.swing.JComboBox<>();
        rdbDoCliente = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        cmbTipoEquipamento = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        btnCadastrar.setBackground(new java.awt.Color(0, 0, 0));
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/cadastrar.png"))); // NOI18N
        btnCadastrar.setToolTipText("Salvar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnCadTipoEquipamento.setBackground(new java.awt.Color(0, 0, 0));
        btnCadTipoEquipamento.setForeground(new java.awt.Color(255, 255, 255));
        btnCadTipoEquipamento.setText("OUTRO TIPO");
        btnCadTipoEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadTipoEquipamentoActionPerformed(evt);
            }
        });

        lblValorPorHora.setForeground(new java.awt.Color(255, 255, 255));
        lblValorPorHora.setText("VALOR POR HORA: ");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("EQUIPAMENTO: ");

        lblCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblCliente.setText("A QUEM PERTENCE?");

        rdbDaLoja.setBackground(new java.awt.Color(0, 0, 0));
        btgDaLojaOuNao.add(rdbDaLoja);
        rdbDaLoja.setForeground(new java.awt.Color(255, 255, 255));
        rdbDaLoja.setText("DA LOJA");
        rdbDaLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbDaLojaActionPerformed(evt);
            }
        });

        cmbClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        rdbDoCliente.setBackground(new java.awt.Color(0, 0, 0));
        btgDaLojaOuNao.add(rdbDoCliente);
        rdbDoCliente.setForeground(new java.awt.Color(255, 255, 255));
        rdbDoCliente.setSelected(true);
        rdbDoCliente.setText("DO CLIENTE");
        rdbDoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbDoClienteActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TIPO: ");

        cmbTipoEquipamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("QUAL EQUIPAMENTO? ");

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel5.setFont(new java.awt.Font("Perpetua Titling MT", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/equipamento.png"))); // NOI18N
        jLabel5.setText("Cadastro de Equipamentos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(lblValorPorHora)
                            .addComponent(lblCliente))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTipoEquipamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNome)
                            .addComponent(txtValorPorHora)
                            .addComponent(cmbClientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(rdbDoCliente)
                        .addGap(18, 18, 18)
                        .addComponent(rdbDaLoja)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(btnCadTipoEquipamento)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(255, 255, 255))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rdbDoCliente)
                    .addComponent(rdbDaLoja))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbTipoEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadTipoEquipamento))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorPorHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorPorHora))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCliente))
                .addGap(31, 31, 31)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadTipoEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadTipoEquipamentoActionPerformed
        // TODO add your handling code here:

        frmCadTipoEquipamento cadTipoEquipamento = new frmCadTipoEquipamento(); // INSTÂNCIA DO JFRAME QUE EU VOU COPIAR

        JDialog dialogo = new JDialog(this, cadTipoEquipamento.getTitle(), true); // INSTÂNCIA DO JDIALOG QUE VAI RECEBER O MEU JFRAME

        // COLOCAR TODOS OS COMPONENTES DO JFRAME DENTRO DO MEU JDIALOG
        for (int i = 0; i < cadTipoEquipamento.getComponentCount(); i++) {

            dialogo.add(cadTipoEquipamento.getComponent(i));

        }

        // DEFINIR TAMANHO do JDialog IDÊNTICO AO MEU JFRAME
        dialogo.setSize(cadTipoEquipamento.getSize());

        // DEIXAR A POSIÇÃO DO DIÁLOGO RELATIVO À ESTE FORM
        dialogo.setLocationRelativeTo(this);

        //EXIBIR DIÁLOGO PRONTO
        dialogo.setVisible(true);

        //DEPOIS DE EXIBIR O DIÁLOGO, CARREGAR TIPOS
        AtualizarTiposDeEquipamento();

    }//GEN-LAST:event_btnCadTipoEquipamentoActionPerformed

    private void AtualizarTiposDeEquipamento() {
        tiposDeEquipamentos = teBLL.Consultar(); // CONSULTAR TODOS OS TIPOS DE EQUIPAMENTOS DISPONÍVEIS

        cmbTipoEquipamento.removeAllItems();

        for (int i = 0; i < tiposDeEquipamentos.size(); i++) {
            cmbTipoEquipamento.addItem(tiposDeEquipamentos.get(i).getTipo());
        }
    }

    private void AtualizarClientes() {
        listaDePessoaFisica = pfBLL.Consultar(); // CONSULTAR TODOS OS TIPOS DE EQUIPAMENTOS DISPONÍVEIS

        cmbClientes.removeAllItems();

        for (int i = 0; i < listaDePessoaFisica.size(); i++) {
            cmbClientes.addItem(listaDePessoaFisica.get(i).getNome());
        }
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        lblValorPorHora.setVisible(false);
        txtValorPorHora.setVisible(false);
        AtualizarTiposDeEquipamento();
        AtualizarClientes();
    }//GEN-LAST:event_formWindowOpened

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:

        if (rdbDoCliente.isSelected()) {

            // INSTÂNCIA E PREENCHIMENTO DAS INFORMAÇÕES DO EQUIPAMENTO DO CLIENTE
            EquipamentoDoClienteBLL emBLL = new EquipamentoDaManutencaoBLL();
            emBLL.setNome(txtNome.getText());
            emBLL.getCliente().setCodigo(listaDePessoaFisica.get(cmbClientes.getSelectedIndex()).getCodigo());
            emBLL.setTipo(tiposDeEquipamentos.get(cmbTipoEquipamento.getSelectedIndex()));
            emBLL.setAtivo(true);

            if (emBLL.Cadastrar()) {
                int escolha = JOptionPane.showConfirmDialog(null, "Equipamento cadastrado com sucesso.\nDeseja cadastrar outro equipamento?", "CADASTRO REALIZADO COM SUCESSO", JOptionPane.YES_NO_OPTION);

                //CASO O USUÁRIO ESCOLHA NÃO
                if (escolha == JOptionPane.NO_OPTION) {
                    this.setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Aconteceu um erro ao cadastrar o equipamento do cliente.", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // INSTÂNCIA E PREENCHIMENTO DAS INFORMAÇÕES DO EQUIPAMENTO DA LOJA
            EquipamentoDaLojaBLL elBLL = new EquipamentoDaLojaBLL();
            elBLL.setNome(txtNome.getText());
            elBLL.setValorPorHora(Float.valueOf(txtValorPorHora.getText()));
            elBLL.setTipo(tiposDeEquipamentos.get(cmbTipoEquipamento.getSelectedIndex()));
            elBLL.setAtivo(true);

            if (elBLL.Cadastrar()) {
                JOptionPane.showMessageDialog(null, "Equipamento da loja cadastrado com sucesso.", "CADASTRO REALIZADO COM SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Aconteceu um erro ao cadastrar o equipamento da loja.", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void rdbDaLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbDaLojaActionPerformed
        if (rdbDaLoja.isSelected()) {
            lblValorPorHora.setVisible(true);
            txtValorPorHora.setVisible(true);
            lblCliente.setVisible(false);
            cmbClientes.setVisible(false);
        } else {
            lblValorPorHora.setVisible(false);
            txtValorPorHora.setVisible(false);
            lblCliente.setVisible(true);
            cmbClientes.setVisible(true);
        }
    }//GEN-LAST:event_rdbDaLojaActionPerformed

    private void rdbDoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbDoClienteActionPerformed

        if (rdbDaLoja.isSelected()) {
            lblValorPorHora.setVisible(true);
            txtValorPorHora.setVisible(true);
            lblCliente.setVisible(false);
            cmbClientes.setVisible(false);
        } else {
            lblValorPorHora.setVisible(false);
            txtValorPorHora.setVisible(false);
            lblCliente.setVisible(true);
            cmbClientes.setVisible(true);
        }
    }//GEN-LAST:event_rdbDoClienteActionPerformed

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
            java.util.logging.Logger.getLogger(frmCadEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCadEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCadEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCadEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCadEquipamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgDaLojaOuNao;
    private javax.swing.JButton btnCadTipoEquipamento;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox<String> cmbClientes;
    private javax.swing.JComboBox<String> cmbTipoEquipamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblValorPorHora;
    private javax.swing.JRadioButton rdbDaLoja;
    private javax.swing.JRadioButton rdbDoCliente;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtValorPorHora;
    // End of variables declaration//GEN-END:variables
}
