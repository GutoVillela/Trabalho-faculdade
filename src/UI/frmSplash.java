/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAL.Conexao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Guto
 */
public class frmSplash extends javax.swing.JFrame {

    /**
     * Creates new form frmSplash
     */
    public frmSplash() {
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

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/orcamento.png"))); // NOI18N
        jLabel2.setText("SISTEMA GERENCIADOR DE LOJA DE JOGOS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 460, 80));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Carregando...");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/fundo4.png"))); // NOI18N
        jLabel1.setText("genomics");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        this.setSize(500, 250);
        this.setLocationRelativeTo(null);
        
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(frmSplash.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // TENTAR GERAR BANCO DE DADOS
        DAL.Conexao con = new Conexao();
        
        if(!con.GerarBanco()){
            System.out.println("DEU ERRADO AQUI");
            if (con.getErro() == DAL.Conexao.mensagemDeErroConexaoComServidor) {
                con.setPassword(JOptionPane.showInputDialog(null, "Aconteceu um erro na tentativa de instalar nosso banco de dados na sua máquina."
                        + "\nTalvez seja a senha do seu servidor. Vamor tentar resolver?"
                        + "\nEntre com a senha do servidor para criar o banco de dados: ", "Erro na criação do banco de dados.", JOptionPane.WARNING_MESSAGE));
                        
                con.setErro("");
                
                if(!con.GerarBanco() && con.getErro() == DAL.Conexao.mensagemDeErroConexaoComServidor){
                    JOptionPane.showMessageDialog(null, "Ainda não foi possível criar o banco de dados. Por favor reinicie o programa e tente novamente em seguida.", "ERRO AO CRIAR BANCO DE DADOS", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                else{
                    AbrirTelaDeLogin();
                }
                
            }
            else{
                AbrirTelaDeLogin();
            }
        }
        else{
            System.out.println("DEU CERTO GERAR BANCO");
            AbrirTelaDeLogin();
        }
        
        
    }//GEN-LAST:event_formWindowOpened

    private void AbrirTelaDeLogin(){
        try {
            //DEMORAR 5 SEGUNDOS POR CHARME
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(frmSplash.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //FECHAR SPLASH E ABRIR TELA DE LOGIN
            this.setVisible(false);
            frmLogin login = new frmLogin();
            login.setVisible(true);
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
            java.util.logging.Logger.getLogger(frmSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSplash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}