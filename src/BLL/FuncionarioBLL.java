
package BLL;

import java.util.List;

public class FuncionarioBLL {
    
    private int codigo;
    private String nome;
    private String cpf;
    private String email;
    private EnderecoBLL endereco;
    private CargoBLL cargo;
    private CredencialDeAcessoBLL login;
    private List<TelefoneBLL> telefones;
    
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
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
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
     * @return the cargo
     */
    public CargoBLL getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(CargoBLL cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the login
     */
    public CredencialDeAcessoBLL getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(CredencialDeAcessoBLL login) {
        this.login = login;
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
