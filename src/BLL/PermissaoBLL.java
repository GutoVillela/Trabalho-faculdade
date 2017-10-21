package BLL;

import DAL.PermissaoDAL;
import java.util.List;

public class PermissaoBLL {

    // TODOS OS ATRIBUTOS DE PERMISSÕES
    private int codigo;
    private boolean pode_cadastrar_FORNECEDOR;
    private boolean pode_consultar_FORNECEDOR;
    private boolean pode_alterar_FORNECEDOR;
    private boolean pode_desligar_FORNECEDOR;

    private boolean pode_cadastrar_CLIENTE;
    private boolean pode_consultar_CLIENTE;
    private boolean pode_alterar_CLIENTE;
    private boolean pode_desligar_CLIENTE;

    private boolean pode_cadastrar_COD_CADASTRO;
    private boolean pode_consultar_COD_CADASTRO;
    private boolean pode_alterar_COD_CADASTRO;
    private boolean pode_desligar_COD_CADASTRO;

    private boolean pode_cadastrar_VENDA;
    private boolean pode_consultar_VENDA;
    private boolean pode_alterar_VENDA;
    private boolean pode_desligar_VENDA;

    private boolean pode_cadastrar_PROMOCAO;
    private boolean pode_consultar_PROMOCAO;
    private boolean pode_alterar_PROMOCAO;
    private boolean pode_desligar_PROMOCAO;

    private boolean pode_cadastrar_ALUGUEL;
    private boolean pode_consultar_ALUGUEL;
    private boolean pode_alterar_ALUGUEL;
    private boolean pode_desligar_ALUGUEL;

    private boolean pode_cadastrar_PRODUTO;
    private boolean pode_consultar_PRODUTO;
    private boolean pode_alterar_PRODUTO;
    private boolean pode_desligar_PRODUTO;

    private boolean pode_cadastrar_EQUIPAMENTO;
    private boolean pode_consultar_EQUIPAMENTO;
    private boolean pode_alterar_EQUIPAMENTO;
    private boolean pode_desligar_EQUIPAMENTO;

    private boolean pode_cadastrar_MANUTENCAO;
    private boolean pode_consultar_MANUTENCAO;
    private boolean pode_alterar_MANUTENCAO;
    private boolean pode_desligar_MANUTENCAO;

    private boolean pode_cadastrar_CARGO;
    private boolean pode_consultar_CARGO;
    private boolean pode_alterar_CARGO;
    private boolean pode_desligar_CARGO;

    private boolean pode_cadastrar_FUNCIONARIO;
    private boolean pode_consultar_FUNCIONARIO;
    private boolean pode_alterar_FUNCIONARIO;
    private boolean pode_desligar_FUNCIONARIO;

    private boolean pode_gerar_BACKUP;
    private boolean pode_restaurar_BACKUP;

    private boolean pode_gerar_RELATORIO;

    private boolean ativo;

    /**
     * @return the pode_cadastrar_FORNECEDOR
     */
    public boolean isPode_cadastrar_FORNECEDOR() {
        return pode_cadastrar_FORNECEDOR;
    }

    /**
     * @param pode_cadastrar_FORNECEDOR the pode_cadastrar_FORNECEDOR to set
     */
    public void setPode_cadastrar_FORNECEDOR(boolean pode_cadastrar_FORNECEDOR) {
        this.pode_cadastrar_FORNECEDOR = pode_cadastrar_FORNECEDOR;
    }

    /**
     * @return the pode_consultar_FORNECEDOR
     */
    public boolean isPode_consultar_FORNECEDOR() {
        return pode_consultar_FORNECEDOR;
    }

    /**
     * @param pode_consultar_FORNECEDOR the pode_consultar_FORNECEDOR to set
     */
    public void setPode_consultar_FORNECEDOR(boolean pode_consultar_FORNECEDOR) {
        this.pode_consultar_FORNECEDOR = pode_consultar_FORNECEDOR;
    }

    /**
     * @return the pode_alterar_FORNECEDOR
     */
    public boolean isPode_alterar_FORNECEDOR() {
        return pode_alterar_FORNECEDOR;
    }

    /**
     * @param pode_alterar_FORNECEDOR the pode_alterar_FORNECEDOR to set
     */
    public void setPode_alterar_FORNECEDOR(boolean pode_alterar_FORNECEDOR) {
        this.pode_alterar_FORNECEDOR = pode_alterar_FORNECEDOR;
    }

