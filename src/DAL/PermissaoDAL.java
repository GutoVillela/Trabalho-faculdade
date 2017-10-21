package DAL;

import BLL.PermissaoBLL; // IMPORTAÇÃO DA RESPECTIVA CLASSE BLL
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PermissaoDAL {

    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO

    public boolean Cadastrar(PermissaoBLL pBLL) {
        // CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO Permissoes (\n"
                + "\n"
                + "	pode_cadastrar_FORNECEDOR, \n"
                + "	pode_consultar_FORNECEDOR,\n"
                + "    pode_alterar_FORNECEDOR,\n"
                + "    pode_desligar_FORNECEDOR,\n"
                + "    \n"
                + "    pode_cadastrar_CLIENTE,\n"
                + "    pode_consultar_CLIENTE,\n"
                + "    pode_alterar_CLIENTE,\n"
                + "    pode_desligar_CLIENTE,\n"
                + "    \n"
                + "    pode_cadastrar_COD_CADASTRO,\n"
                + "    pode_consultar_COD_CADASTRO,\n"
                + "    pode_alterar_COD_CADASTRO,\n"
                + "    pode_desligar_COD_CADASTRO,\n"
                + "    \n"
                + "    pode_cadastrar_VENDA,\n"
                + "    pode_consultar_VENDA,\n"
                + "    pode_alterar_VENDA,\n"
                + "    pode_desligar_VENDA,\n"
                + "    \n"
                + "    pode_cadastrar_PROMOCAO,\n"
                + "    pode_consultar_PROMOCAO,\n"
                + "    pode_alterar_PROMOCAO,\n"
                + "    pode_desligar_PROMOCAO,\n"
                + "    \n"
                + "    pode_cadastrar_ALUGUEL,\n"
                + "    pode_consultar_ALUGUEL,\n"
                + "    pode_alterar_ALUGUEL,\n"
                + "    pode_desligar_ALUGUEL,\n"
                + "    \n"
                + "    pode_cadastrar_PRODUTO,\n"
                + "    pode_consultar_PRODUTO,\n"
                + "    pode_alterar_PRODUTO,\n"
                + "    pode_desligar_PRODUTO,\n"
                + "    \n"
                + "    pode_cadastrar_EQUIPAMENTO,\n"
                + "    pode_consultar_EQUIPAMENTO,\n"
                + "    pode_alterar_EQUIPAMENTO,\n"
                + "    pode_desligar_EQUIPAMENTO,\n"
                + "    \n"
                + "    pode_cadastrar_MANUTENCAO,\n"
                + "    pode_consultar_MANUTENCAO,\n"
                + "    pode_alterar_MANUTENCAO,\n"
                + "    pode_desligar_MANUTENCAO,\n"
                + "    \n"
                + "    pode_cadastrar_CARGO,\n"
                + "    pode_consultar_CARGO,\n"
                + "    pode_alterar_CARGO,\n"
                + "    pode_desligar_CARGO,\n"
                + "    \n"
                + "    pode_cadastrar_FUNCIONARIO,\n"
                + "    pode_consultar_FUNCIONARIO,\n"
                + "    pode_alterar_FUNCIONARIO,\n"
                + "    pode_desligar_FUNCIONARIO,\n"
                + "    \n"
                + "    pode_gerar_BACKUP,\n"
                + "    pode_restaurar_BACKUP,\n"
                + "    \n"
                + "    pode_gerar_RELATORIO,\n"
                + "    \n"
                + "	ativo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        // TRATAMENTO DE ERRO
        try {

            // PREPARANDO QUERY PARA EXECUÇÃO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);

            query.setBoolean(1, pBLL.isPode_cadastrar_FORNECEDOR());
            query.setBoolean(2, pBLL.isPode_consultar_FORNECEDOR());
            query.setBoolean(3, pBLL.isPode_alterar_FORNECEDOR());
            query.setBoolean(4, pBLL.isPode_desligar_FORNECEDOR());

            query.setBoolean(5, pBLL.isPode_cadastrar_CLIENTE());
            query.setBoolean(6, pBLL.isPode_consultar_CLIENTE());
            query.setBoolean(7, pBLL.isPode_alterar_CLIENTE());
            query.setBoolean(8, pBLL.isPode_desligar_CLIENTE());

            query.setBoolean(9, pBLL.isPode_cadastrar_COD_CADASTRO());
            query.setBoolean(10, pBLL.isPode_consultar_COD_CADASTRO());
            query.setBoolean(11, pBLL.isPode_alterar_COD_CADASTRO());
            query.setBoolean(12, pBLL.isPode_desligar_COD_CADASTRO());

            query.setBoolean(13, pBLL.isPode_cadastrar_VENDA());
            query.setBoolean(14, pBLL.isPode_consultar_VENDA());
            query.setBoolean(15, pBLL.isPode_alterar_VENDA());
            query.setBoolean(16, pBLL.isPode_desligar_VENDA());

            query.setBoolean(17, pBLL.isPode_cadastrar_PROMOCAO());
            query.setBoolean(18, pBLL.isPode_consultar_PROMOCAO());
            query.setBoolean(19, pBLL.isPode_alterar_PROMOCAO());
            query.setBoolean(20, pBLL.isPode_desligar_PROMOCAO());

            query.setBoolean(21, pBLL.isPode_cadastrar_ALUGUEL());
            query.setBoolean(22, pBLL.isPode_consultar_ALUGUEL());
            query.setBoolean(23, pBLL.isPode_alterar_ALUGUEL());
            query.setBoolean(24, pBLL.isPode_desligar_ALUGUEL());

            query.setBoolean(25, pBLL.isPode_cadastrar_PRODUTO());
            query.setBoolean(26, pBLL.isPode_consultar_PRODUTO());
            query.setBoolean(27, pBLL.isPode_alterar_PRODUTO());
            query.setBoolean(28, pBLL.isPode_desligar_PRODUTO());

            query.setBoolean(29, pBLL.isPode_cadastrar_EQUIPAMENTO());
            query.setBoolean(30, pBLL.isPode_consultar_EQUIPAMENTO());
            query.setBoolean(31, pBLL.isPode_alterar_EQUIPAMENTO());
            query.setBoolean(32, pBLL.isPode_desligar_EQUIPAMENTO());

            query.setBoolean(33, pBLL.isPode_cadastrar_MANUTENCAO());
            query.setBoolean(34, pBLL.isPode_consultar_MANUTENCAO());
            query.setBoolean(35, pBLL.isPode_alterar_MANUTENCAO());
            query.setBoolean(36, pBLL.isPode_desligar_MANUTENCAO());

            query.setBoolean(37, pBLL.isPode_cadastrar_CARGO());
            query.setBoolean(38, pBLL.isPode_consultar_CARGO());
            query.setBoolean(39, pBLL.isPode_alterar_CARGO());
            query.setBoolean(40, pBLL.isPode_desligar_CARGO());

            query.setBoolean(41, pBLL.isPode_cadastrar_FUNCIONARIO());
            query.setBoolean(42, pBLL.isPode_consultar_FUNCIONARIO());
            query.setBoolean(43, pBLL.isPode_alterar_FUNCIONARIO());
            query.setBoolean(44, pBLL.isPode_desligar_FUNCIONARIO());

            query.setBoolean(45, pBLL.isPode_gerar_RELATORIO());

            query.setBoolean(46, pBLL.isPode_gerar_BACKUP());
            query.setBoolean(47, pBLL.isPode_restaurar_BACKUP());

            query.setBoolean(48, pBLL.isAtivo());

            // EXECUTAR COMANDO
            query.executeUpdate();

            return true;

        } catch (SQLException ex) {

            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + ex);
            return false;
        }
    }

    public List<PermissaoBLL> Consultar() {
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM Permissoes;";

        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<PermissaoBLL> listaPermissoes = new LinkedList<>();

        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);

            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            while (resultadoConsulta.next()) {
                //PREENCHER ITEM
                PermissaoBLL pBLL = new PermissaoBLL();
                
                pBLL.setCodigo(resultadoConsulta.getInt("codigo"));
                
                pBLL.setPode_cadastrar_FORNECEDOR(resultadoConsulta.getBoolean("Pode_cadastrar_FORNECEDOR"));
                pBLL.setPode_consultar_FORNECEDOR(resultadoConsulta.getBoolean("Pode_consultar_FORNECEDOR"));
                pBLL.setPode_alterar_FORNECEDOR(resultadoConsulta.getBoolean("Pode_alterar_FORNECEDOR"));
                pBLL.setPode_desligar_FORNECEDOR(resultadoConsulta.getBoolean("Pode_desligar_FORNECEDOR"));

                pBLL.setPode_cadastrar_CLIENTE(resultadoConsulta.getBoolean("Pode_cadastrar_CLIENTE"));
                pBLL.setPode_consultar_CLIENTE(resultadoConsulta.getBoolean("Pode_consultar_CLIENTE"));
                pBLL.setPode_alterar_CLIENTE(resultadoConsulta.getBoolean("Pode_alterar_CLIENTE"));
                pBLL.setPode_desligar_CLIENTE(resultadoConsulta.getBoolean("Pode_desligar_CLIENTE"));

                pBLL.setPode_cadastrar_COD_CADASTRO(resultadoConsulta.getBoolean("Pode_cadastrar_COD_CADASTRO"));
                pBLL.setPode_consultar_COD_CADASTRO(resultadoConsulta.getBoolean("Pode_consultar_COD_CADASTRO"));
                pBLL.setPode_alterar_COD_CADASTRO(resultadoConsulta.getBoolean("Pode_alterar_COD_CADASTRO"));
                pBLL.setPode_desligar_COD_CADASTRO(resultadoConsulta.getBoolean("Pode_desligar_COD_CADASTRO"));

                pBLL.setPode_cadastrar_VENDA(resultadoConsulta.getBoolean("Pode_cadastrar_VENDA"));
                pBLL.setPode_consultar_VENDA(resultadoConsulta.getBoolean("Pode_consultar_VENDA"));
                pBLL.setPode_alterar_VENDA(resultadoConsulta.getBoolean("Pode_alterar_VENDA"));
                pBLL.setPode_desligar_VENDA(resultadoConsulta.getBoolean("Pode_desligar_VENDA"));

                pBLL.setPode_cadastrar_PROMOCAO(resultadoConsulta.getBoolean("Pode_cadastrar_PROMOCAO"));
                pBLL.setPode_consultar_PROMOCAO(resultadoConsulta.getBoolean("Pode_consultar_PROMOCAO"));
                pBLL.setPode_alterar_PROMOCAO(resultadoConsulta.getBoolean("Pode_alterar_PROMOCAO"));
                pBLL.setPode_desligar_PROMOCAO(resultadoConsulta.getBoolean("Pode_cadastrar_ALUGUEL"));

                pBLL.setPode_cadastrar_ALUGUEL(resultadoConsulta.getBoolean("Pode_cadastrar_ALUGUEL"));
                pBLL.setPode_consultar_ALUGUEL(resultadoConsulta.getBoolean("Pode_consultar_ALUGUEL"));
                pBLL.setPode_alterar_ALUGUEL(resultadoConsulta.getBoolean("Pode_alterar_ALUGUEL"));
                pBLL.setPode_desligar_ALUGUEL(resultadoConsulta.getBoolean("Pode_desligar_ALUGUEL"));

                pBLL.setPode_cadastrar_PRODUTO(resultadoConsulta.getBoolean("Pode_cadastrar_PRODUTO"));
                pBLL.setPode_consultar_PRODUTO(resultadoConsulta.getBoolean("Pode_consultar_PRODUTO"));
                pBLL.setPode_alterar_PRODUTO(resultadoConsulta.getBoolean("Pode_alterar_PRODUTO"));
                pBLL.setPode_desligar_PRODUTO(resultadoConsulta.getBoolean("Pode_desligar_PRODUTO"));

                pBLL.setPode_cadastrar_EQUIPAMENTO(resultadoConsulta.getBoolean("Pode_cadastrar_EQUIPAMENTO"));
                pBLL.setPode_consultar_EQUIPAMENTO(resultadoConsulta.getBoolean("Pode_consultar_EQUIPAMENTO"));
                pBLL.setPode_alterar_EQUIPAMENTO(resultadoConsulta.getBoolean("Pode_alterar_EQUIPAMENTO"));
                pBLL.setPode_desligar_EQUIPAMENTO(resultadoConsulta.getBoolean("Pode_desligar_EQUIPAMENTO"));

                pBLL.setPode_cadastrar_MANUTENCAO(resultadoConsulta.getBoolean("Pode_cadastrar_MANUTENCAO"));
                pBLL.setPode_consultar_MANUTENCAO(resultadoConsulta.getBoolean("Pode_consultar_MANUTENCAO"));
                pBLL.setPode_alterar_MANUTENCAO(resultadoConsulta.getBoolean("Pode_alterar_MANUTENCAO"));
                pBLL.setPode_desligar_MANUTENCAO(resultadoConsulta.getBoolean("Pode_desligar_MANUTENCAO"));

                pBLL.setPode_cadastrar_CARGO(resultadoConsulta.getBoolean("Pode_cadastrar_CARGO"));
                pBLL.setPode_consultar_CARGO(resultadoConsulta.getBoolean("Pode_consultar_CARGO"));
                pBLL.setPode_alterar_CARGO(resultadoConsulta.getBoolean("Pode_alterar_CARGO"));
                pBLL.setPode_desligar_CARGO(resultadoConsulta.getBoolean("Pode_desligar_CARGO"));

                pBLL.setPode_cadastrar_FUNCIONARIO(resultadoConsulta.getBoolean("Pode_cadastrar_FUNCIONARIO"));
                pBLL.setPode_consultar_FUNCIONARIO(resultadoConsulta.getBoolean("Pode_consultar_FUNCIONARIO"));
                pBLL.setPode_alterar_FUNCIONARIO(resultadoConsulta.getBoolean("Pode_alterar_FUNCIONARIO"));
                pBLL.setPode_desligar_FUNCIONARIO(resultadoConsulta.getBoolean("Pode_desligar_FUNCIONARIO"));

                pBLL.setPode_gerar_BACKUP(resultadoConsulta.getBoolean("pode_gerar_BACKUP"));
                pBLL.setPode_restaurar_BACKUP(resultadoConsulta.getBoolean("Pode_restaurar_BACKUP"));

                pBLL.setPode_gerar_RELATORIO(resultadoConsulta.getBoolean("Pode_gerar_RELATORIO"));

                pBLL.setAtivo(resultadoConsulta.getBoolean("ATIVO"));

                //ADICIONAR NOVO TÍTULO PREENCHIDO À COMBOBOX
                listaPermissoes.add(pBLL);
            }

            // RETORNAR LISTA PREENCHIDA
            return listaPermissoes;

        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + e);
            return null;
        }
    }
    
    public int RecuperarUltimaChavePrimaria(){
        //CRIANDO COMANDO SQL
        String comandoSQL = "select count(codigo) as 'ID' from permissoes;";
        
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