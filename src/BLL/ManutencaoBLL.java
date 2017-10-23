
package BLL;

import java.util.LinkedList;
import java.util.List;

public class ManutencaoBLL {
    
    private int codigo;
    private float valor;
    private String dataManutencao;
    private String parecerTecnico;
    private ClienteBLL cliente;
    private FuncionarioBLL tecnicoResponsavel;
    private boolean ativo;
    private List<TipoManutencaoBLL> tipos;
    private List<EquipamentoDaManutencaoBLL> equipamentosDaManutencao;

    public ManutencaoBLL() {
        this.equipamentosDaManutencao = new LinkedList<>();
        this.tipos = new LinkedList<>();
        this.tecnicoResponsavel = new FuncionarioBLL();
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
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    /**
     * @return the dataManutencao
     */
    public String getDataManutencao() {
        return dataManutencao;
    }

    /**
     * @param dataManutencao the dataManutencao to set
     */
    public void setDataManutencao(String dataManutencao) {
        this.dataManutencao = dataManutencao;
    }

    /**
     * @return the parecerTecnico
     */
    public String getParecerTecnico() {
        return parecerTecnico;
    }

    /**
     * @param parecerTecnico the parecerTecnico to set
     */
    public void setParecerTecnico(String parecerTecnico) {
        this.parecerTecnico = parecerTecnico;
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
     * @return the tecnicoResponsavel
     */
    public FuncionarioBLL getTecnicoResponsavel() {
        return tecnicoResponsavel;
    }

    /**
     * @param tecnicoResponsavel the tecnicoResponsavel to set
     */
    public void setTecnicoResponsavel(FuncionarioBLL tecnicoResponsavel) {
        this.tecnicoResponsavel = tecnicoResponsavel;
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
     * @return the tipos
     */
    public List<TipoManutencaoBLL> getTipos() {
        return tipos;
    }

    /**
     * @param tipos the tipos to set
     */
    public void setTipos(List<TipoManutencaoBLL> tipos) {
        this.tipos = tipos;
    }

    /**
     * @return the equipamentosDaManutencao
     */
    public List<EquipamentoDaManutencaoBLL> getEquipamentosDaManutencao() {
        return equipamentosDaManutencao;
    }

    /**
     * @param equipamentosDaManutencao the equipamentosDaManutencao to set
     */
    public void setEquipamentosDaManutencao(List<EquipamentoDaManutencaoBLL> equipamentosDaManutencao) {
        this.equipamentosDaManutencao = equipamentosDaManutencao;
    }
}
