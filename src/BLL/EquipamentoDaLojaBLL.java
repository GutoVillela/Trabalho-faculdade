
package BLL;

public class EquipamentoDaLojaBLL {
    
    private int codigo;
    private TipoEquipamentoBLL tipo;
    private String nome;
    private float valorPorHora;
    private boolean ativo;

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
     * @return the tipo
     */
    public TipoEquipamentoBLL getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoEquipamentoBLL tipo) {
        this.tipo = tipo;
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
     * @return the valorPorHora
     */
    public float getValorPorHora() {
        return valorPorHora;
    }

    /**
     * @param valorPorHora the valorPorHora to set
     */
    public void setValorPorHora(float valorPorHora) {
        this.valorPorHora = valorPorHora;
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
