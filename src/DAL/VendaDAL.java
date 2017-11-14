package DAL;

import BLL.ClienteBLL;
import BLL.VendaBLL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDAL {

    private Conexao con = new Conexao();

    public boolean Cadastrar(VendaBLL vBLL) {

        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO Vendas (cliente, data_da_venda, ativo) VALUES (?, ?, ?);";

        // TRATAMENTO DE ERRO
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, vBLL.getCliente().getCodigo());
            query.setString(2, vBLL.getDataDaVenda());
            query.setBoolean(3, vBLL.isAtivo());

            // EXECUTAR COMANDO
            query.executeUpdate();

            return true;
        } catch (SQLException erro) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return false;
        }

    }

    public int RecuperarUltimaChavePrimaria() {
        //CRIANDO COMANDO SQL
        String comandoSQL = "select count(codigo) as 'ID' from Vendas;";

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

    public boolean CadastrarItensDaVenda(VendaBLL vBLL) {
        //CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO itens_da_venda (venda, produto, preco_cobrado, quantidade_comprada) VALUES (?, ?, ?, ?);";

        // TRATAMENTO DE ERRO
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);

            //DEFINIR PARÂMETROS PARA CADA EQUIPAMENTO CADASTRADO
            for (int i = 0; i < vBLL.getItensDaVenda().size(); i++) {
                query.setInt(1, vBLL.getCodigo());
                query.setInt(2, vBLL.getItensDaVenda().get(i).getCodigo());
                query.setFloat(3, vBLL.getItensDaVenda().get(i).getPreco());
                query.setInt(4, vBLL.getItensDaVenda().get(i).getQuantidade());

                // EXECUTAR COMANDO
                query.executeUpdate();
            }

            return true;
        } catch (SQLException erro) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + " no método 'CadastrarItensDaVenda'\n" + erro);
            return false;
        }
    }

    public List<VendaBLL> Consultar() {
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM Vendas;";

        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<VendaBLL> listaVendas = new ArrayList<>();

        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);

            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            while (resultadoConsulta.next()) {
                //PREENCHER ITEM
                VendaBLL vBLL = new VendaBLL();
                vBLL.setCodigo(resultadoConsulta.getInt(1)); // COLUNA 'codigo' DA TABELA 'Vendas'
                vBLL.getCliente().setCodigo(resultadoConsulta.getInt(2)); // COLUNA 'cliente' DA TABELA 'Vendas'
                vBLL.setDataDaVenda(resultadoConsulta.getString(3)); // COLUNA 'data_da_venda' DA TABELA 'Vendas'
                vBLL.setAtivo(resultadoConsulta.getBoolean(4)); // COLUNA 'ativo' DA TABELA 'Vendas'

                //CONSULTAR TODOS OS ITENS DA VENDA
                vBLL.setItensDaVenda(ConsultarItensDaVenda(vBLL.getCodigo()));

                //CONSULTAR CLIENTE DA VENDA
                vBLL.setCliente(ConsultarCliente(vBLL.getCodigo()));

                //ADICIONAR NOVA VENDA PREENCHIDAO À LISTA
                listaVendas.add(vBLL);
            }

            // RETORNAR LISTA PREENCHIDA
            return listaVendas;

        } catch (Exception erro) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return null;
        }
    }
    
    public List<VendaBLL> ConsultarPorCliente(int codCliente) {
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM Vendas WHERE Vendas.cliente = ?;";

        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<VendaBLL> listaVendas = new ArrayList<>();

        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, codCliente);
            
            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            while (resultadoConsulta.next()) {
                //PREENCHER ITEM
                VendaBLL vBLL = new VendaBLL();
                vBLL.setCodigo(resultadoConsulta.getInt(1)); // COLUNA 'codigo' DA TABELA 'Vendas'
                vBLL.getCliente().setCodigo(resultadoConsulta.getInt(2)); // COLUNA 'cliente' DA TABELA 'Vendas'
                vBLL.setDataDaVenda(resultadoConsulta.getString(3)); // COLUNA 'data_da_venda' DA TABELA 'Vendas'
                vBLL.setAtivo(resultadoConsulta.getBoolean(4)); // COLUNA 'ativo' DA TABELA 'Vendas'

                //CONSULTAR TODOS OS ITENS DA VENDA
                vBLL.setItensDaVenda(ConsultarItensDaVenda(vBLL.getCodigo()));

                //CONSULTAR CLIENTE DA VENDA
                vBLL.setCliente(ConsultarCliente(vBLL.getCodigo()));

                //ADICIONAR NOVA VENDA PREENCHIDAO À LISTA
                listaVendas.add(vBLL);
            }

            // RETORNAR LISTA PREENCHIDA
            return listaVendas;

        } catch (Exception erro) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return null;
        }
    }

    public List<BLL.ProdutoBLL> ConsultarItensDaVenda(int codVenda) {
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM itens_da_venda LEFT JOIN produtos ON itens_da_venda.produto = produtos.codigo WHERE itens_da_venda.venda = ?;";

        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<BLL.ProdutoBLL> listaItensDaVenda = new ArrayList<>();

        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, codVenda);

            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            while (resultadoConsulta.next()) {
                //PREENCHER ITEM
                BLL.ProdutoBLL pBLL = new BLL.ProdutoBLL();
                pBLL.setCodigo(resultadoConsulta.getInt(2)); // COLUNA 'produto' DA TABELA 'Itens_da_venda'
                pBLL.setPreco(resultadoConsulta.getFloat(3)); // COLUNA 'preco_cobrado' DA TABELA 'Itens_da_venda'
                pBLL.setQuantidade(resultadoConsulta.getInt(4)); // COLUNA 'quantidade_comprada' DA TABELA 'Itens_da_venda'
                pBLL.setNome(resultadoConsulta.getString(6)); // COLUNA 'nome' DA TABELA 'Produtos'
                pBLL.setAtivo(resultadoConsulta.getBoolean(9)); // COLUNA 'ativo' DA TABELA 'Produtos'

                //ADICIONAR NOVO TÍTULO PREENCHIDO À COMBOBOX
                listaItensDaVenda.add(pBLL);
            }

            // RETORNAR LISTA PREENCHIDA
            return listaItensDaVenda;

        } catch (Exception erro) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return null;
        }
    }

    public BLL.ClienteBLL ConsultarCliente(int codVenda) {
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM Clientes INNER JOIN Vendas ON Vendas.cliente = clientes.codigo WHERE Vendas.codigo = ?;";
        
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, codVenda);

            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            //REALIZAR CONSULTA
            if (resultadoConsulta.next()) {
                // CRIAR PREENCHER OBJETO
                BLL.ClienteBLL cBLL = new ClienteBLL();
                cBLL.setCodigo(resultadoConsulta.getInt(1)); // COLUNA 'codigo' DA TABELA 'Clientes'
                cBLL.setAtivo(resultadoConsulta.getBoolean(2)); // COLUNA 'ativo' DA TABELA 'Clientes'
                cBLL.getEndereco().setCodigo(resultadoConsulta.getInt(3)); // COLUNA 'endereco' DA TABELA 'Clientes'
                cBLL.setEmail(resultadoConsulta.getString(4)); // COLUNA 'email' DA TABELA 'Clientes'
                
                // RETORNAR LISTA PREENCHIDA
                return cBLL;
            }
            else{
                return null;
            }

            

        } catch (Exception erro) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return null;
        }
    }

    public int PreverProximoCodigo() {
        return RecuperarUltimaChavePrimaria() + 1;
    }
}
