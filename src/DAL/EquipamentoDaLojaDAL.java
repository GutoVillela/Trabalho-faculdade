
package DAL;

import BLL.EquipamentoDaLojaBLL; // IMPORTAÇÃO DA RESPECTIVA CLASSE BLL
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EquipamentoDaLojaDAL {
    
    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO
    
    public boolean Cadastrar(EquipamentoDaLojaBLL elBLL){
        // CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO equipamentos_da_loja (TIPO, NOME, VALOR_POR_HORA, ATIVO) VALUES (?, ?, ?, ?);";
        
        // TRATAMENTO DE ERRO
        try {
            
            // PREPARANDO QUERY PARA EXECUÇÃO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, elBLL.getTipo().getCodigo());
            query.setString(2, elBLL.getNome());
            query.setFloat(3, elBLL.getValorPorHora());
            query.setBoolean(4, elBLL.isAtivo());
            
            // EXECUTAR COMANDO
            query.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + ex);
            return false;
        }
    }
    
}
