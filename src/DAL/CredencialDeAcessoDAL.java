/*
 * CLASSE QUE GERENCIA AS CREDENCIAIS DE ACESSO DE TODOS OS USUÁRIOS DO SISTEMA
 */
package DAL;

import BLL.CredencialDeAcessoBLL; // IMPORTANDO O PACOTE BLL CORRESPONDENTE À ESTE CLASSE
import java.sql.*;

public class CredencialDeAcessoDAL {
    
    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO NECESSÁRIA
    
    public boolean Validar(CredencialDeAcessoBLL cBLL){
        
        String comandoSQL = "SELECT * FROM Credenciais_de_acesso WHERE USUARIO = ? AND SENHA = ?;"; // COMANDO SQL
        
        try {
            
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL); // PREPARAR COMANDO PARA EXECUÇÃO
            query.setString(1, cBLL.getUsuario());// DEFININDO PARÂMETRO DE USUÁRIO
            query.setString(2, cBLL.getSenha()); // DEFININDO PARÂMETRO DE SENHA
            
            ResultSet resultadoConsulta = query.executeQuery();
            
            if (resultadoConsulta.next()) {
                return true; // CREDENCIAL EXISTE
            }
            else{
                return false; // CREDENCIAL NÃO EXISTE
                
            }
            
            
        } catch (SQLException ex) {
            
            System.out.println("ERRO DE SQL. \n" + ex);
            return false;
            
        }
        
    }
    
    public boolean Cadastrar(CredencialDeAcessoBLL fBLL){
        // CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO Credenciais_de_acesso (usuario, senha, cod_cadastro) VALUES (?, ?, ?);";
        
        // TRATAMENTO DE ERRO
        try {
            
            // PREPARANDO QUERY PARA EXECUÇÃO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, fBLL.getUsuario());
            query.setString(2, fBLL.getSenha());
            query.setString(3, fBLL.getCodCadastro().getCodigoDeCadastro());
            
            // EXECUTAR COMANDO
            query.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + ex);
            return false;
        }
    }
    
}
