
package DAL;

import BLL.TipoEquipamentoBLL; // IMPORTAÇÃO DA CLASSE BLL RESPECTIVA DESTA CLASSE
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TipoEquipamentoDAL {
    
    private Conexao con = new Conexao();//INSTÂNCIA DA CLASSE DE CONEXÃO NECESSÁRIA
    
    public boolean Cadastrar(TipoEquipamentoBLL tBLL){
        // CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO tipos_equipamentos (tipo, ativo) VALUES (?, ?);";
        
        // TRATAMENTO DE ERRO
        try {
            
            // PREPARANDO QUERY PARA EXECUÇÃO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, tBLL.getTipo());
            query.setBoolean(2, tBLL.isAtivo());
            
            
            // EXECUTAR COMANDO
            query.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + ex);
            return false;
        }
    }
    
    public List<TipoEquipamentoBLL> Consultar(){
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM tipos_equipamentos;";
        
        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<TipoEquipamentoBLL> listaTiposEquipamentos = new LinkedList<>();
        
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            
            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();
            
            while (resultadoConsulta.next()) { 
                //PREENCHER ITEM
                TipoEquipamentoBLL tBLL = new TipoEquipamentoBLL();
                tBLL.setCodigo(resultadoConsulta.getInt("codigo"));
                tBLL.setTipo(resultadoConsulta.getString("TIPO"));
                tBLL.setAtivo(resultadoConsulta.getBoolean("ATIVO"));
                
                //ADICIONAR NOVO TÍTULO PREENCHIDO À COMBOBOX
                listaTiposEquipamentos.add(tBLL);
            }
            
            // RETORNAR LISTA PREENCHIDA
            return listaTiposEquipamentos;
            
            
        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + e);
            return null;
        }
    }
    
}
