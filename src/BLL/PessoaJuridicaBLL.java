
package BLL;

import DAL.PessoaJuridicaDAL;

public class PessoaJuridicaBLL extends ClienteBLL{
    
    private String razaoSocial;
    private String cnpj;
    
    private PessoaJuridicaDAL pjDAL = new PessoaJuridicaDAL();
    

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
    
    @Override
    public boolean Cadastrar(){
        super.Cadastrar();
        this.codigo = super.RecuperarUltimaChavePrimaria();
        return pjDAL.Cadastrar(this);
    }
    
}
