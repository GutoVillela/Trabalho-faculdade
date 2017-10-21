
package DAL;

import BLL.AcessorioBLL; // IMPORTAÇÃO DA RESPECTIVA CLASSE BLL
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AcessorioDAL {
    
    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO
    
    public boolean Cadastrar(AcessorioBLL aBLL){
        // CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO acessorios (codigo, tipo) VALUES (?, ?);";
        
        // TRATAMENTO DE ERRO
        try {
            
            // PREPARANDO QUERY PARA EXECUÇÃO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, aBLL.getCodigo());
            query.setInt(2, aBLL.getTipo().getCodigo());
            
            
            // EXECUTAR COMANDO
            query.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + ex);
            return false;
        }
    }
    
}
