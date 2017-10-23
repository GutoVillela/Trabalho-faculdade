
package BLL;

public class FornecimentoBLL {
    
    private FornecedorBLL fornecedor;
    private ProdutoBLL produto;
    private String duracaoGarantia;
    private float preco;
    private int quantidadeFornecida;

    public FornecimentoBLL() {
        this.produto = new ProdutoBLL();
        this.fornecedor = new FornecedorBLL();
    }

    /**
     * @return the fornecedor
     */
    public FornecedorBLL getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(FornecedorBLL fornecedor) {
        this.fornecedor = fornecedor;
    }

    /**
     * @return the produto
     */
    public ProdutoBLL getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(ProdutoBLL produto) {
        this.produto = produto;
    }

    /**
     * @return the duracaoGarantia
     */
    public String getDuracaoGarantia() {
        return duracaoGarantia;
    }

    /**
     * @param duracaoGarantia the duracaoGarantia to set
     */
    public void setDuracaoGarantia(String duracaoGarantia) {
        this.duracaoGarantia = duracaoGarantia;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     * @return the quantidadeFornecida
     */
    public int getQuantidadeFornecida() {
        return quantidadeFornecida;
    }

    /**
     * @param quantidadeFornecida the quantidadeFornecida to set
     */
    public void setQuantidadeFornecida(int quantidadeFornecida) {
        this.quantidadeFornecida = quantidadeFornecida;
    }
    
}
