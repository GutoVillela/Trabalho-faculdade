
package DAL;

import BLL.VendaBLL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendaDAL {
    
    private Conexao con = new Conexao();

    public boolean Cadastrar(VendaBLL vBLL) {

        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO Vendas (cliente, data_da_venda, ativo) VALUES (?, ?, ?);";

        // TRATAMENTO DE ERRO
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, vBLL.getCliente().getCodigo());
            query.setString(2, vBLL.getDataDaVenda());
            query.setBoolean(3, vBLL.isAtivo());

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
        String comandoSQL = "select count(codigo) as 'ID' from Vendas;";

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
    
    public  boolean CadastrarItensDaVenda(VendaBLL vBLL){
        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO itens_da_venda (venda, produto, preco) VALUES (?, ?, ?);";
        
        // TRATAMENTO DE ERRO
        try{
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            
            //DEFINIR PARÂMETROS PARA CADA EQUIPAMENTO CADASTRADO
            for (int i = 0; i < vBLL.getItensDaVenda().size(); i++) {
                query.setInt(1, vBLL.getCodigo());
                query.setInt(2, vBLL.getItensDaVenda().get(i).getCodigo());
                query.setFloat(3, vBLL.getItensDaVenda().get(i).getPreco());
                
                // EXECUTAR COMANDO
                query.executeUpdate();
            }
            
            
            
            return true;
        }
        catch (SQLException erro){
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + " no método 'CadastrarListaDeEquipamentos'\n" + erro);
            return false;
        }
    }

    
}
