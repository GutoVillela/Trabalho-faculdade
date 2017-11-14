
package BLL;

import DAL.PessoaJuridicaDAL;
import java.util.List;

public class PessoaJuridicaBLL extends ClienteBLL{
    
    private String razaoSocial;
    private String cnpj;
    
    private PessoaJuridicaDAL pjDAL = new PessoaJuridicaDAL();
    
    // MÉTODOS
    @Override
    public boolean Cadastrar(){
        super.Cadastrar();
        this.codigo = super.RecuperarUltimaChavePrimaria();
        
        // CADASTRAR TODOS OS TELEFONES DA LISTA
        for (int i = 0; i < telefones.size(); i++) {
            if (telefones.get(i).Cadastrar())
                telefones.get(i).setCodigo(telefones.get(i).RecuperarUltimaChavePrimaria()); // RECUPERAR ÚLTIMA CHAVE PRIMÁRIA E COLOCAR DENTRO DO RESPECTIVO TELEFONE
        }
        
        //ASSOCIAR TODOS OS TELEFONES DA LISTA
        boolean deuCertoTelefones = AssociarTodosTelefoneDaLista();
        
        // CADASTRAR PESSOA JURÍDICA ASSOCIADA À CLIENTE
        boolean deuCertoPessoaJuridica = pjDAL.Cadastrar(this);
        
        // RETORNAR RESULTADOS DE AMBAS AS OPERAÇÕES
        return deuCertoTelefones && deuCertoPessoaJuridica;
    }
    
    private boolean AssociarTelefoneACliente(){
        return true;
    }
    
    /**
     * @return Retorna uma lista com todas as pessoas juridicas cadastradas.
     * Retorna inclusive endereço completo.
     */
    
    public List<PessoaJuridicaBLL> ConsultarPorRazao(){
        
        return pjDAL.ConsultarPorRazao(this.getRazaoSocial());
    }
    
    
    public List<PessoaJuridicaBLL> Consultar(){
        return pjDAL.Consultar();
    }
    
    public boolean Desativar(){
        return pjDAL.Desativar(codigo);
    }

@Override

    public boolean Atualizar(){
        
       super.Atualizar();
       boolean ende = endereco.Atualizar(); System.out.println(ende);
       return pjDAL.AtualizarDadosPJ(this);
       
    }
    
    // ENCAPSULAMENTOS
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
    
    
    
    
    
}
