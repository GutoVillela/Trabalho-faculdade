
package DAL;

import BLL.CodigoDeCadastroBLL; // INSTÂNCIA DA RESPECTIVA CLASSE BLL
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CodigoDeCadastroDAL {
    private Conexao con = new Conexao();// INSTÂNCIA DA CLASSE DE CONEXÃO
    
    public boolean Cadastrar(CodigoDeCadastroBLL ccBLL){
        // CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO Codigos_de_cadastro (codigo_De_Cadastro, utilizado, cargo, ativo) VALUES (?, ?, ?, ?);";
        
        // TRATAMENTO DE ERRO
        try {
            
            // PREPARANDO QUERY PARA EXECUÇÃO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, ccBLL.getCodigoDeCadastro());
            query.setBoolean(2, ccBLL.isUtilizado());
            query.setInt(3, ccBLL.getCargo().getCodigo());
            query.setBoolean(4, ccBLL.isAtivo());
            
            // EXECUTAR COMANDO
            query.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + ex);
            return false;
        }
    }
    
    public int QuantidadeDeCodigosCadastrados(){
        //CRIANDO COMANDO SQL
        String comandoSQL = "select count(codigo_De_Cadastro) as 'QTD_CODIGOS' from Codigos_de_cadastro;";
        
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
    
    public int QuantidadeDeCodigosCadastradosEmUmCargo(CodigoDeCadastroBLL ccBLL){
        //CRIANDO COMANDO SQL
        String comandoSQL = "select count(codigo_De_Cadastro) as 'QTD_CODIGOS' from Codigos_de_cadastro WHERE codigos_de_cadastro.cargo = ?;";
        
        //CRIANDO VARIÁVEL QUE VAI RECEBER O RESULTADO DA CONSULTA
        int ultimaChavePrimaria;
        
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, ccBLL.getCargo().getCodigo());
            
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
    
    public boolean Validar(CodigoDeCadastroBLL ccBLL){
        
        String comandoSQL = "SELECT * FROM Codigos_de_cadastro WHERE codigo_de_cadastro = ?;"; // COMANDO SQL
        
        try {
            
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL); // PREPARAR COMANDO PARA EXECUÇÃO
            query.setString(1, ccBLL.getCodigoDeCadastro());// DEFININDO PARÂMETRO
            
            ResultSet resultadoConsulta = query.executeQuery();
            
            if (resultadoConsulta.next()) {
                return true; // CÓDIGO EXISTE
            }
            else{
                return false; // CÓDIGO NÃO EXISTE
                
            }
            
            
        } catch (SQLException ex) {
            
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + ex);
            return false;
        }
        
    }
}
