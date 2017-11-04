
package DAL;

import BLL.EquipamentoDaLojaBLL; // IMPORTAÇÃO DA RESPECTIVA CLASSE BLL
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDaLojaDAL {
    
    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO
    
    public boolean Cadastrar(EquipamentoDaLojaBLL elBLL){
        // CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO equipamentos_da_loja (TIPO, NOME, VALOR_POR_HORA, ATIVO) VALUES (?, ?, ?, ?);";
        
        // TRATAMENTO DE ERRO
        try {
            
            // PREPARANDO QUERY PARA EXECUÇÃO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, elBLL.getTipo().getCodigo());
            query.setString(2, elBLL.getNome());
            query.setFloat(3, elBLL.getValorPorHora());
            query.setBoolean(4, elBLL.isAtivo());
            
            // EXECUTAR COMANDO
            query.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + ex);
            return false;
        }
    }
    
    /**
     * @return Retorna uma lista com todos os equipamentos da loja cadastradas no banco de dados.
     * Preenche inclusive todas as informações do Tipo relacionados à cada equipamento.
     */
    public List<EquipamentoDaLojaBLL> Consultar(){
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM equipamentos_da_loja JOIN tipos_equipamentos ON equipamentos_da_loja.tipo = tipos_equipamentos.codigo;";

        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<EquipamentoDaLojaBLL> listaDeEquipamentosDaLoja = new ArrayList<>();

        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);

            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            while (resultadoConsulta.next()) {
                //PREENCHER ITEM
                EquipamentoDaLojaBLL elBLL = new EquipamentoDaLojaBLL();
                elBLL.setCodigo(resultadoConsulta.getInt(1)); // COLUNA 'codigo' DA TABELA 'equipamentos_da_loja'
                elBLL.getTipo().setCodigo(resultadoConsulta.getInt(resultadoConsulta.getInt(2))); // COLUNA 'tipo' DA TABELA 'equipamentos_da_loja'
                elBLL.setNome(resultadoConsulta.getString(3)); // COLUNA 'nome' DA TABELA 'equipamentos_da_loja'
                elBLL.setValorPorHora(resultadoConsulta.getFloat(4));// COLUNA 'valor_por_hora' DA TABELA 'equipamentos_da_loja'
                elBLL.setAtivo(resultadoConsulta.getBoolean(5)); // COLUNA 'ativo' DA TABELA 'equipamentos_da_loja'
                elBLL.getTipo().setCodigo(resultadoConsulta.getInt(6)); // COLUNA 'codigo' DA TABELA 'tipos_equipamentos'
                elBLL.getTipo().setTipo(resultadoConsulta.getString(7)); // COLUNA 'tipo' DA TABELA 'tipos_equipamentos' 
                elBLL.getTipo().setAtivo(resultadoConsulta.getBoolean(8)); // COLUNA 'ativo' DA TABELA 'tipos_equipamentos' 
                
                
                //ADICIONAR OBJETO PREENCHIDO À LISTA
                listaDeEquipamentosDaLoja.add(elBLL);
            }

            // RETORNAR LISTA PREENCHIDA
            return listaDeEquipamentosDaLoja;

        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + " \n" + e);
            return null;
        }
    }
    
}
