
package DAL;

import BLL.PessoaJuridicaBLL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaDAL {
    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO
    
    public boolean Cadastrar(PessoaJuridicaBLL pjBLL){
        
        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO pessoa_juridica (codigo, razao_social, cnpj) VALUES (?, ?, ?);";
        
        // TRATAMENTO DE ERRO
        try{
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, pjBLL.getCodigo());
            query.setString(2, pjBLL.getRazaoSocial());
            query.setString(3, pjBLL.getCnpj());
            
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
        String comandoSQL = "select count(codigo) as 'ID' from pessoa_jurudica;";
        
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
     * @return Retorna uma lista com todas as pessoas juridicas cadastradas.
     * Retorna inclusive endereço completo.
     */
    public List<PessoaJuridicaBLL> Consultar(){
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM clientes JOIN pessoa_juridica ON clientes.codigo = pessoa_juridica.codigo LEFT JOIN enderecos ON Clientes.endereco = enderecos.codigo;";

        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<PessoaJuridicaBLL> listaDePessoasJuridicas = new ArrayList<>();

        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);

            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            while (resultadoConsulta.next()) {
                //PREENCHER ITEM
                PessoaJuridicaBLL pjBLL = new PessoaJuridicaBLL();
                pjBLL.setCodigo(resultadoConsulta.getInt(1)); // COLUNA 'codigo' DA TABELA 'Clientes'
                pjBLL.setAtivo(resultadoConsulta.getBoolean(2)); // COLUNA 'ativo' DA TABELA 'Clientes'
                pjBLL.getEndereco().setCodigo(resultadoConsulta.getInt(3)); // COLUNA 'endereco' DA TABELA 'Clientes'
                pjBLL.setEmail(resultadoConsulta.getString(4)); // COLUNA 'email' DA TABELA 'Clientes'
                pjBLL.setCodigo(resultadoConsulta.getInt(5)); // COLUNA 'codigo' DA TABELA 'pessoa_juridica'
                pjBLL.setRazaoSocial(resultadoConsulta.getString(6)); // COLUNA 'nome' DA TABELA 'pessoa_juridica'
                pjBLL.setCnpj(resultadoConsulta.getString(7)); // COLUNA 'cpf' DA TABELA 'pessoa_juridica'
                pjBLL.getEndereco().setCodigo(resultadoConsulta.getInt(8)); // COLUNA 'codigo' DA TABELA 'enderecos' 
                pjBLL.getEndereco().setLogradouro(resultadoConsulta.getString(9)); // COLUNA 'logradouro' DA TABELA 'enderecos' 
                pjBLL.getEndereco().setNumero(resultadoConsulta.getString(10)); // COLUNA 'numero' DA TABELA 'enderecos' 
                pjBLL.getEndereco().setCep(resultadoConsulta.getString(11)); // COLUNA 'cep' DA TABELA 'enderecos' 
                pjBLL.getEndereco().getBairro().setNome(resultadoConsulta.getString(12)); // COLUNA 'bairro' DA TABELA 'enderecos' 
                pjBLL.getEndereco().getBairro().getCidade().setNome(resultadoConsulta.getString(13)); // COLUNA 'cidade' DA TABELA 'enderecos' 
                pjBLL.getEndereco().getBairro().getCidade().getEstado().setNome(resultadoConsulta.getString(14)); // COLUNA 'estado' DA TABELA 'enderecos' 
                pjBLL.getEndereco().getBairro().getCidade().getEstado().getPais().setPaisPt(resultadoConsulta.getString(15)); // COLUNA 'pais' DA TABELA 'enderecos' 
                
                //ADICIONAR OBJETO PREENCHIDO À LISTA
                listaDePessoasJuridicas.add(pjBLL);
            }

            // RETORNAR LISTA PREENCHIDA
            return listaDePessoasJuridicas;

        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + " \n" + e);
            return null;
        }
    }
}
