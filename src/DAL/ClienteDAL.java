package DAL;

import BLL.ClienteBLL; // IMPORTAÇÃO DA RESPECTIVA CLASSE BLL
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClienteDAL {

    private Conexao con = new Conexao();

    public boolean Cadastrar(ClienteBLL cBLL) {

        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO clientes (ativo, endereco, email) VALUES (?, ?, ?);";

        // TRATAMENTO DE ERRO
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setBoolean(1, cBLL.isAtivo());
            query.setInt(2, cBLL.getEndereco().getCodigo());
            query.setString(3, cBLL.getEmail());

            // EXECUTAR COMANDO
            query.executeUpdate();

            return true;
        } catch (SQLException erro) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return false;
        }

    }
    

    public int RecuperarUltimaChavePrimaria() {
        //CRIANDO COMANDO SQL
        String comandoSQL = "select count(codigo) as 'ID' from clientes;";

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
    
    public boolean AtualizarDados(ClienteBLL acBLL){
        //CRIANDO COMANDO SQL
        String comandoSQL = "UPDATE CLIENTES SET ativo=?, endereco=?, email=? where codigo=?;";

        // TRATAMENTO DE ERRO
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setBoolean(1, acBLL.isAtivo());
            query.setInt(2, acBLL.getEndereco().getCodigo());
            query.setString(3, acBLL.getEmail());
            query.setInt(4, acBLL.getCodigo());

            // EXECUTAR COMANDO
            query.executeUpdate();

            return true;
        } catch (SQLException erro) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return false;
        }
        
    }
    

    public boolean AssociarTodosTelefoneDaLista(ClienteBLL cBLL) {

        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO clientes_tem_telefones (CLIENTE, TELEFONE) VALUES (?, ?);";

        // TRATAMENTO DE ERRO
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, cBLL.getCodigo());

            // DEFINIR UMA CHAVE PARA CADA TELEFONE
            for (int i = 0; i < cBLL.getTelefones().size(); i++) {

                // RECUPERAR TELEFONE DO RESPECTIVO ÍNDICE DA LISTA
                query.setInt(2, cBLL.getTelefones().get(i).getCodigo());

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
