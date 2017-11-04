
package DAL;


import BLL.ClienteBLL;
import BLL.PessoaFisicaBLL;
import BLL.TelefoneBLL;
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
    
        String comandoSQL = "select * from Pessoa_fisica inner join enderecos \n" +
"on (Pessoa_fisica.codigo = Enderecos.codigo) \n" +
"inner join clientes on (clientes.codigo = pessoa_fisica.codigo)\n" +
"where nome like ?;";

        // TRATAMENTO DE ERRO
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, nome + "%");
            List<PessoaFisicaBLL> listaPessoaFisica = new ArrayList<PessoaFisicaBLL>();
           
            ResultSet consulta = query.executeQuery();
            while (consulta.next()) {
                PessoaFisicaBLL pfBLL = new PessoaFisicaBLL();
                pfBLL.setCodigo(consulta.getInt("codigo"));
                pfBLL.setNome(consulta.getString("nome"));
                pfBLL.setCpf(consulta.getString("cpf"));
                pfBLL.getEndereco().setLogradouro(consulta.getString("logradouro"));
                pfBLL.setEmail(consulta.getString("email"));
                
                List<TelefoneBLL> listaTelefones = consultarTelefone(pfBLL.getCodigo());
                pfBLL.setTelefones(listaTelefones);
                listaPessoaFisica.add(pfBLL);
                
                System.out.println("NOME: " + pfBLL.getNome());
                
                
       
            }
            return listaPessoaFisica;
        } catch (SQLException erro) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return null;
        }
          
    }
    
    public List<TelefoneBLL> consultarTelefone(int codCliente){
        
        
        String comandoSQL = "select * from clientes_tem_telefones join telefones on (telefones.codigo = clientes_tem_telefones.telefone)\n" +
"where cliente=?;";

        // TRATAMENTO DE ERRO
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, codCliente);
            List<TelefoneBLL> listaTel = new ArrayList<TelefoneBLL>();
            ResultSet consulta = query.executeQuery();
            
            while (consulta.next()) {
                
                TelefoneBLL telefone = new TelefoneBLL();
                telefone.setNumero(consulta.getString("numero"));
                telefone.setCodigo(consulta.getInt("codigo"));
                telefone.setDdd(consulta.getString("ddd"));
                telefone.setAtivo(consulta.getBoolean("ativo"));
                listaTel.add(telefone);
                
            
                        
            }

            return listaTel;
        
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
    
    /**
     * @return Retorna uma lista com todas as pessoas físicas cadastradas.
     * Retorna inclusive endereço completo.
     */
    public List<PessoaFisicaBLL> Consultar(){
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM clientes LEFT JOIN pessoa_fisica ON clientes.codigo = pessoa_fisica.codigo LEFT JOIN enderecos ON Clientes.endereco = enderecos.codigo;";

        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<PessoaFisicaBLL> listaDePessoasFisicas = new ArrayList<>();

        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);

            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            while (resultadoConsulta.next()) {
                //PREENCHER ITEM
                PessoaFisicaBLL pfBLL = new PessoaFisicaBLL();
                pfBLL.setCodigo(resultadoConsulta.getInt(1)); // COLUNA 'codigo' DA TABELA 'Clientes'
                pfBLL.setAtivo(resultadoConsulta.getBoolean(2)); // COLUNA 'ativo' DA TABELA 'Clientes'
                pfBLL.getEndereco().setCodigo(resultadoConsulta.getInt(3)); // COLUNA 'endereco' DA TABELA 'Clientes'
                pfBLL.setEmail(resultadoConsulta.getString(4)); // COLUNA 'email' DA TABELA 'Clientes'
                pfBLL.setCodigo(resultadoConsulta.getInt(5)); // COLUNA 'codigo' DA TABELA 'pessoa_fisica'
                pfBLL.setNome(resultadoConsulta.getString(6)); // COLUNA 'nome' DA TABELA 'pessoa_fisica'
                pfBLL.setCpf(resultadoConsulta.getString(7)); // COLUNA 'cpf' DA TABELA 'pessoa_fisica'
                pfBLL.getEndereco().setCodigo(resultadoConsulta.getInt(8)); // COLUNA 'codigo' DA TABELA 'enderecos' 
                pfBLL.getEndereco().setLogradouro(resultadoConsulta.getString(9)); // COLUNA 'logradouro' DA TABELA 'enderecos' 
                pfBLL.getEndereco().setNumero(resultadoConsulta.getString(10)); // COLUNA 'numero' DA TABELA 'enderecos' 
                pfBLL.getEndereco().setCep(resultadoConsulta.getString(11)); // COLUNA 'cep' DA TABELA 'enderecos' 
                pfBLL.getEndereco().getBairro().setNome(resultadoConsulta.getString(12)); // COLUNA 'bairro' DA TABELA 'enderecos' 
                pfBLL.getEndereco().getBairro().getCidade().setNome(resultadoConsulta.getString(13)); // COLUNA 'cidade' DA TABELA 'enderecos' 
                pfBLL.getEndereco().getBairro().getCidade().getEstado().setNome(resultadoConsulta.getString(14)); // COLUNA 'estado' DA TABELA 'enderecos' 
                pfBLL.getEndereco().getBairro().getCidade().getEstado().getPais().setPaisPt(resultadoConsulta.getString(15)); // COLUNA 'pais' DA TABELA 'enderecos' 
                
                //ADICIONAR OBJETO PREENCHIDO À LISTA
                listaDePessoasFisicas.add(pfBLL);
            }

            // RETORNAR LISTA PREENCHIDA
            return listaDePessoasFisicas;

        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + " \n" + e);
            return null;
        }
    }
}