    /**
     * @return the pode_desligar_FORNECEDOR
     */
    public boolean isPode_desligar_FORNECEDOR() {
        return pode_desligar_FORNECEDOR;
    }

    /**
     * @param pode_desligar_FORNECEDOR the pode_desligar_FORNECEDOR to set
     */
    public void setPode_desligar_FORNECEDOR(boolean pode_desligar_FORNECEDOR) {
        this.pode_desligar_FORNECEDOR = pode_desligar_FORNECEDOR;
    }

    /**
     * @return the pode_cadastrar_CLIENTE
     */
    public boolean isPode_cadastrar_CLIENTE() {
        return pode_cadastrar_CLIENTE;
    }

    /**
     * @param pode_cadastrar_CLIENTE the pode_cadastrar_CLIENTE to set
     */
    public void setPode_cadastrar_CLIENTE(boolean pode_cadastrar_CLIENTE) {
        this.pode_cadastrar_CLIENTE = pode_cadastrar_CLIENTE;
    }

    /**
     * @return the pode_consultar_CLIENTE
     */
    public boolean isPode_consultar_CLIENTE() {
        return pode_consultar_CLIENTE;
    }

    /**
     * @param pode_consultar_CLIENTE the pode_consultar_CLIENTE to set
     */
    public void setPode_consultar_CLIENTE(boolean pode_consultar_CLIENTE) {
        this.pode_consultar_CLIENTE = pode_consultar_CLIENTE;
    }

    /**
     * @return the pode_alterar_CLIENTE
     */
    public boolean isPode_alterar_CLIENTE() {
        return pode_alterar_CLIENTE;
    }

    /**
     * @param pode_alterar_CLIENTE the pode_alterar_CLIENTE to set
     */
    public void setPode_alterar_CLIENTE(boolean pode_alterar_CLIENTE) {
        this.pode_alterar_CLIENTE = pode_alterar_CLIENTE;
    }

    /**
     * @return the pode_desligar_CLIENTE
     */
    public boolean isPode_desligar_CLIENTE() {
        return pode_desligar_CLIENTE;
    }

    /**
     * @param pode_desligar_CLIENTE the pode_desligar_CLIENTE to set
     */
    public void setPode_desligar_CLIENTE(boolean pode_desligar_CLIENTE) {
        this.pode_desligar_CLIENTE = pode_desligar_CLIENTE;
    }

    /**
     * @return the pode_cadastrar_COD_CADASTRO
     */
    public boolean isPode_cadastrar_COD_CADASTRO() {
        return pode_cadastrar_COD_CADASTRO;
    }

    /**
     * @param pode_cadastrar_COD_CADASTRO the pode_cadastrar_COD_CADASTRO to set
     */
    public void setPode_cadastrar_COD_CADASTRO(boolean pode_cadastrar_COD_CADASTRO) {
        this.pode_cadastrar_COD_CADASTRO = pode_cadastrar_COD_CADASTRO;
    }

    /**
     * @return the pode_consultar_COD_CADASTRO
     */
    public boolean isPode_consultar_COD_CADASTRO() {
        return pode_consultar_COD_CADASTRO;
    }

    /**
     * @param pode_consultar_COD_CADASTRO the pode_consultar_COD_CADASTRO to set
     */
    public void setPode_consultar_COD_CADASTRO(boolean pode_consultar_COD_CADASTRO) {
        this.pode_consultar_COD_CADASTRO = pode_consultar_COD_CADASTRO;
    }

    /**
     * @return the pode_alterar_COD_CADASTRO
     */
    public boolean isPode_alterar_COD_CADASTRO() {
        return pode_alterar_COD_CADASTRO;
    }

    /**
     * @param pode_alterar_COD_CADASTRO the pode_alterar_COD_CADASTRO to set
     */
    public void setPode_alterar_COD_CADASTRO(boolean pode_alterar_COD_CADASTRO) {
        this.pode_alterar_COD_CADASTRO = pode_alterar_COD_CADASTRO;
    }

    /**
     * @return the pode_desligar_COD_CADASTRO
     */
    public boolean isPode_desligar_COD_CADASTRO() {
        return pode_desligar_COD_CADASTRO;
    }

    /**
     * @param pode_desligar_COD_CADASTRO the pode_desligar_COD_CADASTRO to set
     */
    public void setPode_desligar_COD_CADASTRO(boolean pode_desligar_COD_CADASTRO) {
        this.pode_desligar_COD_CADASTRO = pode_desligar_COD_CADASTRO;
    }

