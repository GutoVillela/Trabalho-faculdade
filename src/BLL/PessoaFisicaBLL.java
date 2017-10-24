
package BLL;

import DAL.PessoaFisicaDAL;

public class PessoaFisicaBLL extends ClienteBLL{
    
    private String nome;
    private String cpf;
    
    private PessoaFisicaDAL pfDAL = new PessoaFisicaDAL();

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
    
    // MÉTODOS
    @Override
    public boolean Cadastrar(){
        return pfDAL.Cadastrar(this);
    }
}
