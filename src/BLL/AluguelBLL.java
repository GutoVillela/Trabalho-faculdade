
package BLL;

import java.util.LinkedList;
import java.util.List;

public class AluguelBLL {
    
    private int codigo;
    private String horarioInicio;
    private String duracao;
    private boolean ativo;
    private ClienteBLL cliente;
    private List<CopiaParaAlugarBLL> copiasDoAluguel;
    private List<EquipamentoDaLojaBLL> equipamentosDoAluguel;

    public AluguelBLL() {
        //INICIALIZAR TODOS OS OBJETOS
        this.equipamentosDoAluguel = new LinkedList<>();
        this.copiasDoAluguel = new LinkedList<>();
        this.cliente = new ClienteBLL();
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
     * @return the horarioInicio
     */
    public String getHorarioInicio() {
        return horarioInicio;
    }

    /**
     * @param horarioInicio the horarioInicio to set
     */
    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    /**
     * @return the duracao
     */
    public String getDuracao() {
        return duracao;
    }

    /**
     * @param duracao the duracao to set
     */
    public void setDuracao(String duracao) {
        this.duracao = duracao;
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

    /**
     * @return the copiasDoAluguel
     */
    public List<CopiaParaAlugarBLL> getCopiasDoAluguel() {
        return copiasDoAluguel;
    }

    /**
     * @param copiasDoAluguel the copiasDoAluguel to set
     */
    public void setCopiasDoAluguel(List<CopiaParaAlugarBLL> copiasDoAluguel) {
        this.copiasDoAluguel = copiasDoAluguel;
    }

    /**
     * @return the equipamentosDoAluguel
     */
    public List<EquipamentoDaLojaBLL> getEquipamentosDoAluguel() {
        return equipamentosDoAluguel;
    }

    /**
     * @param equipamentosDoAluguel the equipamentosDoAluguel to set
     */
    public void setEquipamentosDoAluguel(List<EquipamentoDaLojaBLL> equipamentosDoAluguel) {
        this.equipamentosDoAluguel = equipamentosDoAluguel;
    }

    
    
}
