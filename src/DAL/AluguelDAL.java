
package DAL;

import BLL.AluguelBLL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AluguelDAL {
    
    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO
    
    public boolean Cadastrar(AluguelBLL aBLL){
        
        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO Alugueis (horario_inicio, duracao, ativo, cliente) VALUES (?, ?, ?, ?);";
        
        // TRATAMENTO DE ERRO
        try{
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, aBLL.getHorarioInicio());
            query.setString(2, aBLL.getDuracao());
            query.setBoolean(3, aBLL.isAtivo());
            query.setInt(4, aBLL.getCliente().getCodigo());
            
            // EXECUTAR COMANDO
            query.executeUpdate();
            
            return true;
        }
        catch (SQLException erro){
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + " no método 'Cadastrar'.\n" + erro);
            return false;
        }
        
        
    }
    
    public  boolean CadastrarListaDeEquipamentos(AluguelBLL aBLL){
        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO equipamentos_do_aluguel (equipamento, aluguel, valor_cobrado_por_hora) VALUES (?, ?, ?);";
        
        // TRATAMENTO DE ERRO
        try{
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            
            //DEFINIR PARÂMETROS PARA CADA EQUIPAMENTO CADASTRADO
            for (int i = 0; i < aBLL.getEquipamentosDoAluguel().size(); i++) {
                query.setInt(1, aBLL.getEquipamentosDoAluguel().get(i).getCodigo());
                query.setInt(2, aBLL.getCodigo());
                query.setFloat(3, aBLL.getEquipamentosDoAluguel().get(i).getValorPorHora());
                
                // EXECUTAR COMANDO
                query.executeUpdate();
            }
            
            
            
            return true;
        }
        catch (SQLException erro){
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + " no método 'CadastrarListaDeEquipamentos'\n" + erro);
            return false;
        }
    }
    
    public  boolean CadastrarListaDeCopias(AluguelBLL aBLL){
        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO copias_do_aluguel (copia, aluguel, quantidade_alugada) VALUES (?, ?, ?);";
        
        // TRATAMENTO DE ERRO
        try{
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            
            //DEFINIR PARÂMETROS PARA CADA EQUIPAMENTO CADASTRADO
            for (int i = 0; i < aBLL.getCopiasDoAluguel().size(); i++) {
                query.setInt(1, aBLL.getCopiasDoAluguel().get(i).getCodigo());
                query.setInt(2, aBLL.getCodigo());
                query.setInt(3, aBLL.getCopiasDoAluguel().get(i).getQuantidade());
                
                // EXECUTAR COMANDO
                query.executeUpdate();
            }
            
            
            
            return true;
        }
        catch (SQLException erro){
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + " no método 'CadastrarListaDeCopias'.\n" + erro);
            return false;
        }
    }
    
    public int RecuperarUltimaChavePrimaria(){
        //CRIANDO COMANDO SQL
        String comandoSQL = "select count(codigo) as 'ID' from alugueis;";
        
        //CRIANDO VARIÁVEL QUE VAI RECEBER O RESULTADO DA CONSULTA
        int ultimaChavePrimaria;
        
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            
            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();
            
            //RECUPERAR PRÓXIMA CONSULTA
            resultadoConsulta.next();
            
            //ATRIBUINDO RESULTADO À VARIÁVEL
            ultimaChavePrimaria = resultadoConsulta.getInt(1);
            
            // RETORNAR LISTA PREENCHIDA
            return ultimaChavePrimaria;
            
            
        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + e);
            return 0;
        }
    }
}
