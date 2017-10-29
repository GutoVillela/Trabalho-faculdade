
package DAL;

import BLL.TelefoneBLL; // IMPORTAÇÃO DA RESPECTIVA CLASSE BLL
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelefoneDAL {
    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO
    
    public boolean Cadastrar(TelefoneBLL tBLL){
        
        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO Telefones (ddd, numero, ativo) VALUES (?, ?, ?);";
        
        // TRATAMENTO DE ERRO
        try{
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, tBLL.getDdd());
            query.setString(2, tBLL.getNumero());
            query.setBoolean(3, tBLL.isAtivo());
            
            // EXECUTAR COMANDO
            query.executeUpdate();
            
            return true;
        }
        catch (SQLException erro){
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return false;
        }
        
        
    }
    
    
    public int RecuperarUltimaChavePrimaria(){
        //CRIANDO COMANDO SQL
        String comandoSQL = "select count(codigo) as 'ID' from telefones;";
        
        //CRIANDO VARIÁVEL QUE VAI RECEBER O RESULTADO DA CONSULTA
        int ultimaChavePrimaria;
        
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            
            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();
            
            //RECUPERAR PRÓXIMA CONSULTA
            resultadoConsulta.next();
            
            //ATRIBUINDO RESULTADO À VARIÁVEL
            ultimaChavePrimaria = resultadoConsulta.getInt(1);
            
            // RETORNAR LISTA PREENCHIDA
            return ultimaChavePrimaria;
            
            
        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + e);
            return 0;
        }
    }
}
