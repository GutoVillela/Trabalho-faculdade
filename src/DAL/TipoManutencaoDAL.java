
package DAL;

import BLL.TipoManutencaoBLL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoManutencaoDAL {
    
    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO
    
    public boolean Cadastrar(TipoManutencaoBLL tmBLL){
        
        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO tipos_manutencoes (tipo_manutencao, ativo) VALUES (?, ?);";
        
        // TRATAMENTO DE ERRO
        try{
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, tmBLL.getTipoManutencao());
            query.setBoolean(2, tmBLL.isAtivo());
            
            // EXECUTAR COMANDO
            query.executeUpdate();
            
            return true;
        }
        catch (SQLException erro){
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return false;
        }
        
        
    }
    
    /**
     * @return Retorna uma lista com todos os tipos de manutenção cadastrados.
     */
    public List<TipoManutencaoBLL> Consultar(){
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM tipos_manutencoes;";

        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<TipoManutencaoBLL> listaDeTiposDeManutencao = new ArrayList<>();

        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);

            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            while (resultadoConsulta.next()) {
                //PREENCHER ITEM
                TipoManutencaoBLL tmBLL = new TipoManutencaoBLL();
                tmBLL.setCodigo(resultadoConsulta.getInt(1)); // COLUNA 'codigo' DA TABELA 'tipos_manutencoes'
                tmBLL.setTipoManutencao(resultadoConsulta.getString(2)); // COLUNA 'tipo_manutencao' DA TABELA 'tipos_manutencoes'
                tmBLL.setAtivo(resultadoConsulta.getBoolean(3)); // COLUNA 'ativo' DA TABELA 'tipos_manutencoes'
                
                //ADICIONAR OBJETO PREENCHIDO À LISTA
                listaDeTiposDeManutencao.add(tmBLL);
            }

            // RETORNAR LISTA PREENCHIDA
            return listaDeTiposDeManutencao;

        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + " \n" + e);
            return null;
        }
    }
    
}
