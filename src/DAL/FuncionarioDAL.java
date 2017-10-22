package DAL;

import BLL.FuncionarioBLL; // IMPORTAÇÃO DA RESPECTIVA CLASSE BLL
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioDAL {
    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO
    
    public boolean Cadastrar(FuncionarioBLL fBLL){
        // CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO Funcionarios (nome, cpf, email, endereco, cargo, login, ativo) VALUES (?, ?, ?, ?, ?, ?);";
        
        // TRATAMENTO DE ERRO
        try {
            
            // PREPARANDO QUERY PARA EXECUÇÃO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, fBLL.getNome());
            query.setString(2, fBLL.getCpf());
            query.setString(3, fBLL.getEmail());
            query.setInt(4, fBLL.getCargo().getCodigo());
            query.setString(5, fBLL.getLogin().getUsuario());
            query.setBoolean(6, fBLL.isAtivo());
            
            // EXECUTAR COMANDO
            query.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + ex);
            return false;
        }
    }
}
