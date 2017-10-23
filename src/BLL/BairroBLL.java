package BLL;

public class BairroBLL {
    
    private int codigo;
    private String codigoBairro;
    private String nome;
    private CidadeBLL cidade;

    public BairroBLL() {
        this.cidade = new CidadeBLL();
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
     * @return the codigoBairro
     */
    public String getCodigoBairro() {
        return codigoBairro;
    }

    /**
     * @param codigoBairro the codigoBairro to set
     */
    public void setCodigoBairro(String codigoBairro) {
        this.codigoBairro = codigoBairro;
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
     * @return the cidade
     */
    public CidadeBLL getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(CidadeBLL cidade) {
        this.cidade = cidade;
    }
    
}
