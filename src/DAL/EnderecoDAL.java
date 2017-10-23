
package DAL;

import BLL.EnderecoBLL;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class EnderecoDAL {
    
     private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO
    
    public boolean Cadastrar(EnderecoBLL eBLL){
        
        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO ENDERECOS (logradouro, numero, cep, bairro, ativo) VALUES (?, ?,?, ?, ?);";
        
        // TRATAMENTO DE ERRO
        try{
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1,eBLL.getLogradouro());
            query.setString(2,eBLL.getNumero());
            query.setString(3,eBLL.getCep());
            query.setInt(4,eBLL.getBairro().getCodigo());
            query.setBoolean(5,eBLL.isAtivo());
            
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
