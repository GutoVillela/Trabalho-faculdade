
package DAL;

import BLL.TituloBLL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.AbstractList;
import java.util.LinkedList;
import java.util.List;

public class TituloDAL {
    
    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO SERÁ NECESSÁRIA AQUI
    
    //MÉTODO QUE VAI CADASTRAR
    public boolean Cadastrar(TituloBLL tBLL){
        
        //DEFINIR COMANDO SQL
        String comandoSQL = "INSERT INTO Titulos (NOME, SINOPSE, ATIVO) VALUES (?, ?, ?);";
        
        // TRATAMENTO DE ERROS
        try {
            
            //PREPARAR O COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, tBLL.getNome());
            query.setString(2, tBLL.getSinopse());
            query.setBoolean(3, tBLL.isAtivo());
            
            query.executeUpdate();// EXECUTAR O INSERT
            return true;
            
            
        } catch (Exception erro) {
            System.out.println("ERRO EM " + this.getClass().getCanonicalName() + "!\n" + erro);
            
            return false;
        }
        
    }
    
    public List<TituloBLL> Consultar(){
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM Titulos;";
        
        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<TituloBLL> listaTitulos = new LinkedList<>();
        
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            
            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();
            
            while (resultadoConsulta.next()) { 
                //PREENCHER ITEM
                TituloBLL tBLL = new TituloBLL();
                tBLL.setCodigo(resultadoConsulta.getInt("codigo"));
                tBLL.setNome(resultadoConsulta.getString("NOME"));
                tBLL.setSinopse(resultadoConsulta.getString("SINOPSE"));
                tBLL.setAtivo(resultadoConsulta.getBoolean("ATIVO"));
                
                //ADICIONAR NOVO TÍTULO PREENCHIDO À COMBOBOX
                listaTitulos.add(tBLL);
            }
            
            // RETORNAR LISTA PREENCHIDA
            return listaTitulos;
            
            
        } catch (Exception e) {
            return null;
        }
    }
    
}
