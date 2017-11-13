
package DAL;

import BLL.ProdutoBLL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAL {
    
    private Conexao con = new Conexao();

    public boolean Cadastrar(ProdutoBLL pBLL) {

        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO Produtos (nome, quantidade, preco, ativo) VALUES (?, ?, ?, ?);";

        // TRATAMENTO DE ERRO
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, pBLL.getNome());
            query.setInt(2, pBLL.getQuantidade());
            query.setFloat(3, pBLL.getPreco());
            query.setBoolean(4, pBLL.isAtivo());

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
        String comandoSQL = "select count(codigo) as 'ID' from produtos;";

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
    
    public List<ProdutoBLL> Consultar(){
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM Produtos;";
        
        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<ProdutoBLL> listaDeProdutos = new ArrayList<>();
        
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            
            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();
            
            while (resultadoConsulta.next()) { 
                //PREENCHER ITEM
                ProdutoBLL pBLL = new ProdutoBLL();
                pBLL.setCodigo(resultadoConsulta.getInt(1)); // COLUNA 'codigo' DA TABELA 'Produtos'
                pBLL.setNome(resultadoConsulta.getString(2)); // COLUNA 'nome' DA TABELA 'Produtos'
                pBLL.setQuantidade(resultadoConsulta.getInt(3)); // COLUNA 'quantidade' DA TABELA 'Produtos'
                pBLL.setPreco(resultadoConsulta.getFloat(4)); // COLUNA 'preco' DA TABELA 'Produtos'
                pBLL.setAtivo(resultadoConsulta.getBoolean(5)); // COLUNA 'ativo' DA TABELA 'Produtos'
                
                //ADICIONAR NOVO TÍTULO PREENCHIDO À COMBOBOX
                listaDeProdutos.add(pBLL);
            }
            
            // RETORNAR LISTA PREENCHIDA
            return listaDeProdutos;
            
            
        } catch (Exception e) {
            return null;
        }
    }
}