    /**
     * @return the pode_cadastrar_VENDA
     */
    public boolean isPode_cadastrar_VENDA() {
        return pode_cadastrar_VENDA;
    }

    /**
     * @param pode_cadastrar_VENDA the pode_cadastrar_VENDA to set
     */
    public void setPode_cadastrar_VENDA(boolean pode_cadastrar_VENDA) {
        this.pode_cadastrar_VENDA = pode_cadastrar_VENDA;
    }

    /**
     * @return the pode_consultar_VENDA
     */
    public boolean isPode_consultar_VENDA() {
        return pode_consultar_VENDA;
    }

    /**
     * @param pode_consultar_VENDA the pode_consultar_VENDA to set
     */
    public void setPode_consultar_VENDA(boolean pode_consultar_VENDA) {
        this.pode_consultar_VENDA = pode_consultar_VENDA;
    }

    /**
     * @return the pode_alterar_VENDA
     */
    public boolean isPode_alterar_VENDA() {
        return pode_alterar_VENDA;
    }

    /**
     * @param pode_alterar_VENDA the pode_alterar_VENDA to set
     */
    public void setPode_alterar_VENDA(boolean pode_alterar_VENDA) {
        this.pode_alterar_VENDA = pode_alterar_VENDA;
    }

    /**
     * @return the pode_desligar_VENDA
     */
    public boolean isPode_desligar_VENDA() {
        return pode_desligar_VENDA;
    }

    /**
     * @param pode_desligar_VENDA the pode_desligar_VENDA to set
     */
    public void setPode_desligar_VENDA(boolean pode_desligar_VENDA) {
        this.pode_desligar_VENDA = pode_desligar_VENDA;
    }

    /**
     * @return the pode_cadastrar_PROMOCAO
     */
    public boolean isPode_cadastrar_PROMOCAO() {
        return pode_cadastrar_PROMOCAO;
    }

    /**
     * @param pode_cadastrar_PROMOCAO the pode_cadastrar_PROMOCAO to set
     */
    public void setPode_cadastrar_PROMOCAO(boolean pode_cadastrar_PROMOCAO) {
        this.pode_cadastrar_PROMOCAO = pode_cadastrar_PROMOCAO;
    }

    /**
     * @return the pode_consultar_PROMOCAO
     */
    public boolean isPode_consultar_PROMOCAO() {
        return pode_consultar_PROMOCAO;
    }

    /**
     * @param pode_consultar_PROMOCAO the pode_consultar_PROMOCAO to set
     */
    public void setPode_consultar_PROMOCAO(boolean pode_consultar_PROMOCAO) {
        this.pode_consultar_PROMOCAO = pode_consultar_PROMOCAO;
    }

    /**
     * @return the pode_alterar_PROMOCAO
     */
    public boolean isPode_alterar_PROMOCAO() {
        return pode_alterar_PROMOCAO;
    }

    /**
     * @param pode_alterar_PROMOCAO the pode_alterar_PROMOCAO to set
     */
    public void setPode_alterar_PROMOCAO(boolean pode_alterar_PROMOCAO) {
        this.pode_alterar_PROMOCAO = pode_alterar_PROMOCAO;
    }

    /**
     * @return the pode_desligar_PROMOCAO
     */
    public boolean isPode_desligar_PROMOCAO() {
        return pode_desligar_PROMOCAO;
    }

    /**
     * @param pode_desligar_PROMOCAO the pode_desligar_PROMOCAO to set
     */
    public void setPode_desligar_PROMOCAO(boolean pode_desligar_PROMOCAO) {
        this.pode_desligar_PROMOCAO = pode_desligar_PROMOCAO;
    }

    /**
     * @return the pode_cadastrar_ALUGUEL
     */
    public boolean isPode_cadastrar_ALUGUEL() {
        return pode_cadastrar_ALUGUEL;
    }

    /**
     * @param pode_cadastrar_ALUGUEL the pode_cadastrar_ALUGUEL to set
     */
    public void setPode_cadastrar_ALUGUEL(boolean pode_cadastrar_ALUGUEL) {
        this.pode_cadastrar_ALUGUEL = pode_cadastrar_ALUGUEL;
    }

