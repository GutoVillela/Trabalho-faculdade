
package BLL;

import DAL.EnderecoDAL; // IMPORTAÇÃO DA RESPECTIVA CLASSE DAL

public class EnderecoBLL {
    
    private int codigo;
    private String logradouro;
    private String numero;
    private String cep;
    private BairroBLL bairro;
    private boolean ativo;
    
    private EnderecoDAL eDAL = new EnderecoDAL();

    public EnderecoBLL() {
        this.bairro = new BairroBLL();
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
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the bairro
     */
    public BairroBLL getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(BairroBLL bairro) {
        this.bairro = bairro;
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
    
    // MÉTODOS
    public boolean Cadastrar(){
        return eDAL.Cadastrar(this);
    }
    
}
