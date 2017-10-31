
package BLL;

import DAL.PessoaFisicaDAL;
import java.util.List;

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
        super.Cadastrar();
        this.codigo = super.RecuperarUltimaChavePrimaria();
        
        // CADASTRAR TODOS OS TELEFONES DA LISTA
        for (int i = 0; i < telefones.size(); i++) {
            if (telefones.get(i).Cadastrar()){
                telefones.get(i).setCodigo(telefones.get(i).RecuperarUltimaChavePrimaria()); // RECUPERAR ÚLTIMA CHAVE PRIMÁRIA E COLOCAR DENTRO DO RESPECTIVO TELEFONE
                System.out.println("TEL. COD: " + telefones.get(i).getCodigo());
            }
                
        }
     
        
        //ASSOCIAR TODOS OS TELEFONES DA LISTA
        boolean deuCertoTelefones = AssociarTodosTelefoneDaLista();
        
        // CADASTRAR PESSOA FÍSICA ASSOCIADA À CLIENTE
        boolean deuCertoPessoaFisica = pfDAL.Cadastrar(this);
        
        // RETORNAR RESULTADOS DE AMBAS AS OPERAÇÕES
        return deuCertoTelefones && deuCertoPessoaFisica;
    }

    public List<PessoaFisicaBLL> ConsultarPorNome(){
        
        return pfDAL.ConsultarPorNome(this.getNome());
    }

}

    
