package BLL;

public class EstadoBLL {
    
    private int codigo;
    private int codigoUf;
    private String nome;
    private String uf;
    private PaisBLL pais;

    public EstadoBLL() {
        this.pais = new PaisBLL();
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
     * @return the codigoUf
     */
    public int getCodigoUf() {
        return codigoUf;
    }

    /**
     * @param codigoUf the codigoUf to set
     */
    public void setCodigoUf(int codigoUf) {
        this.codigoUf = codigoUf;
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
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the pais
     */
    public PaisBLL getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(PaisBLL pais) {
        this.pais = pais;
    }
    
    
}