    /**
     * @return the pode_consultar_ALUGUEL
     */
    public boolean isPode_consultar_ALUGUEL() {
        return pode_consultar_ALUGUEL;
    }

    /**
     * @param pode_consultar_ALUGUEL the pode_consultar_ALUGUEL to set
     */
    public void setPode_consultar_ALUGUEL(boolean pode_consultar_ALUGUEL) {
        this.pode_consultar_ALUGUEL = pode_consultar_ALUGUEL;
    }

    /**
     * @return the pode_alterar_ALUGUEL
     */
    public boolean isPode_alterar_ALUGUEL() {
        return pode_alterar_ALUGUEL;
    }

    /**
     * @param pode_alterar_ALUGUEL the pode_alterar_ALUGUEL to set
     */
    public void setPode_alterar_ALUGUEL(boolean pode_alterar_ALUGUEL) {
        this.pode_alterar_ALUGUEL = pode_alterar_ALUGUEL;
    }

    /**
     * @return the pode_desligar_ALUGUEL
     */
    public boolean isPode_desligar_ALUGUEL() {
        return pode_desligar_ALUGUEL;
    }

    /**
     * @param pode_desligar_ALUGUEL the pode_desligar_ALUGUEL to set
     */
    public void setPode_desligar_ALUGUEL(boolean pode_desligar_ALUGUEL) {
        this.pode_desligar_ALUGUEL = pode_desligar_ALUGUEL;
    }

    /**
     * @return the pode_cadastrar_PRODUTO
     */
    public boolean isPode_cadastrar_PRODUTO() {
        return pode_cadastrar_PRODUTO;
    }

    /**
     * @param pode_cadastrar_PRODUTO the pode_cadastrar_PRODUTO to set
     */
    public void setPode_cadastrar_PRODUTO(boolean pode_cadastrar_PRODUTO) {
        this.pode_cadastrar_PRODUTO = pode_cadastrar_PRODUTO;
    }

    /**
     * @return the pode_consultar_PRODUTO
     */
    public boolean isPode_consultar_PRODUTO() {
        return pode_consultar_PRODUTO;
    }

    /**
     * @param pode_consultar_PRODUTO the pode_consultar_PRODUTO to set
     */
    public void setPode_consultar_PRODUTO(boolean pode_consultar_PRODUTO) {
        this.pode_consultar_PRODUTO = pode_consultar_PRODUTO;
    }

    /**
     * @return the pode_alterar_PRODUTO
     */
    public boolean isPode_alterar_PRODUTO() {
        return pode_alterar_PRODUTO;
    }

    /**
     * @param pode_alterar_PRODUTO the pode_alterar_PRODUTO to set
     */
    public void setPode_alterar_PRODUTO(boolean pode_alterar_PRODUTO) {
        this.pode_alterar_PRODUTO = pode_alterar_PRODUTO;
    }

    /**
     * @return the pode_desligar_PRODUTO
     */
    public boolean isPode_desligar_PRODUTO() {
        return pode_desligar_PRODUTO;
    }

    /**
     * @param pode_desligar_PRODUTO the pode_desligar_PRODUTO to set
     */
    public void setPode_desligar_PRODUTO(boolean pode_desligar_PRODUTO) {
        this.pode_desligar_PRODUTO = pode_desligar_PRODUTO;
    }

    /**
     * @return the pode_cadastrar_EQUIPAMENTO
     */
    public boolean isPode_cadastrar_EQUIPAMENTO() {
        return pode_cadastrar_EQUIPAMENTO;
    }

    /**
     * @param pode_cadastrar_EQUIPAMENTO the pode_cadastrar_EQUIPAMENTO to set
     */
    public void setPode_cadastrar_EQUIPAMENTO(boolean pode_cadastrar_EQUIPAMENTO) {
        this.pode_cadastrar_EQUIPAMENTO = pode_cadastrar_EQUIPAMENTO;
    }

    /**
     * @return the pode_consultar_EQUIPAMENTO
     */
    public boolean isPode_consultar_EQUIPAMENTO() {
        return pode_consultar_EQUIPAMENTO;
    }

    /**
     * @param pode_consultar_EQUIPAMENTO the pode_consultar_EQUIPAMENTO to set
     */
    public void setPode_consultar_EQUIPAMENTO(boolean pode_consultar_EQUIPAMENTO) {
        this.pode_consultar_EQUIPAMENTO = pode_consultar_EQUIPAMENTO;
    }

