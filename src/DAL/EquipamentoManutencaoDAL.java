
package DAL;

import BLL.EquipamentoManutencaoBLL; // IMPORTAÇÃO DA RESPECTIVA CLASSE BLL
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EquipamentoManutencaoDAL {
    
    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO
    
    public boolean Cadastrar(EquipamentoManutencaoBLL emBLL){
        // CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO equipamentos_manutencao (NOME, TIPO, ATIVO) VALUES (?,?,?);";
        
        // TRATAMENTO DE ERRO
        try {
            
            // PREPARANDO QUERY PARA EXECUÇÃO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, emBLL.getNome());
            query.setInt(2, emBLL.getTipo().getCodigo());
            query.setBoolean(3, emBLL.isAtivo());
            
            // EXECUTAR COMANDO
            query.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + ex);
            return false;
        }
    }
    
}
