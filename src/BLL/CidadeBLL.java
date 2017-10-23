/*
* CLASSE QUE GERENCIA AS CIDADES
*/
package BLL;

public class CidadeBLL {
    
    private int codigo;
    private int codigoCidade;
    private String nome;
    private EstadoBLL estado;

    public CidadeBLL() {
        this.estado = new EstadoBLL();
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
     * @return the codigoCidade
     */
    public int getCodigoCidade() {
        return codigoCidade;
    }

    /**
     * @param codigoCidade the codigoCidade to set
     */
    public void setCodigoCidade(int codigoCidade) {
        this.codigoCidade = codigoCidade;
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
     * @return the estado
     */
    public EstadoBLL getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(EstadoBLL estado) {
        this.estado = estado;
    }
    
    
}
