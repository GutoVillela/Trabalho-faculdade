package DAL;

import BLL.TipoAcessorioBLL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoAcessorioDAL {

    private Conexao con = new Conexao();//INSTÂNCIA DA CLASSE DE CONEXÃO NECESSÁRIA

    public boolean Cadastrar(TipoAcessorioBLL taBLL){
        // CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO tipos_acessorio (nome, ativo) VALUES (?, ?);";
        
        // TRATAMENTO DE ERRO
        try {
            
            // PREPARANDO QUERY PARA EXECUÇÃO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, taBLL.getNome());
            query.setBoolean(2, taBLL.isAtivo());
            
            
            // EXECUTAR COMANDO
            query.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + ex);
            return false;
        }
    }
    
    public List<TipoAcessorioBLL> Consultar() {
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM tipos_acessorio;";

        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<TipoAcessorioBLL> listaTiposAcessorios = new ArrayList<TipoAcessorioBLL>();

        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);

            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            while (resultadoConsulta.next()) {
                //PREENCHER ITEM
                TipoAcessorioBLL taBLL = new TipoAcessorioBLL();
                taBLL.setCodigo(resultadoConsulta.getInt("codigo"));
                taBLL.setNome(resultadoConsulta.getString("NOME"));
                taBLL.setAtivo(resultadoConsulta.getBoolean("ATIVO"));

                //ADICIONAR NOVO TÍTULO PREENCHIDO À COMBOBOX
                listaTiposAcessorios.add(taBLL);
            }

            // RETORNAR LISTA PREENCHIDA
            return listaTiposAcessorios;

        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + e);
            return null;
        }
    }

}
