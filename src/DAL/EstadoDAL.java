
package DAL;

import BLL.EstadoBLL; // IMPORTAÇÃO DA RESPECTIVA CLASSE BLL
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EstadoDAL {
    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO
    
    public boolean Cadastrar(EstadoBLL eBLL){
        
        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO ESTADOS (codigoUf, Nome, uf, pais) VALUES (?, ?, ?, ?);";
        
        // TRATAMENTO DE ERRO
        try{
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, eBLL.getCodigoUf());
            query.setString(2,eBLL.getNome());
            query.setString(3,eBLL.getUf());
            query.setInt(4,eBLL.getPais().getCodigo());
            
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
