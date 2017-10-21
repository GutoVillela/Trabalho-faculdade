
package BLL;

import DAL.CopiaParaVenderDAL;

public class CopiaParaVenderBLL extends ProdutoBLL{
    
    private TituloBLL titulo;
    private PlataformaBLL plataforma;

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

    /**
     * @return the titulo
     */
    public TituloBLL getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(TituloBLL titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the plataforma
     */
    public PlataformaBLL getPlataforma() {
        return plataforma;
    }

    /**
     * @param plataforma the plataforma to set
     */
    public void setPlataforma(PlataformaBLL plataforma) {
        this.plataforma = plataforma;
    }

    // MÉTODOS
    
    public boolean Cadastrar(){
        CopiaParaVenderDAL cDAL = new CopiaParaVenderDAL();
        
        if (cDAL.Cadastrar(this)) {
            return true;
        }
        else{
            return false;
        }
    }
    
    
}
