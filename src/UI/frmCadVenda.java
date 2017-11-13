/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BLL.AcessorioBLL;
import BLL.PessoaFisicaBLL;
import BLL.PessoaJuridicaBLL;
import BLL.ProdutoBLL;
import BLL.VendaBLL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Guto
 */
public class frmCadVenda extends javax.swing.JFrame {

    /**
     * Creates new form frmCadVenda
     */
    public frmCadVenda() {
        initComponents();

        // ASSOCIAR MODELS NAS RESPECTIVAS TABELAS
        modelTabelaProdutosCadastrados = (DefaultTableModel) tblProdCadastrados.getModel();
        modelTabelaItensDaVenda = (DefaultTableModel) tblItensDaVenda.getModel();
    }

    //MODELS DAS TABELAS
    private DefaultTableModel modelTabelaProdutosCadastrados;
    private DefaultTableModel modelTabelaItensDaVenda;

    // OBJETOS PARA TRABALHAR COM PRODUTOS
    private List<ProdutoBLL> listaDeProdutosCadastrados;
    private ProdutoBLL pBLL = new ProdutoBLL();

    // OBJETOS PARA TRABALHAR COM CLIENTES
    private PessoaFisicaBLL pfBLL = new PessoaFisicaBLL();
    private List<PessoaFisicaBLL> listaDeClientesFisicos;

    private PessoaJuridicaBLL pjBLL = new PessoaJuridicaBLL();
    private List<PessoaJuridicaBLL> listaDeClientesJuridicos;

    // OBJETOS PARA TRABALHAR COM A VENDA
    private List<ProdutoBLL> itensDaVenda = new ArrayList<>();
    private VendaBLL vBLL = new VendaBLL();
    
    private List<Integer> indicesDosProdutosAdicionadosAoCarrinho = new ArrayList<>();
    
