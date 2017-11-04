
package DAL;

import BLL.TipoManutencaoBLL;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TipoManutencaoDAL {
    
    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO
    
    public boolean Cadastrar(TipoManutencaoBLL tmBLL){
        
        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO tipos_manutencoes (tipo_manutencao, ativo) VALUES (?, ?);";
        
        // TRATAMENTO DE ERRO
        try{
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, tmBLL.getTipoManutencao());
            query.setBoolean(2, tmBLL.isAtivo());
            
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
