
package DAL;

import BLL.BairroBLL;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BairroDAL {
    
    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO
    
    public boolean Cadastrar(BairroBLL bBLL){
        
        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO Bairros (codigoBairro, Nome, Cidade) VALUES (?,?, ?);";
        
        // TRATAMENTO DE ERRO
        try{
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
           query.setString(1, bBLL.getCodigoBairro());
           query.setString(2,bBLL.getNome());
           query.setInt(3,bBLL.getCidade().getCodigo());
            
            // EXECUTAR COMANDO
            query.executeUpdate();
            
            return true;
        }
        catch (SQLException erro){
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return false;
        }
        
        
    }
}
