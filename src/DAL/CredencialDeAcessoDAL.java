/*
 * CLASSE QUE GERENCIA AS CREDENCIAIS DE ACESSO DE TODOS OS USUÁRIOS DO SISTEMA
 */
package DAL;

import BLL.CredencialDeAcessoBLL; // IMPORTANDO O PACOTE BLL CORRESPONDENTE À ESTE CLASSE
import BLL.FuncionarioBLL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CredencialDeAcessoDAL {

    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO NECESSÁRIA

    public boolean Validar(CredencialDeAcessoBLL cBLL) {

        String comandoSQL = "SELECT * FROM Credenciais_de_acesso WHERE USUARIO = ? AND SENHA = ?;"; // COMANDO SQL

        try {

            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL); // PREPARAR COMANDO PARA EXECUÇÃO
            query.setString(1, cBLL.getUsuario());// DEFININDO PARÂMETRO DE USUÁRIO
            query.setString(2, cBLL.getSenha()); // DEFININDO PARÂMETRO DE SENHA

            ResultSet resultadoConsulta = query.executeQuery();

            if (resultadoConsulta.next()) {
                return true; // CREDENCIAL EXISTE
            } else {
                return false; // CREDENCIAL NÃO EXISTE

            }

        } catch (SQLException ex) {

            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + ex);
            return false;
        }

    }

    public boolean Cadastrar(CredencialDeAcessoBLL fBLL) {
        // CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO Credenciais_de_acesso (usuario, senha, cod_cadastro) VALUES (?, ?, ?);";

        // TRATAMENTO DE ERRO
        try {

            // PREPARANDO QUERY PARA EXECUÇÃO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, fBLL.getUsuario());
            query.setString(2, fBLL.getSenha());
            query.setString(3, fBLL.getCodCadastro().getCodigoDeCadastro());

            // EXECUTAR COMANDO
            query.executeUpdate();

            return true;

        } catch (SQLException ex) {

            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + ex);
            return false;
        }
    }

    public BLL.FuncionarioBLL ConsultarFuncionarioDonoDasCredenciais(CredencialDeAcessoBLL caBLL) {
        //CRIANDO COMANDO SQL
        String comandoSQL = "SELECT * FROM credenciais_de_acesso JOIN funcionarios ON credenciais_de_acesso.usuario = funcionarios.login WHERE credenciais_de_acesso.usuario = ? AND credenciais_de_acesso.senha = ?; ";

        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, caBLL.getUsuario());
            query.setString(2, caBLL.getSenha());

            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            //CONSULTAR
            resultadoConsulta.next();

            //FUNCIONÁRIO QUE RETORNARÁ PREENCHIDO
            BLL.FuncionarioBLL fBLL = new FuncionarioBLL();

            //PREENCHER ITEM
            fBLL.getLogin().setUsuario(resultadoConsulta.getString(1)); // COLUNA 'usuario' DA TABELA 'credenciais_de_acesso'
            fBLL.getLogin().setSenha(resultadoConsulta.getString(2)); // COLUNA 'senha' DA TABELA 'credenciais_de_acesso'
            fBLL.getLogin().getCodCadastro().setCodigoDeCadastro(resultadoConsulta.getString(3)); // COLUNA 'cod_cadastro' DA TABELA 'credenciais_de_acesso'
            fBLL.setCodigo(resultadoConsulta.getInt(4)); // COLUNA 'codigo' DA TABELA 'Funcionarios'
            fBLL.setNome(resultadoConsulta.getString(5)); // COLUNA 'nome' DA TABELA 'Funcionarios'
            fBLL.setCpf(resultadoConsulta.getString(6)); // COLUNA 'cpf' DA TABELA 'Funcionarios'
            fBLL.setEmail(resultadoConsulta.getString(7)); // COLUNA 'email' DA TABELA 'Funcionarios'
            fBLL.getEndereco().setCodigo(resultadoConsulta.getInt(8)); // COLUNA 'endereco' DA TABELA 'Funcionarios'
            fBLL.getCargo().setCodigo(resultadoConsulta.getInt(9)); // COLUNA 'cargo' DA TABELA 'Funcionarios'
            fBLL.getLogin().setUsuario(resultadoConsulta.getString(10)); // COLUNA 'login' DA TABELA 'Funcionarios'
            fBLL.setAtivo(resultadoConsulta.getBoolean(11)); // COLUNA 'ativo' DA TABELA 'Funcionarios'
            
            //PREENCHER DEMAIS INFORMAÇOES
            fBLL.getCargo().setPermissao(fBLL.getCargo().ConsultarPermissao());
            
            // RETORNAR OBJETO PREENCHIDO
            return fBLL;

        } catch (Exception e) {
            System.err.println("DEU RUIM");
            return null;
        }
    }

}
