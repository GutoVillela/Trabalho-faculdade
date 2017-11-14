package DAL;

import BLL.EnderecoBLL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EnderecoDAL {
    
     private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO
    
    public boolean Cadastrar(EnderecoBLL eBLL){
        
        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO ENDERECOS (logradouro, numero, cep, bairro, CIDADE, ESTADO, PAIS, ativo) VALUES (?, ?,?, ?, ?, ?, ?, ?);";
        
        // TRATAMENTO DE ERRO
        try{
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1,eBLL.getLogradouro());
            query.setString(2,eBLL.getNumero());
            query.setString(3,eBLL.getCep());
            query.setString(4,eBLL.getBairro().getNome());
            query.setString(5,eBLL.getBairro().getCidade().getNome());
            query.setString(6,eBLL.getBairro().getCidade().getEstado().getNome());
            query.setString(7,eBLL.getBairro().getCidade().getEstado().getPais().getPaisPt());
            query.setBoolean(8,eBLL.isAtivo());
            
            // EXECUTAR COMANDO
            query.executeUpdate();
            
            return true;
        }
        catch (SQLException erro){
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return false;
        }
        
        
    }
    public boolean Atualizar(EnderecoBLL eBLL){
        
        //CRIANDO COMANDO SQL
        String comandoSQL = "UPDATE ENDERECOS SET logradouro=?, numero=?, cep=?, bairro=?, CIDADE=?, ESTADO=?, PAIS=?, ativo=? where codigo=?;";
        
        // TRATAMENTO DE ERRO
        try{
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1,eBLL.getLogradouro());
            query.setString(2,eBLL.getNumero());
            query.setString(3,eBLL.getCep());
            query.setString(4,eBLL.getBairro().getNome());
            query.setString(5,eBLL.getBairro().getCidade().getNome());
            query.setString(6,eBLL.getBairro().getCidade().getEstado().getNome());
            query.setString(7,eBLL.getBairro().getCidade().getEstado().getPais().getPaisPt());
            query.setBoolean(8,eBLL.isAtivo());
            query.setInt(9, eBLL.getCodigo());
            
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
        String comandoSQL = "select count(codigo) as 'ID' from enderecos;";
        
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
