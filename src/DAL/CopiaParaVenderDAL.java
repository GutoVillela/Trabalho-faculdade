/*
 * CLASSE QUE GERENCIA ACESSO A DADOS DAS COPIAS PARA VENDER
 */
package DAL;

import BLL.CopiaParaVenderBLL;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CopiaParaVenderDAL {
    
    //INSTÂNCIA DA CLASSE DE CONEXÃO
    private Conexao con = new Conexao();
    
    public boolean Cadastrar(CopiaParaVenderBLL cBLL){
        
        // CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO copias_para_vender (TITULO, PLATAFORMA, QUANTIDADE) VALUES (?, ?, ?);";
        
        // TRATAMENTO DE ERRO
        try {
            
            // PREPARANDO QUERY PARA EXECUÇÃO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, cBLL.getTitulo().getCodigo());
            query.setInt(2, cBLL.getPlataforma().getCodigo());
            query.setInt(3, cBLL.getQuantidade());
            
            // EXECUTAR COMANDO
            query.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + ex);
            return false;
        }
    }
    
}
