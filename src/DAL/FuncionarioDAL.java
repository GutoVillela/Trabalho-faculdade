package DAL;

import BLL.FuncionarioBLL; // IMPORTAÇÃO DA RESPECTIVA CLASSE BLL
import BLL.TelefoneBLL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAL {
    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO
    
    public boolean Cadastrar(FuncionarioBLL fBLL){
        // CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO Funcionarios (nome, cpf, email, endereco, cargo, login, ativo) VALUES (?, ?, ?, ?, ?, ?, ?);";
        
        // TRATAMENTO DE ERRO
        try {
            
            // PREPARANDO QUERY PARA EXECUÇÃO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, fBLL.getNome());
            query.setString(2, fBLL.getCpf());
            query.setString(3, fBLL.getEmail());
            query.setInt(4, fBLL.getEndereco().getCodigo());
            query.setInt(5, fBLL.getCargo().getCodigo());
            query.setString(6, fBLL.getLogin().getUsuario());
            query.setBoolean(7, fBLL.isAtivo());
            
            // EXECUTAR COMANDO
            query.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + ex);
            return false;
        }
    }
    
    public List<FuncionarioBLL> Consultar() {
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM Funcionarios JOIN Cargos ON Funcionarios.cargo = Cargos.codigo JOIN credenciais_de_acesso ON  funcionarios.login = credenciais_de_acesso.usuario JOIN Enderecos ON Funcionarios.endereco = enderecos.codigo;";

        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<FuncionarioBLL> listaFuncionarios = new ArrayList<FuncionarioBLL>();

        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);

            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            while (resultadoConsulta.next()) {
                //PREENCHER ITEM
                FuncionarioBLL fBLL = new FuncionarioBLL();
                fBLL.setCodigo(resultadoConsulta.getInt(1)); // COLUNA 'codigo'  DA TABELA 'Funcionarios'
                fBLL.setNome(resultadoConsulta.getString(2)); // COLUNA 'nome' DA TABELA 'Funcionarios'
                fBLL.setCpf(resultadoConsulta.getString(3)); // COLUNA 'cpf' DA TABELA 'Funcionarios'
                fBLL.setEmail(resultadoConsulta.getString(4)); // COLUNA 'email' DA TABELA 'Funcionarios'
                fBLL.getEndereco().setCodigo(resultadoConsulta.getInt(5)); // COLUNA 'endereco' DA TABELA 'Funcionarios'
                fBLL.getCargo().setCodigo(resultadoConsulta.getInt(6)); // COLUNA 'cargo' DA TABELA 'Funcionarios'
                fBLL.getLogin().setUsuario(resultadoConsulta.getString(7)); // COLUNA 'login'
                fBLL.setAtivo(resultadoConsulta.getBoolean(8)); // COLUNA 'ativo' DA TABELA 'Funcionarios'
                fBLL.getCargo().setCodigo(resultadoConsulta.getInt(9)); // COLUNA 'codigo' DA TABELA 'Cargos'
                fBLL.getCargo().setCargo(resultadoConsulta.getString(10)); // COLUNA 'cargo' DA TABELA 'Cargos'
                fBLL.getCargo().setSalario(resultadoConsulta.getFloat(11)); // COLUNA 'salario' DA TABELA 'Cargos'
                fBLL.getCargo().getPermissao().setCodigo(resultadoConsulta.getInt(12)); // COLUNA 'permissao' DA TABELA 'Cargos'
                fBLL.getCargo().setAtivo(resultadoConsulta.getBoolean(13)); // COLUNA 'ativo' DA TABELA 'Cargos'
                fBLL.getLogin().setUsuario(resultadoConsulta.getString(14)); // COLUNA 'usuario' DA TABELA 'Credenciais_de_acesso'
                fBLL.getLogin().setSenha(resultadoConsulta.getString(15)); // COLUNA 'senha' DA TABELA 'Credenciais_de_acesso'
                fBLL.getLogin().getCodCadastro().setCodigoDeCadastro(resultadoConsulta.getString(16)); // COLUNA 'cod_cadastro' DA TABELA 'Credenciais_de_acesso'
                fBLL.getEndereco().setCodigo(resultadoConsulta.getInt(17)); // COLUNA 'codigo' DA TABELA 'Enderecos'
                fBLL.getEndereco().setLogradouro(resultadoConsulta.getString(18)); // COLUNA 'logradouro' DA TABELA 'Enderecos'
                fBLL.getEndereco().setNumero(resultadoConsulta.getString(19)); // COLUNA 'numero' DA TABELA 'Enderecos'
                fBLL.getEndereco().setCep(resultadoConsulta.getString(20)); // COLUNA 'CEP' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().setNome(resultadoConsulta.getString(21)); // COLUNA 'bairro' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().getCidade().setNome(resultadoConsulta.getString(22)); // COLUNA 'cidade' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().getCidade().getEstado().setNome(resultadoConsulta.getString(23)); // COLUNA 'estado' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().getCidade().getEstado().getPais().setPaisPt(resultadoConsulta.getString(24)); // COLUNA 'pais' DA TABELA 'Enderecos'
                
                //CONSULTAR E ATRIBUIR LISTA DE TELEFONES DESTE FUNCIONÁRIO
                fBLL.setTelefones(ConsultarTelefones(fBLL.getCodigo()));
                
                //ADICIONAR NOVO TÍTULO PREENCHIDO À COMBOBOX
                listaFuncionarios.add(fBLL);
            }

            // RETORNAR LISTA PREENCHIDA
            return listaFuncionarios;

        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + " \n" + e);
            return null;
        }
    }
    
    public List<TelefoneBLL> ConsultarTelefones(int codFuncionario){
        
        // CRIANDO COMANDO SQL
        String comandoSQL = "select * from funcionarios_tem_telefones join telefones on (telefones.codigo = funcionarios_tem_telefones.telefone) where funcionario = ?;";

        // TRATAMENTO DE ERRO
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, codFuncionario);
            
            // CRIANDO LISTA QUE RECEBERÁ OS TELEFONES DO FUNCIONÁRIO
            List<TelefoneBLL> listaTel = new ArrayList<TelefoneBLL>();
            
            // EXECUTANDO O COMANDO E ADICIONANDO RESULTADO À UM RESULTSET
            ResultSet consulta = query.executeQuery();
            
            while (consulta.next()) {
                
                //DEFININDO ATRIBUTOS DO TELEFONE ENCONTRADO
                TelefoneBLL telefone = new TelefoneBLL();
                telefone.setNumero(consulta.getString("numero"));
                telefone.setCodigo(consulta.getInt("codigo"));
                telefone.setDdd(consulta.getString("ddd"));
                telefone.setAtivo(consulta.getBoolean("ativo"));
                
                // ADICIONANDO TELEFONE À LISTA
                listaTel.add(telefone);
                
            }

            // RETORNANDO LISTA PREENCHIDA
            return listaTel;
        
        } catch (SQLException erro) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return null;
        }
               
    }
    
    public List<FuncionarioBLL> ConsultarPorNome(String nome) {
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM Funcionarios JOIN Cargos ON Funcionarios.cargo = Cargos.codigo JOIN credenciais_de_acesso ON  funcionarios.login = credenciais_de_acesso.usuario JOIN Enderecos ON Funcionarios.endereco = enderecos.codigo WHERE Funcionarios.nome LIKE ?;";

        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<FuncionarioBLL> listaFuncionarios = new ArrayList<FuncionarioBLL>();

        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, nome + "%");

            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            while (resultadoConsulta.next()) {
                //PREENCHER ITEM
                FuncionarioBLL fBLL = new FuncionarioBLL();
                fBLL.setCodigo(resultadoConsulta.getInt(1)); // COLUNA 'codigo'  DA TABELA 'Funcionarios'
                fBLL.setNome(resultadoConsulta.getString(2)); // COLUNA 'nome' DA TABELA 'Funcionarios'
                fBLL.setCpf(resultadoConsulta.getString(3)); // COLUNA 'cpf' DA TABELA 'Funcionarios'
                fBLL.setEmail(resultadoConsulta.getString(4)); // COLUNA 'email' DA TABELA 'Funcionarios'
                fBLL.getEndereco().setCodigo(resultadoConsulta.getInt(5)); // COLUNA 'endereco' DA TABELA 'Funcionarios'
                fBLL.getCargo().setCodigo(resultadoConsulta.getInt(6)); // COLUNA 'cargo' DA TABELA 'Funcionarios'
                fBLL.getLogin().setUsuario(resultadoConsulta.getString(7)); // COLUNA 'login'
                fBLL.setAtivo(resultadoConsulta.getBoolean(8)); // COLUNA 'ativo' DA TABELA 'Funcionarios'
                fBLL.getCargo().setCodigo(resultadoConsulta.getInt(9)); // COLUNA 'codigo' DA TABELA 'Cargos'
                fBLL.getCargo().setCargo(resultadoConsulta.getString(10)); // COLUNA 'cargo' DA TABELA 'Cargos'
                fBLL.getCargo().setSalario(resultadoConsulta.getFloat(11)); // COLUNA 'salario' DA TABELA 'Cargos'
                fBLL.getCargo().getPermissao().setCodigo(resultadoConsulta.getInt(12)); // COLUNA 'permissao' DA TABELA 'Cargos'
                fBLL.getCargo().setAtivo(resultadoConsulta.getBoolean(13)); // COLUNA 'ativo' DA TABELA 'Cargos'
                fBLL.getLogin().setUsuario(resultadoConsulta.getString(14)); // COLUNA 'usuario' DA TABELA 'Credenciais_de_acesso'
                fBLL.getLogin().setSenha(resultadoConsulta.getString(15)); // COLUNA 'senha' DA TABELA 'Credenciais_de_acesso'
                fBLL.getLogin().getCodCadastro().setCodigoDeCadastro(resultadoConsulta.getString(16)); // COLUNA 'cod_cadastro' DA TABELA 'Credenciais_de_acesso'
                fBLL.getEndereco().setCodigo(resultadoConsulta.getInt(17)); // COLUNA 'codigo' DA TABELA 'Enderecos'
                fBLL.getEndereco().setLogradouro(resultadoConsulta.getString(18)); // COLUNA 'logradouro' DA TABELA 'Enderecos'
                fBLL.getEndereco().setNumero(resultadoConsulta.getString(19)); // COLUNA 'numero' DA TABELA 'Enderecos'
                fBLL.getEndereco().setCep(resultadoConsulta.getString(20)); // COLUNA 'CEP' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().setNome(resultadoConsulta.getString(21)); // COLUNA 'bairro' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().getCidade().setNome(resultadoConsulta.getString(22)); // COLUNA 'cidade' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().getCidade().getEstado().setNome(resultadoConsulta.getString(23)); // COLUNA 'estado' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().getCidade().getEstado().getPais().setPaisPt(resultadoConsulta.getString(24)); // COLUNA 'pais' DA TABELA 'Enderecos'
                
                //CONSULTAR E ATRIBUIR LISTA DE TELEFONES DESTE FUNCIONÁRIO
                fBLL.setTelefones(ConsultarTelefones(fBLL.getCodigo()));
                
                //ADICIONAR NOVO TÍTULO PREENCHIDO À COMBOBOX
                listaFuncionarios.add(fBLL);
            }

            // RETORNAR LISTA PREENCHIDA
            return listaFuncionarios;

        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + " \n" + e);
            return null;
        }
    }
    
    public List<FuncionarioBLL> ConsultarPorCpf(String cpf) {
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM Funcionarios JOIN Cargos ON Funcionarios.cargo = Cargos.codigo JOIN credenciais_de_acesso ON  funcionarios.login = credenciais_de_acesso.usuario JOIN Enderecos ON Funcionarios.endereco = enderecos.codigo WHERE Funcionarios.cpf LIKE ?;";

        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<FuncionarioBLL> listaFuncionarios = new ArrayList<FuncionarioBLL>();

        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, cpf + "%");

            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            while (resultadoConsulta.next()) {
                //PREENCHER ITEM
                FuncionarioBLL fBLL = new FuncionarioBLL();
                fBLL.setCodigo(resultadoConsulta.getInt(1)); // COLUNA 'codigo'  DA TABELA 'Funcionarios'
                fBLL.setNome(resultadoConsulta.getString(2)); // COLUNA 'nome' DA TABELA 'Funcionarios'
                fBLL.setCpf(resultadoConsulta.getString(3)); // COLUNA 'cpf' DA TABELA 'Funcionarios'
                fBLL.setEmail(resultadoConsulta.getString(4)); // COLUNA 'email' DA TABELA 'Funcionarios'
                fBLL.getEndereco().setCodigo(resultadoConsulta.getInt(5)); // COLUNA 'endereco' DA TABELA 'Funcionarios'
                fBLL.getCargo().setCodigo(resultadoConsulta.getInt(6)); // COLUNA 'cargo' DA TABELA 'Funcionarios'
                fBLL.getLogin().setUsuario(resultadoConsulta.getString(7)); // COLUNA 'login'
                fBLL.setAtivo(resultadoConsulta.getBoolean(8)); // COLUNA 'ativo' DA TABELA 'Funcionarios'
                fBLL.getCargo().setCodigo(resultadoConsulta.getInt(9)); // COLUNA 'codigo' DA TABELA 'Cargos'
                fBLL.getCargo().setCargo(resultadoConsulta.getString(10)); // COLUNA 'cargo' DA TABELA 'Cargos'
                fBLL.getCargo().setSalario(resultadoConsulta.getFloat(11)); // COLUNA 'salario' DA TABELA 'Cargos'
                fBLL.getCargo().getPermissao().setCodigo(resultadoConsulta.getInt(12)); // COLUNA 'permissao' DA TABELA 'Cargos'
                fBLL.getCargo().setAtivo(resultadoConsulta.getBoolean(13)); // COLUNA 'ativo' DA TABELA 'Cargos'
                fBLL.getLogin().setUsuario(resultadoConsulta.getString(14)); // COLUNA 'usuario' DA TABELA 'Credenciais_de_acesso'
                fBLL.getLogin().setSenha(resultadoConsulta.getString(15)); // COLUNA 'senha' DA TABELA 'Credenciais_de_acesso'
                fBLL.getLogin().getCodCadastro().setCodigoDeCadastro(resultadoConsulta.getString(16)); // COLUNA 'cod_cadastro' DA TABELA 'Credenciais_de_acesso'
                fBLL.getEndereco().setCodigo(resultadoConsulta.getInt(17)); // COLUNA 'codigo' DA TABELA 'Enderecos'
                fBLL.getEndereco().setLogradouro(resultadoConsulta.getString(18)); // COLUNA 'logradouro' DA TABELA 'Enderecos'
                fBLL.getEndereco().setNumero(resultadoConsulta.getString(19)); // COLUNA 'numero' DA TABELA 'Enderecos'
                fBLL.getEndereco().setCep(resultadoConsulta.getString(20)); // COLUNA 'CEP' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().setNome(resultadoConsulta.getString(21)); // COLUNA 'bairro' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().getCidade().setNome(resultadoConsulta.getString(22)); // COLUNA 'cidade' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().getCidade().getEstado().setNome(resultadoConsulta.getString(23)); // COLUNA 'estado' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().getCidade().getEstado().getPais().setPaisPt(resultadoConsulta.getString(24)); // COLUNA 'pais' DA TABELA 'Enderecos'
                
                //CONSULTAR E ATRIBUIR LISTA DE TELEFONES DESTE FUNCIONÁRIO
                fBLL.setTelefones(ConsultarTelefones(fBLL.getCodigo()));
                
                //ADICIONAR NOVO TÍTULO PREENCHIDO À COMBOBOX
                listaFuncionarios.add(fBLL);
            }

            // RETORNAR LISTA PREENCHIDA
            return listaFuncionarios;

        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + " \n" + e);
            return null;
        }
    }
    
    public List<FuncionarioBLL> ConsultarPorEmail(String email) {
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM Funcionarios JOIN Cargos ON Funcionarios.cargo = Cargos.codigo JOIN credenciais_de_acesso ON  funcionarios.login = credenciais_de_acesso.usuario JOIN Enderecos ON Funcionarios.endereco = enderecos.codigo WHERE Funcionarios.email LIKE ?;";

        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<FuncionarioBLL> listaFuncionarios = new ArrayList<FuncionarioBLL>();

        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, email + "%");

            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            while (resultadoConsulta.next()) {
                //PREENCHER ITEM
                FuncionarioBLL fBLL = new FuncionarioBLL();
                fBLL.setCodigo(resultadoConsulta.getInt(1)); // COLUNA 'codigo'  DA TABELA 'Funcionarios'
                fBLL.setNome(resultadoConsulta.getString(2)); // COLUNA 'nome' DA TABELA 'Funcionarios'
                fBLL.setCpf(resultadoConsulta.getString(3)); // COLUNA 'cpf' DA TABELA 'Funcionarios'
                fBLL.setEmail(resultadoConsulta.getString(4)); // COLUNA 'email' DA TABELA 'Funcionarios'
                fBLL.getEndereco().setCodigo(resultadoConsulta.getInt(5)); // COLUNA 'endereco' DA TABELA 'Funcionarios'
                fBLL.getCargo().setCodigo(resultadoConsulta.getInt(6)); // COLUNA 'cargo' DA TABELA 'Funcionarios'
                fBLL.getLogin().setUsuario(resultadoConsulta.getString(7)); // COLUNA 'login'
                fBLL.setAtivo(resultadoConsulta.getBoolean(8)); // COLUNA 'ativo' DA TABELA 'Funcionarios'
                fBLL.getCargo().setCodigo(resultadoConsulta.getInt(9)); // COLUNA 'codigo' DA TABELA 'Cargos'
                fBLL.getCargo().setCargo(resultadoConsulta.getString(10)); // COLUNA 'cargo' DA TABELA 'Cargos'
                fBLL.getCargo().setSalario(resultadoConsulta.getFloat(11)); // COLUNA 'salario' DA TABELA 'Cargos'
                fBLL.getCargo().getPermissao().setCodigo(resultadoConsulta.getInt(12)); // COLUNA 'permissao' DA TABELA 'Cargos'
                fBLL.getCargo().setAtivo(resultadoConsulta.getBoolean(13)); // COLUNA 'ativo' DA TABELA 'Cargos'
                fBLL.getLogin().setUsuario(resultadoConsulta.getString(14)); // COLUNA 'usuario' DA TABELA 'Credenciais_de_acesso'
                fBLL.getLogin().setSenha(resultadoConsulta.getString(15)); // COLUNA 'senha' DA TABELA 'Credenciais_de_acesso'
                fBLL.getLogin().getCodCadastro().setCodigoDeCadastro(resultadoConsulta.getString(16)); // COLUNA 'cod_cadastro' DA TABELA 'Credenciais_de_acesso'
                fBLL.getEndereco().setCodigo(resultadoConsulta.getInt(17)); // COLUNA 'codigo' DA TABELA 'Enderecos'
                fBLL.getEndereco().setLogradouro(resultadoConsulta.getString(18)); // COLUNA 'logradouro' DA TABELA 'Enderecos'
                fBLL.getEndereco().setNumero(resultadoConsulta.getString(19)); // COLUNA 'numero' DA TABELA 'Enderecos'
                fBLL.getEndereco().setCep(resultadoConsulta.getString(20)); // COLUNA 'CEP' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().setNome(resultadoConsulta.getString(21)); // COLUNA 'bairro' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().getCidade().setNome(resultadoConsulta.getString(22)); // COLUNA 'cidade' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().getCidade().getEstado().setNome(resultadoConsulta.getString(23)); // COLUNA 'estado' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().getCidade().getEstado().getPais().setPaisPt(resultadoConsulta.getString(24)); // COLUNA 'pais' DA TABELA 'Enderecos'
                
                //CONSULTAR E ATRIBUIR LISTA DE TELEFONES DESTE FUNCIONÁRIO
                fBLL.setTelefones(ConsultarTelefones(fBLL.getCodigo()));
                
                //ADICIONAR NOVO TÍTULO PREENCHIDO À COMBOBOX
                listaFuncionarios.add(fBLL);
            }

            // RETORNAR LISTA PREENCHIDA
            return listaFuncionarios;

        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + " \n" + e);
            return null;
        }
    }
    
    public List<FuncionarioBLL> ConsultarPorEndereco(BLL.EnderecoBLL eBLL) {
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM Funcionarios JOIN Cargos ON Funcionarios.cargo = Cargos.codigo JOIN credenciais_de_acesso ON  funcionarios.login = credenciais_de_acesso.usuario JOIN Enderecos ON Funcionarios.endereco = enderecos.codigo WHERE enderecos.bairro LIKE ? OR enderecos.CEP LIKE ? OR enderecos.CIDADE LIKE ? OR enderecos.estado LIKE ? OR enderecos.Logradouro LIKE ? OR enderecos.Numero LIKE ? OR enderecos.PAIS LIKE ?;";

        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<FuncionarioBLL> listaFuncionarios = new ArrayList<FuncionarioBLL>();

        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, eBLL.getBairro().getNome() + "%");
            query.setString(2, eBLL.getCep() + "%");
            query.setString(3, eBLL.getBairro().getCidade().getNome() + "%");
            query.setString(4, eBLL.getBairro().getCidade().getEstado().getNome() + "%");
            query.setString(5, eBLL.getLogradouro() + "%");
            query.setString(6, eBLL.getNumero() + "%");
            query.setString(7, eBLL.getBairro().getCidade().getEstado().getPais().getPaisPt() + "%");

            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            while (resultadoConsulta.next()) {
                //PREENCHER ITEM
                FuncionarioBLL fBLL = new FuncionarioBLL();
                fBLL.setCodigo(resultadoConsulta.getInt(1)); // COLUNA 'codigo'  DA TABELA 'Funcionarios'
                fBLL.setNome(resultadoConsulta.getString(2)); // COLUNA 'nome' DA TABELA 'Funcionarios'
                fBLL.setCpf(resultadoConsulta.getString(3)); // COLUNA 'cpf' DA TABELA 'Funcionarios'
                fBLL.setEmail(resultadoConsulta.getString(4)); // COLUNA 'email' DA TABELA 'Funcionarios'
                fBLL.getEndereco().setCodigo(resultadoConsulta.getInt(5)); // COLUNA 'endereco' DA TABELA 'Funcionarios'
                fBLL.getCargo().setCodigo(resultadoConsulta.getInt(6)); // COLUNA 'cargo' DA TABELA 'Funcionarios'
                fBLL.getLogin().setUsuario(resultadoConsulta.getString(7)); // COLUNA 'login'
                fBLL.setAtivo(resultadoConsulta.getBoolean(8)); // COLUNA 'ativo' DA TABELA 'Funcionarios'
                fBLL.getCargo().setCodigo(resultadoConsulta.getInt(9)); // COLUNA 'codigo' DA TABELA 'Cargos'
                fBLL.getCargo().setCargo(resultadoConsulta.getString(10)); // COLUNA 'cargo' DA TABELA 'Cargos'
                fBLL.getCargo().setSalario(resultadoConsulta.getFloat(11)); // COLUNA 'salario' DA TABELA 'Cargos'
                fBLL.getCargo().getPermissao().setCodigo(resultadoConsulta.getInt(12)); // COLUNA 'permissao' DA TABELA 'Cargos'
                fBLL.getCargo().setAtivo(resultadoConsulta.getBoolean(13)); // COLUNA 'ativo' DA TABELA 'Cargos'
                fBLL.getLogin().setUsuario(resultadoConsulta.getString(14)); // COLUNA 'usuario' DA TABELA 'Credenciais_de_acesso'
                fBLL.getLogin().setSenha(resultadoConsulta.getString(15)); // COLUNA 'senha' DA TABELA 'Credenciais_de_acesso'
                fBLL.getLogin().getCodCadastro().setCodigoDeCadastro(resultadoConsulta.getString(16)); // COLUNA 'cod_cadastro' DA TABELA 'Credenciais_de_acesso'
                fBLL.getEndereco().setCodigo(resultadoConsulta.getInt(17)); // COLUNA 'codigo' DA TABELA 'Enderecos'
                fBLL.getEndereco().setLogradouro(resultadoConsulta.getString(18)); // COLUNA 'logradouro' DA TABELA 'Enderecos'
                fBLL.getEndereco().setNumero(resultadoConsulta.getString(19)); // COLUNA 'numero' DA TABELA 'Enderecos'
                fBLL.getEndereco().setCep(resultadoConsulta.getString(20)); // COLUNA 'CEP' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().setNome(resultadoConsulta.getString(21)); // COLUNA 'bairro' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().getCidade().setNome(resultadoConsulta.getString(22)); // COLUNA 'cidade' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().getCidade().getEstado().setNome(resultadoConsulta.getString(23)); // COLUNA 'estado' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().getCidade().getEstado().getPais().setPaisPt(resultadoConsulta.getString(24)); // COLUNA 'pais' DA TABELA 'Enderecos'
                
                //CONSULTAR E ATRIBUIR LISTA DE TELEFONES DESTE FUNCIONÁRIO
                fBLL.setTelefones(ConsultarTelefones(fBLL.getCodigo()));
                
                //ADICIONAR NOVO TÍTULO PREENCHIDO À COMBOBOX
                listaFuncionarios.add(fBLL);
            }

            // RETORNAR LISTA PREENCHIDA
            return listaFuncionarios;

        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + " \n" + e);
            return null;
        }
    }
    
    public List<FuncionarioBLL> ConsultarPorUsuario(String usuario) {
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM Funcionarios JOIN Cargos ON Funcionarios.cargo = Cargos.codigo JOIN credenciais_de_acesso ON  funcionarios.login = credenciais_de_acesso.usuario JOIN Enderecos ON Funcionarios.endereco = enderecos.codigo WHERE credenciais_de_acesso.usuario LIKE ?;";

        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<FuncionarioBLL> listaFuncionarios = new ArrayList<FuncionarioBLL>();

        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, usuario + "%");

            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            while (resultadoConsulta.next()) {
                //PREENCHER ITEM
                FuncionarioBLL fBLL = new FuncionarioBLL();
                fBLL.setCodigo(resultadoConsulta.getInt(1)); // COLUNA 'codigo'  DA TABELA 'Funcionarios'
                fBLL.setNome(resultadoConsulta.getString(2)); // COLUNA 'nome' DA TABELA 'Funcionarios'
                fBLL.setCpf(resultadoConsulta.getString(3)); // COLUNA 'cpf' DA TABELA 'Funcionarios'
                fBLL.setEmail(resultadoConsulta.getString(4)); // COLUNA 'email' DA TABELA 'Funcionarios'
                fBLL.getEndereco().setCodigo(resultadoConsulta.getInt(5)); // COLUNA 'endereco' DA TABELA 'Funcionarios'
                fBLL.getCargo().setCodigo(resultadoConsulta.getInt(6)); // COLUNA 'cargo' DA TABELA 'Funcionarios'
                fBLL.getLogin().setUsuario(resultadoConsulta.getString(7)); // COLUNA 'login'
                fBLL.setAtivo(resultadoConsulta.getBoolean(8)); // COLUNA 'ativo' DA TABELA 'Funcionarios'
                fBLL.getCargo().setCodigo(resultadoConsulta.getInt(9)); // COLUNA 'codigo' DA TABELA 'Cargos'
                fBLL.getCargo().setCargo(resultadoConsulta.getString(10)); // COLUNA 'cargo' DA TABELA 'Cargos'
                fBLL.getCargo().setSalario(resultadoConsulta.getFloat(11)); // COLUNA 'salario' DA TABELA 'Cargos'
                fBLL.getCargo().getPermissao().setCodigo(resultadoConsulta.getInt(12)); // COLUNA 'permissao' DA TABELA 'Cargos'
                fBLL.getCargo().setAtivo(resultadoConsulta.getBoolean(13)); // COLUNA 'ativo' DA TABELA 'Cargos'
                fBLL.getLogin().setUsuario(resultadoConsulta.getString(14)); // COLUNA 'usuario' DA TABELA 'Credenciais_de_acesso'
                fBLL.getLogin().setSenha(resultadoConsulta.getString(15)); // COLUNA 'senha' DA TABELA 'Credenciais_de_acesso'
                fBLL.getLogin().getCodCadastro().setCodigoDeCadastro(resultadoConsulta.getString(16)); // COLUNA 'cod_cadastro' DA TABELA 'Credenciais_de_acesso'
                fBLL.getEndereco().setCodigo(resultadoConsulta.getInt(17)); // COLUNA 'codigo' DA TABELA 'Enderecos'
                fBLL.getEndereco().setLogradouro(resultadoConsulta.getString(18)); // COLUNA 'logradouro' DA TABELA 'Enderecos'
                fBLL.getEndereco().setNumero(resultadoConsulta.getString(19)); // COLUNA 'numero' DA TABELA 'Enderecos'
                fBLL.getEndereco().setCep(resultadoConsulta.getString(20)); // COLUNA 'CEP' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().setNome(resultadoConsulta.getString(21)); // COLUNA 'bairro' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().getCidade().setNome(resultadoConsulta.getString(22)); // COLUNA 'cidade' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().getCidade().getEstado().setNome(resultadoConsulta.getString(23)); // COLUNA 'estado' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().getCidade().getEstado().getPais().setPaisPt(resultadoConsulta.getString(24)); // COLUNA 'pais' DA TABELA 'Enderecos'
                
                //CONSULTAR E ATRIBUIR LISTA DE TELEFONES DESTE FUNCIONÁRIO
                fBLL.setTelefones(ConsultarTelefones(fBLL.getCodigo()));
                
                //ADICIONAR NOVO TÍTULO PREENCHIDO À COMBOBOX
                listaFuncionarios.add(fBLL);
            }

            // RETORNAR LISTA PREENCHIDA
            return listaFuncionarios;

        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + " \n" + e);
            return null;
        }
    }
    
    public List<FuncionarioBLL> ConsultarPorCargo(String cargo) {
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM Funcionarios JOIN Cargos ON Funcionarios.cargo = Cargos.codigo JOIN credenciais_de_acesso ON  funcionarios.login = credenciais_de_acesso.usuario JOIN Enderecos ON Funcionarios.endereco = enderecos.codigo WHERE Cargos.cargo LIKE ?;";

        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<FuncionarioBLL> listaFuncionarios = new ArrayList<FuncionarioBLL>();

        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, cargo + "%");

            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            while (resultadoConsulta.next()) {
                //PREENCHER ITEM
                FuncionarioBLL fBLL = new FuncionarioBLL();
                fBLL.setCodigo(resultadoConsulta.getInt(1)); // COLUNA 'codigo'  DA TABELA 'Funcionarios'
                fBLL.setNome(resultadoConsulta.getString(2)); // COLUNA 'nome' DA TABELA 'Funcionarios'
                fBLL.setCpf(resultadoConsulta.getString(3)); // COLUNA 'cpf' DA TABELA 'Funcionarios'
                fBLL.setEmail(resultadoConsulta.getString(4)); // COLUNA 'email' DA TABELA 'Funcionarios'
                fBLL.getEndereco().setCodigo(resultadoConsulta.getInt(5)); // COLUNA 'endereco' DA TABELA 'Funcionarios'
                fBLL.getCargo().setCodigo(resultadoConsulta.getInt(6)); // COLUNA 'cargo' DA TABELA 'Funcionarios'
                fBLL.getLogin().setUsuario(resultadoConsulta.getString(7)); // COLUNA 'login'
                fBLL.setAtivo(resultadoConsulta.getBoolean(8)); // COLUNA 'ativo' DA TABELA 'Funcionarios'
                fBLL.getCargo().setCodigo(resultadoConsulta.getInt(9)); // COLUNA 'codigo' DA TABELA 'Cargos'
                fBLL.getCargo().setCargo(resultadoConsulta.getString(10)); // COLUNA 'cargo' DA TABELA 'Cargos'
                fBLL.getCargo().setSalario(resultadoConsulta.getFloat(11)); // COLUNA 'salario' DA TABELA 'Cargos'
                fBLL.getCargo().getPermissao().setCodigo(resultadoConsulta.getInt(12)); // COLUNA 'permissao' DA TABELA 'Cargos'
                fBLL.getCargo().setAtivo(resultadoConsulta.getBoolean(13)); // COLUNA 'ativo' DA TABELA 'Cargos'
                fBLL.getLogin().setUsuario(resultadoConsulta.getString(14)); // COLUNA 'usuario' DA TABELA 'Credenciais_de_acesso'
                fBLL.getLogin().setSenha(resultadoConsulta.getString(15)); // COLUNA 'senha' DA TABELA 'Credenciais_de_acesso'
                fBLL.getLogin().getCodCadastro().setCodigoDeCadastro(resultadoConsulta.getString(16)); // COLUNA 'cod_cadastro' DA TABELA 'Credenciais_de_acesso'
                fBLL.getEndereco().setCodigo(resultadoConsulta.getInt(17)); // COLUNA 'codigo' DA TABELA 'Enderecos'
                fBLL.getEndereco().setLogradouro(resultadoConsulta.getString(18)); // COLUNA 'logradouro' DA TABELA 'Enderecos'
                fBLL.getEndereco().setNumero(resultadoConsulta.getString(19)); // COLUNA 'numero' DA TABELA 'Enderecos'
                fBLL.getEndereco().setCep(resultadoConsulta.getString(20)); // COLUNA 'CEP' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().setNome(resultadoConsulta.getString(21)); // COLUNA 'bairro' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().getCidade().setNome(resultadoConsulta.getString(22)); // COLUNA 'cidade' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().getCidade().getEstado().setNome(resultadoConsulta.getString(23)); // COLUNA 'estado' DA TABELA 'Enderecos'
                fBLL.getEndereco().getBairro().getCidade().getEstado().getPais().setPaisPt(resultadoConsulta.getString(24)); // COLUNA 'pais' DA TABELA 'Enderecos'
                
                //CONSULTAR E ATRIBUIR LISTA DE TELEFONES DESTE FUNCIONÁRIO
                fBLL.setTelefones(ConsultarTelefones(fBLL.getCodigo()));
                
                //ADICIONAR NOVO TÍTULO PREENCHIDO À COMBOBOX
                listaFuncionarios.add(fBLL);
            }

            // RETORNAR LISTA PREENCHIDA
            return listaFuncionarios;

        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + e);
            return null;
        }
    }
}