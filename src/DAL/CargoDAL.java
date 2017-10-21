/*
* CLASSE QUE GERENCIA O ACESSO A DADOS PARA CARGOS
 */
package DAL;

import BLL.CargoBLL; //
import BLL.PermissaoBLL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class CargoDAL {

    private Conexao con = new Conexao(); // INSTÂNCIA DA CLASSE DE CONEXÃO

    public boolean Cadastrar(CargoBLL cBLL) {
        //DEFINIR COMANDO SQL
        String comandoSQL = "INSERT INTO Cargos (cargo, salario, permissao, ativo) VALUES (?, ?, ?, ?);";

        // TRATAMENTO DE ERROS
        try {

            //PREPARAR O COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, cBLL.getCargo());
            query.setFloat(2, cBLL.getSalario());
            query.setInt(3, cBLL.getPermissao().getCodigo());
            query.setBoolean(4, cBLL.isAtivo());

            query.executeUpdate();// EXECUTAR O INSERT
            return true;

        } catch (Exception erro) {
            System.out.println("ERRO EM " + this.getClass().getCanonicalName() + "!\n" + erro);

            return false;
        }
    }

    public List<CargoBLL> Consultar() {
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM Cargos;";

        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<CargoBLL> listaCargos = new LinkedList<>();

        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);

            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            while (resultadoConsulta.next()) {
                //PREENCHER ITEM
                CargoBLL cBLL = new CargoBLL();
                cBLL.setCodigo(resultadoConsulta.getInt("codigo"));
                cBLL.setCargo(resultadoConsulta.getString("cargo"));
                cBLL.setSalario(resultadoConsulta.getFloat("salario"));
                cBLL.setPermissao(ConsultarPermissao(cBLL)); // COMO A CONSULTA NÃO TRAZ A PERMISSÃO, EU USO OUTRO MÉTODO PARA ISSO
                cBLL.setAtivo(resultadoConsulta.getBoolean("ativo"));

                //ADICIONAR NOVO TÍTULO PREENCHIDO À COMBOBOX
                listaCargos.add(cBLL);
            }

            // RETORNAR LISTA PREENCHIDA
            return listaCargos;

        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + " \n" + e);
            return null;
        }
    }

    /**
     * @param cBLL Objeto CargoBLL com código atribuído.
     * @return A PermissaoBLL referente ao cargo desta instância (pelo código).
     */
    public PermissaoBLL ConsultarPermissao(CargoBLL cBLL) {
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM Permissoes JOIN Cargos ON Cargos.permissao = Permissoes.codigo WHERE Cargos.codigo = ?;";

        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        PermissaoBLL pBLL = new PermissaoBLL();

        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, cBLL.getCodigo());
            
            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            //RECUPERAR PRÓXIMA CONSULTA
            resultadoConsulta.next();

            //COLOCAR TODOS OS RESULTADOS DENTRO DO OBJETO
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

            // RETORNAR LISTA PREENCHIDA
            return pBLL;

        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + " NO MÉTODO 'ConsultarPermissao'.\n" + e);
            return null;
        }
    }

}
