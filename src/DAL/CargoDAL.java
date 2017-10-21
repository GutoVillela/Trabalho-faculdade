/*
* CLASSE QUE GERENCIA O ACESSO A DADOS PARA CARGOS
*/
package DAL;

import BLL.CargoBLL; //
import java.sql.PreparedStatement;

public class CargoDAL {
    
    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO
    
    public boolean Cadastrar(CargoBLL cBLL){
        //DEFINIR COMANDO SQL
        String comandoSQL = "INSERT INTO Cargos (cargo, salario, permissao, ativo) VALUES (?, ?, ?, ?);";
        
        // TRATAMENTO DE ERROS
        try {
            
            //PREPARAR O COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, cBLL.getCargo());
            query.setFloat(2, cBLL.getSalario());
            query.setInt(3, cBLL.getPermissao().getCodigo());
            query.setBoolean(4, cBLL.isAtivo());
            
            query.executeUpdate();// EXECUTAR O INSERT
            return true;
            
            
        } catch (Exception erro) {
            System.out.println("ERRO EM " + this.getClass().getCanonicalName() + "!\n" + erro);
            
            return false;
        }
    }
    
}
