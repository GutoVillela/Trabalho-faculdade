
package DAL;

import BLL.EquipamentoDoClienteBLL; // IMPORTAÇÃO DA RESPECTIVA CLASSE BLL
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EquipamentoDoClienteDAL {
    
    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO
    
    public boolean Cadastrar(EquipamentoDoClienteBLL ecBLL){
        // CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO equipamentos_do_cliente (nome, tipo, cliente, ativo) VALUES (?, ?, ?, ?);";
        
        // TRATAMENTO DE ERRO
        try {
            
            // PREPARANDO QUERY PARA EXECUÇÃO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, ecBLL.getNome());
            query.setInt(2, ecBLL.getTipo().getCodigo());
            query.setInt(3, ecBLL.getCliente().getCodigo());
            query.setBoolean(4, ecBLL.isAtivo());
            
            // EXECUTAR COMANDO
            query.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + ex);
            return false;
        }
    }
    
    public List<EquipamentoDoClienteBLL> ConsultarEquipamentosDeUmCliente(EquipamentoDoClienteBLL ecBLL){
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM EQUIPAMENTOS_DO_CLIENTE JOIN Clientes ON clientes.codigo = EQUIPAMENTOS_DO_CLIENTE.cliente WHERE Clientes.codigo = ?;";
        
        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<EquipamentoDoClienteBLL> listaDeEquipamentosDoCliente = new LinkedList<>();
        
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, ecBLL.getCodigo());
            
            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();
            
            while (resultadoConsulta.next()) { 
                //PREENCHER ITEM
                EquipamentoDoClienteBLL equipamentoDoCliente = new EquipamentoDoClienteBLL();
                equipamentoDoCliente.setCodigo(0); // COLUNA 'Codigo' DA TABELA 'EQUIPAMENTOS_DO_CLIENTE'
                equipamentoDoCliente.setNome(comandoSQL); // COLUNA 'nome' DA TABELA 'EQUIPAMENTOS_DO_CLIENTE'
                equipamentoDoCliente.getTipo().setCodigo(0); // COLUNA 'tipo' DA TABELA 'EQUIPAMENTOS_DO_CLIENTE'
                equipamentoDoCliente.getCliente().setCodigo(0); // COLUNA 'cliente' DA TABELA 'EQUIPAMENTOS_DO_CLIENTE'
                equipamentoDoCliente.setAtivo(true);  // COLUNA 'ativo' DA TABELA 'EQUIPAMENTOS_DO_CLIENTE'
                equipamentoDoCliente.getCliente().setCodigo(0); // COLUNA 'Codigo' DA TABELA 'clientes'
                equipamentoDoCliente.getCliente().setAtivo(true); // COLUNA 'ativo' DA TABELA 'clientes'
                equipamentoDoCliente.getCliente().getEndereco().setCodigo(0); // COLUNA 'endereco' DA TABELA 'clientes'
                equipamentoDoCliente.getCliente().setEmail(comandoSQL); // COLUNA 'email' DA TABELA 'clientes'
                
                //ADICIONAR NOVO TÍTULO PREENCHIDO À COMBOBOX
                listaDeEquipamentosDoCliente.add(ecBLL);
            }
            
            // RETORNAR LISTA PREENCHIDA
            return listaDeEquipamentosDoCliente;
            
            
        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + e);
            return null;
        }
    }
    
}
