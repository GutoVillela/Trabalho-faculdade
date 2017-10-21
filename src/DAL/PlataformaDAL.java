
package DAL;
import BLL.PlataformaBLL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class PlataformaDAL {
    
    private Conexao con = new Conexao();
    
    public boolean Cadastrar(PlataformaBLL pBLL){
        //DEFINIR COMANDO SQL
        String comandoSQL = "INSERT INTO Plataformas (Plataforma, ativo) VALUES (?, ?);";
        
        // TRATAMENTO DE ERROS
        try {
            
            //PREPARAR O COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, pBLL.getPlataforma());
            query.setBoolean(2, pBLL.isAtivo());
            
            query.executeUpdate();// EXECUTAR O INSERT
            return true;
            
            
        } catch (Exception erro) {
            System.out.println("ERRO EM " + this.getClass().getCanonicalName() + "!\n" + erro);
            
            return false;
        }
    }
    
    public List<PlataformaBLL> Consultar(){
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM Plataformas;";
        
        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<PlataformaBLL> listaPlataformas = new LinkedList<>();
        
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            
            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();
            
            while (resultadoConsulta.next()) { 
                //PREENCHER ITEM
                PlataformaBLL pBLL = new PlataformaBLL();
                pBLL.setCodigo(resultadoConsulta.getInt("codigo"));
                pBLL.setPlataforma(resultadoConsulta.getString("Plataforma"));
                pBLL.setAtivo(resultadoConsulta.getBoolean("ativo"));
                
                //ADICIONAR NOVO TÍTULO PREENCHIDO À COMBOBOX
                listaPlataformas.add(pBLL);
            }
            
            // RETORNAR LISTA PREENCHIDA
            return listaPlataformas;
            
            
        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + e);
            return null;
        }
    }
    
}
