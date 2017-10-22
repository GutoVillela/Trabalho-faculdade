
package DAL;

import BLL.CodigoDeCadastroBLL; // INSTÂNCIA DA RESPECTIVA CLASSE BLL
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CodigoDeCadastroDAL {
    private Conexao con = new Conexao();// INSTÂNCIA DA CLASSE DE CONEXÃO
    
    public boolean Cadastrar(CodigoDeCadastroBLL caBLL){
        // CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO Codigos_de_cadastro (codigo_De_Cadastro, utilizado, ativo) VALUES (?, ?, ?);";
        
        // TRATAMENTO DE ERRO
        try {
            
            // PREPARANDO QUERY PARA EXECUÇÃO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, caBLL.getCodigoDeCadastro());
            query.setBoolean(2, caBLL.isUtilizado());
            query.setBoolean(3, caBLL.isAtivo());
            
            // EXECUTAR COMANDO
            query.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + ex);
            return false;
        }
    }
}
