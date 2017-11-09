/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BLL.PessoaFisicaBLL;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class frmConsCliente extends javax.swing.JFrame {

    List<PessoaFisicaBLL> listaConsulta;
    PessoaFisicaBLL consultar = new PessoaFisicaBLL();
    ListModel demonio;

    /**
     * Creates new form frmConsCliente
     */
    public frmConsCliente() {
        initComponents();
        demonio = listConsulta.getModel();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txttelefone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtcelular = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        txtcpf2 = new javax.swing.JFormattedTextField();
        btnAlterar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtconsultnome = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        btnbuscarnome = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listConsulta = new javax.swing.JList();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Nome");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel4.setText("CPF");

        jLabel5.setText("Endereço");

        jLabel6.setText("Telefone");

        txttelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefoneActionPerformed(evt);
            }
        });

        jLabel7.setText("Celular");

        txtcelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcelularActionPerformed(evt);
            }
        });

        jLabel8.setText("E-mail");

        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });

        try {
            txtcpf2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        jButton2.setText("Excluir");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel9.setText("Código");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jLabel2.setText("NOME DO CLIENTE: ");

        txtconsultnome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconsultnomeActionPerformed(evt);
            }
        });

        jLabel10.setText("Lista de nomes encontrados");

        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnbuscarnome.setText("Buscar");
        btnbuscarnome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarnomeActionPerformed(evt);
            }
        });

        jRadioButton1.setText("CONSULTAR CLIENTES - PESSOA FÍSICA");

        listConsulta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        listConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listConsultaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listConsulta);

        jRadioButton2.setText("CONSULTAR CLIENTES - PESSOA JURIDICA");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setText("CONSULTA DE CLIENTES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterar)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalvar)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addGap(50, 50, 50))
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(183, 183, 183)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtcpf2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(13, 13, 13)
                                            .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(537, 537, 537)
                                .addComponent(jLabel10))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(txtconsultnome, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnbuscarnome, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jRadioButton1)
                                .addGap(102, 102, 102)
                                .addComponent(jRadioButton2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtconsultnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnbuscarnome)
                            .addComponent(jLabel2))
                        .addGap(38, 38, 38)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtcpf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAlterar)
                            .addComponent(jButton2)
                            .addComponent(jButton4)
                            .addComponent(btnSalvar))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txttelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefoneActionPerformed

    private void txtcelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcelularActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        txtNome.setEditable(true);
        txtEndereco.setEditable(true);
        txtcelular.setEditable(true);
        txtcpf2.setEditable(true);
        txtemail.setEditable(true);
        txttelefone.setEditable(true);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        /* PessoaFisicaBLL pbll = new PessoaFisicaBLL();
         pbll.setNome(txtnome.getText());
         pbll.setCpf(txtcpf.getText().replace(".", "").replace("-", ""));
         pbll.getEndereco().setCep(txtCep.getText().replace("-", ""));
         pbll.getEndereco().setLogradouro(cmbLogradouro.getSelectedItem()+" "+txtLogradouro.getText());
         pbll.getEndereco().getBairro().setNome(txtBairro.getText());
         pbll.getEndereco().setNumero(txtNumero.getText());
         pbll.getEndereco().getBairro().getCidade().setNome(txtCidade.getText());
         pbll.getEndereco().getBairro().getCidade().getEstado().setNome(txtEstado.getText());
         pbll.getEndereco().getBairro().getCidade().getEstado().getPais().setPaisPt(txtPais.getText());
         pbll.getEndereco().setAtivo(true);

         TelefoneBLL telefone1 = new TelefoneBLL();
         telefone1.setDdd(txtddd.getText().replace("(", "").replace(")", ""));
         telefone1.setNumero(txttelefone.getText().replace("-", ""));
         telefone1.setAtivo(true);

         TelefoneBLL celular1 = new TelefoneBLL();
         celular1.setDdd(txtddd2.getText().replace("(", "").replace(")", ""));
         celular1.setNumero(txtcelular.getText().replace("-", ""));
         celular1.setAtivo(true);

         pbll.getTelefones().add(celular1);
         pbll.getTelefones().add(telefone1);

         pbll.setEmail(txtemail.getText());
         pbll.setAtivo(true);

         if(pbll.Cadastrar()){
         JOptionPane.showMessageDialog(null, "CADASTROU O CLIENTE", "Cadastro efetuado com sucesso", JOptionPane.INFORMATION_MESSAGE);
         } else {
         JOptionPane.showMessageDialog(null, "NÃO DEU CERTO :(", "Erro", JOptionPane.ERROR_MESSAGE);
         }*/
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtconsultnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconsultnomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconsultnomeActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(WIDTH);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnbuscarnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarnomeActionPerformed
        consultar.setNome(txtconsultnome.getText());
        listaConsulta = consultar.ConsultarPorNome();

        DefaultListModel satanas = new DefaultListModel();

        for (int i = 0; i < listaConsulta.size(); i++) {

            satanas.addElement(listaConsulta.get(i).getNome());

        }
        demonio = satanas;
        listConsulta.setModel(demonio);

        txtNome.setEditable(false);
        txtCodigo.setEditable(false);
        txtEndereco.setEditable(false);
        txtcelular.setEditable(false);
        txtcpf2.setEditable(false);
        txtemail.setEditable(false);
        txttelefone.setEditable(false);

    }//GEN-LAST:event_btnbuscarnomeActionPerformed

    private void listConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listConsultaMouseClicked
        int indice = listConsulta.getSelectedIndex();
        txtNome.setText(listaConsulta.get(indice).getNome());
        txtcpf2.setText(listaConsulta.get(indice).getCpf());
        txtEndereco.setText(listaConsulta.get(indice).getEndereco().getLogradouro());
        txtemail.setText(listaConsulta.get(indice).getEmail());
        int teste = listaConsulta.get(indice).getCodigo();
        txtCodigo.setText(String.valueOf(teste));

        //txttelefone.setText(listaConsulta.get(indice).getTelefones());
        txttelefone.setText(listaConsulta.get(indice).getTelefones().get(0).getNumero());
        txtcelular.setText(listaConsulta.get(indice).getTelefones().get(1).getNumero());

    }//GEN-LAST:event_listConsultaMouseClicked

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
            java.util.logging.Logger.getLogger(frmConsCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmConsCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmConsCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmConsCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmConsCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnbuscarnome;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listConsulta;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtconsultnome;
    private javax.swing.JFormattedTextField txtcpf2;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txttelefone;
    // End of variables declaration//GEN-END:variables
}
