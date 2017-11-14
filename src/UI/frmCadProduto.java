/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BLL.AcessorioBLL;
import BLL.CopiaParaVenderBLL;
import BLL.PlataformaBLL;
import BLL.TipoAcessorioBLL;
import BLL.TipoEquipamentoBLL;
import BLL.TituloBLL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

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

    List<TipoAcessorioBLL> listaDeTiposDeAcessorios = new ArrayList<TipoAcessorioBLL>();
    List<TituloBLL> titulos = new ArrayList<TituloBLL>();
    List<PlataformaBLL> plataformas = new ArrayList<PlataformaBLL>();
    private AcessorioBLL aBLL = new AcessorioBLL();
    private CopiaParaVenderBLL cpvBLL = new CopiaParaVenderBLL();
    private TipoAcessorioBLL taBLL = new TipoAcessorioBLL();

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
        jPanel1 = new javax.swing.JPanel();
        lblTipoAcessorio = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        cmbTipoAcessorio = new javax.swing.JComboBox<>();
        cmbTitulo = new javax.swing.JComboBox<>();
        btnNovoTipoAcessorio = new javax.swing.JButton();
        btnNovoTitulo = new javax.swing.JButton();
        spnQuantidade = new javax.swing.JSpinner();
        lblPlataforma = new javax.swing.JLabel();
        btnNovaPlataforma1 = new javax.swing.JButton();
        cmbPlataforma1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rdbJogo = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        rdbAcessorio = new javax.swing.JRadioButton();
        txtPreco = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        btnCadJogo = new javax.swing.JButton();
        txtNomeProduto = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        btnNovaPlataforma.setText("NOVA PLATAFORMA");
        btnNovaPlataforma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaPlataformaActionPerformed(evt);
            }
        });

        cmbPlataforma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblTipoAcessorio.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoAcessorio.setText("TIPO DE ACESSÓRIO: ");

        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("TÍTULO: ");

        cmbTipoAcessorio.setForeground(new java.awt.Color(255, 255, 255));
        cmbTipoAcessorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoAcessorio.setEnabled(false);

        cmbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        cmbTitulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnNovoTipoAcessorio.setBackground(new java.awt.Color(0, 0, 0));
        btnNovoTipoAcessorio.setForeground(new java.awt.Color(255, 255, 255));
        btnNovoTipoAcessorio.setText("NOVO TIPO");
        btnNovoTipoAcessorio.setEnabled(false);
        btnNovoTipoAcessorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoTipoAcessorioActionPerformed(evt);
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

        spnQuantidade.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        lblPlataforma.setForeground(new java.awt.Color(255, 255, 255));
        lblPlataforma.setText("PLATAFORMA:");

        btnNovaPlataforma1.setBackground(new java.awt.Color(0, 0, 0));
        btnNovaPlataforma1.setForeground(new java.awt.Color(255, 255, 255));
        btnNovaPlataforma1.setText("NOVA PLATAFORMA");
        btnNovaPlataforma1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaPlataforma1ActionPerformed(evt);
            }
        });

        cmbPlataforma1.setForeground(new java.awt.Color(255, 255, 255));
        cmbPlataforma1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tipo de produto: ");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("QUANTIDADE: ");

        rdbJogo.setBackground(new java.awt.Color(0, 0, 0));
        btgTipoProduto.add(rdbJogo);
        rdbJogo.setForeground(new java.awt.Color(255, 255, 255));
        rdbJogo.setSelected(true);
        rdbJogo.setText("JOGO");
        rdbJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbJogoActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PREÇO: ");

        rdbAcessorio.setBackground(new java.awt.Color(0, 0, 0));
        btgTipoProduto.add(rdbAcessorio);
        rdbAcessorio.setForeground(new java.awt.Color(255, 255, 255));
        rdbAcessorio.setText("ACESSÓRIO");
        rdbAcessorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbAcessorioActionPerformed(evt);
            }
        });

        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("NOME:");

        btnCadJogo.setBackground(new java.awt.Color(0, 0, 0));
        btnCadJogo.setForeground(new java.awt.Color(255, 255, 255));
        btnCadJogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/cadastrar.png"))); // NOI18N
        btnCadJogo.setToolTipText("Salvar");
        btnCadJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadJogoActionPerformed(evt);
            }
        });

        txtNomeProduto.setEnabled(false);
        txtNomeProduto.setFocusTraversalPolicyProvider(true);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel8.setFont(new java.awt.Font("Perpetua Titling MT", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/CadProduto.png"))); // NOI18N
        jLabel8.setText("CADASTRAR PRODUTO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadJogo)
                .addGap(242, 242, 242))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(82, 82, 82)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lblPlataforma)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel6)))
                                        .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGap(18, 18, 18))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblTipoAcessorio)
                                    .addGap(9, 9, 9)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmbTitulo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbPlataforma1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPreco)
                                .addComponent(cmbTipoAcessorio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spnQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnNovoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnNovaPlataforma1)
                                .addComponent(btnNovoTipoAcessorio, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lblNome)
                            .addGap(18, 18, 18)
                            .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32)
                        .addComponent(rdbJogo)
                        .addGap(41, 41, 41)
                        .addComponent(rdbAcessorio)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rdbJogo)
                    .addComponent(rdbAcessorio))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoAcessorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipoAcessorio)
                    .addComponent(btnNovoTipoAcessorio))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo)
                    .addComponent(btnNovoTitulo))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPlataforma1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlataforma)
                    .addComponent(btnNovaPlataforma1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(34, 34, 34)
                .addComponent(btnCadJogo)
                .addGap(65, 65, 65))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AtualizarTiposDeAcessorio() {
        // LIMPAR E CARREGAR LISTA COM AS PERMISSOES ENCONTRADAS
        cmbTipoAcessorio.removeAllItems();
        listaDeTiposDeAcessorios = taBLL.Consultar();

        for (int i = 0; i < listaDeTiposDeAcessorios.size(); i++) {
            cmbTipoAcessorio.addItem(String.valueOf(listaDeTiposDeAcessorios.get(i).getNome()));

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
        CarregarTitulos();

    }//GEN-LAST:event_btnNovoTituloActionPerformed

    private void btnNovaPlataformaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaPlataformaActionPerformed
        // TODO add your handling code here:
        frmCadPlataforma cadPlataforma = new frmCadPlataforma();
        cadPlataforma.setDefaultCloseOperation(HIDE_ON_CLOSE);
        cadPlataforma.setVisible(true);
    }//GEN-LAST:event_btnNovaPlataformaActionPerformed

    private void btnNovaPlataforma1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaPlataforma1ActionPerformed
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
        CarregarPlataformas();
    }//GEN-LAST:event_btnNovaPlataforma1ActionPerformed

    private void btnCadJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadJogoActionPerformed

        if (rdbJogo.isSelected()) {
            // DEFINIR ATRIBUTOS DA CÓPIA PARA VENDER
            cpvBLL.setNome(cmbTitulo.getSelectedItem().toString() + " " + cmbPlataforma1.getSelectedItem().toString());
            cpvBLL.setQuantidade(Integer.valueOf(spnQuantidade.getValue().toString()));
            cpvBLL.setPreco(Float.valueOf(txtPreco.getText()));
            cpvBLL.getTitulo().setCodigo(titulos.get(cmbTitulo.getSelectedIndex()).getCodigo());
            cpvBLL.getPlataforma().setCodigo(plataformas.get(cmbPlataforma1.getSelectedIndex()).getCodigo());
            cpvBLL.setAtivo(true);

            if (cpvBLL.Cadastrar()) {
                int escolha = JOptionPane.showConfirmDialog(null, "Produto cadastrado com sucesso.\nDeseja cadastrar outro produto?", "CADASTRO REALIZADO COM SUCESSO", JOptionPane.YES_NO_OPTION);

                //CASO O USUÁRIO ESCOLHA NÃO
                if (escolha == JOptionPane.NO_OPTION) {
                    this.setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Aconteceu um erro ao cadastrar o produto.", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // DEFINIR ATRIBUTOS DO ACESSÓRIO   
            aBLL.setNome(txtNomeProduto.getText());
            aBLL.setQuantidade(Integer.valueOf(spnQuantidade.getValue().toString()));
            aBLL.setPreco(Float.valueOf(txtPreco.getText()));
            aBLL.getTipo().setCodigo(listaDeTiposDeAcessorios.get(cmbTipoAcessorio.getSelectedIndex()).getCodigo());
            aBLL.setAtivo(true);

            if (aBLL.Cadastrar()) {
                int escolha = JOptionPane.showConfirmDialog(null, "Produto cadastrado com sucesso.\nDeseja cadastrar outro produto?", "CADASTRO REALIZADO COM SUCESSO", JOptionPane.YES_NO_OPTION);

                //CASO O USUÁRIO ESCOLHA NÃO
                if (escolha == JOptionPane.NO_OPTION) {
                    this.setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Aconteceu um erro ao cadastrar o produto.", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }


    }//GEN-LAST:event_btnCadJogoActionPerformed

    private void ReformatarCampos() {
        if (rdbJogo.isSelected()) {

            txtNomeProduto.setEnabled(false);
            cmbTipoAcessorio.setEnabled(false);
            btnNovoTipoAcessorio.setEnabled(false);
            cmbTitulo.setEnabled(true);
            cmbPlataforma1.setEnabled(true);
            btnNovoTitulo.setEnabled(true);
            btnNovaPlataforma1.setEnabled(true);
            txtNomeProduto.setVisible(false);
            cmbTipoAcessorio.setVisible(false);
            btnNovoTipoAcessorio.setVisible(false);
            cmbTitulo.setVisible(true);
            cmbPlataforma1.setVisible(true);
            btnNovoTitulo.setVisible(true);
            btnNovaPlataforma1.setVisible(true);
            lblNome.setVisible(false);
            lblTipoAcessorio.setVisible(false);
            lblTitulo.setVisible(true);
            lblPlataforma.setVisible(true);

        } else {
            txtNomeProduto.setEnabled(true);
            cmbTipoAcessorio.setEnabled(true);
            btnNovoTipoAcessorio.setEnabled(true);
            cmbTitulo.setEnabled(false);
            cmbPlataforma1.setEnabled(false);
            btnNovoTitulo.setEnabled(false);
            btnNovaPlataforma1.setEnabled(false);
            txtNomeProduto.setVisible(true);
            cmbTipoAcessorio.setVisible(true);
            btnNovoTipoAcessorio.setVisible(true);
            cmbTitulo.setVisible(false);
            cmbPlataforma1.setVisible(false);
            btnNovoTitulo.setVisible(false);
            btnNovaPlataforma1.setVisible(false);
            lblNome.setVisible(true);
            lblTipoAcessorio.setVisible(true);
            lblTitulo.setVisible(false);
            lblPlataforma.setVisible(false);
        }
    }

    private void rdbJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbJogoActionPerformed
        // TODO add your handling code here:

        ReformatarCampos();
    }//GEN-LAST:event_rdbJogoActionPerformed

    private void rdbAcessorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbAcessorioActionPerformed
        ReformatarCampos();

    }//GEN-LAST:event_rdbAcessorioActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        CarregarTitulos();
        CarregarPlataformas();
        AtualizarTiposDeAcessorio();
        ReformatarCampos();
    }//GEN-LAST:event_formWindowOpened

    private void btnNovoTipoAcessorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoTipoAcessorioActionPerformed

        frmCadTipoAcessorio cadTipoAcessorio = new frmCadTipoAcessorio(); // INSTÂNCIA DO JFRAME QUE EU VOU COPIAR

        JDialog dialogo = new JDialog(this, cadTipoAcessorio.getTitle(), true); // INSTÂNCIA DO JDIALOG QUE VAI RECEBER O MEU JFRAME

        // COLOCAR TODOS OS COMPONENTES DO JFRAME DENTRO DO MEU JDIALOG
        for (int i = 0; i < cadTipoAcessorio.getComponentCount(); i++) {

            dialogo.add(cadTipoAcessorio.getComponent(i));

        }

        // DEFINIR TAMANHO do JDialog IDÊNTICO AO MEU JFRAME
        dialogo.setSize(cadTipoAcessorio.getSize());

        // DEIXAR A POSIÇÃO DO DIÁLOGO RELATIVO À ESTE FORM
        dialogo.setLocationRelativeTo(this);

        //EXIBIR DIÁLOGO PRONTO
        dialogo.setVisible(true);

        //DEPOIS DE EXIBIR O DIÁLOGO, ATUALIZAR TIPOS
        AtualizarTiposDeAcessorio();

    }//GEN-LAST:event_btnNovoTipoAcessorioActionPerformed

    private void CarregarTitulos() {
        TituloBLL tBLL = new TituloBLL();
        titulos = tBLL.Consultar();

        cmbTitulo.removeAllItems();

        for (int i = 0; i < titulos.size(); i++) {
            cmbTitulo.addItem(titulos.get(i).getNome());
        }
    }

    private void CarregarPlataformas() {
        PlataformaBLL pBLL = new PlataformaBLL();
        plataformas = pBLL.Consultar();

        cmbPlataforma1.removeAllItems();

        for (int i = 0; i < plataformas.size(); i++) {
            cmbPlataforma1.addItem(plataformas.get(i).getPlataforma());
        }
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPlataforma;
    private javax.swing.JLabel lblTipoAcessorio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JRadioButton rdbAcessorio;
    private javax.swing.JRadioButton rdbJogo;
    private javax.swing.JSpinner spnQuantidade;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}
