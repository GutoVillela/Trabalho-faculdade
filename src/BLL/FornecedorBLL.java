
package BLL;

import java.util.LinkedList;
import java.util.List;
import DAL.FornecedorDAL;

public class FornecedorBLL {
    
    private int codigo;
    private String razaoSocial;
    private String cnpj;
    private EnderecoBLL endereco;
    private String email;
    private boolean ativo;
    private List<TelefoneBLL> telefones;

    public FornecedorBLL() {
        this.telefones = new LinkedList<>();
        this.endereco = new EnderecoBLL();
    }
    
    private FornecedorDAL fDAL = new FornecedorDAL();
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
    
    public boolean Cadastrar(){
    
        this.endereco.Cadastrar();
        
        this.endereco.setCodigo(endereco.RecuperarUltimaChavePrimaria());
        
        boolean deuCertoCadastrar = this.fDAL.Cadastrar(this);
        
        this.codigo= fDAL.RecuperarUltimaChavePrimaria();
        
        for(int i = 0; i < telefones.size(); i++){
            telefones.get(i).Cadastrar();
            telefones.get(i).setCodigo(telefones.get(i).RecuperarUltimaChavePrimaria());
        }
         
        boolean deuCertoTelefones = fDAL.AssociarTodosTelefoneDaLista(this);
       
       return deuCertoCadastrar && deuCertoTelefones; // SE TUDO DEU CERTO VAI RETORNAR TRUE AQUI NESSA BAGAÇA
   
    }
    
    public List<FornecedorBLL> ConsultarPorNome(){
        
        return fDAL.ConsultarPorNome(this.getRazaoSocial());
    }
    
    /**
     * @return Retorna uma lista com todas as pessoas físicas cadastradas.
     * Retorna inclusive endereço completo.
     */
    public List<FornecedorBLL> Consultar(){
        return fDAL.Consultar();
        
    }
    
    public boolean Atualizar(){
        
      
       boolean ende = endereco.Atualizar(); System.out.println(ende);
       return fDAL.AtualizarDados(this);
       
    }
    
    
    public boolean Desativar(){
        return fDAL.Desativar(codigo);
    }
    
    public int RecuperarUltimaChavePrimaria(){
        return fDAL.RecuperarUltimaChavePrimaria();
    }
    
    protected boolean AssociarTodosTelefoneDaLista(){
        return fDAL.AssociarTodosTelefoneDaLista(this);
    }
    
}
