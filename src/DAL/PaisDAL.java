
package DAL;

import BLL.PaisBLL; // IMPORTAÇÃO DA CLASSE BLL CORRESPONDENTE
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaisDAL {
    
    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO
    
    public boolean Cadastrar(PaisBLL pBLL){
        
        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO PAISES (paisPt, paisEn) VALUES (?, ?);";
        
        // TRATAMENTO DE ERRO
        try{
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, pBLL.getPaisPt());
            query.setString(2, pBLL.getPaisEn());
            
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
