
package DAL;

import BLL.CopiaParaAlugarBLL;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CopiaParaAlugarDAL {
    private Conexao con = new Conexao();

    public boolean Cadastrar(CopiaParaAlugarBLL cpaBLL) {

        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO copias_para_alugar (titulo, plataforma, quantidade, ativo) VALUES (?, ?, ?, ?);";

        // TRATAMENTO DE ERRO
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, cpaBLL.getTitulo().getCodigo());
            query.setInt(2, cpaBLL.getPlataforma().getCodigo());
            query.setInt(3, cpaBLL.getQuantidade());
            query.setBoolean(4, cpaBLL.isAtivo());

            // EXECUTAR COMANDO
            query.executeUpdate();

            return true;
        } catch (SQLException erro) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return false;
        }

    }
}