    private float totalDaVenda = 0;
    private int dia, mes, ano, hora, minuto;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgCadVenda = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<>();
        rdbPessoaFisica = new javax.swing.JRadioButton();
        rdbPessoaJuridica = new javax.swing.JRadioButton();
        rdbClienteNaoCadastrado = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdCadastrados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItensDaVenda = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtTotalVenda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel8.setFont(new java.awt.Font("Perpetua Titling MT", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/cadastrarvenda.png"))); // NOI18N
        jLabel8.setText("CADASTRO DE VENDA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel8)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CLIENTE");

        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        rdbPessoaFisica.setBackground(new java.awt.Color(0, 0, 0));
        btgCadVenda.add(rdbPessoaFisica);
        rdbPessoaFisica.setForeground(new java.awt.Color(255, 255, 255));
        rdbPessoaFisica.setText("PESSOA FISICA");
        rdbPessoaFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPessoaFisicaActionPerformed(evt);
            }
        });

        rdbPessoaJuridica.setBackground(new java.awt.Color(0, 0, 0));
        btgCadVenda.add(rdbPessoaJuridica);
        rdbPessoaJuridica.setForeground(new java.awt.Color(255, 255, 255));
        rdbPessoaJuridica.setText("PESSOA JURIDICA");
        rdbPessoaJuridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPessoaJuridicaActionPerformed(evt);
            }
        });

        rdbClienteNaoCadastrado.setBackground(new java.awt.Color(0, 0, 0));
        btgCadVenda.add(rdbClienteNaoCadastrado);
        rdbClienteNaoCadastrado.setForeground(new java.awt.Color(255, 255, 255));
        rdbClienteNaoCadastrado.setText("CLIENTE NÃO CADASTRADO");
        rdbClienteNaoCadastrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbClienteNaoCadastradoActionPerformed(evt);
            }
        });

        tblProdCadastrados.setBackground(new java.awt.Color(0, 0, 0));
        tblProdCadastrados.setForeground(new java.awt.Color(255, 255, 255));
        tblProdCadastrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME DO PRODUTO", "PREÇO DA UNIDADE", "QUANTIDADE NO ESTOQUE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProdCadastrados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdCadastradosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProdCadastrados);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PRODUTOS CADASTRADOS");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ITENS DA VENDA");

        tblItensDaVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME DO PRODUTO", "PREÇO UNIDADE", "QUANTIDADE COMPRADA", "PREÇO TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblItensDaVenda);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADICIONAR ITEM");

        txtTotalVenda.setEditable(false);
        txtTotalVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalVendaActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TOTAL");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DESCONTO");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DATA");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("COD.");

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/cadastrar.png"))); // NOI18N
        jButton2.setToolTipText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("FECHAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdbPessoaFisica)
                                .addGap(18, 18, 18)
                                .addComponent(rdbPessoaJuridica)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdbClienteNaoCadastrado))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtData)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(570, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbPessoaFisica)
                    .addComponent(rdbPessoaJuridica)
                    .addComponent(rdbClienteNaoCadastrado))
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(txtTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void AtualizarTotal(){
        
        totalDaVenda = 0;
        
        //  SOMAR TODOS OS TOTAIS
        for (int i = 0; i < itensDaVenda.size(); i++) {
            
            float totalItem = itensDaVenda.get(i).getPreco() * itensDaVenda.get(i).getQuantidade();
            totalDaVenda += totalItem;
        }
        
        txtTotalVenda.setText("R$ "+totalDaVenda);
        
    }
    
    private void CarregarProdutos() {

        modelTabelaProdutosCadastrados.setRowCount(0); // LIMPAR TABELA

        for (int i = 0; i < listaDeProdutosCadastrados.size(); i++) {

            // DEFINIR OS ATRIBUTOS DE FUNCIONÁRIO EM VARIÁVEIS
            int codigo = listaDeProdutosCadastrados.get(i).getCodigo();
            String nome = listaDeProdutosCadastrados.get(i).getNome();
            int quantidade = listaDeProdutosCadastrados.get(i).getQuantidade();
            float preco = listaDeProdutosCadastrados.get(i).getPreco();
            boolean ativo = listaDeProdutosCadastrados.get(i).isAtivo();

            modelTabelaProdutosCadastrados.insertRow(modelTabelaProdutosCadastrados.getRowCount(), new Object[]{nome, "R$" + preco, quantidade});

        }

        tblProdCadastrados.setModel(modelTabelaProdutosCadastrados);
    }

    private void CarregarItensDaVenda() {

        modelTabelaItensDaVenda.setRowCount(0); // LIMPAR TABELA

        for (int i = 0; i < itensDaVenda.size(); i++) {

            // DEFINIR OS ATRIBUTOS DE FUNCIONÁRIO EM VARIÁVEIS
            int codigo = itensDaVenda.get(i).getCodigo();
            String nome = itensDaVenda.get(i).getNome();
            int quantidade_a_comprar = itensDaVenda.get(i).getQuantidade();
            float preco_a_ser_cobrado = itensDaVenda.get(i).getPreco();
            boolean ativo = itensDaVenda.get(i).isAtivo();
            float total = quantidade_a_comprar * preco_a_ser_cobrado;

            modelTabelaItensDaVenda.insertRow(modelTabelaItensDaVenda.getRowCount(), new Object[]{nome, "R$" + preco_a_ser_cobrado, quantidade_a_comprar, "R$" + total});

        }

        tblItensDaVenda.setModel(modelTabelaItensDaVenda);
    }

    private void CarregarClientes() {

        // LIMPAR COMBO BOX
        cmbCliente.removeAllItems();

        if (rdbPessoaFisica.isSelected()) {
            // PREENCHER COMBO BOX COM PESSOAS FÍSICAS
            for (int i = 0; i < listaDeClientesFisicos.size(); i++) {

                cmbCliente.addItem(listaDeClientesFisicos.get(i).getNome());

            }
        } else if (rdbPessoaJuridica.isSelected()) {
            //PREENCHER COMBO BOX COM PESSOAS JURÍDICAS
            for (int i = 0; i < listaDeClientesJuridicos.size(); i++) {

                cmbCliente.addItem(listaDeClientesJuridicos.get(i).getRazaoSocial());

            }
        }

    }

    private void rdbClienteNaoCadastradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbClienteNaoCadastradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbClienteNaoCadastradoActionPerformed

    private void rdbPessoaFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPessoaFisicaActionPerformed
        CarregarClientes();
    }//GEN-LAST:event_rdbPessoaFisicaActionPerformed

    private void txtTotalVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalVendaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        //INICIAR DATA
        GregorianCalendar calendario = new GregorianCalendar();
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = 1 + calendario.get(Calendar.MONTH);
        ano = calendario.get(Calendar.YEAR);
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minuto = calendario.get(Calendar.MINUTE);
        txtData.setText(dia + "/" + mes + "/" + ano + " às " + hora + ":" + minuto);
        
        // PREENCHER LISTA DE CLIENTES FÍSICOS E JURÍDICOS
        listaDeClientesFisicos = pfBLL.Consultar();
        listaDeClientesJuridicos = pjBLL.Consultar();
        rdbPessoaFisica.setSelected(true); // SELECIONAR O RADIOBUTTON DE PESSOA FÍSICA
        CarregarClientes();

        //CARREGAR E PREENCHER TODOS OS PRODUTOS CADASTRADOS
        listaDeProdutosCadastrados = pBLL.Consultar();
        CarregarProdutos();
    }//GEN-LAST:event_formWindowOpened

    private void rdbPessoaJuridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPessoaJuridicaActionPerformed
        CarregarClientes();
    }//GEN-LAST:event_rdbPessoaJuridicaActionPerformed

    private void AdicionarProdutoAoCarrinho() {
        boolean naoRepetido = true;
        int indice = tblProdCadastrados.getSelectedRow();
        int indiceDoItemRepetido = 0;
        
        // VERIFICAR SE PRODUTO JÁ ESTÁ NA TABELA DE ITENS DA VENDA
        for (int i = 0; i < itensDaVenda.size(); i++) {

            if (itensDaVenda.get(i).getCodigo() == listaDeProdutosCadastrados.get(indice).getCodigo()) {
                naoRepetido = false;
                indiceDoItemRepetido = i;
            }

        }

        // VERIFICAR QUANTIDADE DO PRODUTO ADICIONADO
        int quantidadeProdutoAtual = listaDeProdutosCadastrados.get(indice).getQuantidade();

        // SÓ ADICIONAR PRODUTO SE ELE EXISTIR EM ESTOQUE
        if (quantidadeProdutoAtual > 0) {
           
            if (naoRepetido) {

                //PRODUTO PARA ADICIONAR À LISTA
                ProdutoBLL produtoParaAdicionarAosItensDaVenda = new ProdutoBLL();
                produtoParaAdicionarAosItensDaVenda.setCodigo(listaDeProdutosCadastrados.get(indice).getCodigo());
                produtoParaAdicionarAosItensDaVenda.setNome(listaDeProdutosCadastrados.get(indice).getNome());
                produtoParaAdicionarAosItensDaVenda.setPreco(listaDeProdutosCadastrados.get(indice).getPreco());
                produtoParaAdicionarAosItensDaVenda.setQuantidade(1);        
                
                indicesDosProdutosAdicionadosAoCarrinho.add(indice);
                
                itensDaVenda.add(produtoParaAdicionarAosItensDaVenda);

                listaDeProdutosCadastrados.get(indice).setQuantidade(quantidadeProdutoAtual - 1);
                CarregarProdutos();
                
                CarregarItensDaVenda();
                
                
                
            } else {
                itensDaVenda.get(indiceDoItemRepetido).setQuantidade(itensDaVenda.get(indiceDoItemRepetido).getQuantidade() + 1);
                CarregarItensDaVenda();
                
                listaDeProdutosCadastrados.get(tblProdCadastrados.getSelectedRow()).setQuantidade(quantidadeProdutoAtual - 1);
                CarregarProdutos();
            }
            
            AtualizarTotal();
        }

    }

    private void tblProdCadastradosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdCadastradosMouseClicked

        // RECONHECER SE É UM CLIQUE DUPLO
        if (evt.getClickCount() >= 2) {

            AdicionarProdutoAoCarrinho();

        }

    }//GEN-LAST:event_tblProdCadastradosMouseClicked

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
            java.util.logging.Logger.getLogger(frmCadVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCadVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCadVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCadVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCadVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgCadVenda;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JRadioButton rdbClienteNaoCadastrado;
    private javax.swing.JRadioButton rdbPessoaFisica;
    private javax.swing.JRadioButton rdbPessoaJuridica;
    private javax.swing.JTable tblItensDaVenda;
    private javax.swing.JTable tblProdCadastrados;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtTotalVenda;
    // End of variables declaration//GEN-END:variables
}
