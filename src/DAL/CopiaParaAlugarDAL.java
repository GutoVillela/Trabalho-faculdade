
package DAL;

import BLL.CopiaParaAlugarBLL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    /**
     * @return Retorna todas as copias para alugar cadastradas no banco de dados.
     * Preenche inclusive todas as informações do Título e da Plataforma relacionados à cada cópia.
     */
    public List<CopiaParaAlugarBLL> Consultar(){
        //DEFINIR COMANDO SQL
        String comandoSQL = "select * FROM copias_para_alugar INNER JOIN titulos ON copias_para_alugar.titulo = titulos.codigo JOIN plataformas ON copias_para_alugar.plataforma = plataformas.codigo;";

        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<CopiaParaAlugarBLL> listaDeCopiasParaAlugar = new ArrayList<>();

        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);

            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            while (resultadoConsulta.next()) {
                //PREENCHER ITEM
                CopiaParaAlugarBLL cpaBLL = new CopiaParaAlugarBLL();
                cpaBLL.setCodigo(resultadoConsulta.getInt(1)); // COLUNA 'codigo' DA TABELA 'copias_para_alugar'
                cpaBLL.getTitulo().setCodigo(resultadoConsulta.getInt(2)); // COLUNA 'titulo' DA TABELA 'copias_para_alugar'
                cpaBLL.getPlataforma().setCodigo(resultadoConsulta.getInt(3)); // COLUNA 'plataforma' DA TABELA 'copias_para_alugar'
                cpaBLL.setQuantidade(resultadoConsulta.getInt(4)); // COLUNA 'quantidade' DA TABELA 'copias_para_alugar'
                cpaBLL.setAtivo(resultadoConsulta.getBoolean(5)); // COLUNA 'ativo' DA TABELA 'copias_para_alugar'
                cpaBLL.getTitulo().setCodigo(resultadoConsulta.getInt(6)); //COLUNA 'codigo' DA TABELA 'titulos'
                cpaBLL.getTitulo().setNome(resultadoConsulta.getString(7)); // COLUNA 'nome' DA TABELA 'titulos'
                cpaBLL.getTitulo().setSinopse(resultadoConsulta.getString(8)); // COLUNA 'sinopse' DA TABELA 'titulos'
                cpaBLL.getTitulo().setAtivo(resultadoConsulta.getBoolean(9)); // COLUNA 'ativo' DA TABELA 'titulos'
                cpaBLL.getPlataforma().setCodigo(resultadoConsulta.getInt(10)); // COLUNA 'codigo' DA TABELA 'plataformas'
                cpaBLL.getPlataforma().setPlataforma(resultadoConsulta.getString(11)); // COLUNA 'plataforma' DA TABELA 'plataformas'
                cpaBLL.getPlataforma().setAtivo(resultadoConsulta.getBoolean(12)); // COLUNA 'ativo' DA TABELA 'plataformas'
                
                
                //ADICIONAR OBJETO PREENCHIDO À LISTA
                listaDeCopiasParaAlugar.add(cpaBLL);
            }

            // RETORNAR LISTA PREENCHIDA
            return listaDeCopiasParaAlugar;

        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + " \n" + e);
            return null;
        }
    }
}
