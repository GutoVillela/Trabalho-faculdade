package DAL;

import BLL.FornecedorBLL;
import BLL.TelefoneBLL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAL {
    
    private Conexao con = new Conexao();
    
    
    public boolean Cadastrar(FornecedorBLL fBLL) {

        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO fornecedores (razao_social, cnpj, endereco, email, ativo) VALUES (?, ?, ?, ?, ?);";

        // TRATAMENTO DE ERRO
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, fBLL.getRazaoSocial());
            query.setString(2, fBLL.getCnpj());
            query.setInt(3, fBLL.getEndereco().getCodigo());
            query.setString(4, fBLL.getEmail());
            query.setBoolean(5, fBLL.isAtivo());
            
            

            // EXECUTAR COMANDO
            query.executeUpdate();

            return true;
        } catch (SQLException erro) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return false;
        }

    }
    
    public List<FornecedorBLL> ConsultarPorNome(String nome){
        
        String comandoSQL = "select * from fornecedores inner join enderecos on (fornecedores.codigo = enderecos.codigo)\n" +
"where razao_social like ? and fornecedores.ativo=1; ";
        
         // TRATAMENTO DE ERRO
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, nome + "%");
            List<FornecedorBLL> listaFornecedor = new ArrayList<FornecedorBLL>();
           
            ResultSet consulta = query.executeQuery();
            while (consulta.next()) {
                FornecedorBLL fBLL = new FornecedorBLL();
                fBLL.setCodigo(consulta.getInt(1));
                fBLL.setRazaoSocial(consulta.getString(2));
                fBLL.setCnpj(consulta.getString(3));
                fBLL.getEndereco().setCodigo(consulta.getInt(7));
                fBLL.getEndereco().setLogradouro(consulta.getString(8));
                fBLL.getEndereco().setNumero(consulta.getString(9));
                fBLL.getEndereco().getBairro().setNome(consulta.getString(11));
                fBLL.getEndereco().setCep(consulta.getString(10));
                fBLL.setEmail(consulta.getString("email"));
                fBLL.setAtivo(consulta.getBoolean("Ativo"));
                
                List<TelefoneBLL> listaTelefones = consultarTelefone(fBLL.getCodigo());
                fBLL.setTelefones(listaTelefones);
                listaFornecedor.add(fBLL);
                
                
                
       
            }
            return listaFornecedor;
        } catch (SQLException erro) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return null;
        } 
    
    }
    
    
    
   public List<TelefoneBLL> consultarTelefone(int codFornec){
        
        
        String comandoSQL = "select * from fornecedores_tem_telefones join telefones \n" +
"on (telefones.codigo = fornecedores_tem_telefones.telefone) where fornecedor=?;";

        // TRATAMENTO DE ERRO
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, codFornec);
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
   
   
   public List<FornecedorBLL> Consultar(){
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM fornecedores LEFT JOIN enderecos ON fornecedores.codigo = enderecos.codigo ";

        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<FornecedorBLL> listaDeFornecedores = new ArrayList<>();

        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);

            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            while (resultadoConsulta.next()) {
                //PREENCHER ITEM
                FornecedorBLL fBLL = new FornecedorBLL();
                fBLL.setCodigo(resultadoConsulta.getInt(1)); // COLUNA 'codigo' DA TABELA 'Clientes'
                fBLL.setRazaoSocial(resultadoConsulta.getString(2)); // COLUNA 'ativo' DA TABELA 'Clientes'
                fBLL.setCnpj(resultadoConsulta.getString(3));
                fBLL.getEndereco().setCodigo(resultadoConsulta.getInt(4)); // COLUNA 'endereco' DA TABELA 'Clientes'
                fBLL.setEmail(resultadoConsulta.getString(5)); // COLUNA 'email' DA TABELA 'Clientes'
                fBLL.setAtivo(resultadoConsulta.getBoolean(6)); // COLUNA 'codigo' DA TABELA 'pessoa_fisica'
                fBLL.getEndereco().setCodigo(resultadoConsulta.getInt(7)); // COLUNA 'nome' DA TABELA 'pessoa_fisica'
                fBLL.getEndereco().setLogradouro(resultadoConsulta.getString(8)); // COLUNA 'logradouro' DA TABELA 'enderecos' 
                fBLL.getEndereco().setNumero(resultadoConsulta.getString(9)); // COLUNA 'numero' DA TABELA 'enderecos' 
                fBLL.getEndereco().setCep(resultadoConsulta.getString(10)); // COLUNA 'cep' DA TABELA 'enderecos' 
                fBLL.getEndereco().getBairro().setNome(resultadoConsulta.getString(11)); // COLUNA 'bairro' DA TABELA 'enderecos' 
                fBLL.getEndereco().getBairro().getCidade().setNome(resultadoConsulta.getString(12)); // COLUNA 'cidade' DA TABELA 'enderecos' 
                fBLL.getEndereco().getBairro().getCidade().getEstado().setNome(resultadoConsulta.getString(13)); // COLUNA 'estado' DA TABELA 'enderecos' 
                fBLL.getEndereco().getBairro().getCidade().getEstado().getPais().setPaisPt(resultadoConsulta.getString(14)); // COLUNA 'pais' DA TABELA 'enderecos' 
                fBLL.getEndereco().setAtivo(resultadoConsulta.getBoolean(15));
                
                //ADICIONAR OBJETO PREENCHIDO À LISTA
                listaDeFornecedores.add(fBLL);
            }

            // RETORNAR LISTA PREENCHIDA
            return listaDeFornecedores;

        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + " \n" + e);
            return null;
        }
    }
    
   
   
   
   public boolean AtualizarDados(FornecedorBLL fBLL){
        //CRIANDO COMANDO SQL
        String comandoSQL = "update fornecedores set Razao_social=?, cnpj=?, email=?, ativo=? where codigo = ?;";

        // TRATAMENTO DE ERRO
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, fBLL.getRazaoSocial());
            query.setString(2, fBLL.getCnpj());
            query.setString(3, fBLL.getEmail());
            query.setBoolean(4, fBLL.isAtivo());
            query.setInt(5, fBLL.getCodigo());

            // EXECUTAR COMANDO
            query.executeUpdate();

            return true;
        } catch (SQLException erro) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return false;
        }
        
    }
   
   
   
   
   public boolean Desativar(int CodF){
        
         //CRIANDO COMANDO SQL
        String comandoSQL = "update fornecedores set ativo=0 where codigo=?;";
        
        // TRATAMENTO DE ERRO
        try{
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, CodF);
            
            
            // EXECUTAR COMANDO
            query.executeUpdate();
            
            return true;
        }
        catch (SQLException erro){
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return false;
        }
        
        
        
    }
    
   
    
    
    
    public int RecuperarUltimaChavePrimaria() {
        //CRIANDO COMANDO SQL
        String comandoSQL = "select count(codigo) as 'ID' from fornecedores;";

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
    
    public boolean AssociarTodosTelefoneDaLista(FornecedorBLL fBLL) {

        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO fornecedores_tem_telefones (FORNECEDOR, TELEFONE) VALUES (?, ?);";

        // TRATAMENTO DE ERRO
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, fBLL.getCodigo());

            // DEFINIR UMA CHAVE PARA CADA TELEFONE
            for (int i = 0; i < fBLL.getTelefones().size(); i++) {

                // RECUPERAR TELEFONE DO RESPECTIVO ÍNDICE DA LISTA
                query.setInt(2, fBLL.getTelefones().get(i).getCodigo());

                // EXECUTAR COMANDO
                query.executeUpdate();
            }

            return true;
        } catch (SQLException erro) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return false;
        }

    }

    
    

    
}
