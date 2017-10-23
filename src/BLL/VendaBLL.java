package BLL;

import java.util.LinkedList;
import java.util.List;

public class VendaBLL {
    
    private int codigo;
    private ClienteBLL cliente;
    private String dataDaVenda;
    private boolean ativo;
    private List<ProdutoBLL> itensDaVenda;

    public VendaBLL() {
        this.itensDaVenda = new LinkedList<>();
        this.cliente = new ClienteBLL();
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
    
}
