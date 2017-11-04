
package BLL;

import DAL.EquipamentoDoClienteDAL; // IMPORTAÇÃO DA RESPECTIVA 
import java.util.List;

public class EquipamentoDoClienteBLL {
    
    private int codigo;
    private String nome;
    private TipoEquipamentoBLL tipo;
    private boolean ativo;
    private ClienteBLL cliente;
    
    private EquipamentoDoClienteDAL emDAL = new EquipamentoDoClienteDAL();

    public EquipamentoDoClienteBLL() {
        this.tipo = new TipoEquipamentoBLL();
        this.cliente = new ClienteBLL();
    }

    //MÉTODOS
    
    public boolean Cadastrar(){
        return emDAL.Cadastrar(this);
    }
    
    /**
     * @return Retorna uma lista com todos os equipamentos que pertencem à um cliente. 
     * É necessário setar o código do cliente usando getCliente().setCodigo() antes de chamar este método.
     */
    public List<EquipamentoDoClienteBLL> ConsultarEquipamentosDeUmCliente(){
        return emDAL.ConsultarEquipamentosDeUmCliente(this);
    }
    
    /**
     * @param codCliente O código do cliente a quem pertence os equipamentos da lista.
     * @return Retorna uma lista com todos os equipamentos que pertencem à um cliente. 
     */
    public List<EquipamentoDoClienteBLL> ConsultarEquipamentosDeUmCliente(int codCliente){
        this.cliente.setCodigo(codCliente);
        return emDAL.ConsultarEquipamentosDeUmCliente(this);
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
     * @return the tipo
     */
    public TipoEquipamentoBLL getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoEquipamentoBLL tipo) {
        this.tipo = tipo;
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
     * @return the cliente
     */
    public ClienteBLL getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteBLL cliente) {
        this.cliente = cliente;
    }
    
    
    
}
