package BLL;

import DAL.ClienteDAL;
import java.util.LinkedList;
import java.util.List;

public class ClienteBLL {
    
    protected int codigo;
    protected boolean ativo;
    protected String email;
    protected EnderecoBLL endereco;
    protected List<TelefoneBLL> telefones;

    public ClienteBLL() {
        this.telefones = new LinkedList<>();
        this.endereco = new EnderecoBLL();
    }

    private ClienteDAL cDAL = new ClienteDAL();
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
     * @return os telefones associados à este cliente.
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
        return cDAL.Cadastrar(this);
        
    }
    
    
    public boolean Atualizar(){
        
        return cDAL.AtualizarDados(this);
    }
    
    public int RecuperarUltimaChavePrimaria(){
        return cDAL.RecuperarUltimaChavePrimaria();
    }
    
    protected boolean AssociarTodosTelefoneDaLista(){
        return cDAL.AssociarTodosTelefoneDaLista(this);
    }
    
    
}
