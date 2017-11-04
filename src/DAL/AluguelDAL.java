
package DAL;

import BLL.AluguelBLL;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AluguelDAL {
    
    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO
    
    public boolean Cadastrar(AluguelBLL aBLL){
        
        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO Alugueis (horario_inicio, duracao, ativo, cliente) VALUES (?, ?, ?, ?);";
        
        // TRATAMENTO DE ERRO
        try{
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, aBLL.getHorarioInicio());
            query.setString(2, aBLL.getDuracao());
            query.setBoolean(3, aBLL.isAtivo());
            query.setInt(4, aBLL.getCliente().getCodigo());
            
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
