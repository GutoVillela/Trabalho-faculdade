package DAL;

import BLL.ClienteBLL;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ClienteDAL {

    private Conexao con = new Conexao();

    public void CadastrarCliente(ClienteBLL cBLL) {

        String comando = "INSERT INTO CLIENTES (ativo, endereco, email) values (?,?,?);";

        try {

            PreparedStatement query = con.Conectar().prepareStatement(comando);
            query.setBoolean(1, cBLL.isAtivo());
            query.setInt(2, cBLL.getEndereco().getCodigo());
            query.setString(3, cBLL.getEmail());
            query.executeUpdate();
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro");
        }

    }

}
