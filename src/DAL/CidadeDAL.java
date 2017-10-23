
package DAL;

import BLL.CidadeBLL;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CidadeDAL {
    
    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO
    
    public boolean Cadastrar(CidadeBLL cBLL){
        
        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO CIDADES (CODIGOCIDADE, NOME, ESTADO) VALUES (?, ?, ?);";
        
        // TRATAMENTO DE ERRO
        try{
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1,cBLL.getCodigoCidade());
            query.setString(2,cBLL.getNome());
            query.setInt(3,cBLL.getEstado().getCodigo());
            
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
