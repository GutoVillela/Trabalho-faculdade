
package DAL;


import BLL.ClienteBLL;
import BLL.PessoaFisicaBLL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaDAL {
    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO
    
    public boolean Cadastrar(PessoaFisicaBLL pfBLL){
        
        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO Pessoa_fisica (codigo, nome, cpf) VALUES (?, ?, ?);";
        
        // TRATAMENTO DE ERRO
        try{
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, pfBLL.getCodigo());
            query.setString(2, pfBLL.getNome());
            query.setString(3, pfBLL.getCpf());
            
            // EXECUTAR COMANDO
            query.executeUpdate();
            
            return true;
        }
        catch (SQLException erro){
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return false;
        }
        
        
    }
    public List<PessoaFisicaBLL> ConsultarPorNome(String nome){
    
        String comandoSQL = "select nome, cpf, logradouro, email, telefones.numero from Pessoa_fisica inner join enderecos \n" +
"on (Pessoa_fisica.codigo = Enderecos.codigo) \n" +
"inner join clientes on (Pessoa_fisica.codigo = Clientes.codigo) \n" +
"inner join telefones on (Pessoa_fisica.codigo = telefones.codigo)\n" +
"where nome LIKE ? ;";

        // TRATAMENTO DE ERRO
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, nome);
            List<PessoaFisicaBLL> listatelefone = new ArrayList<PessoaFisicaBLL>();
            ResultSet consulta = query.executeQuery();
            while (consulta.next()) {
                PessoaFisicaBLL pfBLL = new PessoaFisicaBLL();
                pfBLL.setNome(consulta.getString("nome"));
                pfBLL.setCpf(consulta.getString("cpf"));
                pfBLL.getEndereco().setLogradouro(consulta.getString("logradouro"));
                pfBLL.setEmail(consulta.getString("email"));
                
                BLL.TelefoneBLL tBLL = new BLL.TelefoneBLL();
                tBLL.setNumero(consulta.getString("numero"));
                pfBLL.getTelefones().add(tBLL);
                listatelefone.add(pfBLL);
       
            }
            return listatelefone;
        } catch (SQLException erro) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return null;
        }
          
    }
    
    public int RecuperarUltimaChavePrimaria(){
        //CRIANDO COMANDO SQL
        String comandoSQL = "select count(codigo) as 'ID' from pessoa_fisica;";
        
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