    /**
     * @return the pode_alterar_EQUIPAMENTO
     */
    public boolean isPode_alterar_EQUIPAMENTO() {
        return pode_alterar_EQUIPAMENTO;
    }

    /**
     * @param pode_alterar_EQUIPAMENTO the pode_alterar_EQUIPAMENTO to set
     */
    public void setPode_alterar_EQUIPAMENTO(boolean pode_alterar_EQUIPAMENTO) {
        this.pode_alterar_EQUIPAMENTO = pode_alterar_EQUIPAMENTO;
    }

    /**
     * @return the pode_desligar_EQUIPAMENTO
     */
    public boolean isPode_desligar_EQUIPAMENTO() {
        return pode_desligar_EQUIPAMENTO;
    }

    /**
     * @param pode_desligar_EQUIPAMENTO the pode_desligar_EQUIPAMENTO to set
     */
    public void setPode_desligar_EQUIPAMENTO(boolean pode_desligar_EQUIPAMENTO) {
        this.pode_desligar_EQUIPAMENTO = pode_desligar_EQUIPAMENTO;
    }

    /**
     * @return the pode_cadastrar_MANUTENCAO
     */
    public boolean isPode_cadastrar_MANUTENCAO() {
        return pode_cadastrar_MANUTENCAO;
    }

    /**
     * @param pode_cadastrar_MANUTENCAO the pode_cadastrar_MANUTENCAO to set
     */
    public void setPode_cadastrar_MANUTENCAO(boolean pode_cadastrar_MANUTENCAO) {
        this.pode_cadastrar_MANUTENCAO = pode_cadastrar_MANUTENCAO;
    }

    /**
     * @return the pode_consultar_MANUTENCAO
     */
    public boolean isPode_consultar_MANUTENCAO() {
        return pode_consultar_MANUTENCAO;
    }

    /**
     * @param pode_consultar_MANUTENCAO the pode_consultar_MANUTENCAO to set
     */
    public void setPode_consultar_MANUTENCAO(boolean pode_consultar_MANUTENCAO) {
        this.pode_consultar_MANUTENCAO = pode_consultar_MANUTENCAO;
    }

    /**
     * @return the pode_alterar_MANUTENCAO
     */
    public boolean isPode_alterar_MANUTENCAO() {
        return pode_alterar_MANUTENCAO;
    }

    /**
     * @param pode_alterar_MANUTENCAO the pode_alterar_MANUTENCAO to set
     */
    public void setPode_alterar_MANUTENCAO(boolean pode_alterar_MANUTENCAO) {
        this.pode_alterar_MANUTENCAO = pode_alterar_MANUTENCAO;
    }

    /**
     * @return the pode_desligar_MANUTENCAO
     */
    public boolean isPode_desligar_MANUTENCAO() {
        return pode_desligar_MANUTENCAO;
    }

    /**
     * @param pode_desligar_MANUTENCAO the pode_desligar_MANUTENCAO to set
     */
    public void setPode_desligar_MANUTENCAO(boolean pode_desligar_MANUTENCAO) {
        this.pode_desligar_MANUTENCAO = pode_desligar_MANUTENCAO;
    }

    /**
     * @return the pode_cadastrar_CARGO
     */
    public boolean isPode_cadastrar_CARGO() {
        return pode_cadastrar_CARGO;
    }

    /**
     * @param pode_cadastrar_CARGO the pode_cadastrar_CARGO to set
     */
    public void setPode_cadastrar_CARGO(boolean pode_cadastrar_CARGO) {
        this.pode_cadastrar_CARGO = pode_cadastrar_CARGO;
    }

    /**
     * @return the pode_consultar_CARGO
     */
    public boolean isPode_consultar_CARGO() {
        return pode_consultar_CARGO;
    }

    /**
     * @param pode_consultar_CARGO the pode_consultar_CARGO to set
     */
    public void setPode_consultar_CARGO(boolean pode_consultar_CARGO) {
        this.pode_consultar_CARGO = pode_consultar_CARGO;
    }

    /**
     * @return the pode_alterar_CARGO
     */
    public boolean isPode_alterar_CARGO() {
        return pode_alterar_CARGO;
    }

    /**
     * @param pode_alterar_CARGO the pode_alterar_CARGO to set
     */
    public void setPode_alterar_CARGO(boolean pode_alterar_CARGO) {
        this.pode_alterar_CARGO = pode_alterar_CARGO;
    }

