/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BLL.CargoBLL;
import BLL.FuncionarioBLL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Guto
 */
public class frmConFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form frmConFuncionario
     */
    public frmConFuncionario() {
        initComponents();
        tableModel = (DefaultTableModel) tblConsultaFuncionarios.getModel(); // ATRIBUIR MODEL DA TABELA DENTRO DO OBJETO 'DefaultTableModel'
        mascara = new MaskFormatter();// INICIALIZAR MÁSCARA
    }

    private DefaultTableModel tableModel; // MODEL DA TABELA QUE EU VOU USAR PARA INSERIR ELEMENTOS NA TABELA
    private List<FuncionarioBLL> listaDeFuncionarios; // ESTA É A LISTA DE FUNCIONÁRIOS QUE EU VOU ATUALIZAR
    private FuncionarioBLL fBLL = new FuncionarioBLL(); // INSTÂNCIA DE EUM FUNCIONÁRIO BLL PARA TRABALHAR NESTE FORMULÁRIO
    private MaskFormatter mascara; //MÁSCARA DA TEXTBOX
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgMetodosDePesquisa = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rdbNome = new javax.swing.JRadioButton();
        rdbCpf = new javax.swing.JRadioButton();
        rdbEmail = new javax.swing.JRadioButton();
        rdbCargo = new javax.swing.JRadioButton();
        rdbUsuario = new javax.swing.JRadioButton();
        btnConsultar = new javax.swing.JButton();
        cmbCargos = new javax.swing.JComboBox<>();
        txtConsulta = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultaFuncionarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MÉTODO DE CONSULTA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 14))); // NOI18N

        btgMetodosDePesquisa.add(rdbNome);
        rdbNome.setSelected(true);
        rdbNome.setText("NOME");
        rdbNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbNomeActionPerformed(evt);
            }
        });

        btgMetodosDePesquisa.add(rdbCpf);
        rdbCpf.setText("CPF");
        rdbCpf.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rdbCpfStateChanged(evt);
            }
        });
        rdbCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbCpfActionPerformed(evt);
            }
        });

        btgMetodosDePesquisa.add(rdbEmail);
        rdbEmail.setText("EMAIL");
        rdbEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbEmailActionPerformed(evt);
            }
        });

        btgMetodosDePesquisa.add(rdbCargo);
        rdbCargo.setText("CARGO");
        rdbCargo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rdbCargoStateChanged(evt);
            }
        });
        rdbCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbCargoActionPerformed(evt);
            }
        });
        rdbCargo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                rdbCargoPropertyChange(evt);
            }
        });

        btgMetodosDePesquisa.add(rdbUsuario);
        rdbUsuario.setText("USUÁRIO");
        rdbUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbUsuarioActionPerformed(evt);
            }
        });

        btnConsultar.setText("CONSULTAR");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        cmbCargos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCargos.setEnabled(false);
        cmbCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCargosActionPerformed(evt);
            }
        });

        txtConsulta.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtConsultaPropertyChange(evt);
            }
        });
        txtConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtConsultaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConsultar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdbNome)
                        .addGap(18, 18, 18)
                        .addComponent(rdbCpf)
                        .addGap(18, 18, 18)
                        .addComponent(rdbEmail)
                        .addGap(18, 18, 18)
                        .addComponent(rdbUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(rdbCargo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCargos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtConsulta))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbNome)
                    .addComponent(rdbCpf)
                    .addComponent(rdbEmail)
                    .addComponent(rdbCargo)
                    .addComponent(rdbUsuario)
                    .addComponent(cmbCargos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tblConsultaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME", "CPF", "EMAIL", "ENDEREÇO", "CARGO", "USUÁRIO", "SENHA", "ATIVO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblConsultaFuncionarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1036, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        listaDeFuncionarios = fBLL.Consultar();
        CarregarFuncionariosNaTabela();
        CarregarCargos();

    }//GEN-LAST:event_formWindowOpened

    private void CarregarCargos(){
        CargoBLL cBLL = new CargoBLL();
        List<BLL.CargoBLL> listaDeCargos = cBLL.Consultar();
        
        cmbCargos.removeAllItems();
        
        for (int i = 0; i < listaDeCargos.size(); i++) {
            
            cmbCargos.addItem(listaDeCargos.get(i).getCargo());
            
        }
    }
    
    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        Consultar();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void rdbCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbCargoActionPerformed
        FormatarMascaraDeConsulta();

    }//GEN-LAST:event_rdbCargoActionPerformed

    private void rdbCargoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_rdbCargoPropertyChange

    }//GEN-LAST:event_rdbCargoPropertyChange

    private void rdbCargoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rdbCargoStateChanged
        if (rdbCargo.isSelected()) {
            cmbCargos.setEnabled(true);
            txtConsulta.setText("");
            txtConsulta.setEnabled(false);
        } else {
            cmbCargos.setEnabled(false);
            txtConsulta.setText("");
            txtConsulta.setEnabled(true);
        }
    }//GEN-LAST:event_rdbCargoStateChanged

    private void rdbCpfStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rdbCpfStateChanged
        
    }//GEN-LAST:event_rdbCpfStateChanged

    private void FormatarMascaraDeConsulta(){
        if(rdbCpf.isSelected()){
            // FAZER MÁSCARA DE CPF
            try {
                System.out.println("ENTROU NO CPF");
                
                mascara.setPlaceholderCharacter('_');
                mascara.setMask("###.###.###-##");
                mascara.install(txtConsulta);
            }
            catch (ParseException ex) {
                Logger.getLogger(frmConFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            System.out.println("LIMPAR MÁSCARA");
            
            try{
                mascara.uninstall();
                txtConsulta.setText("");
            }
            catch (Exception ex){
                
            }
        }
    }
    
    private void rdbCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbCpfActionPerformed
        FormatarMascaraDeConsulta();
    }//GEN-LAST:event_rdbCpfActionPerformed

    private void txtConsultaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtConsultaPropertyChange
        // TODO add your handling code here:
//        Consultar();
    }//GEN-LAST:event_txtConsultaPropertyChange

    private void txtConsultaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsultaKeyTyped
        Consultar();
    }//GEN-LAST:event_txtConsultaKeyTyped

    private void rdbNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbNomeActionPerformed
        FormatarMascaraDeConsulta();
    }//GEN-LAST:event_rdbNomeActionPerformed

    private void rdbEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbEmailActionPerformed
        FormatarMascaraDeConsulta();
    }//GEN-LAST:event_rdbEmailActionPerformed

    private void rdbUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbUsuarioActionPerformed
        FormatarMascaraDeConsulta();
    }//GEN-LAST:event_rdbUsuarioActionPerformed

    private void cmbCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCargosActionPerformed
        if(rdbCargo.isSelected())   
            Consultar();
    }//GEN-LAST:event_cmbCargosActionPerformed

    private void Consultar() {

        if (rdbNome.isSelected()) {
            listaDeFuncionarios = fBLL.ConsultarPorNome(txtConsulta.getText().trim());
        } else if (rdbCpf.isSelected()) {
            listaDeFuncionarios = fBLL.ConsultarPorCpf(txtConsulta.getText().replace(".", "").replace("-", "").trim());
        } else if (rdbEmail.isSelected()) {
            listaDeFuncionarios = fBLL.ConsultarPorEmail(txtConsulta.getText().trim());
        } else if (rdbCargo.isSelected()) {
            listaDeFuncionarios = fBLL.ConsultarPorCargo(cmbCargos.getSelectedItem().toString().trim());
        } else if (rdbUsuario.isSelected()) {
            listaDeFuncionarios = fBLL.ConsultarPorUsuario(txtConsulta.getText().trim());
        }

        if(listaDeFuncionarios != null)
            CarregarFuncionariosNaTabela();
    }

    /*
    * Carrega a lista de funcionários na tabela de consulta.
     */
    private void CarregarFuncionariosNaTabela() {

        tableModel.setRowCount(0); // LIMPAR TABELA

        
        for (int i = 0; i < listaDeFuncionarios.size(); i++) {

            // DEFINIR OS ATRIBUTOS DE FUNCIONÁRIO EM VARIÁVEIS
            String nome = listaDeFuncionarios.get(i).getNome();
            String cpf = listaDeFuncionarios.get(i).getCpf();
            String email = listaDeFuncionarios.get(i).getEmail();
            String endereco = listaDeFuncionarios.get(i).getEndereco().getLogradouro() + ", " + listaDeFuncionarios.get(i).getEndereco().getNumero() + ", " + listaDeFuncionarios.get(i).getEndereco().getBairro().getNome() + ", " + listaDeFuncionarios.get(i).getEndereco().getBairro().getCidade().getNome() + ", " + listaDeFuncionarios.get(i).getEndereco().getBairro().getCidade().getEstado().getNome();
            String cargo = listaDeFuncionarios.get(i).getCargo().getCargo();
            String usuario = listaDeFuncionarios.get(i).getLogin().getUsuario();
            String senha = listaDeFuncionarios.get(i).getLogin().getSenha();
            boolean ativo = listaDeFuncionarios.get(i).isAtivo();

            tableModel.insertRow(tableModel.getRowCount(), new Object[]{nome, cpf, email, endereco, cargo, usuario, senha, ativo});

        }

        tblConsultaFuncionarios.setModel(tableModel);
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
            java.util.logging.Logger.getLogger(frmConFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmConFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmConFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmConFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmConFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgMetodosDePesquisa;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JComboBox<String> cmbCargos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdbCargo;
    private javax.swing.JRadioButton rdbCpf;
    private javax.swing.JRadioButton rdbEmail;
    private javax.swing.JRadioButton rdbNome;
    private javax.swing.JRadioButton rdbUsuario;
    private javax.swing.JTable tblConsultaFuncionarios;
    private javax.swing.JFormattedTextField txtConsulta;
    // End of variables declaration//GEN-END:variables
}
