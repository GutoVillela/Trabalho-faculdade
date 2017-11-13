package BLL;

import DAL.ProdutoDAL;
import java.util.List;

public class ProdutoBLL {
    
    private int codigo;
    private String nome;
    private int quantidade;
    private float preco;
    private boolean ativo;
    
    private ProdutoDAL pDAL = new ProdutoDAL();
    
    // MÉTODOS
    public boolean Cadastrar(){
        return pDAL.Cadastrar(this);
    }
    
    public int RecuperarUltimaChavePrimaria(){
        return pDAL.RecuperarUltimaChavePrimaria();
    }
    
    public List<ProdutoBLL> Consultar(){
        return pDAL.Consultar();
    }
    // ENCAPSULAMENTO

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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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
