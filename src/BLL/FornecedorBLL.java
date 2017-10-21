
package BLL;

import java.util.List;

public class FornecedorBLL {
    
    private int codigo;
    private String razaoSocial;
    private String cnpj;
    private EnderecoBLL endereco;
    private String email;
    private boolean ativo;
    private List<TelefoneBLL> telefones;

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
     * @return the razaoSocial
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * @param razaoSocial the razaoSocial to set
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the endereco
     */
    public EnderecoBLL getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(EnderecoBLL endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
     * @return the telefones
     */
    public List<TelefoneBLL> getTelefones() {
        return telefones;
    }

    /**
     * @param telefones the telefones to set
     */
    public void setTelefones(List<TelefoneBLL> telefones) {
        this.telefones = telefones;
    }
}
