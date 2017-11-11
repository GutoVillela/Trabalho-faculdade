package BLL;

import DAL.VendaDAL;
import java.util.ArrayList;
import java.util.List;

public class VendaBLL {
    
    private int codigo;
    private ClienteBLL cliente;
    private String dataDaVenda;
    private boolean ativo;
    private List<ProdutoBLL> itensDaVenda;
    
    private VendaDAL vDAL = new VendaDAL();

    public VendaBLL() {
        this.itensDaVenda = new ArrayList<>();
        this.cliente = new ClienteBLL();
    }
    
    //MÉTODOS
    public boolean Cadastrar(){
        //TENTAR CADASTRAR VENDA
        boolean deuCertoVenda = vDAL.Cadastrar(this);
        
        //RECUPERAR VENDA CADASTRADA
        this.codigo = vDAL.RecuperarUltimaChavePrimaria();
        
        // CADASTRAR TODOS OS ITENS DESTA VENDA
        boolean deuCertoItensDaVenda = vDAL.CadastrarItensDaVenda(this);
        
        //RETORNAR RESULTADO DAS OPERAÇÕES
        return deuCertoVenda && deuCertoItensDaVenda;
    }
    
    //ENCAPSULADORES

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

    /**
     * @return the cliente
     */
    public ClienteBLL getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteBLL cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the dataDaVenda
     */
    public String getDataDaVenda() {
        return dataDaVenda;
    }

    /**
     * @param dataDaVenda the dataDaVenda to set
     */
    public void setDataDaVenda(String dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
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
     * @return the itensDaVenda
     */
    public List<ProdutoBLL> getItensDaVenda() {
        return itensDaVenda;
    }

    /**
     * @param itensDaVenda the itensDaVenda to set
     */
    public void setItensDaVenda(List<ProdutoBLL> itensDaVenda) {
        this.itensDaVenda = itensDaVenda;
    }
    
}