    /**
     * @return the pode_desligar_CARGO
     */
    public boolean isPode_desligar_CARGO() {
        return pode_desligar_CARGO;
    }

    /**
     * @param pode_desligar_CARGO the pode_desligar_CARGO to set
     */
    public void setPode_desligar_CARGO(boolean pode_desligar_CARGO) {
        this.pode_desligar_CARGO = pode_desligar_CARGO;
    }

    /**
     * @return the pode_cadastrar_FUNCIONARIO
     */
    public boolean isPode_cadastrar_FUNCIONARIO() {
        return pode_cadastrar_FUNCIONARIO;
    }

    /**
     * @param pode_cadastrar_FUNCIONARIO the pode_cadastrar_FUNCIONARIO to set
     */
    public void setPode_cadastrar_FUNCIONARIO(boolean pode_cadastrar_FUNCIONARIO) {
        this.pode_cadastrar_FUNCIONARIO = pode_cadastrar_FUNCIONARIO;
    }

    /**
     * @return the pode_consultar_FUNCIONARIO
     */
    public boolean isPode_consultar_FUNCIONARIO() {
        return pode_consultar_FUNCIONARIO;
    }

    /**
     * @param pode_consultar_FUNCIONARIO the pode_consultar_FUNCIONARIO to set
     */
    public void setPode_consultar_FUNCIONARIO(boolean pode_consultar_FUNCIONARIO) {
        this.pode_consultar_FUNCIONARIO = pode_consultar_FUNCIONARIO;
    }

    /**
     * @return the pode_alterar_FUNCIONARIO
     */
    public boolean isPode_alterar_FUNCIONARIO() {
        return pode_alterar_FUNCIONARIO;
    }

    /**
     * @param pode_alterar_FUNCIONARIO the pode_alterar_FUNCIONARIO to set
     */
    public void setPode_alterar_FUNCIONARIO(boolean pode_alterar_FUNCIONARIO) {
        this.pode_alterar_FUNCIONARIO = pode_alterar_FUNCIONARIO;
    }

    /**
     * @return the pode_desligar_FUNCIONARIO
     */
    public boolean isPode_desligar_FUNCIONARIO() {
        return pode_desligar_FUNCIONARIO;
    }

    /**
     * @param pode_desligar_FUNCIONARIO the pode_desligar_FUNCIONARIO to set
     */
    public void setPode_desligar_FUNCIONARIO(boolean pode_desligar_FUNCIONARIO) {
        this.pode_desligar_FUNCIONARIO = pode_desligar_FUNCIONARIO;
    }

    /**
     * @return the pode_gerar_BACKUP
     */
    public boolean isPode_gerar_BACKUP() {
        return pode_gerar_BACKUP;
    }

    /**
     * @param pode_gerar_BACKUP the pode_gerar_BACKUP to set
     */
    public void setPode_gerar_BACKUP(boolean pode_gerar_BACKUP) {
        this.pode_gerar_BACKUP = pode_gerar_BACKUP;
    }

    /**
     * @return the pode_restaurar_BACKUP
     */
    public boolean isPode_restaurar_BACKUP() {
        return pode_restaurar_BACKUP;
    }

    /**
     * @param pode_restaurar_BACKUP the pode_restaurar_BACKUP to set
     */
    public void setPode_restaurar_BACKUP(boolean pode_restaurar_BACKUP) {
        this.pode_restaurar_BACKUP = pode_restaurar_BACKUP;
    }

    /**
     * @return the pode_gerar_RELATORIO
     */
    public boolean isPode_gerar_RELATORIO() {
        return pode_gerar_RELATORIO;
    }

    /**
     * @param pode_gerar_RELATORIO the pode_gerar_RELATORIO to set
     */
    public void setPode_gerar_RELATORIO(boolean pode_gerar_RELATORIO) {
        this.pode_gerar_RELATORIO = pode_gerar_RELATORIO;
    }

    /**
     * @return the ativo
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
     /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    private PermissaoDAL pDAL = new PermissaoDAL();
    
    // MÉTODOS
    public boolean Cadastrar() {
        
        if(pDAL.Cadastrar(this)){
            return true;
        }
        else{
            return false;
        }
    }

    public List<PermissaoBLL> Consultar() {
        return pDAL.Consultar();
    }
    
    public int RecuperarUltimaChavePrimaria(){
        return pDAL.RecuperarUltimaChavePrimaria();
    }
}
