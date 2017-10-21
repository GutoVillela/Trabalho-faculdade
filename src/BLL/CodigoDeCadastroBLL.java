package BLL;

public class CodigoDeCadastroBLL {
    
    private String codigoDeCadastro;
    private boolean utilizado;
    private boolean ativo;

    /**
     * @return the codigoDeCadastro
     */
    public String getCodigoDeCadastro() {
        return codigoDeCadastro;
    }

    /**
     * @param codigoDeCadastro the codigoDeCadastro to set
     */
    public void setCodigoDeCadastro(String codigoDeCadastro) {
        this.codigoDeCadastro = codigoDeCadastro;
    }

    /**
     * @return the utilizado
     */
    public boolean isUtilizado() {
        return utilizado;
    }

    /**
     * @param utilizado the utilizado to set
     */
    public void setUtilizado(boolean utilizado) {
        this.utilizado = utilizado;
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
