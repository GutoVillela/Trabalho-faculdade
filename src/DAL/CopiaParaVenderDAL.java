/*
 * CLASSE QUE GERENCIA ACESSO A DADOS DAS COPIAS PARA VENDER
 */
package DAL;

import BLL.CopiaParaVenderBLL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CopiaParaVenderDAL {
    
    //INSTÂNCIA DA CLASSE DE CONEXÃO
    private Conexao con = new Conexao();
    
    public boolean Cadastrar(CopiaParaVenderBLL cBLL){
        
        // CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO copias_para_vender (TITULO, PLATAFORMA) VALUES (?, ?);";
        
        // TRATAMENTO DE ERRO
        try {
            
            // PREPARANDO QUERY PARA EXECUÇÃO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, cBLL.getTitulo().getCodigo());
            query.setInt(2, cBLL.getPlataforma().getCodigo());
            
            // EXECUTAR COMANDO
            query.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + ex);
            return false;
        }
    }
    
    public List<CopiaParaVenderBLL> Consultar() {
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM copias_para_vender INNER JOIN titulos ON copias_para_vender.titulo = titulos.codigo JOIN plataformas ON copias_para_vender.plataforma = plataformas.codigo JOIN produtos ON copias_para_vender.codigo = produtos.codigo;";

        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<CopiaParaVenderBLL> listaDeCopiasParaVender = new ArrayList<CopiaParaVenderBLL>();

        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);

            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            while (resultadoConsulta.next()) {
                //PREENCHER ITEM
                CopiaParaVenderBLL cpvBLL = new CopiaParaVenderBLL();
                cpvBLL.setCodigo(resultadoConsulta.getInt(1)); // COLUNA 'codigo' DA TABELA 'copias_para_vender'
                cpvBLL.getTitulo().setCodigo(resultadoConsulta.getInt(2)); // COLUNA 'titulo' DA TABELA 'copias_para_vender'
                cpvBLL.getPlataforma().setCodigo(resultadoConsulta.getInt(3)); // COLUNA 'plataforma' DA TABELA 'copias_para_vender'
                cpvBLL.getTitulo().setCodigo(resultadoConsulta.getInt(4)); //COLUNA 'codigo' DA TABELA 'titulos'
                cpvBLL.getTitulo().setNome(resultadoConsulta.getString(5)); // COLUNA 'nome' DA TABELA 'titulos'
                cpvBLL.getTitulo().setSinopse(resultadoConsulta.getString(6)); // COLUNA 'sinopse' DA TABELA 'titulos'
                cpvBLL.getTitulo().setAtivo(resultadoConsulta.getBoolean(7)); // COLUNA 'ativo' DA TABELA 'titulos'
                cpvBLL.getPlataforma().setCodigo(resultadoConsulta.getInt(8)); // COLUNA 'codigo' DA TABELA 'plataformas'
                cpvBLL.getPlataforma().setPlataforma(resultadoConsulta.getString(9)); // COLUNA 'plataforma' DA TABELA 'plataformas'
                cpvBLL.getPlataforma().setAtivo(resultadoConsulta.getBoolean(10)); // COLUNA 'ativo' DA TABELA 'plataformas'
                cpvBLL.setCodigo(resultadoConsulta.getInt(11)); // COLUNA 'codigo' DA TABELA 'produtos' - É O MESMO CÓDIGO DA CÓPIA PARA VENDER POIS SE TRATA DE UMA ESPECIALIZAÇÃO
                cpvBLL.setNome(resultadoConsulta.getString(12)); // COLUNA 'nome' DA TABELA 'produtos'
                cpvBLL.setQuantidade(resultadoConsulta.getInt(13)); // COLUNA 'quantidade' DA TABELA 'produtos'
                cpvBLL.setPreco(resultadoConsulta.getFloat(14)); // COLUNA 'preco' DA TABELA 'produtos'
                cpvBLL.setAtivo(resultadoConsulta.getBoolean(15)); // COLUNA 'ativo' DA TABELA 'produtos'
                
                //ADICIONAR OBJETO PREENCHIDO À LISTA
                listaDeCopiasParaVender.add(cpvBLL);
            }

            // RETORNAR LISTA PREENCHIDA
            return listaDeCopiasParaVender;

        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + " \n" + e);
            return null;
        }
    }
    
}
